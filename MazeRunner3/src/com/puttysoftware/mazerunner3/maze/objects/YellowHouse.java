/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Application;
import com.puttysoftware.mazerunner3.Boot;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.abc.AbstractTeleportTo;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;

public class YellowHouse extends AbstractTeleportTo {
    // Constructors
    public YellowHouse() {
	super(ColorConstants.COLOR_YELLOW);
    }

    // Scriptability
    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	final Application app = Boot.getApplication();
	SoundLoader.playSound(SoundConstants.SOUND_UP);
	app.getGameManager().goToLevel(this.getDestinationLevel());
    }

    @Override
    public String getName() {
	return "Yellow House";
    }

    @Override
    public String getPluralName() {
	return "Yellow Houses";
    }

    @Override
    public String getDescription() {
	return "Yellow Houses send you inside when walked on.";
    }
}