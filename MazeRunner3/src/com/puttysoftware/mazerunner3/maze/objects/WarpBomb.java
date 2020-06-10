/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Boot;
import com.puttysoftware.mazerunner3.maze.MazeConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractBomb;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.resourcemanagers.SoundConstants;
import com.puttysoftware.mazerunner3.resourcemanagers.SoundManager;

public class WarpBomb extends AbstractBomb {
    // Constructors
    public WarpBomb() {
	super(ColorConstants.COLOR_BLUE);
    }

    @Override
    public String getName() {
	return "Warp Bomb";
    }

    @Override
    public String getPluralName() {
	return "Warp Bombs";
    }

    @Override
    public String getDescription() {
	return "Warp Bombs randomly teleport anything around the center of the target point.";
    }

    @Override
    public void useActionHook(final int x, final int y, final int z) {
	SoundManager.playSound(SoundConstants.SOUND_EXPLODE);
	Boot.getApplication().getMazeManager().getMaze().radialScanWarpObjects(x, y, z, MazeConstants.LAYER_OBJECT,
		AbstractBomb.EFFECT_RADIUS);
    }
}