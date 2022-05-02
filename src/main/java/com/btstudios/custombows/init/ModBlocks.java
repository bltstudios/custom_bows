package com.btstudios.custombows.init;

import com.btstudios.custombows.CustomBows;
import com.btstudios.custombows.blocks.ArrowWorkStationBaseBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    private ModBlocks() {

    }

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CustomBows.MOD_ID);

    public static final RegistryObject<ArrowWorkStationBaseBlock> ARROW_WORKSTATION_BASE = BLOCKS.register("arrow_workstation_base", () -> new ArrowWorkStationBaseBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL, MaterialColor.METAL).strength(8.0f, 30f).requiresCorrectToolForDrops()));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus); }
}
