/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.abc.AbstractWall;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;

public class InvisibleWall extends AbstractWall {
    // Constructors
    public InvisibleWall() {
	super(true, ColorConstants.COLOR_INVISIBLE);
    }

    // Scriptability
    @Override
    public void moveFailedAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	// Display invisible wall message, if it's enabled
	Game.getApplication().showMessage("Invisible Wall!");
	SoundLoader.playSound(SoundConstants.SOUND_WALK_FAILED);
    }

    @Override
    public boolean isConditionallySolid(final MazeObjectInventory inv) {
	// Disallow passing through Invisible Walls under ANY circumstances
	return true;
    }

    @Override
    public String getName() {
	return "Invisible Wall";
    }

    @Override
    public String getGameName() {
	return "Empty";
    }

    @Override
    public String getPluralName() {
	return "Invisible Walls";
    }

    @Override
    public String getDescription() {
	return "Invisible Walls look like any other open space, but block any attempt at moving into them.";
    }
}