/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.maze.abc.AbstractButton;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class GreenButton extends AbstractButton {
    public GreenButton() {
	super(new GreenWallOff(), new GreenWallOn(), ColorConstants.COLOR_GREEN);
    }

    @Override
    public String getName() {
	return "Green Button";
    }

    @Override
    public String getPluralName() {
	return "Green Buttons";
    }

    @Override
    public String getDescription() {
	return "Green Buttons will cause all Green Walls Off to become On, and all Green Walls On to become Off.";
    }
}
