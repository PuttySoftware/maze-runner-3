/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.maze.abc.AbstractAmulet;
import com.puttysoftware.mazerunner3.maze.effects.MazeEffectConstants;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class FireAmulet extends AbstractAmulet {
    // Constants
    private static final int EFFECT_DURATION = 30;

    // Constructors
    public FireAmulet() {
	super(ColorConstants.COLOR_RED);
    }

    @Override
    public String getName() {
	return "Fire Amulet";
    }

    @Override
    public String getPluralName() {
	return "Fire Amulets";
    }

    @Override
    public String getDescription() {
	return "Fire Amulets grant the power to transform ground into Hot Rock for 30 steps. Note that you can only wear one amulet at once.";
    }

    @Override
    public void stepAction() {
	final int x = Game.getApplication().getMazeManager().getMaze().getPlayerLocationX();
	final int y = Game.getApplication().getMazeManager().getMaze().getPlayerLocationY();
	final int z = Game.getApplication().getMazeManager().getMaze().getPlayerLocationZ();
	Game.getApplication().getMazeManager().getMaze().hotGround(x, y, z);
    }

    @Override
    public void postMoveActionHook() {
	Game.getApplication().getGameManager().activateEffect(MazeEffectConstants.EFFECT_FIERY,
		FireAmulet.EFFECT_DURATION);
    }
}