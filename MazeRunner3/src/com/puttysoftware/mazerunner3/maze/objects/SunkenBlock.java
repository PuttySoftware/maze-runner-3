/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractGround;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class SunkenBlock extends AbstractGround {
    // Constructors
    public SunkenBlock() {
	super(true, true, true, true, ColorConstants.COLOR_WATER);
	this.setAttributeID(ObjectImageConstants.OBJECT_IMAGE_BLOCK_BASE);
	this.setAttributeTemplateColor(ColorConstants.COLOR_SUNKEN_BLOCK);
    }

    @Override
    public String getName() {
	return "Sunken Block";
    }

    @Override
    public String getPluralName() {
	return "Sunken Blocks";
    }

    @Override
    public String getDescription() {
	return "Sunken Blocks are created when Pushable Blocks are pushed into Water, and behave just like Tiles.";
    }
}