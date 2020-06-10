/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractPassThroughObject;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class FakeWall extends AbstractPassThroughObject {
    // Constructors
    public FakeWall() {
	super(true);
	this.setTemplateColor(ColorConstants.COLOR_GRAY);
    }

    @Override
    public int getGameTemplateColor() {
	return ColorConstants.COLOR_FAKE;
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_WALL_ON;
    }

    @Override
    public String getName() {
	return "Fake Wall";
    }

    @Override
    public String getGameName() {
	return "Wall";
    }

    @Override
    public String getPluralName() {
	return "Fake Walls";
    }

    @Override
    public String getDescription() {
	return "Fake Walls look like walls, but can be walked through.";
    }
}