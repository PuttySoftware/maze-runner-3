/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Application;
import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.MazeConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractAntiObject;
import com.puttysoftware.mazerunner3.maze.abc.AbstractMazeObject;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;

public class NoBlock extends AbstractAntiObject {
    // Constructors
    public NoBlock() {
	super();
	this.setTemplateColor(ColorConstants.COLOR_GRAY);
	this.setAttributeID(ObjectImageConstants.OBJECT_IMAGE_NO);
	this.setAttributeTemplateColor(ColorConstants.COLOR_RED);
    }

    @Override
    public final int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_BLOCK_BASE;
    }

    @Override
    public void pushIntoAction(final MazeObjectInventory inv, final AbstractMazeObject mo, final int x, final int y,
	    final int z) {
	// Destroy incoming block
	final Application app = Game.getApplication();
	app.getGameManager().morph(this, x, y, z, MazeConstants.LAYER_OBJECT);
	SoundLoader.playSound(SoundConstants.SOUND_DESTROY);
    }

    @Override
    public void pullIntoAction(final MazeObjectInventory inv, final AbstractMazeObject mo, final int x, final int y,
	    final int z) {
	// Destroy incoming block
	final Application app = Game.getApplication();
	app.getGameManager().morph(this, x, y, z, MazeConstants.LAYER_OBJECT);
	SoundLoader.playSound(SoundConstants.SOUND_DESTROY);
    }

    @Override
    public String getName() {
	return "No Block";
    }

    @Override
    public String getPluralName() {
	return "No Blocks";
    }

    @Override
    public String getDescription() {
	return "No Blocks destroy any blocks that attempt to pass through.";
    }
}