/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.abc.AbstractWand;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class WallMakingWand extends AbstractWand {
    public WallMakingWand() {
	super(ColorConstants.COLOR_RED);
    }

    @Override
    public String getName() {
	return "Wall-Making Wand";
    }

    @Override
    public String getPluralName() {
	return "Wall-Making Wands";
    }

    @Override
    public void useHelper(final int x, final int y, final int z) {
	this.useAction(new Wall(), x, y, z);
	SoundLoader.playSound(SoundConstants.SOUND_CREATE);
    }

    @Override
    public String getDescription() {
	return "Wall-Making Wands will create an ordinary wall in the target square when used.";
    }
}
