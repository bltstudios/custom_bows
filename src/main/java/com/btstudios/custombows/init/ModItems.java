package com.btstudios.custombows.init;

import com.btstudios.custombows.CustomBows;
import com.btstudios.custombows.items.custom.ShortBow;
import com.btstudios.custombows.items.custom.TorchArrowItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CustomBows.MOD_ID);

    public static final RegistryObject<Item> SHORT_BOW = ITEMS.register("short_bow", () -> new ShortBow(new Item.Properties().tab(ModCreativeModeTab.WEAPON_TAB).durability(500)));

    public static final RegistryObject<Item> TORCH_ARROW = ITEMS.register("torch_arrow", () -> new TorchArrowItem(new Item.Properties().tab(ModCreativeModeTab.WEAPON_TAB), 1.5f));

    public static final RegistryObject<Item> HARDENED_SHAFT = ITEMS.register("hardened_shaft", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ITEM_TAB).stacksTo(16)));

    public static final RegistryObject<BlockItem> ARROW_WORKSTATION_BASE_ITEM = ITEMS.register("arrow_workstation_base", () -> new BlockItem(ModBlocks.ARROW_WORKSTATION_BASE.get(), new Item.Properties().tab(ModCreativeModeTab.ITEM_TAB)));

    //public static final RegistryObject<Item> COMPOUND_BOW = ITEMS.register("compound_bow", () -> new CustomizableBow(new Item.Properties().tab(ModCreativeModeTab.WEAPON_TAB).durability(700)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus); }
}
