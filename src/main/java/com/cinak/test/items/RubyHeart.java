package com.cinak.test.items;

import com.cinak.test.DrakelDream;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class RubyHeart extends Item {
    public RubyHeart() {
        super(new Item.Properties()
                .group(DrakelDream.TAB)
                .food(new Food.Builder()
                        .hunger(0)
                        .saturation(0.0F)
                        .effect(new EffectInstance(Effects.REGENERATION, 3000, 3), 1f)
                        .setAlwaysEdible()
                        .build())





        );
    }
}
