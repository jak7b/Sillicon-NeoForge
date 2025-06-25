package net.kuko.silicon.init;

import net.kuko.silicon.SiliconMod;
import net.kuko.silicon.item.ChiselItem;
import net.kuko.silicon.item.FuelItem;
import net.kuko.silicon.item.ModFoodProperties;
import net.kuko.silicon.item.RadishItem;
import net.minecraft.locale.Language;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.function.Supplier;

public class ItemInit {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SiliconMod.MOD_ID);

    public static final DeferredItem<Item> BISMUTH = ITEMS.register("bismuth",
            () -> new Item(new Item.Properties()) { // Anynimus Class >:3
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("item.silicon.bismuth.tooltip"));

                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredItem<Item> RAW_BISMUTH = ITEMS.register("raw_bismuth",
            () -> new Item(new Item.Properties()));


    public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties()
                    .stacksTo(1)
                    .durability(800)));

    // Food
    public static final DeferredItem<Item> RADISH = ITEMS.register("radish",
            () -> new RadishItem(new Item.Properties().food(ModFoodProperties.RADISH)));
    
    
    // Fuels

    public static final DeferredItem<Item> FROSTFIRE_ICE = ITEMS.register("frostfire_ice",
            () -> new FuelItem(new Item.Properties(), 800));

    public static final DeferredItem<Item> STARLIGHT_ASHES = ITEMS.register("starlight_ashes",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}


