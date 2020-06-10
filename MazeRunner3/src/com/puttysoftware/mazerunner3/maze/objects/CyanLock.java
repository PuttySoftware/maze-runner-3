/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Boot;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.abc.AbstractSingleLock;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;

public class CyanLock extends AbstractSingleLock {
    // Constructors
    public CyanLock() {
	super(new CyanKey(), ColorConstants.COLOR_CYAN);
    }

    // Scriptability
    @Override
    public void moveFailedAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	if (this.isConditionallySolid(inv)) {
	    Boot.getApplication().showMessage("You need a cyan key");
	}
	SoundLoader.playSound(SoundConstants.SOUND_WALK_FAILED);
    }

    @Override
    public String getName() {
	return "Cyan Lock";
    }

    @Override
    public String getPluralName() {
	return "Cyan Locks";
    }

    @Override
    public String getDescription() {
	return "Cyan Locks require Cyan Keys to open.";
    }
}