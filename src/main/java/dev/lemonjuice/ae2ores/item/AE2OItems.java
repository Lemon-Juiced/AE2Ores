package dev.lemonjuice.ae2ores.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import static dev.lemonjuice.ae2ores.AE2Ores.MOD_ID;

public class AE2OItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(MOD_ID);

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
