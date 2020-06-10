/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.abc;

import com.puttysoftware.mazerunner3.Application;
import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;

public abstract class AbstractBlockTeleport extends AbstractTeleport {
    // Constructors
    protected AbstractBlockTeleport(final int destinationRow, final int destinationColumn, final int destinationFloor,
	    final int attrName) {
	super(destinationRow, destinationColumn, destinationFloor, true, attrName);
	this.setTemplateColor(ColorConstants.COLOR_ORANGE);
	this.setAttributeTemplateColor(ColorConstants.COLOR_PURPLE);
    }

    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	SoundLoader.playSound(SoundConstants.SOUND_WALK);
    }

    @Override
    public void pushIntoAction(final MazeObjectInventory inv, final AbstractMazeObject mo, final int x, final int y,
	    final int z) {
	final Application app = Game.getApplication();
	final AbstractMovableObject pushedInto = (AbstractMovableObject) mo;
	app.getGameManager().updatePushedIntoPositionAbsolute(this.getDestinationRow(), this.getDestinationColumn(),
		this.getDestinationFloor(), x, y, z, pushedInto, this);
	SoundLoader.playSound(SoundConstants.SOUND_TELEPORT);
    }

    @Override
    public void pullIntoAction(final MazeObjectInventory inv, final AbstractMazeObject mo, final int x, final int y,
	    final int z) {
	final Application app = Game.getApplication();
	final AbstractMovableObject pushedInto = (AbstractMovableObject) mo;
	app.getGameManager().updatePushedIntoPositionAbsolute(this.getDestinationRow(), this.getDestinationColumn(),
		this.getDestinationFloor(), x, y, z, pushedInto, this);
	SoundLoader.playSound(SoundConstants.SOUND_TELEPORT);
    }
}
