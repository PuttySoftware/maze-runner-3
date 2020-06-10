/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Boot;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.abc.AbstractGem;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class DimnessGem extends AbstractGem {
    // Constructors
    public DimnessGem() {
	super(ColorConstants.COLOR_LIGHT_PURPLE);
    }

    @Override
    public String getName() {
	return "Dimness Gem";
    }

    @Override
    public String getPluralName() {
	return "Dimness Gems";
    }

    @Override
    public void postMoveActionHook() {
	Boot.getApplication().getMazeManager().getMaze().decrementVisionRadius();
	SoundLoader.playSound(SoundConstants.SOUND_DARKNESS);
    }

    @Override
    public String getDescription() {
	return "Dimness Gems decrease the visible area by 1.";
    }
}
