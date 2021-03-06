/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Application;
import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.game.InfiniteRecursionException;
import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.MazeConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractMazeObject;
import com.puttysoftware.mazerunner3.maze.abc.AbstractMovableObject;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;

public class Pit extends StairsDown {
    // Constructors
    public Pit() {
	super(true);
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_PIT;
    }

    @Override
    public String getName() {
	return "Pit";
    }

    @Override
    public String getPluralName() {
	return "Pits";
    }

    @Override
    public boolean preMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	return this.searchNestedPits(dirX, dirY,
		Game.getApplication().getMazeManager().getMaze().getPlayerLocationZ() - 1, inv);
    }

    private boolean searchNestedPits(final int dirX, final int dirY, final int floor, final MazeObjectInventory inv) {
	final Application app = Game.getApplication();
	// Stop infinite recursion
	final int lcl = -app.getMazeManager().getMaze().getFloors();
	if (floor <= lcl) {
	    throw new InfiniteRecursionException();
	}
	if (app.getGameManager().doesFloorExist(floor)) {
	    final AbstractMazeObject obj = app.getMazeManager().getMaze().getCell(dirX, dirY, floor,
		    MazeConstants.LAYER_OBJECT);
	    if (obj.isConditionallySolid(inv)) {
		return false;
	    } else {
		if (obj.getName().equals("Pit") || obj.getName().equals("Invisible Pit")) {
		    return this.searchNestedPits(dirX, dirY, floor - 1, inv);
		} else if (obj.getName().equals("Springboard") || obj.getName().equals("Invisible Springboard")) {
		    return false;
		} else {
		    return true;
		}
	    }
	} else {
	    return false;
	}
    }

    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	final Application app = Game.getApplication();
	app.getGameManager().updatePositionAbsolute(this.getDestinationRow(), this.getDestinationColumn(),
		this.getDestinationFloor());
	SoundLoader.playSound(SoundConstants.SOUND_FALLING);
    }

    @Override
    public void pushIntoAction(final MazeObjectInventory inv, final AbstractMazeObject pushed, final int x, final int y,
	    final int z) {
	final Application app = Game.getApplication();
	try {
	    this.searchNestedPits(x, y, z - 1, inv);
	    if (pushed.isPushable()) {
		final AbstractMovableObject pushedInto = (AbstractMovableObject) pushed;
		app.getGameManager().updatePushedIntoPositionAbsolute(x, y, z - 1, x, y, z, pushedInto, this);
		SoundLoader.playSound(SoundConstants.SOUND_INTO_PIT);
	    }
	} catch (final InfiniteRecursionException ir) {
	    SoundLoader.playSound(SoundConstants.SOUND_INTO_PIT);
	    Game.getApplication().getMazeManager().getMaze().setCell(new Empty(), x, y, z, MazeConstants.LAYER_OBJECT);
	}
    }

    @Override
    public boolean isConditionallySolid(final MazeObjectInventory inv) {
	final Application app = Game.getApplication();
	if (!app.getGameManager().isFloorBelow()) {
	    return true;
	} else {
	    return false;
	}
    }

    @Override
    public void editorPlaceHook() {
	// Do nothing
    }

    @Override
    public String getDescription() {
	return "Pits dump anything that wanders in to the floor below. If one of these is placed on the bottom-most floor, it is impassable.";
    }
}
