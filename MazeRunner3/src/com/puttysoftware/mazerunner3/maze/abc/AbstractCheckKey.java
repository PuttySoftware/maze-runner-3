/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.abc;

import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.maze.utilities.TypeConstants;

public abstract class AbstractCheckKey extends AbstractInventoryableObject {
    // Constructors
    protected AbstractCheckKey() {
	super();
    }

    @Override
    protected void setTypes() {
	this.type.set(TypeConstants.TYPE_KEY);
	this.type.set(TypeConstants.TYPE_CHECK_KEY);
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_STONE;
    }
}
