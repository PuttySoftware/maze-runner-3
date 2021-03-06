/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.maze.abc.AbstractToggleWall;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class MagentaWallOff extends AbstractToggleWall {
    // Constructors
    public MagentaWallOff() {
	super(false, ColorConstants.COLOR_MAGENTA);
    }

    // Scriptability
    @Override
    public String getName() {
	return "Magenta Wall Off";
    }

    @Override
    public String getPluralName() {
	return "Magenta Walls Off";
    }

    @Override
    public String getDescription() {
	return "Magenta Walls Off can be walked through, and will change to Magenta Walls On when a Magenta Button is pressed.";
    }
}