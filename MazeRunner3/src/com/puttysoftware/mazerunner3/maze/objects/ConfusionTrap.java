/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.abc.AbstractTrap;
import com.puttysoftware.mazerunner3.maze.effects.MazeEffectConstants;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;

public class ConfusionTrap extends AbstractTrap {
    // Fields
    private static final int EFFECT_DURATION = 10;

    // Constructors
    public ConfusionTrap() {
	super(ColorConstants.COLOR_LIGHT_RED, ObjectImageConstants.OBJECT_IMAGE_CONFUSION,
		ColorConstants.COLOR_DARK_RED);
    }

    @Override
    public String getName() {
	return "Confusion Trap";
    }

    @Override
    public String getPluralName() {
	return "Confusion Traps";
    }

    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	Game.getApplication().showMessage("You are confused!");
	Game.getApplication().getGameManager().activateEffect(MazeEffectConstants.EFFECT_CONFUSED,
		ConfusionTrap.EFFECT_DURATION);
	SoundLoader.playSound(SoundConstants.SOUND_CONFUSED);
    }

    @Override
    public String getDescription() {
	return "Confusion Traps randomly alter your controls for 10 steps when stepped on.";
    }
}