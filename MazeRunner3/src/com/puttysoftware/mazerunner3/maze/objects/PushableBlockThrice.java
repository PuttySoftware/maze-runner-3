/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Application;
import com.puttysoftware.mazerunner3.Boot;
import com.puttysoftware.mazerunner3.maze.MazeConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractMazeObject;
import com.puttysoftware.mazerunner3.maze.abc.AbstractMovableObject;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;
import com.puttysoftware.mazerunner3.resourcemanagers.ObjectImageConstants;
import com.puttysoftware.mazerunner3.resourcemanagers.SoundConstants;
import com.puttysoftware.mazerunner3.resourcemanagers.SoundManager;

public class PushableBlockThrice extends AbstractMovableObject {
    // Constructors
    public PushableBlockThrice() {
	super(true, false, ObjectImageConstants.OBJECT_IMAGE_THRICE);
	this.setTemplateColor(ColorConstants.COLOR_BLOCK);
    }

    @Override
    public String getName() {
	return "Pushable Block Thrice";
    }

    @Override
    public String getPluralName() {
	return "Pushable Blocks Thrice";
    }

    @Override
    public void pushAction(final MazeObjectInventory inv, final AbstractMazeObject mo, final int x, final int y,
	    final int pushX, final int pushY) {
	final Application app = Boot.getApplication();
	app.getGameManager().updatePushedPosition(x, y, pushX, pushY, this);
	SoundManager.playSound(SoundConstants.SOUND_PUSH_PULL);
	app.getGameManager().morphOther(new PushableBlockTwice(), pushX, pushY, MazeConstants.LAYER_OBJECT);
    }

    @Override
    public String getDescription() {
	return "Pushable Blocks Thrice can only be pushed three times, before turning into a wall.";
    }
}