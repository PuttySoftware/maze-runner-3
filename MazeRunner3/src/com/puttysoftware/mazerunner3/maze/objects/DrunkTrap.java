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

public class DrunkTrap extends AbstractTrap {
    // Fields
    private static final int EFFECT_DURATION = 10;

    // Constructors
    public DrunkTrap() {
	super(ColorConstants.COLOR_LIGHT_PURPLE, ObjectImageConstants.OBJECT_IMAGE_DRUNK, ColorConstants.COLOR_PURPLE);
    }

    @Override
    public String getName() {
	return "Drunk Trap";
    }

    @Override
    public String getPluralName() {
	return "Drunk Traps";
    }

    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	Game.getApplication().showMessage("You stumble around drunkenly!");
	Game.getApplication().getGameManager().activateEffect(MazeEffectConstants.EFFECT_DRUNK,
		DrunkTrap.EFFECT_DURATION);
	SoundLoader.playSound(SoundConstants.SOUND_DRUNK);
    }

    @Override
    public String getDescription() {
	return "Drunk Traps alter your movement in a way that resembles being intoxicated for 10 steps when stepped on.";
    }
}