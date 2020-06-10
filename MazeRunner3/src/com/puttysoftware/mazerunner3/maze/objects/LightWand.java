/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.Maze;
import com.puttysoftware.mazerunner3.maze.MazeConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractMazeObject;
import com.puttysoftware.mazerunner3.maze.abc.AbstractWand;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class LightWand extends AbstractWand {
    // Constructors
    public LightWand() {
	super(ColorConstants.COLOR_WHITE);
    }

    @Override
    public String getName() {
	return "Light Wand";
    }

    @Override
    public String getPluralName() {
	return "Light Wands";
    }

    @Override
    public void useHelper(final int x, final int y, final int z) {
	final Maze m = Game.getApplication().getMazeManager().getMaze();
	final AbstractMazeObject obj = m.getCell(x, y, z, MazeConstants.LAYER_OBJECT);
	if (obj.getName().equals("Empty")) {
	    // Create a Light Gem
	    this.useAction(new LightGem(), x, y, z);
	    SoundLoader.playSound(SoundConstants.SOUND_LIGHT);
	} else if (obj.getName().equals("Dark Gem")) {
	    // Destroy the Dark Gem
	    this.useAction(new Empty(), x, y, z);
	    SoundLoader.playSound(SoundConstants.SOUND_SHATTER);
	}
    }

    @Override
    public String getDescription() {
	return "Light Wands have 2 uses. When aimed at an empty space, they create a Light Gem. When aimed at a Dark Gem, it is destroyed.";
    }
}
