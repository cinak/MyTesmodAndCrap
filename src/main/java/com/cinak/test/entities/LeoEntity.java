package com.cinak.test.entities;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.scoreboard.Team;
import net.minecraft.server.management.PreYggdrasilConverter;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

//my custom thing cause there is no underwater tameable mob YET


public abstract class LeoEntity extends TameableEntity {
    protected LeoEntity(EntityType<? extends LeoEntity> type, World p_i48565_2_) {
        super(type, p_i48565_2_);
        this.setPathPriority(PathNodeType.WATER, 0.0F);
    }
    protected static final DataParameter<Byte> TAMED = EntityDataManager.createKey(LeoEntity.class, DataSerializers.BYTE);
    protected static final DataParameter<Optional<UUID>> OWNER_UNIQUE_ID = EntityDataManager.createKey(LeoEntity.class, DataSerializers.OPTIONAL_UNIQUE_ID);
    private boolean field_233683_bw_;

    protected void registerData() {
        super.registerData();
        this.dataManager.register(TAMED, (byte)0);
        this.dataManager.register(OWNER_UNIQUE_ID, Optional.empty());
    }

    private static final DataParameter<BlockPos> TRAVEL_POS = EntityDataManager.createKey(DrakelEntity.class, DataSerializers.BLOCK_POS);


    void setTravelPos(BlockPos position) {
        this.dataManager.set(TRAVEL_POS, position);
    }

    BlockPos getTravelPos() {
        return this.dataManager.get(TRAVEL_POS);
    }

    protected final Random rand = new Random();

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        if (this.getOwnerId() != null) {
            compound.putUniqueId("Owner", this.getOwnerId());
        }

        compound.putBoolean("Sitting", this.field_233683_bw_);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        UUID uuid;
        if (compound.hasUniqueId("Owner")) {
            uuid = compound.getUniqueId("Owner");
        } else {
            String s = compound.getString("Owner");
            uuid = PreYggdrasilConverter.convertMobOwnerIfNeeded(this.getServer(), s);
        }

        if (uuid != null) {
            try {
                this.setOwnerId(uuid);
                this.setTamed(true);
            } catch (Throwable throwable) {
                this.setTamed(false);
            }
        }

