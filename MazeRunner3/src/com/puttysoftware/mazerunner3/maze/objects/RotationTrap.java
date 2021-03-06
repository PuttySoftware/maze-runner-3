/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import java.io.IOException;

import com.puttysoftware.diane.gui.CommonDialogs;
import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.legacyxio.XLegacyDataReader;
import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.abc.AbstractMazeObject;
import com.puttysoftware.mazerunner3.maze.abc.AbstractTrap;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;
import com.puttysoftware.xio.XDataReader;
import com.puttysoftware.xio.XDataWriter;

public class RotationTrap extends AbstractTrap {
    // Fields
    private int radius;
    private boolean direction;
    private static final boolean CLOCKWISE = true;
    private static final boolean COUNTERCLOCKWISE = false;
    private static final String[] rChoices = new String[] { "1", "2", "3" };
    private static final String[] dChoices = new String[] { "Clockwise", "Counterclockwise" };

    // Constructors
    public RotationTrap() {
	super(ColorConstants.COLOR_LIGHT_PURPLE, ObjectImageConstants.OBJECT_IMAGE_SMALL_ROTATION,
		ColorConstants.COLOR_PURPLE);
	this.radius = 1;
	this.direction = RotationTrap.CLOCKWISE;
    }

    public RotationTrap(final int newRadius, final boolean newDirection) {
	super(ColorConstants.COLOR_LIGHT_PURPLE, ObjectImageConstants.OBJECT_IMAGE_SMALL_ROTATION,
		ColorConstants.COLOR_PURPLE);
	this.radius = newRadius;
	this.direction = newDirection;
    }

    @Override
    public RotationTrap clone() {
	final RotationTrap copy = (RotationTrap) super.clone();
	copy.radius = this.radius;
	copy.direction = this.direction;
	return copy;
    }

    @Override
    public void editorProbeHook() {
	String dir;
	if (this.direction == RotationTrap.CLOCKWISE) {
	    dir = "Clockwise";
	} else {
	    dir = "Counterclockwise";
	}
	Game.getApplication().showMessage(this.getName() + " (Radius " + this.radius + ", Direction " + dir + ")");
    }

    @Override
    public AbstractMazeObject editorPropertiesHook() {
	int r = this.radius;
	final String rres = CommonDialogs.showInputDialog("Rotation Radius:", "Editor", RotationTrap.rChoices,
		RotationTrap.rChoices[r - 1]);
	try {
	    r = Integer.parseInt(rres);
	} catch (final NumberFormatException nf) {
	    // Ignore
	}
	boolean d = this.direction;
	int di;
	if (d) {
	    di = 0;
	} else {
	    di = 1;
	}
	final String dres = CommonDialogs.showInputDialog("Rotation Direction:", "Editor", RotationTrap.dChoices,
		RotationTrap.dChoices[di]);
	if (dres.equals(RotationTrap.dChoices[0])) {
	    d = RotationTrap.CLOCKWISE;
	} else {
	    d = RotationTrap.COUNTERCLOCKWISE;
	}
	return new RotationTrap(r, d);
    }

    @Override
    public String getName() {
	return "Rotation Trap";
    }

    @Override
    public String getPluralName() {
	return "Rotation Traps";
    }

    @Override
    protected AbstractMazeObject readLegacyMazeObjectHook(final XLegacyDataReader reader, final int formatVersion)
	    throws IOException {
	this.radius = reader.readInt();
	this.direction = reader.readBoolean();
	return this;
    }

    @Override
    protected AbstractMazeObject readMazeObjectHook(final XDataReader reader, final int formatVersion)
	    throws IOException {
	this.radius = reader.readInt();
	this.direction = reader.readBoolean();
	return this;
    }

    @Override
    protected void writeMazeObjectHook(final XDataWriter writer) throws IOException {
	writer.writeInt(this.radius);
	writer.writeBoolean(this.direction);
    }

    @Override
    public int getCustomFormat() {
	return AbstractMazeObject.CUSTOM_FORMAT_MANUAL_OVERRIDE;
    }

    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	if (this.direction) {
	    Game.getApplication().getGameManager().doClockwiseRotate(this.radius);
	} else {
	    Game.getApplication().getGameManager().doCounterclockwiseRotate(this.radius);
	}
	SoundLoader.playSound(SoundConstants.SOUND_CHANGE);
    }

    @Override
    public String getDescription() {
	return "Rotation Traps rotate part of the maze when stepped on.";
    }
}
