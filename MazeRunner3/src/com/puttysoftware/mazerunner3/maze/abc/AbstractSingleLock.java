/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.abc;

import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.maze.utilities.TypeConstants;

public abstract class AbstractSingleLock extends AbstractLock {
    protected AbstractSingleLock(final AbstractSingleKey mgk, final int tc) {
	super(mgk);
	this.setTemplateColor(tc);
    }

    @Override
    protected void setTypes() {
	this.type.set(TypeConstants.TYPE_SINGLE_LOCK);
	this.type.set(TypeConstants.TYPE_LOCK);
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_LOCK;
    }
}
