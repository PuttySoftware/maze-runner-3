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
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;

public class StairsDown extends AbstractTeleport {
    // Constructors
    public StairsDown() {
	super(0, 0, 0, false, ObjectImageConstants.OBJECT_IMAGE_NONE);
	this.setTemplateColor(ColorConstants.COLOR_NONE);
	this.setAttributeTemplateColor(ColorConstants.COLOR_NONE);
    }

    // For derived classes only
    protected StairsDown(final boolean doesAcceptPushInto) {
	super(doesAcceptPushInto, ObjectImageConstants.OBJECT_IMAGE_NONE);
	this.setTemplateColor(ColorConstants.COLOR_NONE);
	this.setAttributeTemplateColor(ColorConstants.COLOR_NONE);
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_STAIRS_DOWN;
    }

    @Override
    public String getName() {
	return "Stairs Down";
    }

    @Override
    public String getPluralName() {
	return "Sets of Stairs Down";
    }

    @Override
    public int getDestinationRow() {
	final Application app = Game.getApplication();
	return app.getMazeManager().getMaze().getPlayerLocationX();
    }

    @Override
    public int getDestinationColumn() {
	final Application app = Game.getApplication();
	return app.getMazeManager().getMaze().getPlayerLocationY();
    }

    @Override
    public int getDestinationFloor() {
	final Application app = Game.getApplication();
	return app.getMazeManager().getMaze().getPlayerLocationZ() - 1;
    }

    @Override
    public int getDestinationLevel() {
	final Application app = Game.getApplication();
	return app.getMazeManager().getMaze().getPlayerLocationW();
    }

    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	final Application app = Game.getApplication();
	app.getGameManager().updatePositionAbsoluteNoEvents(this.getDestinationRow(), this.getDestinationColumn(),
		this.getDestinationFloor(), this.getDestinationLevel());
	SoundLoader.playSound(SoundConstants.SOUND_DOWN);
    }

    @Override
    public void editorPlaceHook() {
	final MazeEditorLogic me = Game.getApplication().getEditor();
	me.pairStairs(MazeEditorLogic.STAIRS_DOWN);
    }

    @Override
    public AbstractMazeObject editorPropertiesHook() {
	return null;
    }

    @Override
    public String getDescription() {
	return "Stairs Down lead to the floor below.";
    }

    @Override
    public int getCustomFormat() {
	return 0;
    }

    @Override
    public int getCustomProperty(final int propID) {
	return AbstractMazeObject.DEFAULT_CUSTOM_VALUE;
    }

    @Override
    public void setCustomProperty(final int propID, final int value) {
	// Do nothing
    }
}
