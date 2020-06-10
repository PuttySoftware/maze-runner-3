/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.maze.abc.AbstractScoreIncreaser;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class Sapphire extends AbstractScoreIncreaser {
    // Fields
    private static final long SCORE_INCREASE = 250L;

    // Constructors
    public Sapphire() {
	super(ColorConstants.COLOR_LIGHT_GREEN);
    }

    @Override
    public String getName() {
	return "Sapphire";
    }

    @Override
    public String getPluralName() {
	return "Sapphires";
    }

    @Override
    public void postMoveActionHook() {
	Game.getApplication().getGameManager().addToScore(Sapphire.SCORE_INCREASE);
    }

    @Override
    public String getDescription() {
	return "Sapphires increase your score when picked up.";
    }
}
