/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractMovableObject;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class PullableBlock extends AbstractMovableObject {
    // Constructors
    public PullableBlock() {
	super(false, true, ObjectImageConstants.OBJECT_IMAGE_PULLABLE);
	this.setTemplateColor(ColorConstants.COLOR_GRAY);
    }

    @Override
    public String getName() {
	return "Pullable Block";
    }

    @Override
    public String getPluralName() {
	return "Pullable Blocks";
    }

    @Override
    public String getDescription() {
	return "Pullable Blocks can only be pulled, not pushed.";
    }
}