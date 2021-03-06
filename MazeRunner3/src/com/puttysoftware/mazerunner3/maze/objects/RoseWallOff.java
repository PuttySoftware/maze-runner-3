/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.maze.abc.AbstractToggleWall;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class RoseWallOff extends AbstractToggleWall {
    // Constructors
    public RoseWallOff() {
	super(false, ColorConstants.COLOR_ROSE);
    }

    // Scriptability
    @Override
    public String getName() {
	return "Rose Wall Off";
    }

    @Override
    public String getPluralName() {
	return "Rose Walls Off";
    }

    @Override
    public String getDescription() {
	return "Rose Walls Off can be walked through, and will change to Rose Walls On when a Rose Button is pressed.";
    }
}