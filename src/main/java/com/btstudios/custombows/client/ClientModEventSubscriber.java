package com.btstudios.custombows.client;

import com.btstudios.custombows.CustomBows;
import com.btstudios.custombows.client.renderer.entity.CustomArrowRenderer;
import com.btstudios.custombows.init.ModEntityType;
import com.btstudios.custombows.recipes.ArrowWorkstationBaseRecipe;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CustomBows.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEventSubscriber {
    @SubscribeEvent
    public static void onClientSetup(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntityType.CUSTOM_ARROW.get(), CustomArrowRenderer::new);

    }

    @SubscribeEvent
    public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event) {
        Registry.register(Registry.RECIPE_TYPE, ArrowWorkstationBaseRecipe.Type.ID, ArrowWorkstationBaseRecipe.Type.INSTANCE);
    }
}
