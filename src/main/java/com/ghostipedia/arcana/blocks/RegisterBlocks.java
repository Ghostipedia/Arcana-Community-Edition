package com.ghostipedia.arcana.blocks;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.ghostipedia.arcana.Arcana.MOD_ID;
import static com.ghostipedia.arcana.items.RegisterItems.ITEMS;

public class RegisterBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MOD_ID);

    //Blocks
    public static final DeferredBlock<Block> ARCANE_STONE = BLOCKS.registerSimpleBlock("arcane_stone", BlockBehaviour.Properties.of().mapColor(MapColor.STONE));
    public static final DeferredItem<BlockItem> ARCANE_STONE_ITEM = ITEMS.registerSimpleBlockItem("example_block", ARCANE_STONE);
}
