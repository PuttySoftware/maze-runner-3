/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.abc;

import com.puttysoftware.mazerunner3.maze.utilities.TypeConstants;

public abstract class AbstractInfiniteKey extends AbstractKey {
    // Constructors
    protected AbstractInfiniteKey() {
	super(true);
    }

    // Scriptability
    @Override
    public abstract String getName();

    @Override
    protected void setTypes() {
	this.type.set(TypeConstants.TYPE_INFINITE_KEY);
	this.type.set(TypeConstants.TYPE_KEY);
	this.type.set(TypeConstants.TYPE_INVENTORYABLE);
    }
}