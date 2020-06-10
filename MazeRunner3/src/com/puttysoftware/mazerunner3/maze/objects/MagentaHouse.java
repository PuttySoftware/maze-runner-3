/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Application;
import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.abc.AbstractTeleportTo;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;

public class MagentaHouse extends AbstractTeleportTo {
    // Constructors
    public MagentaHouse() {
	super(ColorConstants.COLOR_MAGENTA);
    }

    // Scriptability
    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	final Application app = Game.getApplication();
	SoundLoader.playSound(SoundConstants.SOUND_UP);
	app.getGameManager().goToLevel(this.getDestinationLevel());
    }

    @Override
    public String getName() {
	return "Magenta House";
    }

    @Override
    public String getPluralName() {
	return "Magenta Houses";
    }

    @Override
    public String getDescription() {
	return "Magenta Houses send you inside when walked on.";
    }
}