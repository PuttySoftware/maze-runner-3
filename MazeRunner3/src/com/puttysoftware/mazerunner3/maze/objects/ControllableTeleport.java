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

public class ControllableTeleport extends AbstractTeleport {
    // Constructors
    public ControllableTeleport() {
	super(0, 0, 0, false, ObjectImageConstants.OBJECT_IMAGE_CONTROLLABLE);
    }

    // Scriptability
    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	final Application app = Game.getApplication();
	SoundLoader.playSound(SoundConstants.SOUND_WALK);
	app.getGameManager().controllableTeleport();
    }

    @Override
    public String getName() {
	return "Controllable Teleport";
    }

    @Override
    public String getPluralName() {
	return "Controllable Teleports";
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
	return "Controllable Teleports let you choose the place you teleport to.";
    }

    @Override
    public int getCustomFormat() {
	return 0;
    }
}