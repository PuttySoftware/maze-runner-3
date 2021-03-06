/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Application;
import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.abc.AbstractTrap;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;
import com.puttysoftware.randomrange.RandomRange;

public class WarpTrap extends AbstractTrap {
    // Fields
    private RandomRange rr, rc, rf;

    // Constructors
    public WarpTrap() {
	super(ColorConstants.COLOR_LIGHT_GRAY, ObjectImageConstants.OBJECT_IMAGE_WARP, ColorConstants.COLOR_GRAY);
    }

    @Override
    public String getName() {
	return "Warp Trap";
    }

    @Override
    public String getPluralName() {
	return "Warp Traps";
    }

    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	final Application app = Game.getApplication();
	int maxRow, maxCol, maxFloor, rRow, rCol, rFloor;
	maxRow = app.getMazeManager().getMaze().getRows() - 1;
	this.rr = new RandomRange(0, maxRow);
	maxCol = app.getMazeManager().getMaze().getColumns() - 1;
	this.rc = new RandomRange(0, maxCol);
	maxFloor = app.getMazeManager().getMaze().getFloors() - 1;
	this.rf = new RandomRange(0, maxFloor);
	do {
	    rRow = this.rr.generate();
	    rCol = this.rc.generate();
	    rFloor = this.rf.generate();
	} while (!app.getGameManager().tryUpdatePositionAbsolute(rRow, rCol, rFloor));
	app.getGameManager().updatePositionAbsolute(rRow, rCol, rFloor);
	SoundLoader.playSound(SoundConstants.SOUND_TELEPORT);
    }

    @Override
    public String getDescription() {
	return "Warp Traps send anything that steps on one to a random location.";
    }
}
