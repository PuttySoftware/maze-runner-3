/*  MazeRunnerII: An RPG
Copyright (C) 2011-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractPassThroughObject;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class ClosedDoor extends AbstractPassThroughObject {
    // Constructors
    public ClosedDoor() {
	super();
	this.setTemplateColor(ColorConstants.COLOR_DOOR);
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_CLOSED_DOOR;
    }

    // Scriptability
    @Override
    public String getName() {
	return "Closed Door";
    }

    @Override
    public String getPluralName() {
	return "Closed Doors";
    }

    @Override
    public String getDescription() {
	return "Closed Doors are purely decorative.";
    }

    @Override
    public boolean enabledInBattle() {
	return false;
    }
}
