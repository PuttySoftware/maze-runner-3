/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.creatures.party.PartyManager;
import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.abc.AbstractTrap;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;

public class HealTrap extends AbstractTrap {
    // Fields
    private int healing;

    // Constructors
    public HealTrap() {
	super(ColorConstants.COLOR_MAGENTA, ObjectImageConstants.OBJECT_IMAGE_HEALTH,
		ColorConstants.COLOR_DARK_MAGENTA);
    }

    @Override
    public String getName() {
	return "Heal Trap";
    }

    @Override
    public String getPluralName() {
	return "Heal Traps";
    }

    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	this.healing = PartyManager.getParty().getLeader().getMaximumHP() / 50;
	if (this.healing < 1) {
	    this.healing = 1;
	}
	PartyManager.getParty().getLeader().heal(this.healing);
	SoundLoader.playSound(SoundConstants.SOUND_BARRIER);
    }

    @Override
    public String getDescription() {
	return "Heal Traps heal you when stepped on.";
    }
}