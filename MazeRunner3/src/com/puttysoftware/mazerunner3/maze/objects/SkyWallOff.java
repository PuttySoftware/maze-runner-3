/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.maze.abc.AbstractToggleWall;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class SkyWallOff extends AbstractToggleWall {
    // Constructors
    public SkyWallOff() {
	super(false, ColorConstants.COLOR_SKY);
    }

    // Scriptability
    @Override
    public String getName() {
	return "Sky Wall Off";
    }

    @Override
    public String getPluralName() {
	return "Sky Walls Off";
    }

    @Override
    public String getDescription() {
	return "Sky Walls Off can be walked through, and will change to Sky Walls On when a Sky Button is pressed.";
    }
}