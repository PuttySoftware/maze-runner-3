/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.maze.abc.AbstractButton;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class RoseButton extends AbstractButton {
    public RoseButton() {
	super(new RoseWallOff(), new RoseWallOn(), ColorConstants.COLOR_ROSE);
    }

    @Override
    public String getName() {
	return "Rose Button";
    }

    @Override
    public String getPluralName() {
	return "Rose Buttons";
    }

    @Override
    public String getDescription() {
	return "Rose Buttons will cause all Rose Walls Off to become On, and all Rose Walls On to become Off.";
    }
}
