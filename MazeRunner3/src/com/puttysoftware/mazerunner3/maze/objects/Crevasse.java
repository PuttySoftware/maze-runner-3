/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractWall;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;

public class Crevasse extends AbstractWall {
    // Constructors
    public Crevasse() {
	super(ColorConstants.COLOR_WHITE);
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_CREVASSE;
    }

    @Override
    public String getName() {
	return "Crevasse";
    }

    @Override
    public String getPluralName() {
	return "Crevasses";
    }

    @Override
    public boolean arrowHitAction(final int locX, final int locY, final int locZ, final int dirX, final int dirY,
	    final int arrowType, final MazeObjectInventory inv) {
	return true;
    }

    @Override
    public String getDescription() {
	return "Crevasses stop movement, but not arrows, which pass over them unimpeded.";
    }
}