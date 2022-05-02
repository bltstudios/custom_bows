package com.btstudios.custombows.init;

import com.btstudios.custombows.CustomBows;
import com.btstudios.custombows.blocks.entity.ArrowWorkstationBaseEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, CustomBows.MOD_ID);

    public static final RegistryObject<BlockEntityType<ArrowWorkstationBaseEntity>> ARROW_WORKSTATION_BASE = BLOCK_ENTITIES.register("arrow_workstation_base", () -> BlockEntityType.Builder.of(ArrowWorkstationBaseEntity::new, ModBlocks.ARROW_WORKSTATION_BASE.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus); }
}
