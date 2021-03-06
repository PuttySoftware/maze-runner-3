/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.abc.AbstractContainer;
import com.puttysoftware.mazerunner3.maze.abc.AbstractMazeObject;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;

public class TreasureChest extends AbstractContainer {
    // Constructors
    public TreasureChest() {
	super(new TreasureKey());
	this.setTemplateColor(ColorConstants.COLOR_BRIDGE);
    }

    public TreasureChest(final AbstractMazeObject inside) {
	super(new TreasureKey(), inside);
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_TREASURE_CHEST;
    }

    // Scriptability
    @Override
    public void moveFailedAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	if (this.isConditionallyDirectionallySolid(ie, dirX, dirY, inv)) {
	    Game.getApplication().showMessage("You need a treasure key");
	}
	SoundLoader.playSound(SoundConstants.SOUND_WALK_FAILED);
    }

    @Override
    public String getName() {
	return "Treasure Chest";
    }

    @Override
    public String getPluralName() {
	return "Treasure Chests";
    }

    @Override
    public AbstractMazeObject editorPropertiesHook() {
	return Game.getApplication().getEditor().editTreasureChestContents();
    }

    @Override
    public String getDescription() {
	return "Treasure Chests require Treasure Keys to open, and contain 1 other item.";
    }
}