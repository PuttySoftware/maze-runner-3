/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractMultipleKey;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class Shield extends AbstractMultipleKey {
    // Constructors
    public Shield() {
	super(ColorConstants.COLOR_ORANGE);
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_SHIELD;
    }

    @Override
    public String getName() {
	return "Shield";
    }

    @Override
    public String getPluralName() {
	return "Shields";
    }

    @Override
    public String getDescription() {
	return "Shields are the keys to Shield Walls.";
    }

    @Override
    public String getIdentifierV1() {
	return "Orange Crystal";
    }
}