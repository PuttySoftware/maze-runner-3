package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Boot;
import com.puttysoftware.mazerunner3.maze.abc.AbstractMovingObject;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.resourcemanagers.ObjectImageConstants;
import com.puttysoftware.randomrange.RandomRange;

public class MovingBlock extends AbstractMovingObject {
    // Constructors
    public MovingBlock() {
	super(true, ColorConstants.COLOR_GRASS, ObjectImageConstants.OBJECT_IMAGE_PULLABLE, ColorConstants.COLOR_WHITE);
	final RandomRange t = new RandomRange(1, 2);
	this.activateTimer(t.generate());
    }

    @Override
    public void timerExpiredAction(final int dirX, final int dirY) {
	// Move the block
	final RandomRange r = new RandomRange(0, 7);
	final int move = r.generate();
	Boot.getApplication().getMazeManager().getMaze().updateMovingBlockPosition(move, dirX, dirY, this);
	final RandomRange t = new RandomRange(1, 2);
	this.activateTimer(t.generate());
    }

    @Override
    public String getName() {
	return "Moving Block";
    }

    @Override
    public String getPluralName() {
	return "Moving Blocks";
    }

    @Override
    public String getDescription() {
	return "Moving Blocks move on their own. They cannot be pushed or pulled.";
    }
}
