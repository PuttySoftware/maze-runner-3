/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractConditionalTeleport;

public class OneShotConditionalTeleport extends AbstractConditionalTeleport {
    // Constructors
    public OneShotConditionalTeleport() {
	super(ObjectImageConstants.OBJECT_IMAGE_ONE_SHOT_CONDITIONAL);
    }

    @Override
    public String getName() {
	return "One-Shot Conditional Teleport";
    }

    @Override
    public String getPluralName() {
	return "One-Shot Conditional Teleports";
    }

    @Override
    public String getDescription() {
	return "One-Shot Conditional Teleports send you to one of two predetermined destinations when stepped on, depending on how many Sun or Moon Stones are in your inventory, then disappear.";
    }

    @Override
    public void postMoveActionHook() {
	Game.getApplication().getGameManager().decay();
    }
}