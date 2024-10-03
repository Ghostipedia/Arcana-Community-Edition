package com.ghostipedia.arcana.common.datagen;

import com.ghostipedia.arcana.Arcana;
import com.ghostipedia.arcana.blocks.ArcanaBlockNames;
import com.ghostipedia.arcana.blocks.RegisterBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
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
        registerCubeAll(RegisterBlocks.ARCANE_STONE.get(), ArcanaBlockNames.ARCANE_STONE);

    }

    private void registerStateOnly(Block block, String registry){
        simpleBlock(block, getNewModelFile(registry));
    }
    public void registerCubeAll(Block block, String registry){
        buildCube(registry);
        simpleBlock(block, getNewModelFile(registry));
    }
    public void buildCube(String registryName) {
        this.models().getBuilder(registryName).parent(new ModelFile.UncheckedModelFile("block/cube_all")).texture("all", getBlockLocation(registryName));
    }
    public static ModelFile getNewModelFile(String registry){
        return new ModelFile.UncheckedModelFile("arcana:block/" + registry);
    }
    public ResourceLocation getBlockLocation(String registryName){
        return Arcana.prefix("block" + "/" + registryName);
    }
}
