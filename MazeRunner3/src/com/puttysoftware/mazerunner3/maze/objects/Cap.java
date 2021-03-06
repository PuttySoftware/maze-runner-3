/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractMultipleKey;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class Cap extends AbstractMultipleKey {
    // Constructors
    public Cap() {
	super(ColorConstants.COLOR_RED);
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_CAP;
    }

    @Override
    public String getName() {
	return "Cap";
    }

    @Override
    public String getPluralName() {
	return "Caps";
    }

    @Override
    public String getDescription() {
	return "Caps are the keys to Cap Walls.";
    }

    @Override
    public String getIdentifierV1() {
	return "Red Crystal";
    }
}