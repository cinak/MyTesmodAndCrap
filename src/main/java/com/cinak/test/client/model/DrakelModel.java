// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.12.2 or 1.15.2 (same format for both) for entity models animated with GeckoLib
// Paste this class into your mod and follow the documentation for GeckoLib to use animations. You can find the documentation here: https://github.com/bernie-g/geckolib
// Blockbench plugin created by Gecko
package com.cinak.test.client.model;

import com.cinak.test.entities.DrakelEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class DrakelModel extends AnimatedEntityModel<DrakelEntity> {


    private final AnimatedModelRenderer body;
    private final AnimatedModelRenderer body4;
    private final AnimatedModelRenderer tail1;
    private final AnimatedModelRenderer tail3;
    private final AnimatedModelRenderer tail2;
    private final AnimatedModelRenderer tail4;
    private final AnimatedModelRenderer joint4;
    private final AnimatedModelRenderer finbottomleftfront;
    private final AnimatedModelRenderer fintopleftfront;
    private final AnimatedModelRenderer finleft;
    private final AnimatedModelRenderer joint5;
    private final AnimatedModelRenderer finbottomleftfront2;
    private final AnimatedModelRenderer fintopleftfront2;
    private final AnimatedModelRenderer finright;
    private final AnimatedModelRenderer joint6;
    private final AnimatedModelRenderer finbottomleftfront3;
    private final AnimatedModelRenderer fintopleftfront3;
    private final AnimatedModelRenderer secondaryfinbackleft;
    private final AnimatedModelRenderer joint7;
    private final AnimatedModelRenderer finbottomleftfront4;
    private final AnimatedModelRenderer fintopleftfront4;
    private final AnimatedModelRenderer secondaryfinbackleft2;
    private final AnimatedModelRenderer neck1;
    private final AnimatedModelRenderer neck2;
    private final AnimatedModelRenderer neck3;
    private final AnimatedModelRenderer head;
    private final AnimatedModelRenderer body3;
    private final AnimatedModelRenderer body2;
    private final AnimatedModelRenderer jaw;

    public DrakelModel()
    {
    textureWidth = 256;
    textureHeight = 256;
    body = new AnimatedModelRenderer(this);
		body.setRotationPoint(0.0F, 15.0F, -20.0F);
		body.setTextureOffset(0, 0).addBox(-15.0F, -11.0F, -1.0F, 30.0F, 20.0F, 21.0F, 0.0F, false);
		body.setModelRendererName("body");
		this.registerModelRenderer(body);

    body4 = new AnimatedModelRenderer(this);
		body4.setRotationPoint(0.0F, 15.0F, 0.0F);
		body4.setTextureOffset(0, 41).addBox(-15.0F, -11.0F, 0.0F, 30.0F, 20.0F, 20.0F, 0.0F, false);
		body4.setModelRendererName("body4");
		this.registerModelRenderer(body4);

    tail1 = new AnimatedModelRenderer(this);
		tail1.setRotationPoint(0.0F, 14.0F, 20.5F);
		tail1.setTextureOffset(0, 81).addBox(-14.0F, -9.0F, -0.5F, 28.0F, 18.0F, 18.0F, 0.0F, false);
		tail1.setModelRendererName("tail1");
		this.registerModelRenderer(tail1);

    tail3 = new AnimatedModelRenderer(this);
		tail3.setRotationPoint(0.0F, 14.0F, 38.0F);
		tail3.setTextureOffset(79, 60).addBox(-11.0F, -7.0F, 0.0F, 22.0F, 14.0F, 21.0F, 0.0F, false);
		tail3.setModelRendererName("tail3");
		this.registerModelRenderer(tail3);

    tail2 = new AnimatedModelRenderer(this);
		tail2.setRotationPoint(0.0F, 14.0F, 59.0F);
		tail2.setTextureOffset(92, 95).addBox(-8.0F, -4.0F, 0.0F, 16.0F, 9.0F, 18.0F, 0.0F, false);
		tail2.setModelRendererName("tail2");
		this.registerModelRenderer(tail2);

    tail4 = new AnimatedModelRenderer(this);
		tail4.setRotationPoint(0.0F, 14.0F, 76.0F);
		tail4.setTextureOffset(128, 142).addBox(-6.0F, -2.0F, 1.0F, 12.0F, 5.0F, 6.0F, 0.0F, false);
		tail4.setTextureOffset(25, 117).addBox(-3.0F, -2.0F, 7.0F, 6.0F, 5.0F, 11.0F, 0.0F, false);
		tail4.setTextureOffset(0, 117).addBox(-1.0F, -8.0F, 1.0F, 2.0F, 16.0F, 21.0F, 0.0F, false);
		tail4.setTextureOffset(46, 117).addBox(-1.0F, -7.0F, -17.0F, 2.0F, 14.0F, 18.0F, 0.0F, false);
		tail4.setTextureOffset(0, 0).addBox(-1.0F, -7.0F, 22.0F, 2.0F, 14.0F, 6.0F, 0.0F, false);
		tail4.setModelRendererName("tail4");
		this.registerModelRenderer(tail4);

    joint4 = new AnimatedModelRenderer(this);
		joint4.setRotationPoint(-12.5F, 11.0F, 13.5F);

		joint4.setModelRendererName("joint4");
		this.registerModelRenderer(joint4);

    finbottomleftfront = new AnimatedModelRenderer(this);
		finbottomleftfront.setRotationPoint(12.5F, 34.0F, -15.0F);
		finbottomleftfront.setTextureOffset(0, 81).addBox(0.5F, 0.0F, -3.0F, 2.0F, 5.0F, 7.0F, 0.0F, false);
		finbottomleftfront.setTextureOffset(92, 95).addBox(0.5F, 5.0F, -3.0F, 2.0F, 8.0F, 5.0F, 0.0F, false);
		finbottomleftfront.setModelRendererName("finbottomleftfront");
		this.registerModelRenderer(finbottomleftfront);

    fintopleftfront = new AnimatedModelRenderer(this);
		fintopleftfront.setRotationPoint(12.5F, 22.0F, -13.0F);
		fintopleftfront.setTextureOffset(102, 140).addBox(-0.5F, 0.0F, -5.0F, 3.0F, 12.0F, 10.0F, 0.0F, false);
		fintopleftfront.setModelRendererName("fintopleftfront");
		this.registerModelRenderer(fintopleftfront);

    finleft = new AnimatedModelRenderer(this);
		finleft.setRotationPoint(-12.5F, 2.0F, 13.0F);

		finleft.setModelRendererName("finleft");
		this.registerModelRenderer(finleft);

    joint5 = new AnimatedModelRenderer(this);
		joint5.setRotationPoint(12.5F, 11.0F, 13.5F);

		joint5.setModelRendererName("joint5");
		this.registerModelRenderer(joint5);

    finbottomleftfront2 = new AnimatedModelRenderer(this);
		finbottomleftfront2.setRotationPoint(-12.5F, 34.0F, -15.0F);
		finbottomleftfront2.setTextureOffset(0, 41).addBox(-2.5F, 0.0F, -3.0F, 2.0F, 5.0F, 7.0F, 0.0F, false);
		finbottomleftfront2.setTextureOffset(81, 0).addBox(-2.5F, 5.0F, -3.0F, 2.0F, 8.0F, 5.0F, 0.0F, false);
		finbottomleftfront2.setModelRendererName("finbottomleftfront2");
		this.registerModelRenderer(finbottomleftfront2);

    fintopleftfront2 = new AnimatedModelRenderer(this);
		fintopleftfront2.setRotationPoint(-12.5F, 22.0F, -13.0F);
		fintopleftfront2.setTextureOffset(76, 140).addBox(-2.5F, 0.0F, -5.0F, 3.0F, 12.0F, 10.0F, 0.0F, false);
		fintopleftfront2.setModelRendererName("fintopleftfront2");
		this.registerModelRenderer(fintopleftfront2);

    finright = new AnimatedModelRenderer(this);
		finright.setRotationPoint(-2.0F, 24.0F, 0.0F);

		finright.setModelRendererName("finright");
		this.registerModelRenderer(finright);

    joint6 = new AnimatedModelRenderer(this);
		joint6.setRotationPoint(-11.5F, 10.0F, -13.0F);

		joint6.setModelRendererName("joint6");
		this.registerModelRenderer(joint6);

    finbottomleftfront3 = new AnimatedModelRenderer(this);
		finbottomleftfront3.setRotationPoint(11.5F, 32.0F, 12.0F);
		finbottomleftfront3.setTextureOffset(80, 53).addBox(-0.5F, 0.0F, -2.0F, 3.0F, 4.0F, 4.0F, 0.0F, false);
		finbottomleftfront3.setTextureOffset(80, 41).addBox(-0.5F, 4.0F, -2.0F, 3.0F, 4.0F, 2.0F, 0.0F, false);
		finbottomleftfront3.setModelRendererName("finbottomleftfront3");
		this.registerModelRenderer(finbottomleftfront3);

    fintopleftfront3 = new AnimatedModelRenderer(this);
		fintopleftfront3.setRotationPoint(11.5F, 22.0F, 14.0F);
		fintopleftfront3.setTextureOffset(144, 57).addBox(-2.5F, 0.0F, -4.0F, 5.0F, 10.0F, 7.0F, 0.0F, false);
		fintopleftfront3.setModelRendererName("fintopleftfront3");
		this.registerModelRenderer(fintopleftfront3);

    secondaryfinbackleft = new AnimatedModelRenderer(this);
		secondaryfinbackleft.setRotationPoint(-1.0F, 24.0F, -28.0F);

		secondaryfinbackleft.setModelRendererName("secondaryfinbackleft");
		this.registerModelRenderer(secondaryfinbackleft);

    joint7 = new AnimatedModelRenderer(this);
		joint7.setRotationPoint(11.5F, 10.0F, -13.0F);

		joint7.setModelRendererName("joint7");
		this.registerModelRenderer(joint7);

    finbottomleftfront4 = new AnimatedModelRenderer(this);
		finbottomleftfront4.setRotationPoint(-11.5F, 32.0F, 12.0F);
		finbottomleftfront4.setTextureOffset(0, 53).addBox(-2.5F, 0.0F, -2.0F, 3.0F, 4.0F, 4.0F, 0.0F, false);
		finbottomleftfront4.setTextureOffset(10, 0).addBox(-2.5F, 4.0F, -2.0F, 3.0F, 4.0F, 2.0F, 0.0F, false);
		finbottomleftfront4.setModelRendererName("finbottomleftfront4");
		this.registerModelRenderer(finbottomleftfront4);

    fintopleftfront4 = new AnimatedModelRenderer(this);
		fintopleftfront4.setRotationPoint(-11.5F, 22.0F, 14.0F);
		fintopleftfront4.setTextureOffset(142, 95).addBox(-2.5F, 0.0F, -4.0F, 5.0F, 10.0F, 7.0F, 0.0F, false);
		fintopleftfront4.setModelRendererName("fintopleftfront4");
		this.registerModelRenderer(fintopleftfront4);

    secondaryfinbackleft2 = new AnimatedModelRenderer(this);
		secondaryfinbackleft2.setRotationPoint(22.0F, 24.0F, -28.0F);

		secondaryfinbackleft2.setModelRendererName("secondaryfinbackleft2");
		this.registerModelRenderer(secondaryfinbackleft2);

    neck1 = new AnimatedModelRenderer(this);
		neck1.setRotationPoint(-0.5F, -7.0F, 21.5F);

		neck1.setModelRendererName("neck1");
		this.registerModelRenderer(neck1);

    neck2 = new AnimatedModelRenderer(this);
		neck2.setRotationPoint(-0.5F, -7.0F, 26.0F);

		neck2.setModelRendererName("neck2");
		this.registerModelRenderer(neck2);

    neck3 = new AnimatedModelRenderer(this);
		neck3.setRotationPoint(-0.5F, 14.0F, -29.0F);
		neck3.setTextureOffset(92, 31).addBox(-11.5F, -9.0F, -2.0F, 25.0F, 16.0F, 10.0F, 0.0F, false);
		neck3.setModelRendererName("neck3");
		this.registerModelRenderer(neck3);

    head = new AnimatedModelRenderer(this);
		head.setRotationPoint(0.0F, 13.0F, -31.0F);
		head.setTextureOffset(102, 0).addBox(-9.0F, -7.0F, -11.0F, 19.0F, 13.0F, 11.0F, 0.0F, false);
		head.setTextureOffset(86, 122).addBox(-6.0F, -5.0F, -21.0F, 14.0F, 8.0F, 10.0F, 0.0F, false);
		head.setTextureOffset(33, 2).addBox(-6.0F, -5.0F, -22.0F, 14.0F, 8.0F, 1.0F, 0.0F, false);
		head.setModelRendererName("head");
		this.registerModelRenderer(head);

    body3 = new AnimatedModelRenderer(this);
		body3.setRotationPoint(-12.0F, -6.0F, 11.0F);

		body3.setModelRendererName("body3");
		this.registerModelRenderer(body3);

    body2 = new AnimatedModelRenderer(this);
		body2.setRotationPoint(-12.0F, -6.0F, 11.0F);

		body2.setModelRendererName("body2");
		this.registerModelRenderer(body2);

    jaw = new AnimatedModelRenderer(this);
		jaw.setRotationPoint(1.0F, 17.0F, -42.0F);
		jaw.setTextureOffset(124, 130).addBox(-6.0F, -1.0F, -10.0F, 12.0F, 2.0F, 10.0F, 0.0F, false);
		jaw.setTextureOffset(0, 0).addBox(4.5F, -2.0F, -10.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		jaw.setTextureOffset(0, 0).addBox(5.5F, -2.0F, -10.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		jaw.setTextureOffset(0, 0).addBox(2.5F, -2.0F, -10.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		jaw.setTextureOffset(0, 0).addBox(0.5F, -2.0F, -10.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		jaw.setTextureOffset(0, 0).addBox(-1.5F, -2.0F, -10.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		jaw.setTextureOffset(0, 0).addBox(-3.5F, -2.0F, -10.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		jaw.setTextureOffset(0, 0).addBox(-5.5F, -2.0F, -10.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		jaw.setModelRendererName("jaw");
		this.registerModelRenderer(jaw);

    this.rootBones.add(body);
		this.rootBones.add(body4);
		this.rootBones.add(tail1);
		this.rootBones.add(tail3);
		this.rootBones.add(tail2);
		this.rootBones.add(tail4);
		this.rootBones.add(joint4);
		this.rootBones.add(finbottomleftfront);
		this.rootBones.add(fintopleftfront);
		this.rootBones.add(finleft);
		this.rootBones.add(joint5);
		this.rootBones.add(finbottomleftfront2);
		this.rootBones.add(fintopleftfront2);
		this.rootBones.add(finright);
		this.rootBones.add(joint6);
		this.rootBones.add(finbottomleftfront3);
		this.rootBones.add(fintopleftfront3);
		this.rootBones.add(secondaryfinbackleft);
		this.rootBones.add(joint7);
		this.rootBones.add(finbottomleftfront4);
		this.rootBones.add(fintopleftfront4);
		this.rootBones.add(secondaryfinbackleft2);
		this.rootBones.add(neck1);
		this.rootBones.add(neck2);
		this.rootBones.add(neck3);
		this.rootBones.add(head);
		this.rootBones.add(body3);
		this.rootBones.add(body2);
		this.rootBones.add(jaw);
}

    @Override
    public ResourceLocation getAnimationFileLocation()
    {
        return new ResourceLocation("testermodding", "animations/drakel_entity.json");
    }
    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        super.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }
}