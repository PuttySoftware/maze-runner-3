/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Application;
import com.puttysoftware.mazerunner3.Boot;
import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.abc.AbstractAntiObject;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;

public class NoPlayer extends AbstractAntiObject {
    // Constructors
    public NoPlayer() {
	super();
	this.setTemplateColor(ColorConstants.COLOR_NONE);
	this.setAttributeID(ObjectImageConstants.OBJECT_IMAGE_NO);
	this.setAttributeTemplateColor(ColorConstants.COLOR_RED);
    }

    @Override
    public final int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_PLAYER;
    }

    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	final Application app = Boot.getApplication();
	app.getGameManager().backUpPlayer(this);
	SoundLoader.playSound(SoundConstants.SOUND_WALK_FAILED);
    }

    @Override
    public String getName() {
	return "No Player";
    }

    @Override
    public String getPluralName() {
	return "No Players";
    }

    @Override
    public String getDescription() {
	return "No Players prevent players from attempting to pass through.";
    }
}