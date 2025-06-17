package net.kuko.silicon.item;

import net.kuko.silicon.SiliconMod;
import net.neoforged.neoforge.registries.DeferredItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItem {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SiliconMod.MOD_ID);

    public static final DeferredItem<Item> SILICON = ITEMS.register("silicon",
            () -> new Item(new Item.Properties()));





    public static void register(IEventBus bus){
        ITEMS.register(bus);
        SiliconMod.LOGGER.info("Registered {} items", ITEMS.getEntries().size());

    }
}
