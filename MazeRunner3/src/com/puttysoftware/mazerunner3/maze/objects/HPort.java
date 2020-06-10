/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractPort;

public class HPort extends AbstractPort {
    // Constructors
    public HPort() {
	super(new HPlug(), 'H');
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_H_PORT;
    }
}