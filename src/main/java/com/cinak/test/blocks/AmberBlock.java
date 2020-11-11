package com.cinak.test.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class AmberBlock extends Block {

    public AmberBlock() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(30.0f, 1200.0f)
                .sound(SoundType.METAL)
                .harvestLevel(4)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool()
                .setLightLevel(value -> 5)
        );
    }
}
