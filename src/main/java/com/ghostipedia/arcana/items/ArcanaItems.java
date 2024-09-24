package com.ghostipedia.arcana.items;

import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullConsumer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;

import static com.ghostipedia.arcana.api.registry.ArcanaRegistration.REGISTRATE;

public class ArcanaItems {
    public static final ItemEntry<Item> BONK = REGISTRATE.item("bonk", Item::new)
            .lang("Bonk")
            .properties(p -> p.stacksTo(64))
            .register();

    public static void init() {

    }
}
