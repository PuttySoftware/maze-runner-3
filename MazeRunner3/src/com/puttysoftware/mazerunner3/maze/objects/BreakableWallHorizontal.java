/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Boot;
import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.Maze;
import com.puttysoftware.mazerunner3.maze.MazeConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractMazeObject;
import com.puttysoftware.mazerunner3.maze.abc.AbstractWall;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;
import com.puttysoftware.mazerunner3.maze.utilities.TypeConstants;

public class BreakableWallHorizontal extends AbstractWall {
    // Constructors
    public BreakableWallHorizontal() {
	super(ColorConstants.COLOR_BROWN);
	this.setAttributeID(ObjectImageConstants.OBJECT_IMAGE_BREAKABLE_HORIZONTAL);
	this.setAttributeTemplateColor(ColorConstants.COLOR_NONE);
    }

    @Override
    public String getName() {
	return "Breakable Wall Horizontal";
    }

    @Override
    public String getPluralName() {
	return "Breakable Walls Horizontal";
    }

    @Override
    public String getDescription() {
	return "Breakable Walls Horizontal break up into nothing if walked into, and propagate the effect to other like walls.";
    }

    @Override
    public void moveFailedAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	final int dirZ = Boot.getApplication().getMazeManager().getMaze().getPlayerLocationZ();
	this.chainReactionAction(dirX, dirY, dirZ);
	SoundLoader.playSound(SoundConstants.SOUND_CRACK);
    }

    @Override
    public void chainReactionAction(final int dirX, final int dirY, final int dirZ) {
	// Break up
	Boot.getApplication().getGameManager().morph(new Empty(), dirX, dirY, dirZ, MazeConstants.LAYER_OBJECT);
	final Maze m = Boot.getApplication().getMazeManager().getMaze();
	try {
	    final AbstractMazeObject left = m.getCell(dirX - 1, dirY, dirZ, MazeConstants.LAYER_OBJECT);
	    if (left.isOfType(TypeConstants.TYPE_BREAKABLE_H)) {
		this.chainReactionAction(dirX - 1, dirY, dirZ);
	    }
	} catch (final ArrayIndexOutOfBoundsException aioobe) {
	    // Ignore
	}
	try {
	    final AbstractMazeObject right = m.getCell(dirX + 1, dirY, dirZ, MazeConstants.LAYER_OBJECT);
	    if (right.isOfType(TypeConstants.TYPE_BREAKABLE_H)) {
		this.chainReactionAction(dirX + 1, dirY, dirZ);
	    }
	} catch (final ArrayIndexOutOfBoundsException aioobe) {
	    // Ignore
	}
    }

    @Override
    protected void setTypes() {
	this.type.set(TypeConstants.TYPE_WALL);
	this.type.set(TypeConstants.TYPE_BREAKABLE_H);
    }
}