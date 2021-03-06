/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractWall;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class SealingWall extends AbstractWall {
    // Constructors
    public SealingWall() {
	super(ColorConstants.COLOR_WHITE);
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_SEALING_WALL;
    }

    @Override
    public String getName() {
	return "Sealing Wall";
    }

    @Override
    public String getPluralName() {
	return "Sealing Walls";
    }

    @Override
    public String getDescription() {
	return "Sealing Walls are impassable and indestructible - you'll need to go around them.";
    }
}