package com.cinak.test.client.render;

import com.cinak.test.Test;
import com.cinak.test.client.model.BorsusModel;
import com.cinak.test.client.model.DrakelModel;
import com.cinak.test.entities.BorsusEntity;
import com.cinak.test.entities.DrakelEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class DrakelRenderer extends MobRenderer<DrakelEntity, DrakelModel> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Test.MOD_ID,"textures/entity/drakel_entity.png");

    public DrakelRenderer(EntityRendererManager renderManagerIn)
    { super(renderManagerIn, new DrakelModel(), 2F); }

    @Override
    public ResourceLocation getEntityTexture(DrakelEntity entity) {
        return TEXTURE;
    }

}