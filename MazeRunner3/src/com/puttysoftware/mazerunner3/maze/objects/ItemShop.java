/*  MazeRunnerII: An RPG
Copyright (C) 2011-2012 Eric Ahnell


Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.items.ShopTypes;
import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractShop;

public class ItemShop extends AbstractShop {
    // Constructors
    public ItemShop() {
	super(ShopTypes.SHOP_TYPE_ITEMS);
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_ITEM_SHOP;
    }

    @Override
    public String getName() {
	return "Item Shop";
    }

    @Override
    public String getPluralName() {
	return "Item Shops";
    }

    @Override
    public String getDescription() {
	return "Item Shops sell items used in battle.";
    }
}
