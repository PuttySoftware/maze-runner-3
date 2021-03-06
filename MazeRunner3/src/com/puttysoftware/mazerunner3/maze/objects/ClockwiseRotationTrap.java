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

public class ClockwiseRotationTrap extends AbstractTrap {
    // Fields
    private static final int EFFECT_DURATION = 10;

    // Constructors
    public ClockwiseRotationTrap() {
	super(ColorConstants.COLOR_CYAN, ObjectImageConstants.OBJECT_IMAGE_SMALL_ROTATION,
		ColorConstants.COLOR_DARK_CYAN);
    }

    @Override
    public String getName() {
	return "Clockwise Rotation Trap";
    }

    @Override
    public String getPluralName() {
	return "Clockwise Rotation Traps";
    }

    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	SoundLoader.playSound(SoundConstants.SOUND_CHANGE);
	Game.getApplication().showMessage("Your controls are rotated!");
	Game.getApplication().getGameManager().activateEffect(MazeEffectConstants.EFFECT_ROTATED_CLOCKWISE,
		ClockwiseRotationTrap.EFFECT_DURATION);
    }

    @Override
    public String getDescription() {
	return "Clockwise Rotation Traps rotate your controls clockwise for 10 steps when stepped on.";
    }
}