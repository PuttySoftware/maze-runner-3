/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractWallTrap;

public class WallTrap2 extends AbstractWallTrap {
    public WallTrap2() {
	super(2, new TrappedWall2());
    }

    @Override
    public String getDescription() {
	return "Wall Traps 2 disappear when stepped on, causing all Trapped Walls 2 to also disappear.";
    }

    @Override
    public int getAttributeID() {
	return ObjectImageConstants.OBJECT_IMAGE_SMALL_2;
    }
}
