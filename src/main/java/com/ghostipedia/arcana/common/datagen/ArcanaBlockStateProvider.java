package com.ghostipedia.arcana.common.datagen;

import com.ghostipedia.arcana.blocks.RegisterBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ArcanaBlockStateProvider extends BlockStateProvider {
    public ArcanaBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, "arcana", exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        registerSimpleBlock(RegisterBlocks.ARCANE_STONE.get(),RegisterBlocks.ARCANE_STONE.getRegisteredName());
    }

    private void registerSimpleBlock(Block block, String registry){
        simpleBlock(block, getNewModelFile(registry));
    }
    public static ModelFile getNewModelFile(String registry){
        return new ModelFile.UncheckedModelFile("arcana:block/" + registry);
    }
}
