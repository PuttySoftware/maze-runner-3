/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.editor.MazeEditorLogic;
import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractMazeObject;
import com.puttysoftware.mazerunner3.maze.abc.AbstractNWayTeleport;

public class NWayTeleport extends AbstractNWayTeleport {
    // Constructors
    public NWayTeleport() {
	super(1, ObjectImageConstants.OBJECT_IMAGE_N_WAY);
    }

    @Override
    public String getName() {
	return "N-Way Teleport";
    }

    @Override
    public String getPluralName() {
	return "N-Way Teleports";
    }

    @Override
    public String getDescription() {
	return "N-Way Teleports send you to one of N predetermined destinations when stepped on, depending on which destination is selected.";
    }

    @Override
    public final AbstractMazeObject editorPropertiesHook() {
	final MazeEditorLogic me = Game.getApplication().getEditor();
	me.setNWayDestCount(this.getDestinationCount());
	me.setNWayEdited(this);
	me.editTeleportDestination(MazeEditorLogic.TELEPORT_TYPE_N_WAY);
	return null;
    }
}