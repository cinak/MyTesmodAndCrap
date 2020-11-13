package com.cinak.test.client.model;

import com.cinak.test.entities.CrawlerEntity;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class CrawlerModel<T extends CrawlerEntity> extends AgeableModel<T> {

    private final ModelRenderer head;
    private final ModelRenderer body;
    private final ModelRenderer legFrontLeft;
    private final ModelRenderer legFrontRight;
    private final ModelRenderer legBackRight;
    private final ModelRenderer legBackLeft;



    public CrawlerModel() {
        super(false, 24.0F, 0.0F);
        textureWidth = 64;
        textureHeight = 32;

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 17.0F, -4.0F);
        head.setTextureOffset(36, 3).addBox(-3.0F, -2.0F, -3.0F, 6.0F, 4.0F, 3.0F, 0.0F, false);
        head.setTextureOffset(30, 14).addBox(-2.0F, -1.0F, -6.0F, 4.0F, 3.0F, 3.0F, 0.0F, false);
        head.setTextureOffset(1, 0).addBox(1.0F, 2.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(1, 0).addBox(-2.0F, 2.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 17.0F, 1.0F);
        setRotationAngle(body, -1.5708F, 0.0F, 0.0F);
        body.setTextureOffset(6, 7).addBox(-4.0F, -5.0F, -4.0F, 8.0F, 12.0F, 6.0F, 0.0F, true);
        body.setTextureOffset(27, 11).addBox(-3.0F, 7.0F, -3.0F, 6.0F, 3.0F, 4.0F, 0.0F, false);
        body.setTextureOffset(27, 11).addBox(-2.0F, 10.0F, -2.0F, 4.0F, 3.0F, 2.0F, 0.0F, false);

        legFrontLeft = new ModelRenderer(this);
        legFrontLeft.setRotationPoint(3.0F, 20.0F, -3.0F);
        legFrontLeft.setTextureOffset(53, 4).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 5.0F, 3.0F, 0.0F, false);

        legFrontRight = new ModelRenderer(this);
        legFrontRight.setRotationPoint(-3.0F, 20.0F, -3.0F);
        legFrontRight.setTextureOffset(47, 19).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 5.0F, 3.0F, 0.0F, false);

        legBackRight = new ModelRenderer(this);
        legBackRight.setRotationPoint(-3.0F, 20.0F, 4.0F);
        legBackRight.setTextureOffset(47, 19).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 5.0F, 3.0F, 0.0F, false);

        legBackLeft = new ModelRenderer(this);
        legBackLeft.setRotationPoint(3.0F, 20.0F, 4.0F);
        legBackLeft.setTextureOffset(53, 4).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 5.0F, 3.0F, 0.0F, false);
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        legFrontLeft.render(matrixStack, buffer, packedLight, packedOverlay);
        legFrontRight.render(matrixStack, buffer, packedLight, packedOverlay);
        legBackRight.render(matrixStack, buffer, packedLight, packedOverlay);
        legBackLeft.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    @Override
    protected Iterable<ModelRenderer> getHeadParts() {
        return null;
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    protected Iterable<ModelRenderer> getBodyParts() {
return null;    }



    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.body.rotateAngleX = ((float)Math.PI / 2F);
        this.legBackRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.legBackLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.legFrontRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.legFrontLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }
}



