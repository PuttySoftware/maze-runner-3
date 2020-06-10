/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Application;
import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.abc.AbstractInfiniteLock;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;

public class Tree extends AbstractInfiniteLock {
    // Constructors
    public Tree() {
	super(new Axe());
	this.setTemplateColor(ColorConstants.COLOR_GREEN);
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_TREE;
    }

    // Scriptability
    @Override
    public void moveFailedAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	if (this.isConditionallySolid(inv)) {
	    Game.getApplication().showMessage("You need an axe");
	}
	SoundLoader.playSound(SoundConstants.SOUND_WALK_FAILED);
    }

    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	if (!this.getKey().isInfinite()) {
	    inv.removeItem(this.getKey());
	}
	final Application app = Game.getApplication();
	app.getGameManager().decayTo(new CutTree());
	SoundLoader.playSound(SoundConstants.SOUND_UNLOCK);
    }

    @Override
    public String getName() {
	return "Tree";
    }

    @Override
    public String getPluralName() {
	return "Trees";
    }

    @Override
    public String getDescription() {
	return "Trees transform into Cut Trees when hit with an Axe.";
    }
}