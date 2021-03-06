/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractMultipleKey;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class Suit extends AbstractMultipleKey {
    // Constructors
    public Suit() {
	super(ColorConstants.COLOR_MAGENTA);
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_SUIT;
    }

    @Override
    public String getName() {
	return "Suit";
    }

    @Override
    public String getPluralName() {
	return "Suits";
    }

    @Override
    public String getDescription() {
	return "Suits are the keys to Suit Walls.";
    }

    @Override
    public String getIdentifierV1() {
	return "Magenta Crystal";
    }
}