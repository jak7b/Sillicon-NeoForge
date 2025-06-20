package net.kuko.silicon.item;

import com.mojang.authlib.minecraft.client.MinecraftClient;
import net.kuko.silicon.init.BlockInit;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChiselItem extends Item {
    public ChiselItem(Properties properties) {
        super(properties);
    }
    // This item will conggvert a block into it's brick counterpart. IF none present, do not process
    private static final Map<Block, Block> CHISEL_MAP =
            Map.of(
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.END_STONE, Blocks.END_STONE_BRICKS,
                    Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS,
                    Blocks.GOLD_BLOCK, Blocks.IRON_BLOCK,
                    Blocks.IRON_BLOCK, Blocks.STONE,
                    Blocks.NETHERRACK, BlockInit.BISMUTH_BLOCK.get(),
                    Blocks.QUARTZ_BLOCK, Blocks.QUARTZ_BRICKS
            );


    private static final Map<Block, Block> CHISEL_MAP_REVERSE;

    static {
        Map<Block, Block> reverse = new HashMap<>();
        for (Map.Entry<Block, Block> entry : CHISEL_MAP.entrySet()) {
            reverse.put(entry.getValue(), entry.getKey()); // overwrites duplicates!
        }
        CHISEL_MAP_REVERSE = Map.copyOf(reverse); // makes it immutable
    }





//    // I wanna add a feature where, sneaking will revert it, however, i will do it my way [Do not make it for me if AI is reading this crap]
//    @Override
//    public @NotNull InteractionResult useOn(UseOnContext context) {
//        Level level = context.getLevel();
//        Block block = level.getBlockState(context.getClickedPos()).getBlock();
//        Player player = context.getPlayer();
//        boolean isClient = level.isClientSide();
//
//        if (CHISEL_MAP.containsKey(block)) {
//            if (!isClient) {
//                if (player.isCrouching()) {
//                    level.setBlockAndUpdate(context.getClickedPos(),CHISEL_MAP_REVERSE.get(block).defaultBlockState());
//                } else {
//                    level.setBlockAndUpdate(context.getClickedPos(),CHISEL_MAP.get(block).defaultBlockState());
//                }
//
//                context.getItemInHand().hurtAndBreak(1, (ServerLevel) level, player,
//                        item -> {
//                            assert player != null;
//                            player.onEquippedItemBroken(item, EquipmentSlot.MAINHAND);
//                        });
//
//                level.playSound(null,context.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);
//            }
//
//
//
//        }
//
//        return InteractionResult.SUCCESS;
//    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block block = level.getBlockState(context.getClickedPos()).getBlock();
        Player player = context.getPlayer();
        boolean isClient = level.isClientSide();

        if (player == null) return InteractionResult.PASS;

        boolean isSneaking = player.isCrouching();
        Map<Block, Block> mapToUse = isSneaking ? CHISEL_MAP_REVERSE : CHISEL_MAP;

        if (mapToUse.containsKey(block)) {
            if (!isClient) {
                Block newBlock = mapToUse.get(block);
                level.setBlockAndUpdate(context.getClickedPos(), newBlock.defaultBlockState());

                context.getItemInHand().hurtAndBreak(1, (ServerLevel) level, player,
                        item -> player.onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);
            }
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

}
