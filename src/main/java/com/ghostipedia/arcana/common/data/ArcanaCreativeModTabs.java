package com.ghostipedia.arcana.common.data;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.ghostipedia.arcana.Arcana.MOD_ID;
import static com.ghostipedia.arcana.items.RegisterItems.*;
import static com.ghostipedia.arcana.blocks.RegisterBlocks.*;

public class ArcanaCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN_BLOCKS = CREATIVE_MODE_TABS.register("arcana_blocks", () -> CreativeModeTab.builder()
            .title(Component.translatable("blocksGroup.arcana")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ARCANE_STONE.asItem().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(EXAMPLE_ITEM.get());
                output.accept(ARCANE_STONE_ITEM.get());
                output.accept(CRUCIBLE.get());
            }).build());
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ASPECTS = CREATIVE_MODE_TABS.register("arcana_aspects", () -> CreativeModeTab.builder()
            .title(Component.translatable("aspectGroup.arcana")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ARCANE_STONE.asItem().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(EXAMPLE_ITEM.get());
                output.accept(ARCANE_STONE_ITEM.get());
            }).build());
    public static void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {}
    }
    public static void init(){
    }
}
