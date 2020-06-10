/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Application;
import com.puttysoftware.mazerunner3.Boot;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.MazeConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractMazeObject;
import com.puttysoftware.mazerunner3.maze.abc.AbstractWand;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class WarpWand extends AbstractWand {
    public WarpWand() {
	super(ColorConstants.COLOR_CYAN);
    }

    @Override
    public String getName() {
	return "Warp Wand";
    }

    @Override
    public String getPluralName() {
	return "Warp Wands";
    }

    @Override
    public void useHelper(final int x, final int y, final int z) {
	this.useAction(null, x, y, z);
	SoundLoader.playSound(SoundConstants.SOUND_TELEPORT);
    }

    @Override
    public void useAction(final AbstractMazeObject mo, final int x, final int y, final int z) {
	final Application app = Boot.getApplication();
	app.getMazeManager().getMaze().warpObject(
		app.getMazeManager().getMaze().getCell(x, y, z, MazeConstants.LAYER_OBJECT), x, y, z,
		MazeConstants.LAYER_OBJECT);
    }

    @Override
    public String getDescription() {
	return "Warp Wands will teleport the object at the target square to a random location when used.";
    }
}
