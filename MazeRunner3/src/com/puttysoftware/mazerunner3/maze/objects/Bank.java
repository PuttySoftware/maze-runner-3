/*  MazeRunnerII: An RPG
Copyright (C) 2011-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.items.ShopTypes;
import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractShop;

public class Bank extends AbstractShop {
    // Constructors
    public Bank() {
	super(ShopTypes.SHOP_TYPE_BANK);
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_BANK;
    }

    @Override
    public String getName() {
	return "Bank";
    }

    @Override
    public String getPluralName() {
	return "Banks";
    }

    @Override
    public String getDescription() {
	return "Banks store money for safe keeping.";
    }
}
