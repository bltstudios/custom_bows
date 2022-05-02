package com.btstudios.custombows;

import com.btstudios.custombows.client.screen.ArrowWorkstationBaseScreen;
import com.btstudios.custombows.init.*;
import com.btstudios.custombows.util.ModItemProperties;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("custombows")
public class CustomBows
{
    public static final String MOD_ID = "custombows";

    private static final Logger LOGGER = LogManager.getLogger();

    public CustomBows() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModEntityType.register(eventBus);
        ModBlockEntities.register(eventBus);
        ModBlocks.register(eventBus);
        ModContainers.register(eventBus);
        ModMenuTypes.register(eventBus);
        ModRecipes.register(eventBus);



        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);
        GeckoLib.initialize();
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event) {

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ARROW_WORKSTATION_BASE.get(), RenderType.translucent());

        ModItemProperties.addCustomItemProperties();
        event.enqueueWork(() -> {
            MenuScreens.register(ModMenuTypes.ARROW_WORKSTATION_BASE_MENU.get(), ArrowWorkstationBaseScreen::new);
        });
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(()-> {

        });
    }
}
