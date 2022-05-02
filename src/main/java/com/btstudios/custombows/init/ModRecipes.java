package com.btstudios.custombows.init;

import com.btstudios.custombows.CustomBows;
import com.btstudios.custombows.recipes.ArrowWorkstationBaseRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, CustomBows.MOD_ID);

    public static final RegistryObject<RecipeSerializer<ArrowWorkstationBaseRecipe>> ARROW_WORKSTATION_BASE_SERIALIZER = SERIALIZERS.register("arrow_making", () -> ArrowWorkstationBaseRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }

}
