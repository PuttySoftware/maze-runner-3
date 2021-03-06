/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.abc.AbstractGround;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;

public class Ice extends AbstractGround {
    public Ice() {
	super(true, true, false, false, false, ColorConstants.COLOR_ICE);
    }

    @Override
    public final int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_CARPET;
    }

    @Override
    public String getName() {
	return "Ice";
    }

    @Override
    public String getPluralName() {
	return "Squares of Ice";
    }

    @Override
    public boolean overridesDefaultPostMove() {
	return true;
    }

    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	SoundLoader.playSound(SoundConstants.SOUND_WALK_ICE);
    }

    @Override
    public String getDescription() {
	return "Ice is one of the many types of ground - it is frictionless. Anything that crosses it will slide.";
    }

    @Override
    public boolean hasFrictionConditionally(final MazeObjectInventory inv, final boolean moving) {
	if (inv.isItemThere(new GlueBoots())) {
	    if (moving) {
		return false;
	    } else {
		return true;
	    }
	} else {
	    return false;
	}
    }
}
