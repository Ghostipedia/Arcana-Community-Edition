package com.ghostipedia.arcana.blocks;

import com.ghostipedia.arcana.Arcana;
import com.ghostipedia.arcana.common.data.ArcanaCreativeModTabs;
import com.ghostipedia.arcana.common.data.ArcanaModels;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

import static com.ghostipedia.arcana.api.registry.ArcanaRegistration.REGISTRATE;

public class ArcanaBlocks {
    static {
        REGISTRATE.creativeModeTab(() -> ArcanaCreativeModTabs.MAIN_TAB);
    }
    private static ToIntFunction<BlockState> light(int level) {
        return (state) -> level;
    }
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Arcana.MOD_ID);
//    public static final RegistryObject<Block> ARCANE_STONE = BLOCKS.register("arcane_stone", () -> new Block(BlockBehaviour.Properties.of().strength(2.0F, 5.0F).sound(SoundType.STONE).requiresCorrectToolForDrops()));
    public static final BlockEntry<Block> ARCANE_STONE = createBlock("arcane_stone", Arcana.id("block/arcane_stone"));

    public static final BlockEntry<SlabBlock> ARCANE_STONE_SLAB = REGISTRATE
            .block("arcane_stone_slab", SlabBlock::new)
            .initialProperties(() -> Blocks.STONE_SLAB)
            .lang("Arcane Stone Slab")
            .blockstate(
                    (ctx, prov) -> prov.slabBlock(ctx.getEntry(), prov.blockTexture(ArcanaBlocks.ARCANE_STONE.get()),
                            prov.blockTexture(ArcanaBlocks.ARCANE_STONE.get())))
            .tag(BlockTags.SLABS, BlockTags.MINEABLE_WITH_PICKAXE)
            .item()
            .tag(ItemTags.SLABS)
            .build()
            .register();
    public static final BlockEntry<StairBlock> ARCANE_STONE_STAIRS = REGISTRATE
            .block("arcane_stone_stairs", (p) -> new StairBlock(ARCANE_STONE::getDefaultState, p))
            .initialProperties(() -> Blocks.STONE_SLAB)
            .lang("Arcane Stone Stairs")
            .blockstate((ctx, prov) -> prov.stairsBlock(ctx.getEntry(), prov.blockTexture(ArcanaBlocks.ARCANE_STONE.get())))
            .tag(BlockTags.STAIRS, BlockTags.MINEABLE_WITH_PICKAXE)
            .item()
            .tag(ItemTags.STAIRS)
            .build()
            .register();









    private static BlockEntry<Block> createGlassCasingBlock(String name, ResourceLocation texture, Supplier<Supplier<RenderType>> type) {
        return createBlock(name, GlassBlock::new, texture, () -> Blocks.GLASS, type);
    }

    public static BlockEntry<Block> createBlock(String name, ResourceLocation texture) {
        return createBlock(name, Block::new, texture, () -> Blocks.IRON_BLOCK,
                () -> RenderType::cutoutMipped);
    }

    public static BlockEntry<Block> createBlock(String name,
                                                      NonNullFunction<BlockBehaviour.Properties, Block> blockSupplier,
                                                      ResourceLocation texture,
                                                      NonNullSupplier<? extends Block> properties,
                                                      Supplier<Supplier<RenderType>> type) {
        return REGISTRATE.block(name, blockSupplier)
                .initialProperties(properties)
                .properties(p -> p.isValidSpawn((state, level, pos, ent) -> false))
                .addLayer(type)
                .blockstate(ArcanaModels.cubeAllModel(name, texture))
                .tag()
                .item(BlockItem::new)
                .build()
                .register();
    }

    public static void init() {
    }
}

