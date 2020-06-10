/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractTeleportTo;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class FinishTo extends AbstractTeleportTo {
    // Constructors
    public FinishTo() {
	super(ColorConstants.COLOR_NONE);
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_FINISH_TO;
    }

    @Override
    public String getName() {
	return "Finish To";
    }

    @Override
    public String getPluralName() {
	return "Finishes To";
    }

    @Override
    public String getDescription() {
	return "Finishes To behave like regular Finishes, except that the level they send you to might not be the next one.";
    }
}