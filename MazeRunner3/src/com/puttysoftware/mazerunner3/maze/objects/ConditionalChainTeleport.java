/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Application;
import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.abc.AbstractConditionalTeleport;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;

public class ConditionalChainTeleport extends AbstractConditionalTeleport {
    // Constructors
    public ConditionalChainTeleport() {
	super(ObjectImageConstants.OBJECT_IMAGE_CONDITIONAL_CHAIN);
    }

    @Override
    public final void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	final Application app = Game.getApplication();
	int testVal;
	if (this.getSunMoon() == AbstractConditionalTeleport.TRIGGER_SUN) {
	    testVal = inv.getItemCount(new SunStone());
	} else if (this.getSunMoon() == AbstractConditionalTeleport.TRIGGER_MOON) {
	    testVal = inv.getItemCount(new MoonStone());
	} else {
	    testVal = 0;
	}
	if (testVal >= this.getTriggerValue()) {
	    app.getGameManager().updatePositionAbsoluteNoEvents(this.getDestinationRow2(), this.getDestinationColumn2(),
		    this.getDestinationFloor2(), this.getDestinationLevel());
	} else {
	    app.getGameManager().updatePositionAbsoluteNoEvents(this.getDestinationRow(), this.getDestinationColumn(),
		    this.getDestinationFloor(), this.getDestinationLevel());
	}
	SoundLoader.playSound(SoundConstants.SOUND_TELEPORT);
	this.postMoveActionHook();
    }

    @Override
    public String getName() {
	return "Conditional Chain Teleport";
    }

    @Override
    public String getPluralName() {
	return "Conditional Chain Teleports";
    }

    @Override
    public String getDescription() {
	return "Conditional Chain Teleports send you to one of two predetermined destinations when stepped on, depending on how many Sun or Moon Stones are in your inventory.";
    }
}