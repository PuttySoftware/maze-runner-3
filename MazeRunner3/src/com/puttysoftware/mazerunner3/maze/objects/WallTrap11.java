/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.maze.abc.AbstractWallTrap;
import com.puttysoftware.mazerunner3.resourcemanagers.ObjectImageConstants;

public class WallTrap11 extends AbstractWallTrap {
    public WallTrap11() {
	super(11, new TrappedWall11());
    }

    @Override
    public String getDescription() {
	return "Wall Traps 11 disappear when stepped on, causing all Trapped Walls 11 to also disappear.";
    }

    @Override
    public int getAttributeID() {
	return ObjectImageConstants.OBJECT_IMAGE_SMALL_11;
    }
}
