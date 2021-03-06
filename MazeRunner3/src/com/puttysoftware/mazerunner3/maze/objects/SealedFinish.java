/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractWall;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class SealedFinish extends AbstractWall {
    // Constructors
    public SealedFinish() {
	super(ColorConstants.COLOR_WHITE);
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_SEALED_FINISH;
    }

    @Override
    public String getName() {
	return "Sealed Finish";
    }

    @Override
    public String getPluralName() {
	return "Sealed Finishes";
    }

    @Override
    public String getDescription() {
	return "Sealed Finishes are Finishes that are currently closed.";
    }
}