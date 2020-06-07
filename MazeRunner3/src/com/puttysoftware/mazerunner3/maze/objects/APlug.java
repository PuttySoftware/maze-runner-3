/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.maze.abc.AbstractPlug;
import com.puttysoftware.mazerunner3.resourcemanagers.ObjectImageConstants;

public class APlug extends AbstractPlug {
    // Constructors
    public APlug() {
        super('A');
    }

    @Override
    public int getBaseID() {
        return ObjectImageConstants.OBJECT_IMAGE_A_PLUG;
    }
}