package com.cinak.test.client.model;

import com.cinak.test.entities.BorsusEntity;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class BorsusModel extends AnimatedEntityModel<BorsusEntity> {

    private final AnimatedModelRenderer head;
    private final AnimatedModelRenderer jaw;
    private final AnimatedModelRenderer chest;
    private final AnimatedModelRenderer body;
    private final AnimatedModelRenderer tail;
    private final AnimatedModelRenderer legFrontLeft;
    private final AnimatedModelRenderer legFrontRight;
    private final AnimatedModelRenderer legBackLeft;
    private final AnimatedModelRenderer legBackRight;

    public BorsusModel()
    {
        textureWidth = 128;
        textureHeight = 128;
        head = new AnimatedModelRenderer(this);
        head.setRotationPoint(0.0F, 16.0F, -11.0F);
        head.setTextureOffset(20, 37).addBox(-3.0F, -2.0F, -3.0F, 6.0F, 4.0F, 3.0F, 0.0F, false);
        head.setTextureOffset(0, 10).addBox(-2.0F, -1.0F, -6.0F, 4.0F, 3.0F, 3.0F, 0.0F, false);
        head.setTextureOffset(8, 0).addBox(1.0F, 2.0F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(0, 0).addBox(-2.0F, 2.0F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(0, 0).addBox(-2.0F, 2.0F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        head.setModelRendererName("head");
        this.registerModelRenderer(head);

        jaw = new AnimatedModelRenderer(this);
        jaw.setRotationPoint(0.0F, 18.0F, -14.0F);
        jaw.setTextureOffset(17, 45).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);
        jaw.setModelRendererName("jaw");
        this.registerModelRenderer(jaw);

        chest = new AnimatedModelRenderer(this);
        chest.setRotationPoint(0.0F, 19.0F, -1.5F);
        chest.setTextureOffset(16, 59).addBox(-3.0F, 0.0F, -4.5F, 6.0F, 1.0F, 9.0F, 0.0F, false);
        chest.setModelRendererName("chest");
        this.registerModelRenderer(chest);

        body = new AnimatedModelRenderer(this);
        body.setRotationPoint(0.0F, 15.0F, -1.0F);
        body.setTextureOffset(0, 37).addBox(-4.0F, -2.0F, -10.0F, 8.0F, 5.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(0, 0).addBox(-5.0F, -2.0F, -8.0F, 10.0F, 5.0F, 16.0F, 0.0F, false);
        body.setTextureOffset(35, 35).addBox(-5.0F, -3.0F, -7.0F, 10.0F, 1.0F, 15.0F, 0.0F, false);
        body.setTextureOffset(11, 9).addBox(0.0F, -4.0F, -7.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(11, 9).addBox(0.0F, -3.0F, -10.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(11, 8).addBox(0.0F, -4.0F, -3.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(8, 1).addBox(0.0F, -4.0F, 1.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(0, 1).addBox(0.0F, -4.0F, 5.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(0, 21).addBox(-5.0F, 3.0F, -7.0F, 10.0F, 1.0F, 15.0F, 0.0F, false);
        body.setModelRendererName("body");
        this.registerModelRenderer(body);

        tail = new AnimatedModelRenderer(this);
        tail.setRotationPoint(0.0F, 15.0F, 7.0F);
        tail.setTextureOffset(36, 0).addBox(-3.0F, -1.0F, 6.0F, 6.0F, 3.0F, 7.0F, 0.0F, false);
        tail.setTextureOffset(35, 21).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 5.0F, 6.0F, 0.0F, false);
        tail.setTextureOffset(0, 1).addBox(0.0F, -3.0F, 1.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        tail.setTextureOffset(0, 1).addBox(0.0F, -3.0F, 4.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        tail.setTextureOffset(0, 1).addBox(0.0F, -2.0F, 7.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        tail.setTextureOffset(0, 1).addBox(0.0F, -2.0F, 10.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        tail.setModelRendererName("tail");
        this.registerModelRenderer(tail);

        legFrontLeft = new AnimatedModelRenderer(this);
        legFrontLeft.setRotationPoint(4.0F, 19.0F, -5.0F);
        legFrontLeft.setTextureOffset(0, 44).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 6.0F, 4.0F, 0.0F, false);
        legFrontLeft.setModelRendererName("legFrontLeft");
        this.registerModelRenderer(legFrontLeft);

        legFrontRight = new AnimatedModelRenderer(this);
        legFrontRight.setRotationPoint(-4.0F, 19.0F, -5.0F);
        legFrontRight.setTextureOffset(38, 38).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 6.0F, 4.0F, 0.0F, false);
        legFrontRight.setModelRendererName("legFrontRight");
        this.registerModelRenderer(legFrontRight);

        legBackLeft = new AnimatedModelRenderer(this);
        legBackLeft.setRotationPoint(4.0F, 19.0F, 4.0F);
        legBackLeft.setTextureOffset(0, 0).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 6.0F, 4.0F, 0.0F, false);
        legBackLeft.setModelRendererName("legBackLeft");
        this.registerModelRenderer(legBackLeft);

        legBackRight = new AnimatedModelRenderer(this);
        legBackRight.setRotationPoint(-4.0F, 19.0F, 4.0F);
        legBackRight.setTextureOffset(0, 21).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 6.0F, 4.0F, 0.0F, false);
        legBackRight.setModelRendererName("legBackRight");
        this.registerModelRenderer(legBackRight);

        this.rootBones.add(head);
        this.rootBones.add(jaw);
        this.rootBones.add(chest);
        this.rootBones.add(body);
        this.rootBones.add(tail);
        this.rootBones.add(legFrontLeft);
        this.rootBones.add(legFrontRight);
        this.rootBones.add(legBackLeft);
        this.rootBones.add(legBackRight);
    }


    @Override
    public ResourceLocation getAnimationFileLocation()
    {
        return new ResourceLocation("testermodding", "animations/borsus_entity.json");
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        super.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }
}



