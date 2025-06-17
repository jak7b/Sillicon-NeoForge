package net.kuko.silicon.item;

import io.wispforest.owo.registration.reflect.ItemRegistryContainer;
import net.minecraft.world.item.Item;

public class ItemInit implements ItemRegistryContainer {

    public static final Item BLACKBERRY = new Item(new Item.Properties());

    public static final String notAnItem = "this will be ignored";
}

