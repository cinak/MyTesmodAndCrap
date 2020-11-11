package com.cinak.test.client.model;

import com.cinak.test.entities.AggresivePlaceHolderEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class AggresivePlaceHolderModel<T extends AggresivePlaceHolderEntity> extends EntityModel<T> {

    private final ModelRenderer head;
    private final ModelRenderer body;
    private final ModelRenderer legFrontLeft;
    private final ModelRenderer legFrontRight;
    private final ModelRenderer legBackRight;
    private final ModelRenderer legBackLeft;

    public AggresivePlaceHolderModel() {
        textureWidth = 128;
        textureHeight = 128;

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 16.0F, -11.0F);
        head.setTextureOffset(20, 37).addBox(-3.0F, -2.0F, -3.0F, 6.0F, 4.0F, 3.0F, 0.0F, false);
        head.setTextureOffset(0, 10).addBox(-2.0F, -1.0F, -6.0F, 4.0F, 3.0F, 3.0F, 0.0F, false);
        head.setTextureOffset(8, 0).addBox(1.0F, 2.0F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(0, 0).addBox(-2.0F, 2.0F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 15.0F, 4.0F);
        body.setTextureOffset(0, 37).addBox(-4.0F, -2.0F, -15.0F, 8.0F, 5.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(0, 0).addBox(-5.0F, -2.0F, -13.0F, 10.0F, 5.0F, 16.0F, 0.0F, false);
        body.setTextureOffset(35, 35).addBox(-5.0F, -3.0F, -12.0F, 10.0F, 1.0F, 15.0F, 0.0F, false);
        body.setTextureOffset(11, 9).addBox(0.0F, -4.0F, -12.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(11, 9).addBox(0.0F, -3.0F, -15.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(11, 8).addBox(0.0F, -4.0F, -8.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(8, 1).addBox(0.0F, -4.0F, -4.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(0, 1).addBox(0.0F, -3.0F, 4.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(0, 1).addBox(0.0F, -3.0F, 7.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(0, 1).addBox(0.0F, -2.0F, 10.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(0, 1).addBox(0.0F, -2.0F, 13.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(0, 1).addBox(0.0F, -4.0F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(0, 21).addBox(-5.0F, 3.0F, -12.0F, 10.0F, 1.0F, 15.0F, 0.0F, false);
        body.setTextureOffset(35, 21).addBox(-4.0F, -2.0F, 3.0F, 8.0F, 5.0F, 6.0F, 0.0F, false);
        body.setTextureOffset(36, 0).addBox(-3.0F, -1.0F, 9.0F, 6.0F, 3.0F, 7.0F, 0.0F, false);

        legFrontLeft = new ModelRenderer(this);
        legFrontLeft.setRotationPoint(4.0F, 19.0F, -5.0F);
        legFrontLeft.setTextureOffset(0, 44).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 6.0F, 4.0F, 0.0F, false);

        legFrontRight = new ModelRenderer(this);
        legFrontRight.setRotationPoint(-4.0F, 19.0F, -5.0F);
        legFrontRight.setTextureOffset(38, 38).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 6.0F, 4.0F, 0.0F, false);

        legBackLeft = new ModelRenderer(this);
        legBackLeft.setRotationPoint(4.0F, 19.0F, 4.0F);
        legBackLeft.setTextureOffset(0, 0).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 6.0F, 4.0F, 0.0F, false);

        legBackRight = new ModelRenderer(this);
        legBackRight.setRotationPoint(-4.0F, 19.0F, 4.0F);
        legBackRight.setTextureOffset(0, 21).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 6.0F, 4.0F, 0.0F, false);
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

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }


    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.body.rotateAngleX = ((float)Math.PI / 38F);
        this.legBackRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.legBackLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.legFrontRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.legFrontLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }
}



