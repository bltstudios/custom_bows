package com.btstudios.custombows.init;

import com.btstudios.custombows.CustomBows;
import com.btstudios.custombows.blocks.container.ArrowWorkstationBaseContainer;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModContainers {
    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, CustomBows.MOD_ID);

    public static final RegistryObject<MenuType<ArrowWorkstationBaseContainer>> ARROW_WORKSTATION_BASE = CONTAINERS.register("arrow_workstation_base", () -> new MenuType<>(ArrowWorkstationBaseContainer::new));

    public static void register(IEventBus eventBus) {
        CONTAINERS.register(eventBus); }
}
