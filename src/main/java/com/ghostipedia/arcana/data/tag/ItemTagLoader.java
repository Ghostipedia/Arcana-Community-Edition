package com.ghostipedia.arcana.data.tag;

import com.ghostipedia.arcana.data.tag.CustomTags;
import com.tterrag.registrate.providers.RegistrateTagsProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class ItemTagLoader {
    public static void init(RegistrateTagsProvider<Item> provider) {
        create(provider, CustomTags.PISTONS, Items.PISTON, Items.STICKY_PISTON);
    }
    public static void create(RegistrateTagsProvider<Item> provider, TagKey<Item> tagKey, ResourceLocation... rls) {
        var builder = provider.addTag(tagKey);
        for (ResourceLocation rl : rls) {
            builder.addOptional(rl);
        }
    }

    public static void create(RegistrateTagsProvider<Item> provider, TagKey<Item> tagKey, Item... rls) {
        var builder = provider.addTag(tagKey);
        for (Item item : rls) {
            builder.add(BuiltInRegistries.ITEM.getResourceKey(item).get());
        }
    }

    private static ResourceLocation rl(String name) {
        return new ResourceLocation(name);
    }
}
