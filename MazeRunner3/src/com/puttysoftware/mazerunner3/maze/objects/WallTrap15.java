/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.maze.abc.AbstractWallTrap;
import com.puttysoftware.mazerunner3.resourcemanagers.ObjectImageConstants;

public class WallTrap15 extends AbstractWallTrap {
    public WallTrap15() {
        super(15, new TrappedWall15());
    }

    @Override
    public String getDescription() {
        return "Wall Traps 15 disappear when stepped on, causing all Trapped Walls 15 to also disappear.";
    }

    @Override
    public int getAttributeID() {
        return ObjectImageConstants.OBJECT_IMAGE_SMALL_15;
    }
}