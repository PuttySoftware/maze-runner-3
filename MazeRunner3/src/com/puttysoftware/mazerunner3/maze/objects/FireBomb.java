/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Boot;
import com.puttysoftware.mazerunner3.maze.abc.AbstractBomb;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class FireBomb extends AbstractBomb {
    // Constructors
    public FireBomb() {
	super(ColorConstants.COLOR_LIGHT_RED);
    }

    @Override
    public String getName() {
	return "Fire Bomb";
    }

    @Override
    public String getPluralName() {
	return "Fire Bombs";
    }

    @Override
    public String getDescription() {
	return "Fire Bombs burn anything in an area of radius 2 centered on the target point.";
    }

    @Override
    public void useActionHook(final int x, final int y, final int z) {
	// Enrage objects that react to fire
	Boot.getApplication().getMazeManager().getMaze().radialScanEnrageObjects(x, y, z, AbstractBomb.EFFECT_RADIUS);
	// Burn the ground, too
	Boot.getApplication().getMazeManager().getMaze().radialScanBurnGround(x, y, z, AbstractBomb.EFFECT_RADIUS);
    }
}
