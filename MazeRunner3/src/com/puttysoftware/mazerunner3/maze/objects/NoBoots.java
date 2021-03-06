/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.abc.AbstractInventoryModifier;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;

public class NoBoots extends AbstractInventoryModifier {
    // Constructors
    public NoBoots() {
	super();
	this.setAttributeID(ObjectImageConstants.OBJECT_IMAGE_NO);
	this.setAttributeTemplateColor(ColorConstants.COLOR_RED);
    }

    @Override
    public String getName() {
	return "No Boots";
    }

    @Override
    public String getPluralName() {
	return "Pairs of No Boots";
    }

    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	Game.getApplication().getGameManager().decay();
	inv.removeAllBoots();
	SoundLoader.playSound(SoundConstants.SOUND_GRAB);
    }

    @Override
    public String getDescription() {
	return "No Boots remove any boots worn when picked up.";
    }

    @Override
    public final int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_BOOTS;
    }
}
