/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: mazer5d@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.effects;

import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.maze.objects.TrueSightAmulet;

public class TrueSight extends MazeEffect {
    // Constructor
    public TrueSight(final int newRounds) {
	super("True Sight", newRounds);
    }

    @Override
    public void customExtendLogic() {
	// Apply the effect
	Game.getApplication().getGameManager().enableTrueSight();
    }

    @Override
    public void customTerminateLogic() {
	// Remove item that granted effect from inventory
	Game.getApplication().getGameManager().getObjectInventory().removeItem(new TrueSightAmulet());
	// Undo the effect
	Game.getApplication().getGameManager().disableTrueSight();
    }
}