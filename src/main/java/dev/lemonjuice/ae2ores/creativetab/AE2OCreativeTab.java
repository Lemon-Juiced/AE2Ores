package dev.lemonjuice.ae2ores.creativetab;

import dev.lemonjuice.ae2ores.AE2Ores;
import dev.lemonjuice.ae2ores.block.AE2OBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AE2OCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AE2Ores.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> AE2ORES_ITEMS_TAB = CREATIVE_MODE_TABS.register("ae2ores_items", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.ae2ores.items"))
            .icon(() -> new ItemStack(AE2OBlocks.CERTUS_QUARTZ_ORE.get().asItem()))
            .build());


    public static void registerTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == AE2ORES_ITEMS_TAB.get()) {
            event.accept(AE2OBlocks.CERTUS_QUARTZ_ORE.get().asItem());
            event.accept(AE2OBlocks.DEEPSLATE_CERTUS_QUARTZ.get().asItem());
            event.accept(AE2OBlocks.CHARGED_CERTUS_QUARTZ_ORE.get().asItem());
            event.accept(AE2OBlocks.DEEPSLATE_CHARGED_CERTUS_QUARTZ.get().asItem());
        }
    }

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
