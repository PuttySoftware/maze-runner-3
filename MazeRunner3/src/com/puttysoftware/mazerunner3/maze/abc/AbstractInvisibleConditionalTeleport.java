/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.abc;

import com.puttysoftware.mazerunner3.Application;
import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.objects.MoonStone;
import com.puttysoftware.mazerunner3.maze.objects.SunStone;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;

public abstract class AbstractInvisibleConditionalTeleport extends AbstractConditionalTeleport {
    // Constructors
    protected AbstractInvisibleConditionalTeleport(final int attrName) {
	super(attrName);
	this.setTemplateColor(ColorConstants.COLOR_CYAN);
	this.setAttributeTemplateColor(ColorConstants.COLOR_INVISIBLE_TELEPORT_ATTRIBUTE);
    }

    // Scriptability
    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
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
	    app.getGameManager().updatePositionAbsolute(this.getDestinationRow2(), this.getDestinationColumn2(),
		    this.getDestinationFloor2());
	} else {
	    app.getGameManager().updatePositionAbsolute(this.getDestinationRow(), this.getDestinationColumn(),
		    this.getDestinationFloor());
	}
	Game.getApplication().showMessage("Invisible Teleport!");
	SoundLoader.playSound(SoundConstants.SOUND_TELEPORT);
	this.postMoveActionHook();
    }
}
