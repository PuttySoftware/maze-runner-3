/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.maze.abc.AbstractSingleKey;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class OrangeKey extends AbstractSingleKey {
    // Constructors
    public OrangeKey() {
	super(ColorConstants.COLOR_ORANGE);
    }

    // Scriptability
    @Override
    public String getName() {
	return "Orange Key";
    }

    @Override
    public String getPluralName() {
	return "Orange Keys";
    }

    @Override
    public String getDescription() {
	return "Orange Keys will unlock Orange Locks, and can only be used once.";
    }
}