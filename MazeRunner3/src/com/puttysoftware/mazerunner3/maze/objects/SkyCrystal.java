/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.maze.abc.AbstractProgrammableKey;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class SkyCrystal extends AbstractProgrammableKey {
    // Constructors
    public SkyCrystal() {
	super("Sky", ColorConstants.COLOR_SKY);
    }

    // Scriptability
    @Override
    public String getName() {
	return "Sky Crystal";
    }

    @Override
    public String getPluralName() {
	return "Sky Crystals";
    }

    @Override
    public String getDescription() {
	return "Sky Crystals will open Sky Crystal Walls.";
    }

    @Override
    public final String getIdentifierV1() {
	return "";
    }
}