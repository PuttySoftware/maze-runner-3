/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.abc.AbstractWand;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class FinishMakingWand extends AbstractWand {
    public FinishMakingWand() {
	super(ColorConstants.COLOR_GREEN);
    }

    @Override
    public String getName() {
	return "Finish-Making Wand";
    }

    @Override
    public String getPluralName() {
	return "Finish-Making Wands";
    }

    @Override
    public void useHelper(final int x, final int y, final int z) {
	this.useAction(new Finish(), x, y, z);
	SoundLoader.playSound(SoundConstants.SOUND_CREATE);
    }

    @Override
    public String getDescription() {
	return "Finish-Making Wands will create a finish when used.";
    }
}
