/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Boot;
import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.abc.AbstractField;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;

public class ForceField extends AbstractField {
    // Constructors
    public ForceField() {
	super(new EnergySphere(), false, ColorConstants.COLOR_NONE);
    }

    // Scriptability
    @Override
    public void moveFailedAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	Boot.getApplication().showMessage("You'll get zapped");
	SoundLoader.playSound(SoundConstants.SOUND_FORCE_FIELD);
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_FORCE_FIELD;
    }

    @Override
    public String getName() {
	return "Force Field";
    }

    @Override
    public String getPluralName() {
	return "Force Fields";
    }

    @Override
    public String getDescription() {
	return "Force Fields block movement without an Energy Sphere.";
    }
}
