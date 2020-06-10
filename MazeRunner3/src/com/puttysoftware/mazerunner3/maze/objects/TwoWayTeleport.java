/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Application;
import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.editor.MazeEditorLogic;
import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.abc.AbstractMazeObject;
import com.puttysoftware.mazerunner3.maze.abc.AbstractTeleport;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;

public class TwoWayTeleport extends AbstractTeleport {
    public TwoWayTeleport() {
	super(0, 0, 0, true, ObjectImageConstants.OBJECT_IMAGE_TWO_WAY);
    }

    public TwoWayTeleport(final int destRow, final int destCol, final int destFloor) {
	super(destRow, destCol, destFloor, true, ObjectImageConstants.OBJECT_IMAGE_TWO_WAY);
    }

    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	final Application app = Game.getApplication();
	app.getGameManager().updatePositionAbsoluteNoEvents(this.getDestinationRow(), this.getDestinationColumn(),
		this.getDestinationFloor(), this.getDestinationLevel());
	SoundLoader.playSound(SoundConstants.SOUND_TELEPORT);
    }

    @Override
    public AbstractMazeObject editorPropertiesHook() {
	final MazeEditorLogic me = Game.getApplication().getEditor();
	return me.editTeleportDestination(MazeEditorLogic.TELEPORT_TYPE_TWOWAY);
    }

    @Override
    public String getName() {
	return "Two-Way Teleport";
    }

    @Override
    public String getPluralName() {
	return "Two-Way Teleports";
    }

    @Override
    public String getDescription() {
	return "Two-Way Teleports send you to their companion at their destination, and are linked such that stepping on the companion sends you back to the original.";
    }
}
