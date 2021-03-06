/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractBarrier;

public class HorizontalBarrier extends AbstractBarrier {
    // Constructors
    public HorizontalBarrier() {
	super();
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_HORIZONTAL_BARRIER;
    }

    @Override
    public String getName() {
	return "Horizontal Barrier";
    }

    @Override
    public String getPluralName() {
	return "Horizontal Barriers";
    }

    @Override
    public String getDescription() {
	return "Horizontal Barriers are impassable - you'll need to go around them.";
    }
}