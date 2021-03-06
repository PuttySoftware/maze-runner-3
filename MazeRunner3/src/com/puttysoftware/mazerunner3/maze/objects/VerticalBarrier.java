/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractBarrier;

public class VerticalBarrier extends AbstractBarrier {
    // Constructors
    public VerticalBarrier() {
	super();
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_VERTICAL_BARRIER;
    }

    @Override
    public String getName() {
	return "Vertical Barrier";
    }

    @Override
    public String getPluralName() {
	return "Vertical Barriers";
    }

    @Override
    public String getDescription() {
	return "Vertical Barriers are impassable - you'll need to go around them.";
    }
}