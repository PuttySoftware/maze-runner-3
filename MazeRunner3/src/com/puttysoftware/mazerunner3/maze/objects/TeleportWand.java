/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Application;
import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.abc.AbstractMazeObject;
import com.puttysoftware.mazerunner3.maze.abc.AbstractWand;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class TeleportWand extends AbstractWand {
    public TeleportWand() {
	super(ColorConstants.COLOR_PURPLE);
    }

    @Override
    public String getName() {
	return "Teleport Wand";
    }

    @Override
    public String getPluralName() {
	return "Teleport Wands";
    }

    @Override
    public void useHelper(final int x, final int y, final int z) {
	this.useAction(null, x, y, z);
	SoundLoader.playSound(SoundConstants.SOUND_TELEPORT);
    }

    @Override
    public void useAction(final AbstractMazeObject mo, final int x, final int y, final int z) {
	final Application app = Game.getApplication();
	app.getGameManager().updatePositionAbsolute(x, y, z);
    }

    @Override
    public String getDescription() {
	return "Teleport Wands will teleport you to the target square when used. You cannot teleport to areas you cannot see.";
    }
}
