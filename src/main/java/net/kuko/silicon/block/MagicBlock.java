package net.kuko.silicon.block;

import net.kuko.silicon.init.ItemInit;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class MagicBlock extends Block {
    public MagicBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level,
                                               BlockPos pos, Player player, BlockHitResult hitResult) {
        float pitch = 0.9f + ThreadLocalRandom.current().nextFloat() * 0.2f;
        level.playSound(player, pos, SoundEvents.AMETHYST_CLUSTER_PLACE, SoundSource.BLOCKS, 1.05f ,pitch);

        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity itemEntity) {
            if(itemEntity.getItem().getItem() == ItemInit.RAW_BISMUTH.get()) {
                itemEntity.setItem(new ItemStack(Items.DIAMOND, itemEntity.getItem().getCount()));
            }

            if(itemEntity.getItem().getItem() == Items.DANDELION) {
                itemEntity.setItem(new ItemStack(Items.WITHER_ROSE, itemEntity.getItem().getCount()));
            }

        }
        super.stepOn(level, pos, state, entity);
    }


}
