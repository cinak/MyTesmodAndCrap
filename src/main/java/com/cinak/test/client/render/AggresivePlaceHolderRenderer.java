package com.cinak.test.client.render;

import com.cinak.test.Test;
import com.cinak.test.client.model.AggresivePlaceHolderModel;
import com.cinak.test.client.model.CrawlerModel;
import com.cinak.test.entities.AggresivePlaceHolderEntity;
import com.cinak.test.entities.CrawlerEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class AggresivePlaceHolderRenderer extends MobRenderer<AggresivePlaceHolderEntity, AggresivePlaceHolderModel<AggresivePlaceHolderEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Test.MOD_ID,"textures/entity/borsus.png");

    public AggresivePlaceHolderRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new AggresivePlaceHolderModel<>(), 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(AggresivePlaceHolderEntity entity) {
        return TEXTURE;
    }
}