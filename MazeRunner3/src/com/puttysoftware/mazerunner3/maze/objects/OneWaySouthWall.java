/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractWall;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.maze.utilities.TypeConstants;

public class OneWaySouthWall extends AbstractWall {
    public OneWaySouthWall() {
	super(true, false, true, true, true, false, true, true, ColorConstants.COLOR_BROWN,
		ObjectImageConstants.OBJECT_IMAGE_ONE_WAY_SOUTH, ColorConstants.COLOR_LIGHT_RED);
    }

    @Override
    public String getName() {
	return "One-Way South Wall";
    }

    @Override
    public String getPluralName() {
	return "One-Way South Walls";
    }

    @Override
    public String getDescription() {
	return "One-Way South Walls allow movement through them only South.";
    }

    @Override
    protected void setTypes() {
	this.type.set(TypeConstants.TYPE_PLAIN_WALL);
	this.type.set(TypeConstants.TYPE_WALL);
    }
}
