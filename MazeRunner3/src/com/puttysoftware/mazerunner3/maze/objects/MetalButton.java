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
import com.puttysoftware.mazerunner3.maze.MazeConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractField;
import com.puttysoftware.mazerunner3.maze.abc.AbstractMazeObject;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;
import com.puttysoftware.mazerunner3.maze.utilities.TypeConstants;

public class MetalButton extends AbstractField {
    // Fields
    private final int targetRow;
    private final int targetCol;
    private final int targetFloor;
    private final int targetLevel;

    // Constructors
    public MetalButton() {
	super(new MetalBoots(), false, ColorConstants.COLOR_GRAY);
	this.targetRow = 0;
	this.targetCol = 0;
	this.targetFloor = 0;
	this.targetLevel = 0;
    }

    public MetalButton(final int tRow, final int tCol, final int tFloor, final int tLevel) {
	super(new MetalBoots(), false, ColorConstants.COLOR_GRAY);
	this.targetRow = tRow;
	this.targetCol = tCol;
	this.targetFloor = tFloor;
	this.targetLevel = tLevel;
    }

    @Override
    public boolean equals(final Object obj) {
	if (obj == null) {
	    return false;
	}
	if (this.getClass() != obj.getClass()) {
	    return false;
	}
	final MetalButton other = (MetalButton) obj;
	if (this.targetRow != other.targetRow) {
	    return false;
	}
	if (this.targetCol != other.targetCol) {
	    return false;
	}
	if (this.targetFloor != other.targetFloor) {
	    return false;
	}
	if (this.targetLevel != other.targetLevel) {
	    return false;
	}
	return true;
    }

    @Override
    public int hashCode() {
	int hash = 5;
	hash = 79 * hash + this.targetRow;
	hash = 79 * hash + this.targetCol;
	hash = 79 * hash + this.targetFloor;
	hash = 79 * hash + this.targetLevel;
	return hash;
    }

    public int getTargetRow() {
	return this.targetRow;
    }

    public int getTargetColumn() {
	return this.targetCol;
    }

    public int getTargetFloor() {
	return this.targetFloor;
    }

    // Scriptability
    @Override
    public void moveFailedAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	// Do nothing
    }

    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	if (inv.isItemThere(this.getKey())) {
	    final Application app = Game.getApplication();
	    final AbstractMazeObject there = app.getMazeManager().getMazeObject(this.getTargetRow(),
		    this.getTargetColumn(), this.getTargetFloor(), this.getLayer());
	    if (there != null) {
		if (there.getName().equals(new MetalDoor().getName())) {
		    app.getGameManager().morph(new Empty(), this.getTargetRow(), this.getTargetColumn(),
			    this.getTargetFloor());
		} else {
		    app.getGameManager().morph(new MetalDoor(), this.getTargetRow(), this.getTargetColumn(),
			    this.getTargetFloor());
		}
	    }
	    SoundLoader.playSound(SoundConstants.SOUND_BUTTON);
	} else {
	    SoundLoader.playSound(SoundConstants.SOUND_WALK);
	}
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_BUTTON;
    }

    @Override
    public String getName() {
	return "Metal Button";
    }

    @Override
    public String getPluralName() {
	return "Metal Buttons";
    }

    @Override
    public boolean isConditionallySolid(final MazeObjectInventory inv) {
	return this.isSolid();
    }

    @Override
    public boolean isConditionallyDirectionallySolid(final boolean ie, final int dirX, final int dirY,
	    final MazeObjectInventory inv) {
	// Handle passwall boots and ghost amulet
	if (inv.isItemThere(new PasswallBoots()) || inv.isItemThere(new GhostAmulet())) {
	    return false;
	} else {
	    return this.isDirectionallySolid(ie, dirX, dirY);
	}
    }

    @Override
    public int getLayer() {
	return MazeConstants.LAYER_OBJECT;
    }

    @Override
    public void editorProbeHook() {
	Game.getApplication().showMessage(this.getName() + ": Target (" + (this.targetCol + 1) + ","
		+ (this.targetRow + 1) + "," + (this.targetFloor + 1) + "," + (this.targetLevel + 1) + ")");
    }

    @Override
    public AbstractMazeObject editorPropertiesHook() {
	return Game.getApplication().getEditor().editMetalButtonTarget();
    }

    @Override
    public String getDescription() {
	return "Metal Buttons will not trigger without Metal Boots.";
    }

    @Override
    protected void setTypes() {
	this.type.set(TypeConstants.TYPE_BUTTON);
	this.type.set(TypeConstants.TYPE_FIELD);
	this.type.set(TypeConstants.TYPE_INFINITE_LOCK);
	this.type.set(TypeConstants.TYPE_LOCK);
    }

    @Override
    public boolean defersSetProperties() {
	return true;
    }
}
