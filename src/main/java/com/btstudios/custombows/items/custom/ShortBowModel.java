package com.btstudios.custombows.items.custom;

import com.btstudios.custombows.CustomBows;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.GeckoLib;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ShortBowModel extends AnimatedGeoModel<ShortBow> {
    @Override
    public ResourceLocation getModelLocation(ShortBow object) {
        return new ResourceLocation(CustomBows.MOD_ID, "geo/short_bow.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(ShortBow object) {
        return new ResourceLocation(CustomBows.MOD_ID, "textures/item/short_bow_wood.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(ShortBow animatable) {
        return new ResourceLocation(CustomBows.MOD_ID, "animations/short_bow.animation.json");
    }
}
