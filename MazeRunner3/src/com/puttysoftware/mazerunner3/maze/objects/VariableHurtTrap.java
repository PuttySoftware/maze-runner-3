/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.creatures.party.PartyManager;
import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.abc.AbstractTrap;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;
import com.puttysoftware.randomrange.RandomRange;

public class VariableHurtTrap extends AbstractTrap {
    // Fields
    private RandomRange damageDealt;
    private static final int MIN_DAMAGE = 1;
    private int maxDamage;

    // Constructors
    public VariableHurtTrap() {
	super(ColorConstants.COLOR_SKY, ObjectImageConstants.OBJECT_IMAGE_VARIABLE_HEALTH,
		ColorConstants.COLOR_DARK_SKY);
    }

    @Override
    public String getName() {
	return "Variable Hurt Trap";
    }

    @Override
    public String getPluralName() {
	return "Variable Hurt Traps";
    }

    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	this.maxDamage = PartyManager.getParty().getLeader().getMaximumHP() / 10;
	if (this.maxDamage < VariableHurtTrap.MIN_DAMAGE) {
	    this.maxDamage = VariableHurtTrap.MIN_DAMAGE;
	}
	this.damageDealt = new RandomRange(VariableHurtTrap.MIN_DAMAGE, this.maxDamage);
	PartyManager.getParty().getLeader().doDamage(this.damageDealt.generate());
	SoundLoader.playSound(SoundConstants.SOUND_BARRIER);
	Game.getApplication().getGameManager().decay();
    }

    @Override
    public String getDescription() {
	return "Variable Hurt Traps hurt you when stepped on, then disappear.";
    }
}