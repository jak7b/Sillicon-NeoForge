package net.kuko.silicon.init;

import net.kuko.silicon.SiliconMod;
import net.kuko.silicon.item.ChiselItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ItemInit {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SiliconMod.MOD_ID);

    public static final DeferredItem<Item> BISMUTH = ITEMS.register("bismuth",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_BISMUTH = ITEMS.register("raw_bismuth",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties()
                    .stacksTo(1)
                    .durability(800)));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}


