package com.cinak.test.items;

import com.cinak.test.DrakelDream;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class RawCrawlerMeat extends Item {
    public RawCrawlerMeat() {
        super(new Properties()
                .group(DrakelDream.TAB)
                .food(new Food.Builder()
                        .hunger(3)
                        .saturation(6.0F)
                        .effect(new EffectInstance(Effects.INSTANT_DAMAGE, 1, 1), 0.5f)
                        .build())





        );
    }
}
