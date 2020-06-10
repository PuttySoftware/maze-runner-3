/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Application;
import com.puttysoftware.mazerunner3.Boot;
import com.puttysoftware.mazerunner3.maze.abc.AbstractCheckKey;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;
import com.puttysoftware.mazerunner3.resourcemanagers.SoundConstants;
import com.puttysoftware.mazerunner3.resourcemanagers.SoundManager;

public class SunStone extends AbstractCheckKey {
    // Constructors
    public SunStone() {
	super();
	this.setTemplateColor(ColorConstants.COLOR_SUN_DOOR);
    }

    @Override
    public String getName() {
	return "Sun Stone";
    }

    @Override
    public String getPluralName() {
	return "Sun Stones";
    }

    @Override
    public String getDescription() {
	return "Sun Stones act as a trigger for other actions when collected.";
    }

    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	inv.addItem(this);
	final Application app = Boot.getApplication();
	app.getGameManager().decay();
	SoundManager.playSound(SoundConstants.SOUND_SUN_STONE);
    }
}