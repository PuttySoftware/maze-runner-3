/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractInvisibleConditionalTeleport;

public class InvisibleConditionalTeleport extends AbstractInvisibleConditionalTeleport {
    // Constructors
    public InvisibleConditionalTeleport() {
	super(ObjectImageConstants.OBJECT_IMAGE_CONDITIONAL);
    }

    @Override
    public String getName() {
	return "Invisible Conditional Teleport";
    }

    @Override
    public String getPluralName() {
	return "Invisible Conditional Teleports";
    }

    @Override
    public String getDescription() {
	return "Invisible Conditional Teleports send you to one of two predetermined destinations when stepped on, depending on how many Sun or Moon Stones are in your inventory, and cannot be seen.";
    }

    @Override
    public String getGameName() {
	return "Empty";
    }
}