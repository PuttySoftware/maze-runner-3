/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Boot;
import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.abc.AbstractPassThroughObject;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;

public class FakeFinish extends AbstractPassThroughObject {
    // Constructors
    public FakeFinish() {
	super();
    }

    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	SoundLoader.playSound(SoundConstants.SOUND_WALK_FAILED);
	Boot.getApplication().showMessage("Fake exit!");
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_FAKE_FINISH;
    }

    @Override
    public String getName() {
	return "Fake Finish";
    }

    @Override
    public String getGameName() {
	return "Finish";
    }

    @Override
    public String getPluralName() {
	return "Fake Finishes";
    }

    @Override
    public String getDescription() {
	return "Fake Finishes look like regular finishes but don't lead anywhere.";
    }
}