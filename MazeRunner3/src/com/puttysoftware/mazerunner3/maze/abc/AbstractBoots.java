/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.abc;

import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.maze.utilities.TypeConstants;

public abstract class AbstractBoots extends AbstractPass {
    // Constructors
    protected AbstractBoots(final int tc) {
	super();
	this.setTemplateColor(tc);
    }

    @Override
    public abstract String getName();

    @Override
    public final int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_BOOTS;
    }

    @Override
    protected void setTypes() {
	this.type.set(TypeConstants.TYPE_BOOTS);
	this.type.set(TypeConstants.TYPE_PASS);
	this.type.set(TypeConstants.TYPE_INFINITE_KEY);
	this.type.set(TypeConstants.TYPE_KEY);
	this.type.set(TypeConstants.TYPE_INVENTORYABLE);
    }
}
