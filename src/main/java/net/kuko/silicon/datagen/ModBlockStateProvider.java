package net.kuko.silicon.datagen;

import net.kuko.silicon.SiliconMod;
import net.kuko.silicon.init.BlockInit;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SiliconMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(BlockInit.BISMUTH_BLOCK);

        blockWithItem(BlockInit.BISMUTH_ORE);
        blockWithItem(BlockInit.DEEPSLATE_BISMUTH_ORE);

     //   blockWithItem(BlockInit.MAGIC_BLOCK);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}