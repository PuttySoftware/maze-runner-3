/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractPassThroughObject;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class CutTree extends AbstractPassThroughObject {
    // Constructors
    public CutTree() {
	super();
	this.setTemplateColor(ColorConstants.COLOR_GREEN);
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_CUT_TREE;
    }

    @Override
    public String getName() {
	return "Cut Tree";
    }

    @Override
    public String getPluralName() {
	return "Cut Trees";
    }

    @Override
    public String getDescription() {
	return "Cut Trees are the leftover stubs of Trees that have been cut by an Axe.";
    }
}