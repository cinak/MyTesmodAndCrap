package com.cinak.test.entities;

import com.cinak.test.Test;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Test.MOD_ID);

    //entity types

    public static final RegistryObject<EntityType<CrawlerEntity>> CRAWLER = ENTITY_TYPES.register("crawler",
            () -> EntityType.Builder.create(CrawlerEntity::new, EntityClassification.CREATURE)
                    .size(0.8f,0.8f)
                    .build(new ResourceLocation(Test.MOD_ID, "crawler").toString())

    );
    public static final RegistryObject<EntityType<AggresivePlaceHolderEntity>> AGGRESIVE_PLACE_HOLDER = ENTITY_TYPES.register("aggresive_place_holder",
            () -> EntityType.Builder.create(AggresivePlaceHolderEntity::new, EntityClassification.CREATURE)
                    .size(1.0f,1.0f)
                    .build(new ResourceLocation(Test.MOD_ID, "aggresive_place_holder").toString())

    );
    public static final RegistryObject<EntityType<BorsusEntity>> BORSUS = ENTITY_TYPES.register("borsus_entity",
            () -> EntityType.Builder.create(BorsusEntity::new, EntityClassification.CREATURE)
                    .size(1.0f,1.0f)
                    .build(new ResourceLocation(Test.MOD_ID, "borsus_entity").toString())

    );
    public static final RegistryObject<EntityType<DrakelEntity>> DRAKEL = ENTITY_TYPES.register("drakel_entity",
            () -> EntityType.Builder.create(DrakelEntity::new, EntityClassification.CREATURE)
                    .size(1.0f,1.0f)
                    .build(new ResourceLocation(Test.MOD_ID, "drakel_entity").toString())

    );
}
