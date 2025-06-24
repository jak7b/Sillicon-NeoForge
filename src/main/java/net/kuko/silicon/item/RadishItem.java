package net.kuko.silicon.item;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

public class RadishItem extends Item {
    public RadishItem(Properties properties) {
		super(properties);
    }


    @Override
    public Component getName(ItemStack stack) {
        return Component.translatable("item.silicon.redish");
    }

    
}
