package dev.lemonjuice.ae2ores.block;

import dev.lemonjuice.ae2ores.AE2Ores;
import dev.lemonjuice.ae2ores.item.AE2OItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class AE2OBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(AE2Ores.MOD_ID);

    public static final DeferredBlock<Block> CERTUS_QUARTZ_ORE = registerBlock("certus_quartz_ore", () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of().strength(3F).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DEEPSLATE_CERTUS_QUARTZ = registerBlock("deepslate_certus_quartz_ore", () -> new DropExperienceBlock(UniformInt.of(3, 6), BlockBehaviour.Properties.of().strength(4F).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<Block> CHARGED_CERTUS_QUARTZ_ORE = registerBlock("charged_certus_quartz_ore", () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of().strength(3F).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DEEPSLATE_CHARGED_CERTUS_QUARTZ = registerBlock("deepslate_charged_certus_quartz_ore", () -> new DropExperienceBlock(UniformInt.of(3, 6), BlockBehaviour.Properties.of().strength(4F).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        AE2OItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
