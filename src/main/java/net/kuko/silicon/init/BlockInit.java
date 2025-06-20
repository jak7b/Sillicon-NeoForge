package net.kuko.silicon.init;

import net.kuko.silicon.SiliconMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class BlockInit {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(SiliconMod.MOD_ID);


    public static final DeferredBlock<Block> BISMUTH_BLOCK = registerBlock("bismuth_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.AMETHYST)
                    .strength(3.5f)
                    .requiresCorrectToolForDrops()
            ));


    public static final DeferredBlock<Block> BISMUTH_ORE = registerBlock("bismuth_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.STONE)
                    .strength(3.5f)
                    .requiresCorrectToolForDrops()
            ));

    public static final DeferredBlock<Block> DEEPSLATE_BISMUTH_ORE = registerBlock("bismuth_deepslate_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.DEEPSLATE)
                    .strength(3.9f)
                    .requiresCorrectToolForDrops()
            ));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
