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
import com.puttysoftware.mazerunner3.maze.abc.AbstractRandomTeleport;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;

public class RandomTeleport extends AbstractRandomTeleport {
    // Constructors
    public RandomTeleport() {
	super(0, 0, ObjectImageConstants.OBJECT_IMAGE_RANDOM);
    }

    public RandomTeleport(final int newRandomRangeY, final int newRandomRangeX) {
	super(newRandomRangeY, newRandomRangeX, ObjectImageConstants.OBJECT_IMAGE_RANDOM);
    }

    // Scriptability
    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	final Application app = Game.getApplication();
	int dr, dc;
	do {
	    dr = this.getDestinationRow();
	    dc = this.getDestinationColumn();
	} while (!app.getGameManager().tryUpdatePositionRelative(dr, dc));
	app.getGameManager().updatePositionRelative(dr, dc, 0);
	SoundLoader.playSound(SoundConstants.SOUND_TELEPORT);
    }

    @Override
    public String getName() {
	return "Random Teleport";
    }

    @Override
    public String getPluralName() {
	return "Random Teleports";
    }

    @Override
    public String getDescription() {
	return "Random Teleports, unlike regular Teleports, send you to a randomly chosen destination.";
    }
}