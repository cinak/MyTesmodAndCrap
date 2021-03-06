package com.cinak.test;


import com.cinak.test.entities.*;
import com.cinak.test.util.RegistryHandler;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod("drakeldream")
public class DrakelDream
{

    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "drakeldream";

    public DrakelDream() {

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);


        ModEntityTypes.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());

        RegistryHandler.init();




        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(ModEntityTypes.CRAWLER.get(), CrawlerEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntityTypes.AGGRESIVE_PLACE_HOLDER.get(), AggresivePlaceHolderEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntityTypes.BORSUS.get(), BorsusEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntityTypes.DRAKEL.get(), DrakelEntity.setCustomAttributes().create());

        });
    }

    private void doClientStuff(final FMLClientSetupEvent event) { }

    public static final ItemGroup TAB = new ItemGroup("DrakelsDreamItemTab") {
        @Override
        public ItemStack createIcon(){
            return new ItemStack(RegistryHandler.AMBER.get());
        }

    };
    public static final ItemGroup TAR = new ItemGroup("DrakelDreamBlockTab") {
        @Override
        public ItemStack createIcon(){
            return new ItemStack(RegistryHandler.AMBER.get());
        }

    };

}
