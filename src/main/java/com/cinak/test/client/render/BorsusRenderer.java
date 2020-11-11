package com.cinak.test.client.render;

import com.cinak.test.Test;
import com.cinak.test.client.model.BorsusModel;
import com.cinak.test.entities.BorsusEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BorsusRenderer extends MobRenderer<BorsusEntity, BorsusModel> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Test.MOD_ID,"textures/entity/borsus.png");

    public BorsusRenderer(EntityRendererManager renderManagerIn)
    { super(renderManagerIn, new BorsusModel(), 0.5F); }

    @Override
    public ResourceLocation getEntityTexture(BorsusEntity entity) {
        return TEXTURE;
    }

}