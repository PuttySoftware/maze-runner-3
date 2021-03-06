/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.maze.abc.AbstractLightModifier;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class DarkGem extends AbstractLightModifier {
    // Constructors
    public DarkGem() {
	super(ColorConstants.COLOR_DARK_GRAY);
    }

    @Override
    public String getName() {
	return "Dark Gem";
    }

    @Override
    public String getPluralName() {
	return "Dark Gems";
    }

    @Override
    public String getDescription() {
	return "Dark Gems shroud the immediately adjacent area in permanent darkness.";
    }
}
