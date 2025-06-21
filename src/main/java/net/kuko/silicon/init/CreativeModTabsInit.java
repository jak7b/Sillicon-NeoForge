package net.kuko.silicon.init;

import net.kuko.silicon.SiliconMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CreativeModTabsInit {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SiliconMod.MOD_ID);


    public static final Supplier<CreativeModeTab> BISMUTH_ITEM_TAB = CREATIVE_MODE_TAB.register(
            "bismuth_item_tab",
            () -> CreativeModeTab.builder()
         //           .withSearchBar()
                    .icon(() -> new ItemStack(ItemInit.BISMUTH.get()))
                    .title(Component.translatable("creativetab.silicon.bismuth_item_tab"))

                    .displayItems((parameters, output) ->{
                        output.accept(ItemInit.BISMUTH.get());
                        output.accept(ItemInit.RAW_BISMUTH.get());
                        output.accept(ItemInit.CHISEL.get());
                        output.accept(ItemInit.RADISH.get());
                        output.accept(ItemInit.STARLIGHT_ASHES.get());
                        output.accept(ItemInit.FROSTFIRE_ICE.get());
                    })
                    .build()
    );



    public static final Supplier<CreativeModeTab> BISMUTH_BLOCK_TAB = CREATIVE_MODE_TAB.register(
            "bismuth_block_tab",
            () -> CreativeModeTab.builder()
         //           .withSearchBar()
                    .icon(() -> new ItemStack(BlockInit.BISMUTH_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.tryBuild(SiliconMod.MOD_ID, "bismuth_item_tab"))

                    .title(Component.translatable("creativetab.silicon.bismuth_block_tab"))


                    .displayItems((parameters, output) ->{
                        output.accept(BlockInit.BISMUTH_BLOCK.get());
                        output.accept(BlockInit.BISMUTH_ORE.get());
                        output.accept(BlockInit.DEEPSLATE_BISMUTH_ORE.get());
                        output.accept(BlockInit.MAGIC_BLOCK.get());
                    })
                    .build()
    );


    public static void register(IEventBus bus) {
        CREATIVE_MODE_TAB.register(bus);

        SiliconMod.LOGGER.info("Creative Mod Tabs has loaded");
    }
}