        this.field_233683_bw_ = compound.getBoolean("Sitting");
        this.func_233686_v_(this.field_233683_bw_);
    }


    /**
     * Play the taming effect, will either be hearts or smoke depending on status
     */
    @OnlyIn(Dist.CLIENT)
    protected void playTameEffect(boolean play) {
        IParticleData iparticledata = ParticleTypes.HEART;
        if (!play) {
            iparticledata = ParticleTypes.SMOKE;
        }

        for(int i = 0; i < 7; ++i) {
            double d0 = this.rand.nextGaussian() * 0.02D;
            double d1 = this.rand.nextGaussian() * 0.02D;
            double d2 = this.rand.nextGaussian() * 0.02D;
            this.world.addParticle(iparticledata, this.getPosXRandom(1.0D), this.getPosYRandom() + 0.5D, this.getPosZRandom(1.0D), d0, d1, d2);
        }

    }

    /**
     * Handler for {@link World#setEntityState}
     */
    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 7) {
            this.playTameEffect(true);
        } else if (id == 6) {
            this.playTameEffect(false);
        } else {
            super.handleStatusUpdate(id);
        }

    }

    public boolean isTamed() {
        return (this.dataManager.get(TAMED) & 4) != 0;
    }

    public void setTamed(boolean tamed) {
        byte b0 = this.dataManager.get(TAMED);
        if (tamed) {
            this.dataManager.set(TAMED, (byte)(b0 | 4));
        } else {
            this.dataManager.set(TAMED, (byte)(b0 & -5));
        }

        this.setupTamedAI();
    }

    protected void setupTamedAI() {
    }

    public boolean func_233684_eK_() {
        return (this.dataManager.get(TAMED) & 1) != 0;
    }

    public void func_233686_v_(boolean p_233686_1_) {
        byte b0 = this.dataManager.get(TAMED);
        if (p_233686_1_) {
            this.dataManager.set(TAMED, (byte)(b0 | 1));
        } else {
            this.dataManager.set(TAMED, (byte)(b0 & -2));
        }

    }

    @Nullable
    public UUID getOwnerId() {
        return this.dataManager.get(OWNER_UNIQUE_ID).orElse((UUID)null);
    }

    public void setOwnerId(@Nullable UUID p_184754_1_) {
        this.dataManager.set(OWNER_UNIQUE_ID, Optional.ofNullable(p_184754_1_));
    }


    @Nullable
    public LivingEntity getOwner() {
        try {
            UUID uuid = this.getOwnerId();
            return uuid == null ? null : this.world.getPlayerByUuid(uuid);
        } catch (IllegalArgumentException illegalargumentexception) {
            return null;
        }
    }

    public boolean canAttack(LivingEntity target) {
        return this.isOwner(target) ? false : super.canAttack(target);
    }

    public boolean isOwner(LivingEntity entityIn) {
        return entityIn == this.getOwner();
    }

    public boolean shouldAttackEntity(LivingEntity target, LivingEntity owner) {
        return true;
    }

    public Team getTeam() {
        if (this.isTamed()) {
            LivingEntity livingentity = this.getOwner();
            if (livingentity != null) {
                return livingentity.getTeam();
            }
        }

        return super.getTeam();
    }

    /**
     * Returns whether this Entity is on the same team as the given Entity.
     */
    public boolean isOnSameTeam(Entity entityIn) {
        if (this.isTamed()) {
            LivingEntity livingentity = this.getOwner();
            if (entityIn == livingentity) {
                return true;
            }

            if (livingentity != null) {
                return livingentity.isOnSameTeam(entityIn);
            }
        }

        return super.isOnSameTeam(entityIn);
    }

    /**
     * Called when the mob's health reaches 0.
     */
    public void onDeath(DamageSource cause) {
        if (!this.world.isRemote && this.world.getGameRules().getBoolean(GameRules.SHOW_DEATH_MESSAGES) && this.getOwner() instanceof ServerPlayerEntity) {
            this.getOwner().sendMessage(this.getCombatTracker().getDeathMessage(), Util.DUMMY_UUID);
        }

        super.onDeath(cause);
    }

    public boolean func_233685_eM_() {
        return this.field_233683_bw_;
    }

    public void func_233687_w_(boolean p_233687_1_) {
        this.field_233683_bw_ = p_233687_1_;
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    public CreatureAttribute getCreatureAttribute() {
        return CreatureAttribute.WATER;
    }

    public boolean isNotColliding(IWorldReader worldIn) {
        return worldIn.checkNoEntityCollision(this);
    }

    /**
     * Get number of ticks, at least during which the living entity will be silent.
     */
    public int getTalkInterval() {
        return 120;
    }

    /**
     * Get the experience points the entity currently has.
     */
    protected int getExperiencePoints(PlayerEntity player) {
        return 1 + this.world.rand.nextInt(3);
    }

    protected void updateAir(int p_209207_1_) {
        if (this.isAlive() && !this.isInWaterOrBubbleColumn()) {
            this.setAir(p_209207_1_ - 1);
            if (this.getAir() == -20) {
                this.setAir(0);
                this.attackEntityFrom(DamageSource.DROWN, 2.0F);
            }
        } else {
            this.setAir(300);
        }

    }

    /**
     * Gets called every tick from main Entity class
     */
    public void baseTick() {
        int i = this.getAir();
        super.baseTick();
        this.updateAir(i);
    }

    public boolean isPushedByWater() {
        return false;
    }

    public boolean canBeLeashedTo(PlayerEntity player) {
        return true;
    }



    private static final DataParameter<Boolean> GOING_HOME = EntityDataManager.createKey(LeoEntity.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> TRAVELLING = EntityDataManager.createKey(LeoEntity.class, DataSerializers.BOOLEAN);


    boolean isGoingHome() {
        return this.dataManager.get(GOING_HOME);
    }

    private void setGoingHome(boolean isGoingHome) {
        this.dataManager.set(GOING_HOME, isGoingHome);
    }

    private boolean isTravelling() {
        return this.dataManager.get(TRAVELLING);
    }

    void setTravelling(boolean isTravelling) {
        this.dataManager.set(TRAVELLING, isTravelling);
    }

}