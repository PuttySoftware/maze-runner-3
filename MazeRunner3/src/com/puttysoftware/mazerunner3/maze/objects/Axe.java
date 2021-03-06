/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractInfiniteKey;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class Axe extends AbstractInfiniteKey {
    // Constructors
    public Axe() {
	super();
	this.setTemplateColor(ColorConstants.COLOR_BRIDGE);
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_AXE;
    }

    @Override
    public String getName() {
	return "Axe";
    }

    @Override
    public String getPluralName() {
	return "Axe";
    }

    @Override
    public String getDescription() {
	return "With an Axe, Trees can be cut down. Axes never lose their ability to cut trees.";
    }
}