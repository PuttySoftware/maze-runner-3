/*  MazeRunnerII: An RPG
Copyright (C) 2011-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.items.ShopTypes;
import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractShop;

public class HealShop extends AbstractShop {
    // Constructors
    public HealShop() {
	super(ShopTypes.SHOP_TYPE_HEALER);
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_HEAL_SHOP;
    }

    @Override
    public String getName() {
	return "Heal Shop";
    }

    @Override
    public String getPluralName() {
	return "Heal Shops";
    }

    @Override
    public String getDescription() {
	return "Heal Shops restore health, for a fee.";
    }
}
