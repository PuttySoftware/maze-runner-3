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

public class BridgedLavaHorizontal extends AbstractGround {
    // Constructors
    public BridgedLavaHorizontal() {
	super(ColorConstants.COLOR_ORANGE);
	this.setAttributeID(ObjectImageConstants.OBJECT_IMAGE_BRIDGE_HORIZONTAL);
	this.setAttributeTemplateColor(ColorConstants.COLOR_BRIDGE);
    }

    // Scriptability
    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	SoundLoader.playSound(SoundConstants.SOUND_WALK);
    }

    @Override
    public String getName() {
	return "Bridged Lava Horizontal";
    }

    @Override
    public String getPluralName() {
	return "Squares of Bridged Lava Horizontal";
    }

    @Override
    public boolean overridesDefaultPostMove() {
	return true;
    }

    @Override
    public String getDescription() {
	return "Bridged Lava Horizontal, unlike Lava, can be walked on.";
    }
}
