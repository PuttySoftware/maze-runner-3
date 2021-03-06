/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractTrappedWall;

public class MasterTrappedWall extends AbstractTrappedWall {
    public MasterTrappedWall() {
	super(AbstractTrappedWall.NUMBER_MASTER);
    }

    @Override
    public String getDescription() {
	return "Master Trapped Walls disappear when any Wall Trap is triggered.";
    }

    @Override
    public int getAttributeID() {
	return ObjectImageConstants.OBJECT_IMAGE_LARGE_MASTER;
    }
}
