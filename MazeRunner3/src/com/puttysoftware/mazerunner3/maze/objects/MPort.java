/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractPort;

public class MPort extends AbstractPort {
    // Constructors
    public MPort() {
	super(new MPlug(), 'M');
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_M_PORT;
    }
}