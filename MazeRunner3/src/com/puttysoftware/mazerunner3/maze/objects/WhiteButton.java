/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.maze.abc.AbstractButton;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class WhiteButton extends AbstractButton {
    public WhiteButton() {
	super(new WhiteWallOff(), new WhiteWallOn(), ColorConstants.COLOR_WHITE);
    }

    @Override
    public String getName() {
	return "White Button";
    }

    @Override
    public String getPluralName() {
	return "White Buttons";
    }

    @Override
    public String getDescription() {
	return "White Buttons will cause all White Walls Off to become On, and all White Walls On to become Off.";
    }
}
