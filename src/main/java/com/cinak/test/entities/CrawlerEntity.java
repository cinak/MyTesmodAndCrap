package com.cinak.test.entities;

import com.cinak.test.util.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;

public class CrawlerEntity extends AnimalEntity {

    public static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(Items.ACACIA_SAPLING, Items.BIRCH_SAPLING, Items.SPRUCE_SAPLING, Items.OAK_SAPLING
    ,Items.JUNGLE_SAPLING, Items.DARK_OAK_SAPLING, Items.LEATHER, Items.WHEAT, Items.BROWN_MUSHROOM, Items.RED_MUSHROOM);

    private EatGrassGoal eatGrassGoal;
    private int goatTimer;

    protected CrawlerEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
    }

    //
    public static AttributeModifierMap.MutableAttribute setCustomAttributes(){
        return MobEntity.func_233666_p_()
        .createMutableAttribute(Attributes.MAX_HEALTH, 15)
        .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.5D);

    }

    public ActionResultType func_230254_b_(PlayerEntity p_230254_1_, Hand p_230254_2_) {
        ItemStack itemstack = p_230254_1_.getHeldItem(p_230254_2_);
        Item item = itemstack.getItem();
        if (itemstack.getItem() == Items.BUCKET && !this.isChild()) {
            p_230254_1_.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);
            ItemStack itemstack1 = DrinkHelper.func_241445_a_(itemstack, p_230254_1_, Items.MILK_BUCKET.getDefaultInstance());
            p_230254_1_.setHeldItem(p_230254_2_, itemstack1);
            return ActionResultType.func_233537_a_(this.world.isRemote);
        } else {
            return super.func_230254_b_(p_230254_1_, p_230254_2_);
        }
    }
    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.eatGrassGoal = new EatGrassGoal(this);
        this.goalSelector.addGoal(0,  new SwimGoal(this));
        this.goalSelector.addGoal(1,  new PanicGoal(this, 0.6D));
        this.goalSelector.addGoal(2,  new BreedGoal(this, 0.4D));
        this.goalSelector.addGoal(3,  new TemptGoal(this, 0.6,false,TEMPTATION_ITEMS ));
        this.goalSelector.addGoal(4,  new FollowParentGoal(this, 0.4));
        this.goalSelector.addGoal(5,  new RandomWalkingGoal(this, 0.5D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomFlyingGoal(this,0.5));
        this.goalSelector.addGoal(7,  this.eatGrassGoal);
        this.goalSelector.addGoal(8,  new LookAtGoal(this, PlayerEntity.class, 10.0F));
        this.goalSelector.addGoal(9,  new LookRandomlyGoal(this));



    }

    @Override
    protected int getExperiencePoints(PlayerEntity player) {
        return 1 + this.world.rand.nextInt(4);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_POLAR_BEAR_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_POLAR_BEAR_DEATH;
    }



    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_POLAR_BEAR_HURT;
    }

    @Override
    protected void updateAITasks() {
        this.goatTimer =  this.eatGrassGoal.getEatingGrassTimer();
        super.updateAITasks();
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.ENTITY_POLAR_BEAR_STEP, 0.15F,1F);
    }

    @Nullable
    @Override


    public AgeableEntity createChild(AgeableEntity ageable) {
        return ModEntityTypes.CRAWLER.get().create(this.world);

    }

    @Override
    public void livingTick() {
        if(this.world.isRemote){
            this.goatTimer = Math.max(0, goatTimer-1);
        }
        super.livingTick();
    }

    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if(id == 10) {
            this.goatTimer = 40;
        } else {
            super.handleStatusUpdate(id);
        }
    }
}
