package com.cinak.test.util;


import com.cinak.test.DrakelDream;
import com.cinak.test.armor.ModArmorMaterial;
import com.cinak.test.armor.ModArmorMaterialAmber;
import com.cinak.test.blocks.*;
import com.cinak.test.items.CookedCrawlerMeat;
import com.cinak.test.items.ItemBase;
import com.cinak.test.items.RawCrawlerMeat;
import com.cinak.test.items.RubyHeart;
import com.cinak.test.tools.ModItemTier;
import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create (ForgeRegistries.ITEMS, DrakelDream.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create (ForgeRegistries.BLOCKS, DrakelDream.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());


    }

    //items only
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", ItemBase::new);
    public static final RegistryObject<Item> AMBER = ITEMS.register("amber", ItemBase::new);
    public static final RegistryObject<Item> CRAWLER_HIDE = ITEMS.register("crawler_hide", ItemBase::new);
    public static final RegistryObject<Item> CRAWLER_BILE = ITEMS.register("crawler_bile", ItemBase::new);
    public static final RegistryObject<Item> CRAWLER_SCALE = ITEMS.register("crawler_scale", ItemBase::new);
    public static final RegistryObject<Item> RAW_CRAWLER_MEAT_REGISTRY_OBJECT = ITEMS.register("raw_crawler_meat", RawCrawlerMeat::new);
    public static final RegistryObject<CookedCrawlerMeat> COOKED_CRAWLER_MEAT_REGISTRY_OBJECT = ITEMS.register("cooked_crawler_meat", CookedCrawlerMeat::new);
    public static final RegistryObject<Item> CRAWLER_TUSK = ITEMS.register("crawler_tusk", ItemBase::new);
    public static final RegistryObject<RubyHeart> RUBY_HEART_REGISTRY_OBJECT = ITEMS.register("ruby_heart", RubyHeart::new );

    //tools only
    public static final RegistryObject<SwordItem> RUBY_SWORD = ITEMS.register("ruby_sword", () ->
            new SwordItem(ModItemTier.RUBY, 3, -2.4F, new Item.Properties().group(DrakelDream.TAB)));
    public static final RegistryObject<PickaxeItem> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe", () ->
            new PickaxeItem(ModItemTier.RUBY, 0, -2.8F, new Item.Properties().group(DrakelDream.TAB)));
    public static final RegistryObject<ShovelItem> RUBY_SHOVEL = ITEMS.register("ruby_shovel", () ->
            new ShovelItem(ModItemTier.RUBY, 0.5F, -3.0F, new Item.Properties().group(DrakelDream.TAB)));
    public static final RegistryObject<AxeItem> RUBY_AXE = ITEMS.register("ruby_axe", () ->
            new AxeItem(ModItemTier.RUBY, 5, -3.1F, new Item.Properties().group(DrakelDream.TAB)));
    public static final RegistryObject<HoeItem> RUBY_HOE = ITEMS.register("ruby_hoe", () ->
            new HoeItem(ModItemTier.RUBY,-1 , -3.1F, new Item.Properties().group(DrakelDream.TAB)));
    public static final RegistryObject<SwordItem> AMBER_SWORD = ITEMS.register("amber_sword", () ->
            new SwordItem(ModItemTier.AMBER, 3, -2.4F, new Item.Properties().group(DrakelDream.TAB)));
    public static final RegistryObject<PickaxeItem> AMBER_PICKAXE = ITEMS.register("amber_pickaxe", () ->
            new PickaxeItem(ModItemTier.AMBER, 0, -2.8F, new Item.Properties().group(DrakelDream.TAB)));
    public static final RegistryObject<ShovelItem> AMBER_SHOVEL = ITEMS.register("amber_shovel", () ->
            new ShovelItem(ModItemTier.AMBER, 0.5F, -3.0F, new Item.Properties().group(DrakelDream.TAB)));
    public static final RegistryObject<AxeItem> AMBER_AXE = ITEMS.register("amber_axe", () ->
            new AxeItem(ModItemTier.AMBER, 5, -3.1F, new Item.Properties().group(DrakelDream.TAB)));
    public static final RegistryObject<HoeItem> AMBER_HOE = ITEMS.register("amber_hoe", () ->
            new HoeItem(ModItemTier.AMBER,-1 , -3.1F, new Item.Properties().group(DrakelDream.TAB)));

    //armor only
    public static final RegistryObject<ArmorItem> RUBY_HELMET = ITEMS.register("ruby_helmet", ()->
            new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.HEAD, new Item.Properties().group(DrakelDream.TAB)));
    public static final RegistryObject<ArmorItem> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate", ()->
            new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.CHEST, new Item.Properties().group(DrakelDream.TAB)));
    public static final RegistryObject<ArmorItem> RUBY_LEGGINGS = ITEMS.register("ruby_leggings", ()->
            new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.LEGS, new Item.Properties().group(DrakelDream.TAB)));
    public static final RegistryObject<ArmorItem> RUBY_BOOTS = ITEMS.register("ruby_boots", ()->
            new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.FEET, new Item.Properties().group(DrakelDream.TAB)));
    public static final RegistryObject<ArmorItem> AMBER_HELMET = ITEMS.register("amber_helmet", ()->
            new ArmorItem(ModArmorMaterialAmber.AMBER, EquipmentSlotType.HEAD, new Item.Properties().group(DrakelDream.TAB)));
    public static final RegistryObject<ArmorItem> AMBER_CHESTPLATE = ITEMS.register("amber_chestplate", ()->
            new ArmorItem(ModArmorMaterialAmber.AMBER, EquipmentSlotType.CHEST, new Item.Properties().group(DrakelDream.TAB)));
    public static final RegistryObject<ArmorItem> AMBER_LEGGINGS = ITEMS.register("amber_leggings", ()->
            new ArmorItem(ModArmorMaterialAmber.AMBER, EquipmentSlotType.LEGS, new Item.Properties().group(DrakelDream.TAB)));
    public static final RegistryObject<ArmorItem> AMBER_BOOTS = ITEMS.register("amber_boots", ()->
            new ArmorItem(ModArmorMaterialAmber.AMBER, EquipmentSlotType.FEET, new Item.Properties().group(DrakelDream.TAB)));


    //mobs


    //blocks only
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", RubyBlock::new);
    public static final RegistryObject<Block> DUCKY_TROPHY = BLOCKS.register("ducky_trophy", DuckyTrophy::new);
    public static final RegistryObject<Block> MUSHROOM = BLOCKS.register("mushroom", Shroom::new);
    public static final RegistryObject<Block> AMBER_BLOCK = BLOCKS.register("amber_block", AmberBlock::new);
    public static final RegistryObject<Block> AMBER_ORE = BLOCKS.register("amber_ore", AmberOre::new);
    public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("ruby_ore", RubyOre::new);

    //block items only
    public static final RegistryObject<Item> RUBY_BLOCK_ITEM = ITEMS.register("ruby_block", ()-> new BlockItemBase(RUBY_BLOCK.get()));
    public static final RegistryObject<Item> DUCKY_TROPHY_ITEM = ITEMS.register("ducky_trophy", ()-> new BlockItemBase(DUCKY_TROPHY.get()));
    public static final RegistryObject<Item> RUBY_ORE_ITEM = ITEMS.register("ruby_ore", ()-> new BlockItemBase(RUBY_ORE.get()));
    public static final RegistryObject<Item> AMBER_BLOCK_ITEM = ITEMS.register("amber_block", ()-> new BlockItemBase(AMBER_BLOCK.get()));
    public static final RegistryObject<Item> AMBER_ORE_ITEM = ITEMS.register("amber_ore", ()-> new BlockItemBase(AMBER_ORE.get()));
    public static final RegistryObject<Item> MUSHROOM_ITEM = ITEMS.register("mushroom", ()-> new BlockItemBase(MUSHROOM.get()));



}
