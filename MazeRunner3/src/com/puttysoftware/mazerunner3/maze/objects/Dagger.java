/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractMultipleKey;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class Dagger extends AbstractMultipleKey {
    // Constructors
    public Dagger() {
	super(ColorConstants.COLOR_BLUE);
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_DAGGER;
    }

    @Override
    public String getName() {
	return "Dagger";
    }

    @Override
    public String getPluralName() {
	return "Daggers";
    }

    @Override
    public String getDescription() {
	return "Daggers are the keys to Dagger Walls.";
    }

    @Override
    public String getIdentifierV1() {
	return "Blue Crystal";
    }
}