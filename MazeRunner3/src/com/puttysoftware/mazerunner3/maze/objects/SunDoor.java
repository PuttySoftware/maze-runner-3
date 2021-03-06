/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractCheckpoint;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class SunDoor extends AbstractCheckpoint {
    // Constructors
    public SunDoor() {
	super(new SunStone());
	this.setTemplateColor(ColorConstants.COLOR_SUN_DOOR);
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_CLOSED_DOOR;
    }

    // Scriptability
    @Override
    public String getName() {
	return "Sun Door";
    }

    @Override
    public String getPluralName() {
	return "Sun Doors";
    }

    @Override
    public String getDescription() {
	return "Sun Doors will not allow passage without enough Sun Stones.";
    }
}