package net.kuko.silicon.datagen;

import net.kuko.silicon.SiliconMod;
import net.kuko.silicon.init.ItemInit;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SiliconMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ItemInit.BISMUTH.get());
        basicItem(ItemInit.RAW_BISMUTH.get());

//        basicItem(ItemInit.RADISH.get());
//        basicItem(ItemInit.STARLIGHT_ASHES.get());
//        basicItem(ItemInit.FROSTFIRE_ICE.get());
//        basicItem(ItemInit.CHISEL.get());
    }
}
