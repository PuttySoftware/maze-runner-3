/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Application;
import com.puttysoftware.mazerunner3.Boot;
import com.puttysoftware.mazerunner3.editor.MazeEditorLogic;
import com.puttysoftware.mazerunner3.maze.abc.AbstractInvisibleTeleport;
import com.puttysoftware.mazerunner3.maze.abc.AbstractMazeObject;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;
import com.puttysoftware.mazerunner3.resourcemanagers.ObjectImageConstants;
import com.puttysoftware.mazerunner3.resourcemanagers.SoundConstants;
import com.puttysoftware.mazerunner3.resourcemanagers.SoundManager;

public class InvisibleOneShotChainTeleport extends AbstractInvisibleTeleport {
    // Constructors
    public InvisibleOneShotChainTeleport() {
	super(0, 0, 0, ObjectImageConstants.OBJECT_IMAGE_ONE_SHOT_CHAIN);
    }

    public InvisibleOneShotChainTeleport(final int destinationRow, final int destinationColumn,
	    final int destinationFloor) {
	super(destinationRow, destinationColumn, destinationFloor, ObjectImageConstants.OBJECT_IMAGE_ONE_SHOT_CHAIN);
    }

    // Scriptability
    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	final Application app = Boot.getApplication();
	app.getGameManager().decay();
	app.getGameManager().updatePositionAbsoluteNoEvents(this.getDestinationRow(), this.getDestinationColumn(),
		this.getDestinationFloor(), this.getDestinationLevel());
	Boot.getApplication().showMessage("Invisible Teleport!");
	SoundManager.playSound(SoundConstants.SOUND_TELEPORT);
    }

    @Override
    public String getName() {
	return "Invisible One-Shot Chain Teleport";
    }

    @Override
    public String getGameName() {
	return "Empty";
    }

    @Override
    public String getPluralName() {
	return "Invisible One-Shot Chain Teleports";
    }

    @Override
    public AbstractMazeObject editorPropertiesHook() {
	final MazeEditorLogic me = Boot.getApplication().getEditor();
	return me.editTeleportDestination(MazeEditorLogic.TELEPORT_TYPE_INVISIBLE_ONESHOT_CHAIN);
    }

    @Override
    public String getDescription() {
	return "Invisible One-Shot Chain Teleports are a combination of invisible, one-shot, and chain teleport behaviors.";
    }
}