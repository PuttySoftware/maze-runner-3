/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Application;
import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.abc.AbstractCheckKey;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;

public class MoonStone extends AbstractCheckKey {
    // Constructors
    public MoonStone() {
	super();
	this.setTemplateColor(ColorConstants.COLOR_MOON_DOOR);
    }

    @Override
    public String getName() {
	return "Moon Stone";
    }

    @Override
    public String getPluralName() {
	return "Moon Stones";
    }

    @Override
    public String getDescription() {
	return "Moon Stones act as a trigger for other actions when collected.";
    }

    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	inv.addItem(this);
	final Application app = Game.getApplication();
	app.getGameManager().decay();
	SoundLoader.playSound(SoundConstants.SOUND_SUN_STONE);
    }
}