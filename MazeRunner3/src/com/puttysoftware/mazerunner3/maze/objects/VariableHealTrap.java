/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Boot;
import com.puttysoftware.mazerunner3.creatures.party.PartyManager;
import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.abc.AbstractTrap;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;
import com.puttysoftware.randomrange.RandomRange;

public class VariableHealTrap extends AbstractTrap {
    // Fields
    private RandomRange healingGiven;
    private static final int MIN_HEALING = 1;
    private int maxHealing;

    // Constructors
    public VariableHealTrap() {
	super(ColorConstants.COLOR_MAGENTA, ObjectImageConstants.OBJECT_IMAGE_VARIABLE_HEALTH,
		ColorConstants.COLOR_DARK_MAGENTA);
    }

    @Override
    public String getName() {
	return "Variable Heal Trap";
    }

    @Override
    public String getPluralName() {
	return "Variable Heal Traps";
    }

    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	this.maxHealing = PartyManager.getParty().getLeader().getMaximumHP() / 10;
	if (this.maxHealing < VariableHealTrap.MIN_HEALING) {
	    this.maxHealing = VariableHealTrap.MIN_HEALING;
	}
	this.healingGiven = new RandomRange(VariableHealTrap.MIN_HEALING, this.maxHealing);
	PartyManager.getParty().getLeader().heal(this.healingGiven.generate());
	SoundLoader.playSound(SoundConstants.SOUND_BARRIER);
	Boot.getApplication().getGameManager().decay();
    }

    @Override
    public String getDescription() {
	return "Variable Heal Traps heal you when stepped on, then disappear.";
    }
}