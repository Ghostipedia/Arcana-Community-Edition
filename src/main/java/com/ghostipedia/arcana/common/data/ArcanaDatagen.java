package com.ghostipedia.arcana.common.data;

import com.ghostipedia.arcana.api.registry.ArcanaRegistration;
import com.ghostipedia.arcana.data.lang.LangHandler;
import com.ghostipedia.arcana.data.tag.TagsHandler;
import com.tterrag.registrate.providers.ProviderType;

public class ArcanaDatagen {
    public static void init() {
        ArcanaRegistration.REGISTRATE.addDataGenerator(ProviderType.ITEM_TAGS, TagsHandler::initItem);
        ArcanaRegistration.REGISTRATE.addDataGenerator(ProviderType.BLOCK_TAGS, TagsHandler::initBlock);
        ArcanaRegistration.REGISTRATE.addDataGenerator(ProviderType.FLUID_TAGS, TagsHandler::initFluid);
        ArcanaRegistration.REGISTRATE.addDataGenerator(ProviderType.ENTITY_TAGS, TagsHandler::initEntity);
        ArcanaRegistration.REGISTRATE.addDataGenerator(ProviderType.LANG, LangHandler::init);
    }
}
