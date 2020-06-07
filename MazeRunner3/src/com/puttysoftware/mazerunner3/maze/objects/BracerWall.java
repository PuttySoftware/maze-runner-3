/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.maze.abc.AbstractMultipleLock;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.resourcemanagers.ObjectImageConstants;

public class BracerWall extends AbstractMultipleLock {
    // Constructors
    public BracerWall() {
        super(new Bracer(), ColorConstants.COLOR_CYAN);
    }

    @Override
    public int getAttributeID() {
        return ObjectImageConstants.OBJECT_IMAGE_BRACERS;
    }

    @Override
    public String getName() {
        return "Bracer Wall";
    }

    @Override
    public String getPluralName() {
        return "Bracer Walls";
    }

    @Override
    public String getDescription() {
        return "Bracer Walls are impassable without enough Bracers.";
    }

    @Override
    public String getIdentifierV1() {
        return "Cyan Crystal Wall";
    }
}