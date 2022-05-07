package com.btstudios.custombows.init;

import com.btstudios.custombows.CustomBows;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.Tags;

public class ModTags {
    public static class Blocks {
    }

    public static class Items {
        public static final TagKey<Item> ACCEPTABLE_HEADS = forgeTag("acceptable_heads");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(CustomBows.MOD_ID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}
