package net.kuko.silicon;

import net.kuko.silicon.item.ModItem;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;


import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;


// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(SiliconMod.MOD_ID)
public class SiliconMod {
    public static final String MOD_ID = "silicon";
    public static final Logger LOGGER = LogUtils.getLogger();



    public SiliconMod(IEventBus modEventBus, @SuppressWarnings("unused") ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        ModItem.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }


    private void commonSetup(FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {


        }
    }
}
