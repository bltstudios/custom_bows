package com.btstudios.custombows.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab WEAPON_TAB = new CreativeModeTab("weapontab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.SHORT_BOW.get());
        }
    };

    public static final CreativeModeTab ITEM_TAB = new CreativeModeTab("itemtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.HARDENED_SHAFT.get());
        }
    };
}
