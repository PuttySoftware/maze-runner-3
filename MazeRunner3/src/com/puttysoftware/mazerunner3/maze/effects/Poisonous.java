/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: mazer5d@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.effects;

import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.maze.objects.PoisonousAmulet;

public class Poisonous extends MazeEffect {
    // Constructor
    public Poisonous(final int newRounds) {
	super("Poisonous", newRounds);
    }

    @Override
    public void customExtendLogic() {
	// Apply the effect
	Game.getApplication().getMazeManager().getMaze().doPoisonousAmulet();
    }

    @Override
    public void customTerminateLogic() {
	// Remove item that granted effect from inventory
	Game.getApplication().getGameManager().getObjectInventory().removeItem(new PoisonousAmulet());
	// Undo the effect
	Game.getApplication().getMazeManager().getMaze().undoPoisonAmulets();
    }
}