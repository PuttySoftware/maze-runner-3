/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.creatures.StatConstants;
import com.puttysoftware.mazerunner3.creatures.party.PartyManager;
import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractPotion;

public class SuperHurtPotion extends AbstractPotion {
    // Constructors
    public SuperHurtPotion() {
	super(StatConstants.STAT_CURRENT_HP, false);
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_SUPER_HURT_POTION;
    }

    @Override
    public String getName() {
	return "Super Hurt Potion";
    }

    @Override
    public String getPluralName() {
	return "Super Hurt Potions";
    }

    @Override
    public int getEffectValue() {
	return -(PartyManager.getParty().getLeader().getCurrentHP() - 1);
    }

    @Override
    public String getDescription() {
	return "Super Hurt Potions bring you to the brink of death when picked up.";
    }
}