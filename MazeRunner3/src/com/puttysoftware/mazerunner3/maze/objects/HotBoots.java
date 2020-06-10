/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Boot;
import com.puttysoftware.mazerunner3.maze.abc.AbstractBoots;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class HotBoots extends AbstractBoots {
    // Constructors
    public HotBoots() {
	super(ColorConstants.COLOR_RED);
    }

    @Override
    public String getName() {
	return "Hot Boots";
    }

    @Override
    public String getPluralName() {
	return "Pairs of Hot Boots";
    }

    @Override
    public String getDescription() {
	return "Hot Boots transform any ground into Hot Rock as you walk. Note that you can only wear one pair of boots at once.";
    }

    @Override
    public void stepAction() {
	final int x = Boot.getApplication().getMazeManager().getMaze().getPlayerLocationX();
	final int y = Boot.getApplication().getMazeManager().getMaze().getPlayerLocationY();
	final int z = Boot.getApplication().getMazeManager().getMaze().getPlayerLocationZ();
	Boot.getApplication().getMazeManager().getMaze().hotGround(x, y, z);
    }
}
