/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Application;
import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.Maze;
import com.puttysoftware.mazerunner3.maze.abc.AbstractMazeObject;
import com.puttysoftware.mazerunner3.maze.abc.AbstractTeleport;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;
import com.puttysoftware.mazerunner3.maze.utilities.RandomGenerationRule;

public class Finish extends AbstractTeleport {
    // Constructors
    public Finish() {
	super(0, 0, 0, false, ObjectImageConstants.OBJECT_IMAGE_NONE);
	this.setTemplateColor(ColorConstants.COLOR_WHITE);
    }

    // Scriptability
    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	final Application app = Game.getApplication();
	SoundLoader.playSound(SoundConstants.SOUND_FINISH);
	app.getGameManager().solvedLevel();
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_FINISH;
    }

    @Override
    public String getName() {
	return "Finish";
    }

    @Override
    public String getPluralName() {
	return "Finishes";
    }

    @Override
    public boolean defersSetProperties() {
	return false;
    }

    @Override
    public void editorProbeHook() {
	Game.getApplication().showMessage(this.getName());
    }

    @Override
    public AbstractMazeObject editorPropertiesHook() {
	return null;
    }

    @Override
    public String getDescription() {
	return "Finishes lead to the next level, if one exists. Otherwise, entering one solves the maze.";
    }

    @Override
    public int getCustomFormat() {
	return 0;
    }

    // Random Generation Rules
    @Override
    public boolean isRequired() {
	return true;
    }

    @Override
    public int getMinimumRequiredQuantity(final Maze maze) {
	return 1;
    }

    @Override
    public int getMaximumRequiredQuantity(final Maze maze) {
	return RandomGenerationRule.NO_LIMIT;
    }
}