/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.maze.abc.AbstractButton;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class MagentaButton extends AbstractButton {
    public MagentaButton() {
	super(new MagentaWallOff(), new MagentaWallOn(), ColorConstants.COLOR_MAGENTA);
    }

    @Override
    public String getName() {
	return "Magenta Button";
    }

    @Override
    public String getPluralName() {
	return "Magenta Buttons";
    }

    @Override
    public String getDescription() {
	return "Magenta Buttons will cause all Magenta Walls Off to become On, and all Magenta Walls On to become Off.";
    }
}
