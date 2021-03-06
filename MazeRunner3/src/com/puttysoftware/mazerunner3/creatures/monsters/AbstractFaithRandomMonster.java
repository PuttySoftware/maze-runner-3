/*  MazeRunnerII: An RPG
Copyright (C) 2011-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.creatures.monsters;

import com.puttysoftware.images.BufferedImageIcon;
import com.puttysoftware.mazerunner3.creatures.faiths.FaithManager;

abstract class AbstractFaithRandomMonster extends AbstractMonster {
    // Constructors
    AbstractFaithRandomMonster() {
	super();
	this.element = AbstractFaithRandomMonster.getInitialElement();
    }

    @Override
    public boolean randomAppearance() {
	return false;
    }

    @Override
    public boolean randomFaith() {
	return true;
    }

    @Override
    protected BufferedImageIcon getInitialImage() {
	return null;
    }

    private static Element getInitialElement() {
	return new Element(FaithManager.getRandomFaith());
    }

    @Override
    public void loadMonster() {
	this.image = this.getInitialImage();
    }
}
