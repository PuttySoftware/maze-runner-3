/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.maze.abc.AbstractToggleWall;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class OrangeWallOff extends AbstractToggleWall {
    // Constructors
    public OrangeWallOff() {
	super(false, ColorConstants.COLOR_ORANGE);
    }

    // Scriptability
    @Override
    public String getName() {
	return "Orange Wall Off";
    }

    @Override
    public String getPluralName() {
	return "Orange Walls Off";
    }

    @Override
    public String getDescription() {
	return "Orange Walls Off can be walked through, and will change to Orange Walls On when a Orange Button is pressed.";
    }
}