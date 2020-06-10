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

public class BlueLock extends AbstractSingleLock {
    // Constructors
    public BlueLock() {
	super(new BlueKey(), ColorConstants.COLOR_BLUE);
    }

    // Scriptability
    @Override
    public void moveFailedAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	if (this.isConditionallySolid(inv)) {
	    Boot.getApplication().showMessage("You need a blue key");
	}
	SoundLoader.playSound(SoundConstants.SOUND_WALK_FAILED);
    }

    @Override
    public String getName() {
	return "Blue Lock";
    }

    @Override
    public String getPluralName() {
	return "Blue Locks";
    }

    @Override
    public String getDescription() {
	return "Blue Locks require Blue Keys to open.";
    }
}