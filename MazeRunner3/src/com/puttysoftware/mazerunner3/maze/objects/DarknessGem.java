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

public class DarknessGem extends AbstractGem {
    // Constructors
    public DarknessGem() {
	super(ColorConstants.COLOR_DARK_PURPLE);
    }

    @Override
    public String getName() {
	return "Darkness Gem";
    }

    @Override
    public String getPluralName() {
	return "Darkness Gems";
    }

    @Override
    public void postMoveActionHook() {
	Game.getApplication().getMazeManager().getMaze().setVisionRadiusToMinimum();
	SoundLoader.playSound(SoundConstants.SOUND_DARKNESS);
    }

    @Override
    public String getDescription() {
	return "Darkness Gems decrease the visible area to its minimum.";
    }
}
