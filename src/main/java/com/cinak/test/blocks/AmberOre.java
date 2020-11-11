package com.cinak.test.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class AmberOre extends OreBlock {

    public AmberOre() {
        super(Block.Properties.create(Material.ROCK)
                .hardnessAndResistance(20.0f, 100.0f)
                .sound(SoundType.STONE)
                .harvestLevel(4)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool()
        );
    }
}
