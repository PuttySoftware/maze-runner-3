/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Boot;
import com.puttysoftware.mazerunner3.maze.abc.AbstractGem;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.resourcemanagers.SoundConstants;
import com.puttysoftware.mazerunner3.resourcemanagers.SoundManager;

public class BrightnessGem extends AbstractGem {
    // Constructors
    public BrightnessGem() {
	super(ColorConstants.COLOR_YELLOW);
    }

    @Override
    public String getName() {
	return "Brightness Gem";
    }

    @Override
    public String getPluralName() {
	return "Brightness Gems";
    }

    @Override
    public void postMoveActionHook() {
	Boot.getApplication().getMazeManager().getMaze().setVisionRadiusToMaximum();
	SoundManager.playSound(SoundConstants.SOUND_LIGHT);
    }

    @Override
    public String getDescription() {
	return "Brightness Gems increase the visible area to its maximum.";
    }
}
