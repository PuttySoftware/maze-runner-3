/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Boot;
import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.MazeConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractWall;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;
import com.puttysoftware.mazerunner3.maze.utilities.TypeConstants;

public class CrumblingWall extends AbstractWall {
    // Constructors
    public CrumblingWall() {
	super(ColorConstants.COLOR_BROWN);
	this.setAttributeID(ObjectImageConstants.OBJECT_IMAGE_CRUMBLING);
	this.setAttributeTemplateColor(ColorConstants.COLOR_NONE);
    }

    @Override
    public String getName() {
	return "Crumbling Wall";
    }

    @Override
    public String getPluralName() {
	return "Crumbling Walls";
    }

    @Override
    public String getDescription() {
	return "Crumbling Walls break up into nothing if walked into.";
    }

    @Override
    public void moveFailedAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	final int z = Boot.getApplication().getMazeManager().getMaze().getPlayerLocationZ();
	Boot.getApplication().getGameManager().morph(new Empty(), dirX, dirY, z, MazeConstants.LAYER_OBJECT);
	SoundLoader.playSound(SoundConstants.SOUND_CRACK);
    }

    @Override
    protected void setTypes() {
	this.type.set(TypeConstants.TYPE_WALL);
    }
}