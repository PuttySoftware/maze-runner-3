/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.maze.abc.AbstractMultipleKey;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.resourcemanagers.ObjectImageConstants;

public class Bracer extends AbstractMultipleKey {
    // Constructors
    public Bracer() {
	super(ColorConstants.COLOR_CYAN);
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_BRACERS;
    }

    @Override
    public String getName() {
	return "Bracer";
    }

    @Override
    public String getPluralName() {
	return "Bracers";
    }

    @Override
    public String getDescription() {
	return "Bracers are the keys to Bracer Walls.";
    }

    @Override
    public String getIdentifierV1() {
	return "Cyan Crystal";
    }
}