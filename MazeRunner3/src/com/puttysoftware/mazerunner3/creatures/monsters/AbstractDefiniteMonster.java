/*  MazeRunnerII: An RPG
Copyright (C) 2011-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.creatures.monsters;

import com.puttysoftware.images.BufferedImageIcon;
import com.puttysoftware.mazerunner3.loader.MonsterImageLoader;

abstract class AbstractDefiniteMonster extends AbstractMonster {
    // Constructors
    AbstractDefiniteMonster() {
	super();
    }

    @Override
    public boolean randomAppearance() {
	return false;
    }

    @Override
    public boolean randomFaith() {
	return false;
    }

    // Helper Methods
    @Override
    protected BufferedImageIcon getInitialImage() {
	if (this.getLevel() == 0) {
	    return null;
	} else {
	    return MonsterImageLoader.getImage(this.getType(), this.getElement());
	}
    }

    @Override
    public void loadMonster() {
	this.image = this.getInitialImage();
    }
}
