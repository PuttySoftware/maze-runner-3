/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.abc.AbstractGround;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;

public class BridgedSlimeVertical extends AbstractGround {
    // Constructors
    public BridgedSlimeVertical() {
	super(ColorConstants.COLOR_GREEN);
	this.setAttributeID(ObjectImageConstants.OBJECT_IMAGE_BRIDGE_VERTICAL);
	this.setAttributeTemplateColor(ColorConstants.COLOR_BRIDGE);
    }

    // Scriptability
    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	SoundLoader.playSound(SoundConstants.SOUND_WALK);
    }

    @Override
    public String getName() {
	return "Bridged Slime Vertical";
    }

    @Override
    public String getPluralName() {
	return "Squares of Bridged Slime Vertical";
    }

    @Override
    public boolean overridesDefaultPostMove() {
	return true;
    }

    @Override
    public String getDescription() {
	return "Bridged Slime Vertical, unlike Slime, can be walked on.";
    }
}
