package com.ghostipedia.arcana.common.data;

import com.ghostipedia.arcana.Arcana;
import com.ghostipedia.arcana.api.registry.registrate.ArcanaRegistrate;
import com.ghostipedia.arcana.items.ArcanaItems;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.NotNull;

import static com.ghostipedia.arcana.api.registry.ArcanaRegistration.REGISTRATE;

public class ArcanaCreativeModTabs {
    public static RegistryEntry<CreativeModeTab> MAIN_TAB = REGISTRATE.defaultCreativeTab("main_tab",
                    builder -> builder.displayItems(new RegistrateDisplayItemsGenerator("main_tab", REGISTRATE))
                            .icon(() -> ArcanaItems.BONK.asStack())
                            .title(REGISTRATE.addLang("itemGroup", Arcana.id("item"), Arcana.NAME + " Items"))
                            .build())
            .register();
    public static void init() {}

    public static class RegistrateDisplayItemsGenerator implements CreativeModeTab.DisplayItemsGenerator {

        public final String name;
        public final ArcanaRegistrate registrate;

        public RegistrateDisplayItemsGenerator(String name, ArcanaRegistrate registrate) {
            this.name = name;
            this.registrate = registrate;
        }

        @Override
        public void accept(@NotNull CreativeModeTab.ItemDisplayParameters itemDisplayParameters,
                           @NotNull CreativeModeTab.Output output) {
            var tab = registrate.get(name, Registries.CREATIVE_MODE_TAB);
            for (var entry : registrate.getAll(Registries.BLOCK)) {
                Item item = entry.get().asItem();
                if (item == Items.AIR)
                    continue;
                output.accept(item);
                }
            for (var entry : registrate.getAll(Registries.ITEM)) {
                Item item = entry.get();
                if (item instanceof BlockItem)
                    continue;
                output.accept(item);
            }
        }
    }
}
