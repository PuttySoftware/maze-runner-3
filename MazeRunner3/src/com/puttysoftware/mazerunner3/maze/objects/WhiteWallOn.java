/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.maze.abc.AbstractToggleWall;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class WhiteWallOn extends AbstractToggleWall {
    // Constructors
    public WhiteWallOn() {
	super(true, ColorConstants.COLOR_WHITE);
    }

    // Scriptability
    @Override
    public String getName() {
	return "White Wall On";
    }

    @Override
    public String getPluralName() {
	return "White Walls On";
    }

    @Override
    public String getDescription() {
	return "White Walls On can NOT be walked through, and will change to White Walls Off when a White Button is pressed.";
    }
}