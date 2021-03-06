/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.abc.AbstractWand;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class WallBreakingWand extends AbstractWand {
    // Constructors
    public WallBreakingWand() {
	super(ColorConstants.COLOR_BLUE);
    }

    @Override
    public String getName() {
	return "Wall-Breaking Wand";
    }

    @Override
    public String getPluralName() {
	return "Wall-Breaking Wands";
    }

    @Override
    public void useHelper(final int x, final int y, final int z) {
	this.useAction(new Empty(), x, y, z);
	SoundLoader.playSound(SoundConstants.SOUND_DESTROY);
    }

    @Override
    public String getDescription() {
	return "Wall-Breaking Wands will destroy one wall when used, if aimed at a wall.";
    }
}
