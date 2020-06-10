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
import com.puttysoftware.mazerunner3.maze.abc.AbstractMazeObject;
import com.puttysoftware.mazerunner3.maze.abc.AbstractTeleport;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;

public class OneShotControllableTeleport extends AbstractTeleport {
    // Constructors
    public OneShotControllableTeleport() {
	super(0, 0, 0, true, ObjectImageConstants.OBJECT_IMAGE_ONE_SHOT_CONTROLLABLE);
    }

    // Scriptability
    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	final Application app = Game.getApplication();
	SoundLoader.playSound(SoundConstants.SOUND_WALK);
	app.getGameManager().controllableTeleport();
	app.getGameManager().decay();
    }

    @Override
    public String getName() {
	return "One-Shot Controllable Teleport";
    }

    @Override
    public String getPluralName() {
	return "One-Shot Controllable Teleports";
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
	return "One-Shot Controllable Teleports let you choose the place you teleport to, then disappear.";
    }

    @Override
    public int getCustomFormat() {
	return 0;
    }
}