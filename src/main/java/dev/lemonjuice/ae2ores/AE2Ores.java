package dev.lemonjuice.ae2ores;

import dev.lemonjuice.ae2ores.block.AE2OBlocks;
import dev.lemonjuice.ae2ores.creativetab.AE2OCreativeTab;
import dev.lemonjuice.ae2ores.item.AE2OItems;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(AE2Ores.MOD_ID)
public class AE2Ores {
    public static final String MOD_ID = "ae2ores";

    public AE2Ores(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        // Register Blocks
        AE2OItems.register(modEventBus);
        AE2OBlocks.register(modEventBus);

        // Register Creative Tab
        AE2OCreativeTab.register(modEventBus);
        modEventBus.addListener(AE2OCreativeTab::registerTabs);

        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {}

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {}

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {}
    }
}
