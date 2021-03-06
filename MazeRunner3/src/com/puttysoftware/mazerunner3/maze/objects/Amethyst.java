/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.maze.abc.AbstractScoreIncreaser;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class Amethyst extends AbstractScoreIncreaser {
    // Fields
    private static final long SCORE_INCREASE = 50L;

    // Constructors
    public Amethyst() {
	super(ColorConstants.COLOR_MAGENTA);
    }

    @Override
    public String getName() {
	return "Amethyst";
    }

    @Override
    public String getPluralName() {
	return "Amethysts";
    }

    @Override
    public void postMoveActionHook() {
	Game.getApplication().getGameManager().addToScore(Amethyst.SCORE_INCREASE);
    }

    @Override
    public String getDescription() {
	return "Amethysts increase your score when picked up.";
    }
}
