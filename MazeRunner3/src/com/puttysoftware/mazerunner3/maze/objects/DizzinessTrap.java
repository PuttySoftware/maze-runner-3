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

public class DizzinessTrap extends AbstractTrap {
    // Fields
    private static final int EFFECT_DURATION = 10;

    // Constructors
    public DizzinessTrap() {
	super(ColorConstants.COLOR_LIGHT_GREEN, ObjectImageConstants.OBJECT_IMAGE_DIZZINESS,
		ColorConstants.COLOR_GREEN);
    }

    @Override
    public String getName() {
	return "Dizziness Trap";
    }

    @Override
    public String getPluralName() {
	return "Dizziness Traps";
    }

    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	Game.getApplication().showMessage("You feel dizzy!");
	Game.getApplication().getGameManager().activateEffect(MazeEffectConstants.EFFECT_DIZZY,
		DizzinessTrap.EFFECT_DURATION);
	SoundLoader.playSound(SoundConstants.SOUND_DIZZY);
    }

    @Override
    public String getDescription() {
	return "Dizziness Traps randomly alter your controls each step for 10 steps when stepped on.";
    }
}