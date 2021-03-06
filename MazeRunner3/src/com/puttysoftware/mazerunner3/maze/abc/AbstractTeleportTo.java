/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.abc;

import com.puttysoftware.mazerunner3.Application;
import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.editor.MazeEditorLogic;
import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;

public abstract class AbstractTeleportTo extends AbstractTeleport {
    // Fields
    private int destinationLevel;

    // Constructors
    public AbstractTeleportTo(final int tc) {
	super(false, ObjectImageConstants.OBJECT_IMAGE_NONE);
	this.destinationLevel = 0;
	this.setTemplateColor(tc);
    }

    // Scriptability
    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	final Application app = Game.getApplication();
	SoundLoader.playSound(SoundConstants.SOUND_FINISH);
	app.getGameManager().solvedLevelWarp(this.getDestinationLevel());
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + this.destinationLevel;
	return result;
    }

    @Override
    public boolean equals(final Object obj) {
	if (this == obj) {
	    return true;
	}
	if (!super.equals(obj)) {
	    return false;
	}
	if (!(obj instanceof AbstractTeleportTo)) {
	    return false;
	}
	final AbstractTeleportTo other = (AbstractTeleportTo) obj;
	if (this.destinationLevel != other.destinationLevel) {
	    return false;
	}
	return true;
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_HOUSE;
    }

    @Override
    public int getDestinationLevel() {
	return this.destinationLevel;
    }

    public void setDestinationLevel(final int level) {
	this.destinationLevel = level;
    }

    @Override
    public void gameProbeHook() {
	Game.getApplication().showMessage(this.getName() + " Level " + (this.getDestinationLevel() + 1));
    }

    @Override
    public void editorProbeHook() {
	Game.getApplication().showMessage(this.getName() + " Level " + (this.getDestinationLevel() + 1));
    }

    @Override
    public AbstractMazeObject editorPropertiesHook() {
	final MazeEditorLogic me = Game.getApplication().getEditor();
	me.editFinishToDestination(this);
	return this;
    }

    @Override
    public int getCustomFormat() {
	return 1;
    }

    @Override
    public int getCustomProperty(final int propID) {
	return this.destinationLevel;
    }

    @Override
    public void setCustomProperty(final int propID, final int value) {
	this.destinationLevel = value;
    }
}