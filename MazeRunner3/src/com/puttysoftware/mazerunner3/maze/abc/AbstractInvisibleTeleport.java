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
import com.puttysoftware.mazerunner3.maze.utilities.TypeConstants;

public abstract class AbstractInvisibleTeleport extends AbstractTeleport {
    // Constructors
    protected AbstractInvisibleTeleport(final int destinationRow, final int destinationColumn,
	    final int destinationFloor, final int attrName) {
	super(destinationRow, destinationColumn, destinationFloor, true, attrName);
	this.setTemplateColor(ColorConstants.COLOR_CYAN);
	this.setAttributeTemplateColor(ColorConstants.COLOR_INVISIBLE_TELEPORT_ATTRIBUTE);
    }

    // Scriptability
    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	final Application app = Game.getApplication();
	app.getGameManager().updatePositionAbsolute(this.getDestinationRow(), this.getDestinationColumn(),
		this.getDestinationFloor());
	app.showMessage("Invisible Teleport!");
	SoundLoader.playSound(SoundConstants.SOUND_TELEPORT);
    }

    @Override
    public abstract String getName();

    @Override
    protected void setTypes() {
	this.type.set(TypeConstants.TYPE_INVISIBLE_TELEPORT);
	this.type.set(TypeConstants.TYPE_TELEPORT);
    }
}