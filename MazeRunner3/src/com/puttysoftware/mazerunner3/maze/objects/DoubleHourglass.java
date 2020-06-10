/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.abc.AbstractTimeModifier;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;

public class DoubleHourglass extends AbstractTimeModifier {
    // Fields
    private static final long SCORE_GRAB = 20L;

    // Constructors
    public DoubleHourglass() {
	super(ObjectImageConstants.OBJECT_IMAGE_SMALL_2, ColorConstants.COLOR_BLUE);
    }

    @Override
    public String getName() {
	return "Double Hourglass";
    }

    @Override
    public String getPluralName() {
	return "Double Hourglasses";
    }

    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	Game.getApplication().getGameManager().decay();
	Game.getApplication().getMazeManager().getMaze().extendTimerByInitialValueDoubled();
	SoundLoader.playSound(SoundConstants.SOUND_GRAB);
	Game.getApplication().getGameManager().addToScore(DoubleHourglass.SCORE_GRAB);
    }

    @Override
    public String getDescription() {
	return "Double Hourglasses extend the time to solve the current level by double the initial value.";
    }
}
