/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Boot;
import com.puttysoftware.mazerunner3.editor.MazeEditorLogic;
import com.puttysoftware.mazerunner3.maze.abc.AbstractBlockTeleport;
import com.puttysoftware.mazerunner3.maze.abc.AbstractMazeObject;
import com.puttysoftware.mazerunner3.resourcemanagers.ObjectImageConstants;

public class BlockTeleport extends AbstractBlockTeleport {
    // Constructors
    public BlockTeleport() {
	super(0, 0, 0, ObjectImageConstants.OBJECT_IMAGE_TELEPORT);
    }

    public BlockTeleport(final int destinationRow, final int destinationColumn, final int destinationFloor) {
	super(destinationRow, destinationColumn, destinationFloor, ObjectImageConstants.OBJECT_IMAGE_TELEPORT);
    }

    @Override
    public String getName() {
	return "Block Teleport";
    }

    @Override
    public String getPluralName() {
	return "Block Teleports";
    }

    @Override
    public AbstractMazeObject editorPropertiesHook() {
	final MazeEditorLogic me = Boot.getApplication().getEditor();
	return me.editTeleportDestination(MazeEditorLogic.TELEPORT_TYPE_BLOCK);
    }

    @Override
    public String getDescription() {
	return "Block Teleports send blocks to a predetermined destination when blocks are moved into them.";
    }
}