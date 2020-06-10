/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.maze.abc.AbstractMultipleLock;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class SilverWall extends AbstractMultipleLock {
    // Constructors
    public SilverWall() {
	super(new SilverSquare(), ColorConstants.COLOR_WHITE);
    }

    @Override
    public String getName() {
	return "Silver Wall";
    }

    @Override
    public String getPluralName() {
	return "Silver Walls";
    }

    @Override
    public String getDescription() {
	return "Silver Walls are impassable without enough Silver Squares.";
    }
}