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
import com.puttysoftware.mazerunner3.maze.abc.AbstractMazeObject;
import com.puttysoftware.mazerunner3.maze.abc.AbstractMovableObject;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;

public class PushableBlockTwice extends AbstractMovableObject {
    // Constructors
    public PushableBlockTwice() {
	super(true, false, ObjectImageConstants.OBJECT_IMAGE_TWICE);
	this.setTemplateColor(ColorConstants.COLOR_BLOCK);
    }

    @Override
    public String getName() {
	return "Pushable Block Twice";
    }

    @Override
    public String getPluralName() {
	return "Pushable Blocks Twice";
    }

    @Override
    public void pushAction(final MazeObjectInventory inv, final AbstractMazeObject mo, final int x, final int y,
	    final int pushX, final int pushY) {
	final Application app = Game.getApplication();
	app.getGameManager().updatePushedPosition(x, y, pushX, pushY, this);
	SoundLoader.playSound(SoundConstants.SOUND_PUSH_PULL);
	app.getGameManager().morphOther(new PushableBlockOnce(), pushX, pushY, MazeConstants.LAYER_OBJECT);
    }

    @Override
    public String getDescription() {
	return "Pushable Blocks Twice can only be pushed twice, before turning into a wall.";
    }
}