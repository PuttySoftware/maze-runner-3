/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.abc.AbstractInfiniteLock;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;

public class TabletSlot extends AbstractInfiniteLock {
    // Constructors
    public TabletSlot() {
	super(new Tablet());
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_TABLET_SLOT;
    }

    // Scriptability
    @Override
    public void moveFailedAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	if (this.isConditionallyDirectionallySolid(ie, dirX, dirY, inv)) {
	    Game.getApplication().showMessage("You need a tablet");
	}
	SoundLoader.playSound(SoundConstants.SOUND_WALK_FAILED);
    }

    @Override
    public String getName() {
	return "Tablet Slot";
    }

    @Override
    public String getPluralName() {
	return "Tablet Slots";
    }

    @Override
    public String getDescription() {
	return "Tablet Slots disappear when filled with a Tablet.";
    }
}