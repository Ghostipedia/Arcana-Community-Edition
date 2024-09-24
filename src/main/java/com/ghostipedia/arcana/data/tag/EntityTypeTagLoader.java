package com.ghostipedia.arcana.data.tag;

import com.tterrag.registrate.providers.RegistrateTagsProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class EntityTypeTagLoader {
    public static void init(RegistrateTagsProvider<EntityType<?>> provider) {

    }

    public static void create(RegistrateTagsProvider<EntityType<?>> provider, TagKey<EntityType<?>> tagKey,
                              EntityType<?>... rls) {
        var builder = provider.addTag(tagKey);
        for (EntityType<?> entityType : rls) {
            builder.add(BuiltInRegistries.ENTITY_TYPE.getResourceKey(entityType).get());
        }
    }

    public static void create(RegistrateTagsProvider<EntityType<?>> provider, TagKey<EntityType<?>> tagKey,
                              ResourceLocation... rls) {
        var builder = provider.addTag(tagKey);
        for (ResourceLocation rl : rls) {
            builder.addOptional(rl);
        }
    }
}
