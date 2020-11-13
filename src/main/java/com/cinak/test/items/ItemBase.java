package com.cinak.test.items;

import com.cinak.test.DrakelDream;
import net.minecraft.item.Item;


public class ItemBase extends Item {

    public ItemBase() {
        super(new Item.Properties().group(DrakelDream.TAB));
    }
}
