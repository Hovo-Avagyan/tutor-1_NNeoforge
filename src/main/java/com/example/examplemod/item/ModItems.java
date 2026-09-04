package com.example.examplemod.item;

import net.minecraft.world.item.Item;
import com.example.examplemod.ExampleMod;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ExampleMod.MODID);

    public static final DeferredItem<Item> AZURITE = ITEMS.registerSimpleItem("azurite");

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
