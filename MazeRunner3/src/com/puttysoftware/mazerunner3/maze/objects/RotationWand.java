/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.diane.gui.CommonDialogs;
import com.puttysoftware.mazerunner3.Application;
import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.abc.AbstractMazeObject;
import com.puttysoftware.mazerunner3.maze.abc.AbstractWand;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class RotationWand extends AbstractWand {
    // Fields
    private static final boolean CLOCKWISE = true;
    private static final boolean COUNTERCLOCKWISE = false;
    private static final String[] rChoices = new String[] { "1", "2", "3" };
    private static final String[] dChoices = new String[] { "Clockwise", "Counterclockwise" };

    // Constructors
    public RotationWand() {
	super(ColorConstants.COLOR_ORANGE);
    }

    @Override
    public String getName() {
	return "Rotation Wand";
    }

    @Override
    public String getPluralName() {
	return "Rotation Wands";
    }

    @Override
    public void useHelper(final int x, final int y, final int z) {
	this.useAction(null, x, y, z);
    }

    @Override
    public void useAction(final AbstractMazeObject mo, final int x, final int y, final int z) {
	final Application app = Game.getApplication();
	app.getGameManager().setRemoteAction(x, y, z);
	int r = 1;
	final String rres = CommonDialogs.showInputDialog("Rotation Radius:", "MazeRunnerII", RotationWand.rChoices,
		RotationWand.rChoices[r - 1]);
	try {
	    r = Integer.parseInt(rres);
	} catch (final NumberFormatException nf) {
	    // Ignore
	}
	boolean d = RotationWand.CLOCKWISE;
	int di;
	if (d) {
	    di = 0;
	} else {
	    di = 1;
	}
	final String dres = CommonDialogs.showInputDialog("Rotation Direction:", "MazeRunnerII", RotationWand.dChoices,
		RotationWand.dChoices[di]);
	if (dres.equals(RotationWand.dChoices[0])) {
	    d = RotationWand.CLOCKWISE;
	} else {
	    d = RotationWand.COUNTERCLOCKWISE;
	}
	if (d) {
	    Game.getApplication().getGameManager().doClockwiseRotate(r);
	} else {
	    Game.getApplication().getGameManager().doCounterclockwiseRotate(r);
	}
	SoundLoader.playSound(SoundConstants.SOUND_CHANGE);
    }

    @Override
    public String getDescription() {
	return "Rotation Wands will rotate part of the maze. You can choose the area of effect and the direction.";
    }
}
