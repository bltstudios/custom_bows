package com.btstudios.custombows.client.renderer.entity;

import com.btstudios.custombows.CustomBows;
import com.btstudios.custombows.world.entities.projectiles.TorchArrowEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TorchArrowRenderer extends ArrowRenderer<TorchArrowEntity> {
    public TorchArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(TorchArrowEntity pEntity) {
        Item refItem = pEntity.getPickResult().getItem();
        return new ResourceLocation(CustomBows.MOD_ID, "textures/entity/projectiles/" + refItem.getRegistryName().getPath() + ".png");
    }


}
