/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.abc.AbstractTrap;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;

public class WallMakingTrap extends AbstractTrap {
    public WallMakingTrap() {
	super(ColorConstants.COLOR_BRIDGE, ObjectImageConstants.OBJECT_IMAGE_WALL_MAKING, ColorConstants.COLOR_BROWN);
    }

    @Override
    public String getName() {
	return "Wall-Making Trap";
    }

    @Override
    public String getPluralName() {
	return "Wall-Making Traps";
    }

    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	SoundLoader.playSound(SoundConstants.SOUND_WALK);
	Game.getApplication().getGameManager().delayedDecayTo(new Wall());
    }

    @Override
    public String getDescription() {
	return "Wall-Making Traps create a Wall when you step OFF them.";
    }
}
