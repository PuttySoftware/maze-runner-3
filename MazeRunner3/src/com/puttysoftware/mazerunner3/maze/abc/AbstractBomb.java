/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: mazer5d@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.abc;

import com.puttysoftware.mazerunner3.Boot;
import com.puttysoftware.mazerunner3.maze.objects.Empty;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;
import com.puttysoftware.mazerunner3.maze.utilities.TypeConstants;
import com.puttysoftware.mazerunner3.resourcemanagers.ObjectImageConstants;
import com.puttysoftware.mazerunner3.resourcemanagers.SoundConstants;
import com.puttysoftware.mazerunner3.resourcemanagers.SoundManager;

public abstract class AbstractBomb extends AbstractUsableObject {
    // Fields
    protected static final int EFFECT_RADIUS = 2;

    // Constructors
    protected AbstractBomb(final int tc) {
	super(1);
	this.setTemplateColor(tc);
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_BOMB;
    }

    @Override
    public abstract String getName();

    @Override
    public final boolean arrowHitAction(final int locX, final int locY, final int locZ, final int dirX, final int dirY,
	    final int arrowType, final MazeObjectInventory inv) {
	// Act as if bomb was used
	this.useAction(null, locX, locY, locZ);
	// Destroy bomb
	Boot.getApplication().getGameManager().morph(new Empty(), locX, locY, locZ);
	// Stop arrow
	return false;
    }

    @Override
    public final void useAction(final AbstractMazeObject mo, final int x, final int y, final int z) {
	SoundManager.playSound(SoundConstants.SOUND_EXPLODE);
	this.useActionHook(x, y, z);
    }

    public abstract void useActionHook(final int x, final int y, final int z);

    @Override
    public final void useHelper(final int x, final int y, final int z) {
	this.useAction(null, x, y, z);
    }

    @Override
    protected void setTypes() {
	this.type.set(TypeConstants.TYPE_BOMB);
	this.type.set(TypeConstants.TYPE_USABLE);
	this.type.set(TypeConstants.TYPE_INVENTORYABLE);
	this.type.set(TypeConstants.TYPE_CONTAINABLE);
    }
}
