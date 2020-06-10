package com.puttysoftware.mazerunner3.ai.window;

import com.puttysoftware.mazerunner3.creatures.AbstractCreature;

public class AttackAIRoutine extends AbstractWindowAIRoutine {
    @Override
    public int getNextAction(final AbstractCreature c) {
	return AbstractWindowAIRoutine.ACTION_ATTACK;
    }
}
