package net.kuko.silicon.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather() {
//        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
//                .add(ItemInit.STARLIGHT_ASHES.getId(), new FurnaceFuel(1200), false)
//                .add(ItemInit.FROSTFIRE_ICE.getId(), new FurnaceFuel(2400), false);
    }
}
