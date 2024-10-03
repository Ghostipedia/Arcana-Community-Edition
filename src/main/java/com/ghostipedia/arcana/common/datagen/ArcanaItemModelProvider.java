package com.ghostipedia.arcana.common.datagen;

import com.ghostipedia.arcana.blocks.RegisterBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;


public class ArcanaItemModelProvider extends ItemModelProvider {
    public ArcanaItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, "arcana", existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent(String.valueOf(RegisterBlocks.ARCANE_STONE_ITEM.get()), modLoc("block/arcane_stone"));
        withExistingParent(String.valueOf(RegisterBlocks.CRUCIBLE_ITEM.get()), modLoc("item/crucible"));
    }

}
