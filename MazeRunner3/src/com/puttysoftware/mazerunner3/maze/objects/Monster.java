package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Application;
import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.MazeConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractMazeObject;
import com.puttysoftware.mazerunner3.maze.abc.AbstractMovingObject;
import com.puttysoftware.mazerunner3.maze.utilities.ArrowTypeConstants;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;
import com.puttysoftware.mazerunner3.maze.utilities.TypeConstants;
import com.puttysoftware.mazerunner3.prefs.PreferencesManager;
import com.puttysoftware.randomrange.RandomRange;

public class Monster extends AbstractMovingObject {
    // Constructors
    public Monster() {
	super(false);
	this.setSavedObject(new Empty());
	this.activateTimer(1);
    }

    public Monster(final AbstractMazeObject saved) {
	super(false);
	this.setSavedObject(saved);
	this.activateTimer(1);
    }

    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	if (PreferencesManager.getRPGEnabled()) {
	    if (Game.getApplication().getMode() != Application.STATUS_BATTLE) {
		Game.getApplication().getBattle().doBattle();
		Game.getApplication().getMazeManager().getMaze().postBattle(this, dirX, dirY, true);
	    }
	} else {
	    SoundLoader.playSound(SoundConstants.SOUND_WALK);
	}
    }

    @Override
    public boolean arrowHitAction(final int locX, final int locY, final int locZ, final int dirX, final int dirY,
	    final int arrowType, final MazeObjectInventory inv) {
	if (PreferencesManager.getRPGEnabled()) {
	    if (arrowType == ArrowTypeConstants.ARROW_TYPE_ICE) {
		// Transform into iced monster, if hit by an ice arrow
		final int pz = Game.getApplication().getMazeManager().getMaze().getPlayerLocationZ();
		Game.getApplication().getGameManager().morph(new IcedMonster(this.getSavedObject()), locX, locY, pz,
			MazeConstants.LAYER_OBJECT);
		return false;
	    } else {
		return true;
	    }
	} else {
	    return true;
	}
    }

    @Override
    public void timerExpiredAction(final int dirX, final int dirY) {
	if (PreferencesManager.getRPGEnabled()) {
	    // Move the monster
	    final RandomRange r = new RandomRange(0, 7);
	    final int move = r.generate();
	    Game.getApplication().getMazeManager().getMaze().updateMonsterPosition(move, dirX, dirY, this);
	}
	this.activateTimer(1);
    }

    @Override
    public AbstractMazeObject gameRenderHook(final int x, final int y, final int z) {
	if (PreferencesManager.getRPGEnabled()) {
	    return this;
	} else {
	    return new Empty();
	}
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_MONSTER;
    }

    @Override
    public String getName() {
	return "Monster";
    }

    @Override
    public String getPluralName() {
	return "Monsters";
    }

    @Override
    public String getDescription() {
	return "Monsters are dangerous. Encountering one starts a battle.";
    }

    @Override
    protected void setTypes() {
	super.setTypes();
	this.type.set(TypeConstants.TYPE_REACTS_TO_ICE);
    }
}
