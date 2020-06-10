/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.abc.AbstractGem;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class LightnessGem extends AbstractGem {
    // Constructors
    public LightnessGem() {
	super(ColorConstants.COLOR_LIGHT_YELLOW);
    }

    @Override
    public String getName() {
	return "Lightness Gem";
    }

    @Override
    public String getPluralName() {
	return "Lightness Gems";
    }

    @Override
    public void postMoveActionHook() {
	Game.getApplication().getMazeManager().getMaze().incrementVisionRadius();
	SoundLoader.playSound(SoundConstants.SOUND_LIGHT);
    }

    @Override
    public String getDescription() {
	return "Lightness Gems increase the visible area by 1.";
    }
}
