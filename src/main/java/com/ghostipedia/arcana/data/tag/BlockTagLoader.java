package com.ghostipedia.arcana.data.tag;

import com.tterrag.registrate.providers.RegistrateTagsProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class BlockTagLoader {
    public static void init(RegistrateTagsProvider<Block> provider) {}
    public static void create(RegistrateTagsProvider<Block> provider, TagKey<Block> tagKey, Block... rls) {
        var builder = provider.addTag(tagKey);
        for (Block block : rls) {
            builder.add(BuiltInRegistries.BLOCK.getResourceKey(block).get());
        }
    }

    public static void create(RegistrateTagsProvider<Block> provider, TagKey<Block> tagKey, ResourceLocation... rls) {
        var builder = provider.addTag(tagKey);
        for (ResourceLocation rl : rls) {
            builder.addOptional(rl);
        }
    }
}
