package net.zic.builders_zenith.datagen;

import net.minecraft.client.color.item.ItemTintSource;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.ConditionBuilder;
import net.minecraft.client.data.models.blockstates.MultiPartGenerator;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.color.item.Constant;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.properties.*;
import net.zic.builders_zenith.BuildersZenith;
import net.zic.builders_zenith.blocks.ModBlocks;
import net.zic.builders_zenith.blocks.custom.DyedBrickType;
import net.zic.builders_zenith.blocks.custom.blockz.VerticalSlabBlock;
import net.zic.builders_zenith.items.ModItems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ModModelProvider extends ModelProvider {

    public ModModelProvider(PackOutput output) {
        super(output, BuildersZenith.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        // ── Items ──────────────────────────────────────────────────────────────
        itemModels.generateFlatItem(ModItems.WHITE_BLOCK_POUCH.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.BLUEPRINT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.TAPE_MEASURE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.TROWEL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.HANDHELD_FILLER.get(), ModelTemplates.FLAT_ITEM);

        // ── Simple full-cube blocks ────────────────────────────────────────────
        blockModels.createTrivialCube(ModBlocks.PREVIEW_BLOCK.get());
        horizontalFacingBlock(blockModels, ModBlocks.CARPENTER.get(), modLoc("block/carpenterblock"));
        horizontalFacingBlock(blockModels, ModBlocks.COLOR_MIXER.get(), modLoc("block/color_mixer"));

        // ── Wood vertical slabs ──────────────────────────────────────────────
        registerVerticalSlab(blockModels, ModBlocks.OAK_VERTICAL_SLAB.get(), Blocks.OAK_PLANKS, "oak_planks");
        registerVerticalSlab(blockModels, ModBlocks.SPRUCE_VERTICAL_SLAB.get(), Blocks.SPRUCE_PLANKS, "spruce_planks");
        registerVerticalSlab(blockModels, ModBlocks.BIRCH_VERTICAL_SLAB.get(), Blocks.BIRCH_PLANKS, "birch_planks");
        registerVerticalSlab(blockModels, ModBlocks.JUNGLE_VERTICAL_SLAB.get(), Blocks.JUNGLE_PLANKS, "jungle_planks");
        registerVerticalSlab(blockModels, ModBlocks.ACACIA_VERTICAL_SLAB.get(), Blocks.ACACIA_PLANKS, "acacia_planks");
        registerVerticalSlab(blockModels, ModBlocks.DARK_OAK_VERTICAL_SLAB.get(), Blocks.DARK_OAK_PLANKS, "dark_oak_planks");
        registerVerticalSlab(blockModels, ModBlocks.MANGROVE_VERTICAL_SLAB.get(), Blocks.MANGROVE_PLANKS, "mangrove_planks");
        registerVerticalSlab(blockModels, ModBlocks.CHERRY_VERTICAL_SLAB.get(), Blocks.CHERRY_PLANKS, "cherry_planks");
        registerVerticalSlab(blockModels, ModBlocks.BAMBOO_VERTICAL_SLAB.get(), Blocks.BAMBOO_PLANKS, "bamboo_planks");
        registerVerticalSlab(blockModels, ModBlocks.CRIMSON_VERTICAL_SLAB.get(), Blocks.CRIMSON_PLANKS, "crimson_planks");
        registerVerticalSlab(blockModels, ModBlocks.WARPED_VERTICAL_SLAB.get(), Blocks.WARPED_PLANKS, "warped_planks");

        // ── Stone vertical slabs ─────────────────────────────────────────────
        registerVerticalSlab(blockModels, ModBlocks.STONE_VERTICAL_SLAB.get(), Blocks.STONE, "stone");
        registerVerticalSlab(blockModels, ModBlocks.MUD_BRICK_VERTICAL_SLAB.get(), Blocks.MUD_BRICKS, "mud_bricks");
        registerVerticalSlab(blockModels, ModBlocks.COBBLESTONE_VERTICAL_SLAB.get(), Blocks.COBBLESTONE, "cobblestone");
        registerVerticalSlab(blockModels, ModBlocks.MOSSY_COBBLESTONE_VERTICAL_SLAB.get(), Blocks.MOSSY_COBBLESTONE, "mossy_cobblestone");
        registerVerticalSlab(blockModels, ModBlocks.SMOOTH_STONE_VERTICAL_SLAB.get(), Blocks.SMOOTH_STONE, "smooth_stone");
        registerVerticalSlab(blockModels, ModBlocks.STONE_BRICK_VERTICAL_SLAB.get(), Blocks.STONE_BRICKS, "stone_bricks");
        registerVerticalSlab(blockModels, ModBlocks.MOSSY_STONE_BRICK_VERTICAL_SLAB.get(), Blocks.MOSSY_STONE_BRICKS, "mossy_stone_bricks");
        registerVerticalSlab(blockModels, ModBlocks.GRANITE_VERTICAL_SLAB.get(), Blocks.GRANITE, "granite");
        registerVerticalSlab(blockModels, ModBlocks.POLISHED_GRANITE_VERTICAL_SLAB.get(), Blocks.POLISHED_GRANITE, "polished_granite");
        registerVerticalSlab(blockModels, ModBlocks.DIORITE_VERTICAL_SLAB.get(), Blocks.DIORITE, "diorite");
        registerVerticalSlab(blockModels, ModBlocks.POLISHED_DIORITE_VERTICAL_SLAB.get(), Blocks.POLISHED_DIORITE, "polished_diorite");
        registerVerticalSlab(blockModels, ModBlocks.ANDESITE_VERTICAL_SLAB.get(), Blocks.ANDESITE, "andesite");
        registerVerticalSlab(blockModels, ModBlocks.POLISHED_ANDESITE_VERTICAL_SLAB.get(), Blocks.POLISHED_ANDESITE, "polished_andesite");
        registerVerticalSlab(blockModels, ModBlocks.COBBLED_DEEPSLATE_VERTICAL_SLAB.get(), Blocks.COBBLED_DEEPSLATE, "cobbled_deepslate");
        registerVerticalSlab(blockModels, ModBlocks.POLISHED_DEEPSLATE_VERTICAL_SLAB.get(), Blocks.POLISHED_DEEPSLATE, "polished_deepslate");
        registerVerticalSlab(blockModels, ModBlocks.DEEPSLATE_BRICK_VERTICAL_SLAB.get(), Blocks.DEEPSLATE_BRICKS, "deepslate_bricks");
        registerVerticalSlab(blockModels, ModBlocks.DEEPSLATE_TILE_VERTICAL_SLAB.get(), Blocks.DEEPSLATE_TILES, "deepslate_tiles");
        registerVerticalSlab(blockModels, ModBlocks.TUFF_VERTICAL_SLAB.get(), Blocks.TUFF, "tuff");
        registerVerticalSlab(blockModels, ModBlocks.POLISHED_TUFF_VERTICAL_SLAB.get(), Blocks.POLISHED_TUFF, "polished_tuff");
        registerVerticalSlab(blockModels, ModBlocks.TUFF_BRICK_VERTICAL_SLAB.get(), Blocks.TUFF_BRICKS, "tuff_bricks");
        registerVerticalSlab(blockModels, ModBlocks.BRICK_VERTICAL_SLAB.get(), Blocks.BRICKS, "bricks");
        registerVerticalSlab(blockModels, ModBlocks.SANDSTONE_VERTICAL_SLAB.get(), Blocks.SANDSTONE, "sandstone", "sandstone_bottom", "sandstone_top");
        registerVerticalSlab(blockModels, ModBlocks.SMOOTH_SANDSTONE_VERTICAL_SLAB.get(), Blocks.SMOOTH_SANDSTONE, "sandstone_top");
        registerVerticalSlab(blockModels, ModBlocks.CUT_SANDSTONE_VERTICAL_SLAB.get(), Blocks.CUT_SANDSTONE, "cut_sandstone", "sandstone_top", "sandstone_top");
        registerVerticalSlab(blockModels, ModBlocks.RED_SANDSTONE_VERTICAL_SLAB.get(), Blocks.RED_SANDSTONE, "red_sandstone", "red_sandstone_bottom", "red_sandstone_top");
        registerVerticalSlab(blockModels, ModBlocks.SMOOTH_RED_SANDSTONE_VERTICAL_SLAB.get(), Blocks.SMOOTH_RED_SANDSTONE, "red_sandstone_top");
        registerVerticalSlab(blockModels, ModBlocks.CUT_RED_SANDSTONE_VERTICAL_SLAB.get(), Blocks.CUT_RED_SANDSTONE, "cut_red_sandstone", "red_sandstone_top", "red_sandstone_top");
        registerVerticalSlab(blockModels, ModBlocks.PRISMARINE_VERTICAL_SLAB.get(), Blocks.PRISMARINE, "prismarine");
        registerVerticalSlab(blockModels, ModBlocks.PRISMARINE_BRICK_VERTICAL_SLAB.get(), Blocks.PRISMARINE_BRICKS, "prismarine_bricks");
        registerVerticalSlab(blockModels, ModBlocks.DARK_PRISMARINE_VERTICAL_SLAB.get(), Blocks.DARK_PRISMARINE, "dark_prismarine");
        registerVerticalSlab(blockModels, ModBlocks.NETHER_BRICK_VERTICAL_SLAB.get(), Blocks.NETHER_BRICKS, "nether_bricks");
        registerVerticalSlab(blockModels, ModBlocks.RED_NETHER_BRICK_VERTICAL_SLAB.get(), Blocks.RED_NETHER_BRICKS, "red_nether_bricks");
        registerVerticalSlab(blockModels, ModBlocks.BLACKSTONE_VERTICAL_SLAB.get(), Blocks.BLACKSTONE, "blackstone", "blackstone_top", "blackstone_top");
        registerVerticalSlab(blockModels, ModBlocks.POLISHED_BLACKSTONE_VERTICAL_SLAB.get(), Blocks.POLISHED_BLACKSTONE, "polished_blackstone");
        registerVerticalSlab(blockModels, ModBlocks.POLISHED_BLACKSTONE_BRICK_VERTICAL_SLAB.get(), Blocks.POLISHED_BLACKSTONE_BRICKS, "polished_blackstone_bricks");
        registerVerticalSlab(blockModels, ModBlocks.END_STONE_BRICK_VERTICAL_SLAB.get(), Blocks.END_STONE_BRICKS, "end_stone_bricks");
        registerVerticalSlab(blockModels, ModBlocks.PURPUR_VERTICAL_SLAB.get(), Blocks.PURPUR_BLOCK, "purpur_block");
        registerVerticalSlab(blockModels, ModBlocks.QUARTZ_VERTICAL_SLAB.get(), Blocks.QUARTZ_BLOCK, "quartz_block_side", "quartz_block_top", "quartz_block_top");
        registerVerticalSlab(blockModels, ModBlocks.SMOOTH_QUARTZ_VERTICAL_SLAB.get(), Blocks.SMOOTH_QUARTZ, "quartz_block_bottom");

        // ── Dyed bricks ──────────────────────────────────────────────────────
        for (DyedBrickType type : DyedBrickType.values()) {
            registerDyedBrickFamily(blockModels, itemModels, type);
        }

        // ── Marble (all 16 colors × 5 variants + stairs/slabs/walls) ────────
        registerMarbleModels(blockModels);
    }

    // ========================================================================
    // Marble
    // ========================================================================

    private static final Map<Block, StairBlock> MARBLE_STAIRS_BY_BASE = new HashMap<>();
    private static final Map<Block, SlabBlock>  MARBLE_SLABS_BY_BASE  = new HashMap<>();
    private static final Map<Block, WallBlock>  MARBLE_WALLS_BY_BASE  = new HashMap<>();

    private static final List<Block> MARBLE_FULL_BLOCKS = List.of(
            ModBlocks.MARBLE.get(),             ModBlocks.MARBLE_BRICKS.get(),             ModBlocks.MARBLE_CHISELED.get(),             ModBlocks.MARBLE_TILES.get(),             ModBlocks.POLISHED_MARBLE.get(),
            ModBlocks.LIGHT_GRAY_MARBLE.get(),          ModBlocks.LIGHT_GRAY_MARBLE_BRICKS.get(),          ModBlocks.LIGHT_GRAY_MARBLE_CHISELED.get(),          ModBlocks.LIGHT_GRAY_MARBLE_TILES.get(),          ModBlocks.POLISHED_LIGHT_GRAY_MARBLE.get(),
            ModBlocks.GRAY_MARBLE.get(),                ModBlocks.GRAY_MARBLE_BRICKS.get(),                ModBlocks.GRAY_MARBLE_CHISELED.get(),                ModBlocks.GRAY_MARBLE_TILES.get(),                ModBlocks.GRAY_POLISHED_MARBLE.get(),
            ModBlocks.BLACK_MARBLE.get(),               ModBlocks.BLACK_MARBLE_BRICKS.get(),               ModBlocks.BLACK_MARBLE_CHISELED.get(),               ModBlocks.BLACK_MARBLE_TILES.get(),               ModBlocks.BLACK_POLISHED_MARBLE.get(),
            ModBlocks.BROWN_MARBLE.get(),               ModBlocks.BROWN_MARBLE_BRICKS.get(),               ModBlocks.BROWN_MARBLE_CHISELED.get(),               ModBlocks.BROWN_MARBLE_TILES.get(),               ModBlocks.BROWN_POLISHED_MARBLE.get(),
            ModBlocks.RED_MARBLE.get(),                 ModBlocks.RED_MARBLE_BRICKS.get(),                 ModBlocks.RED_MARBLE_CHISELED.get(),                 ModBlocks.RED_MARBLE_TILES.get(),                 ModBlocks.RED_POLISHED_MARBLE.get(),
            ModBlocks.ORANGE_MARBLE.get(),              ModBlocks.ORANGE_MARBLE_BRICKS.get(),              ModBlocks.ORANGE_MARBLE_CHISELED.get(),              ModBlocks.ORANGE_MARBLE_TILES.get(),              ModBlocks.ORANGE_POLISHED_MARBLE.get(),
            ModBlocks.YELLOW_MARBLE.get(),              ModBlocks.YELLOW_MARBLE_BRICKS.get(),              ModBlocks.YELLOW_MARBLE_CHISELED.get(),              ModBlocks.YELLOW_MARBLE_TILES.get(),              ModBlocks.YELLOW_POLISHED_MARBLE.get(),
            ModBlocks.LIME_MARBLE.get(),                ModBlocks.LIME_MARBLE_BRICKS.get(),                ModBlocks.LIME_MARBLE_CHISELED.get(),                ModBlocks.LIME_MARBLE_TILES.get(),                ModBlocks.LIME_POLISHED_MARBLE.get(),
            ModBlocks.GREEN_MARBLE.get(),               ModBlocks.GREEN_MARBLE_BRICKS.get(),               ModBlocks.GREEN_MARBLE_CHISELED.get(),               ModBlocks.GREEN_MARBLE_TILES.get(),               ModBlocks.GREEN_POLISHED_MARBLE.get(),
            ModBlocks.CYAN_MARBLE.get(),                ModBlocks.CYAN_MARBLE_BRICKS.get(),                ModBlocks.CYAN_MARBLE_CHISELED.get(),                ModBlocks.CYAN_MARBLE_TILES.get(),                ModBlocks.CYAN_POLISHED_MARBLE.get(),
            ModBlocks.LIGHT_BLUE_MARBLE.get(),          ModBlocks.LIGHT_BLUE_MARBLE_BRICKS.get(),          ModBlocks.LIGHT_BLUE_MARBLE_CHISELED.get(),          ModBlocks.LIGHT_BLUE_MARBLE_TILES.get(),          ModBlocks.LIGHT_BLUE_POLISHED_MARBLE.get(),
            ModBlocks.BLUE_MARBLE.get(),                ModBlocks.BLUE_MARBLE_BRICKS.get(),                ModBlocks.BLUE_MARBLE_CHISELED.get(),                ModBlocks.BLUE_MARBLE_TILES.get(),                ModBlocks.BLUE_POLISHED_MARBLE.get(),
            ModBlocks.PURPLE_MARBLE.get(),              ModBlocks.PURPLE_MARBLE_BRICKS.get(),              ModBlocks.PURPLE_MARBLE_CHISELED.get(),              ModBlocks.PURPLE_MARBLE_TILES.get(),              ModBlocks.PURPLE_POLISHED_MARBLE.get(),
            ModBlocks.MAGENTA_MARBLE.get(),             ModBlocks.MAGENTA_MARBLE_BRICKS.get(),             ModBlocks.MAGENTA_MARBLE_CHISELED.get(),             ModBlocks.MAGENTA_MARBLE_TILES.get(),             ModBlocks.MAGENTA_POLISHED_MARBLE.get(),
            ModBlocks.PINK_MARBLE.get(),                ModBlocks.PINK_MARBLE_BRICKS.get(),                ModBlocks.PINK_MARBLE_CHISELED.get(),                ModBlocks.PINK_MARBLE_TILES.get(),                ModBlocks.PINK_POLISHED_MARBLE.get()
    );

    private static final List<Block> MARBLE_SSW_BASES = List.of(
            ModBlocks.MARBLE_BRICKS.get(),      ModBlocks.MARBLE_TILES.get(),
            ModBlocks.LIGHT_GRAY_MARBLE_BRICKS.get(),   ModBlocks.LIGHT_GRAY_MARBLE_TILES.get(),
            ModBlocks.GRAY_MARBLE_BRICKS.get(),         ModBlocks.GRAY_MARBLE_TILES.get(),
            ModBlocks.BLACK_MARBLE_BRICKS.get(),        ModBlocks.BLACK_MARBLE_TILES.get(),
            ModBlocks.BROWN_MARBLE_BRICKS.get(),        ModBlocks.BROWN_MARBLE_TILES.get(),
            ModBlocks.RED_MARBLE_BRICKS.get(),          ModBlocks.RED_MARBLE_TILES.get(),
            ModBlocks.ORANGE_MARBLE_BRICKS.get(),       ModBlocks.ORANGE_MARBLE_TILES.get(),
            ModBlocks.YELLOW_MARBLE_BRICKS.get(),       ModBlocks.YELLOW_MARBLE_TILES.get(),
            ModBlocks.LIME_MARBLE_BRICKS.get(),         ModBlocks.LIME_MARBLE_TILES.get(),
            ModBlocks.GREEN_MARBLE_BRICKS.get(),        ModBlocks.GREEN_MARBLE_TILES.get(),
            ModBlocks.CYAN_MARBLE_BRICKS.get(),         ModBlocks.CYAN_MARBLE_TILES.get(),
            ModBlocks.LIGHT_BLUE_MARBLE_BRICKS.get(),   ModBlocks.LIGHT_BLUE_MARBLE_TILES.get(),
            ModBlocks.BLUE_MARBLE_BRICKS.get(),         ModBlocks.BLUE_MARBLE_TILES.get(),
            ModBlocks.PURPLE_MARBLE_BRICKS.get(),       ModBlocks.PURPLE_MARBLE_TILES.get(),
            ModBlocks.MAGENTA_MARBLE_BRICKS.get(),      ModBlocks.MAGENTA_MARBLE_TILES.get(),
            ModBlocks.PINK_MARBLE_BRICKS.get(),         ModBlocks.PINK_MARBLE_TILES.get()
    );

    static {
        // stairs
        MARBLE_STAIRS_BY_BASE.put(ModBlocks.MARBLE_BRICKS.get(), ModBlocks.MARBLE_BRICK_STAIRS.get());
        MARBLE_STAIRS_BY_BASE.put(ModBlocks.MARBLE_TILES.get(),  ModBlocks.MARBLE_TILE_STAIRS.get());
        MARBLE_STAIRS_BY_BASE.put(ModBlocks.LIGHT_GRAY_MARBLE_BRICKS.get(),   ModBlocks.LIGHT_GRAY_MARBLE_BRICK_STAIRS.get());
        MARBLE_STAIRS_BY_BASE.put(ModBlocks.LIGHT_GRAY_MARBLE_TILES.get(),    ModBlocks.LIGHT_GRAY_MARBLE_TILE_STAIRS.get());
        MARBLE_STAIRS_BY_BASE.put(ModBlocks.GRAY_MARBLE_BRICKS.get(),         ModBlocks.GRAY_MARBLE_BRICK_STAIRS.get());
        MARBLE_STAIRS_BY_BASE.put(ModBlocks.GRAY_MARBLE_TILES.get(),          ModBlocks.GRAY_MARBLE_TILE_STAIRS.get());
        MARBLE_STAIRS_BY_BASE.put(ModBlocks.BLACK_MARBLE_BRICKS.get(),        ModBlocks.BLACK_MARBLE_BRICK_STAIRS.get());
        MARBLE_STAIRS_BY_BASE.put(ModBlocks.BLACK_MARBLE_TILES.get(),         ModBlocks.BLACK_MARBLE_TILE_STAIRS.get());
        MARBLE_STAIRS_BY_BASE.put(ModBlocks.BROWN_MARBLE_BRICKS.get(),        ModBlocks.BROWN_MARBLE_BRICK_STAIRS.get());
        MARBLE_STAIRS_BY_BASE.put(ModBlocks.BROWN_MARBLE_TILES.get(),         ModBlocks.BROWN_MARBLE_TILE_STAIRS.get());
        MARBLE_STAIRS_BY_BASE.put(ModBlocks.RED_MARBLE_BRICKS.get(),          ModBlocks.RED_MARBLE_BRICK_STAIRS.get());
        MARBLE_STAIRS_BY_BASE.put(ModBlocks.RED_MARBLE_TILES.get(),           ModBlocks.RED_MARBLE_TILE_STAIRS.get());
        MARBLE_STAIRS_BY_BASE.put(ModBlocks.ORANGE_MARBLE_BRICKS.get(),       ModBlocks.ORANGE_MARBLE_BRICK_STAIRS.get());
        MARBLE_STAIRS_BY_BASE.put(ModBlocks.ORANGE_MARBLE_TILES.get(),        ModBlocks.ORANGE_MARBLE_TILE_STAIRS.get());
        MARBLE_STAIRS_BY_BASE.put(ModBlocks.YELLOW_MARBLE_BRICKS.get(),       ModBlocks.YELLOW_MARBLE_BRICK_STAIRS.get());
        MARBLE_STAIRS_BY_BASE.put(ModBlocks.YELLOW_MARBLE_TILES.get(),        ModBlocks.YELLOW_MARBLE_TILE_STAIRS.get());
        MARBLE_STAIRS_BY_BASE.put(ModBlocks.LIME_MARBLE_BRICKS.get(),         ModBlocks.LIME_MARBLE_BRICK_STAIRS.get());
        MARBLE_STAIRS_BY_BASE.put(ModBlocks.LIME_MARBLE_TILES.get(),          ModBlocks.LIME_MARBLE_TILE_STAIRS.get());
        MARBLE_STAIRS_BY_BASE.put(ModBlocks.GREEN_MARBLE_BRICKS.get(),        ModBlocks.GREEN_MARBLE_BRICK_STAIRS.get());
        MARBLE_STAIRS_BY_BASE.put(ModBlocks.GREEN_MARBLE_TILES.get(),         ModBlocks.GREEN_MARBLE_TILE_STAIRS.get());
        MARBLE_STAIRS_BY_BASE.put(ModBlocks.CYAN_MARBLE_BRICKS.get(),         ModBlocks.CYAN_MARBLE_BRICK_STAIRS.get());
        MARBLE_STAIRS_BY_BASE.put(ModBlocks.CYAN_MARBLE_TILES.get(),          ModBlocks.CYAN_MARBLE_TILE_STAIRS.get());
        MARBLE_STAIRS_BY_BASE.put(ModBlocks.LIGHT_BLUE_MARBLE_BRICKS.get(),   ModBlocks.LIGHT_BLUE_MARBLE_BRICK_STAIRS.get());
        MARBLE_STAIRS_BY_BASE.put(ModBlocks.LIGHT_BLUE_MARBLE_TILES.get(),    ModBlocks.LIGHT_BLUE_MARBLE_TILE_STAIRS.get());
        MARBLE_STAIRS_BY_BASE.put(ModBlocks.BLUE_MARBLE_BRICKS.get(),         ModBlocks.BLUE_MARBLE_BRICK_STAIRS.get());
        MARBLE_STAIRS_BY_BASE.put(ModBlocks.BLUE_MARBLE_TILES.get(),          ModBlocks.BLUE_MARBLE_TILE_STAIRS.get());
        MARBLE_STAIRS_BY_BASE.put(ModBlocks.PURPLE_MARBLE_BRICKS.get(),       ModBlocks.PURPLE_MARBLE_BRICK_STAIRS.get());
        MARBLE_STAIRS_BY_BASE.put(ModBlocks.PURPLE_MARBLE_TILES.get(),        ModBlocks.PURPLE_MARBLE_TILE_STAIRS.get());
        MARBLE_STAIRS_BY_BASE.put(ModBlocks.MAGENTA_MARBLE_BRICKS.get(),      ModBlocks.MAGENTA_MARBLE_BRICK_STAIRS.get());
        MARBLE_STAIRS_BY_BASE.put(ModBlocks.MAGENTA_MARBLE_TILES.get(),       ModBlocks.MAGENTA_MARBLE_TILE_STAIRS.get());
        MARBLE_STAIRS_BY_BASE.put(ModBlocks.PINK_MARBLE_BRICKS.get(),         ModBlocks.PINK_MARBLE_BRICK_STAIRS.get());
        MARBLE_STAIRS_BY_BASE.put(ModBlocks.PINK_MARBLE_TILES.get(),          ModBlocks.PINK_MARBLE_TILE_STAIRS.get());

        // slabs
        MARBLE_SLABS_BY_BASE.put(ModBlocks.MARBLE_BRICKS.get(), ModBlocks.MARBLE_BRICK_SLABS.get());
        MARBLE_SLABS_BY_BASE.put(ModBlocks.MARBLE_TILES.get(),  ModBlocks.MARBLE_TILE_SLABS.get());
        MARBLE_SLABS_BY_BASE.put(ModBlocks.LIGHT_GRAY_MARBLE_BRICKS.get(),    ModBlocks.LIGHT_GRAY_MARBLE_BRICK_SLABS.get());
        MARBLE_SLABS_BY_BASE.put(ModBlocks.LIGHT_GRAY_MARBLE_TILES.get(),     ModBlocks.LIGHT_GRAY_MARBLE_TILE_SLABS.get());
        MARBLE_SLABS_BY_BASE.put(ModBlocks.GRAY_MARBLE_BRICKS.get(),          ModBlocks.GRAY_MARBLE_BRICK_SLABS.get());
        MARBLE_SLABS_BY_BASE.put(ModBlocks.GRAY_MARBLE_TILES.get(),           ModBlocks.GRAY_MARBLE_TILE_SLABS.get());
        MARBLE_SLABS_BY_BASE.put(ModBlocks.BLACK_MARBLE_BRICKS.get(),         ModBlocks.BLACK_MARBLE_BRICK_SLABS.get());
        MARBLE_SLABS_BY_BASE.put(ModBlocks.BLACK_MARBLE_TILES.get(),          ModBlocks.BLACK_MARBLE_TILE_SLABS.get());
        MARBLE_SLABS_BY_BASE.put(ModBlocks.BROWN_MARBLE_BRICKS.get(),         ModBlocks.BROWN_MARBLE_BRICK_SLABS.get());
        MARBLE_SLABS_BY_BASE.put(ModBlocks.BROWN_MARBLE_TILES.get(),          ModBlocks.BROWN_MARBLE_TILE_SLABS.get());
        MARBLE_SLABS_BY_BASE.put(ModBlocks.RED_MARBLE_BRICKS.get(),           ModBlocks.RED_MARBLE_BRICK_SLABS.get());
        MARBLE_SLABS_BY_BASE.put(ModBlocks.RED_MARBLE_TILES.get(),            ModBlocks.RED_MARBLE_TILE_SLABS.get());
        MARBLE_SLABS_BY_BASE.put(ModBlocks.ORANGE_MARBLE_BRICKS.get(),        ModBlocks.ORANGE_MARBLE_BRICK_SLABS.get());
        MARBLE_SLABS_BY_BASE.put(ModBlocks.ORANGE_MARBLE_TILES.get(),         ModBlocks.ORANGE_MARBLE_TILE_SLABS.get());
        MARBLE_SLABS_BY_BASE.put(ModBlocks.YELLOW_MARBLE_BRICKS.get(),        ModBlocks.YELLOW_MARBLE_BRICK_SLABS.get());
        MARBLE_SLABS_BY_BASE.put(ModBlocks.YELLOW_MARBLE_TILES.get(),         ModBlocks.YELLOW_MARBLE_TILE_SLABS.get());
        MARBLE_SLABS_BY_BASE.put(ModBlocks.LIME_MARBLE_BRICKS.get(),          ModBlocks.LIME_MARBLE_BRICK_SLABS.get());
        MARBLE_SLABS_BY_BASE.put(ModBlocks.LIME_MARBLE_TILES.get(),           ModBlocks.LIME_MARBLE_TILE_SLABS.get());
        MARBLE_SLABS_BY_BASE.put(ModBlocks.GREEN_MARBLE_BRICKS.get(),         ModBlocks.GREEN_MARBLE_BRICK_SLABS.get());
        MARBLE_SLABS_BY_BASE.put(ModBlocks.GREEN_MARBLE_TILES.get(),          ModBlocks.GREEN_MARBLE_TILE_SLABS.get());
        MARBLE_SLABS_BY_BASE.put(ModBlocks.CYAN_MARBLE_BRICKS.get(),          ModBlocks.CYAN_MARBLE_BRICK_SLABS.get());
        MARBLE_SLABS_BY_BASE.put(ModBlocks.CYAN_MARBLE_TILES.get(),           ModBlocks.CYAN_MARBLE_TILE_SLABS.get());
        MARBLE_SLABS_BY_BASE.put(ModBlocks.LIGHT_BLUE_MARBLE_BRICKS.get(),    ModBlocks.LIGHT_BLUE_MARBLE_BRICK_SLABS.get());
        MARBLE_SLABS_BY_BASE.put(ModBlocks.LIGHT_BLUE_MARBLE_TILES.get(),     ModBlocks.LIGHT_BLUE_MARBLE_TILE_SLABS.get());
        MARBLE_SLABS_BY_BASE.put(ModBlocks.BLUE_MARBLE_BRICKS.get(),          ModBlocks.BLUE_MARBLE_BRICK_SLABS.get());
        MARBLE_SLABS_BY_BASE.put(ModBlocks.BLUE_MARBLE_TILES.get(),           ModBlocks.BLUE_MARBLE_TILE_SLABS.get());
        MARBLE_SLABS_BY_BASE.put(ModBlocks.PURPLE_MARBLE_BRICKS.get(),        ModBlocks.PURPLE_MARBLE_BRICK_SLABS.get());
        MARBLE_SLABS_BY_BASE.put(ModBlocks.PURPLE_MARBLE_TILES.get(),         ModBlocks.PURPLE_MARBLE_TILE_SLABS.get());
        MARBLE_SLABS_BY_BASE.put(ModBlocks.MAGENTA_MARBLE_BRICKS.get(),       ModBlocks.MAGENTA_MARBLE_BRICK_SLABS.get());
        MARBLE_SLABS_BY_BASE.put(ModBlocks.MAGENTA_MARBLE_TILES.get(),        ModBlocks.MAGENTA_MARBLE_TILE_SLABS.get());
        MARBLE_SLABS_BY_BASE.put(ModBlocks.PINK_MARBLE_BRICKS.get(),          ModBlocks.PINK_MARBLE_BRICK_SLABS.get());
        MARBLE_SLABS_BY_BASE.put(ModBlocks.PINK_MARBLE_TILES.get(),           ModBlocks.PINK_MARBLE_TILE_SLABS.get());

        // walls
        MARBLE_WALLS_BY_BASE.put(ModBlocks.MARBLE_BRICKS.get(), ModBlocks.MARBLE_BRICK_WALLS.get());
        MARBLE_WALLS_BY_BASE.put(ModBlocks.MARBLE_TILES.get(),  ModBlocks.MARBLE_TILE_WALLS.get());
        MARBLE_WALLS_BY_BASE.put(ModBlocks.LIGHT_GRAY_MARBLE_BRICKS.get(),    ModBlocks.LIGHT_GRAY_MARBLE_BRICK_WALLS.get());
        MARBLE_WALLS_BY_BASE.put(ModBlocks.LIGHT_GRAY_MARBLE_TILES.get(),     ModBlocks.LIGHT_GRAY_MARBLE_TILE_WALLS.get());
        MARBLE_WALLS_BY_BASE.put(ModBlocks.GRAY_MARBLE_BRICKS.get(),          ModBlocks.GRAY_MARBLE_BRICK_WALLS.get());
        MARBLE_WALLS_BY_BASE.put(ModBlocks.GRAY_MARBLE_TILES.get(),           ModBlocks.GRAY_MARBLE_TILE_WALLS.get());
        MARBLE_WALLS_BY_BASE.put(ModBlocks.BLACK_MARBLE_BRICKS.get(),         ModBlocks.BLACK_MARBLE_BRICK_WALLS.get());
        MARBLE_WALLS_BY_BASE.put(ModBlocks.BLACK_MARBLE_TILES.get(),          ModBlocks.BLACK_MARBLE_TILE_WALLS.get());
        MARBLE_WALLS_BY_BASE.put(ModBlocks.BROWN_MARBLE_BRICKS.get(),         ModBlocks.BROWN_MARBLE_BRICK_WALLS.get());
        MARBLE_WALLS_BY_BASE.put(ModBlocks.BROWN_MARBLE_TILES.get(),          ModBlocks.BROWN_MARBLE_TILE_WALLS.get());
        MARBLE_WALLS_BY_BASE.put(ModBlocks.RED_MARBLE_BRICKS.get(),           ModBlocks.RED_MARBLE_BRICK_WALLS.get());
        MARBLE_WALLS_BY_BASE.put(ModBlocks.RED_MARBLE_TILES.get(),            ModBlocks.RED_MARBLE_TILE_WALLS.get());
        MARBLE_WALLS_BY_BASE.put(ModBlocks.ORANGE_MARBLE_BRICKS.get(),        ModBlocks.ORANGE_MARBLE_BRICK_WALLS.get());
        MARBLE_WALLS_BY_BASE.put(ModBlocks.ORANGE_MARBLE_TILES.get(),         ModBlocks.ORANGE_MARBLE_TILE_WALLS.get());
        MARBLE_WALLS_BY_BASE.put(ModBlocks.YELLOW_MARBLE_BRICKS.get(),        ModBlocks.YELLOW_MARBLE_BRICK_WALLS.get());
        MARBLE_WALLS_BY_BASE.put(ModBlocks.YELLOW_MARBLE_TILES.get(),         ModBlocks.YELLOW_MARBLE_TILE_WALLS.get());
        MARBLE_WALLS_BY_BASE.put(ModBlocks.LIME_MARBLE_BRICKS.get(),          ModBlocks.LIME_MARBLE_BRICK_WALLS.get());
        MARBLE_WALLS_BY_BASE.put(ModBlocks.LIME_MARBLE_TILES.get(),           ModBlocks.LIME_MARBLE_TILE_WALLS.get());
        MARBLE_WALLS_BY_BASE.put(ModBlocks.GREEN_MARBLE_BRICKS.get(),         ModBlocks.GREEN_MARBLE_BRICK_WALLS.get());
        MARBLE_WALLS_BY_BASE.put(ModBlocks.GREEN_MARBLE_TILES.get(),          ModBlocks.GREEN_MARBLE_TILE_WALLS.get());
        MARBLE_WALLS_BY_BASE.put(ModBlocks.CYAN_MARBLE_BRICKS.get(),          ModBlocks.CYAN_MARBLE_BRICK_WALLS.get());
        MARBLE_WALLS_BY_BASE.put(ModBlocks.CYAN_MARBLE_TILES.get(),           ModBlocks.CYAN_MARBLE_TILE_WALLS.get());
        MARBLE_WALLS_BY_BASE.put(ModBlocks.LIGHT_BLUE_MARBLE_BRICKS.get(),    ModBlocks.LIGHT_BLUE_MARBLE_BRICK_WALLS.get());
        MARBLE_WALLS_BY_BASE.put(ModBlocks.LIGHT_BLUE_MARBLE_TILES.get(),     ModBlocks.LIGHT_BLUE_MARBLE_TILE_WALLS.get());
        MARBLE_WALLS_BY_BASE.put(ModBlocks.BLUE_MARBLE_BRICKS.get(),          ModBlocks.BLUE_MARBLE_BRICK_WALLS.get());
        MARBLE_WALLS_BY_BASE.put(ModBlocks.BLUE_MARBLE_TILES.get(),           ModBlocks.BLUE_MARBLE_TILE_WALLS.get());
        MARBLE_WALLS_BY_BASE.put(ModBlocks.PURPLE_MARBLE_BRICKS.get(),        ModBlocks.PURPLE_MARBLE_BRICK_WALLS.get());
        MARBLE_WALLS_BY_BASE.put(ModBlocks.PURPLE_MARBLE_TILES.get(),         ModBlocks.PURPLE_MARBLE_TILE_WALLS.get());
        MARBLE_WALLS_BY_BASE.put(ModBlocks.MAGENTA_MARBLE_BRICKS.get(),       ModBlocks.MAGENTA_MARBLE_BRICK_WALLS.get());
        MARBLE_WALLS_BY_BASE.put(ModBlocks.MAGENTA_MARBLE_TILES.get(),        ModBlocks.MAGENTA_MARBLE_TILE_WALLS.get());
        MARBLE_WALLS_BY_BASE.put(ModBlocks.PINK_MARBLE_BRICKS.get(),          ModBlocks.PINK_MARBLE_BRICK_WALLS.get());
        MARBLE_WALLS_BY_BASE.put(ModBlocks.PINK_MARBLE_TILES.get(),           ModBlocks.PINK_MARBLE_TILE_WALLS.get());
    }

    private void registerMarbleModels(BlockModelGenerators blockModels) {
        // 1. Full-cube marble blocks
        for (Block b : MARBLE_FULL_BLOCKS) {
            blockModels.createTrivialCube(b);
        }

        // 2. Stairs / Slabs / Walls — build the model Identifier manually using
        //    the vanilla ModelTemplates, then dispatch the blockstate ourselves.
        for (Block base : MARBLE_SSW_BASES) {
            Identifier blockId = BuiltInRegistries.BLOCK.getKey(base);
            String path = blockId.getPath(); // e.g. "white_marble_bricks"
            Material tex = new Material(Identifier.fromNamespaceAndPath(BuildersZenith.MOD_ID, "block/" + path));

            TextureMapping tm = new TextureMapping()
                    .put(TextureSlot.BOTTOM, tex)
                    .put(TextureSlot.TOP,    tex)
                    .put(TextureSlot.SIDE,   tex);

            // ── Stairs ────────────────────────────────────────────────────
            StairBlock stair = MARBLE_STAIRS_BY_BASE.get(base);
            if (stair != null) {
                Identifier straight = ModelTemplates.STAIRS_STRAIGHT.create(
                        ModelLocationUtils.getModelLocation(stair), tm, blockModels.modelOutput);
                Identifier inner = ModelTemplates.STAIRS_INNER.create(
                        ModelLocationUtils.getModelLocation(stair, "_inner"), tm, blockModels.modelOutput);
                Identifier outer = ModelTemplates.STAIRS_OUTER.create(
                        ModelLocationUtils.getModelLocation(stair, "_outer"), tm, blockModels.modelOutput);
                stairsBlock(blockModels, stair, straight, inner, outer);
                blockModels.registerSimpleItemModel(stair, straight);
            }

            // ── Slabs ─────────────────────────────────────────────────────
            SlabBlock slab = MARBLE_SLABS_BY_BASE.get(base);
            if (slab != null) {
                Identifier bottom = ModelTemplates.SLAB_BOTTOM.create(
                        ModelLocationUtils.getModelLocation(slab), tm, blockModels.modelOutput);
                Identifier top = ModelTemplates.SLAB_TOP.create(
                        ModelLocationUtils.getModelLocation(slab, "_top"), tm, blockModels.modelOutput);
                // Double slab uses the base full block's cube_all model
                Identifier full = ModelTemplates.CUBE_ALL.create(
                        ModelLocationUtils.getModelLocation(slab, "_double"),
                        TextureMapping.cube(tex), blockModels.modelOutput);
                slabBlock(blockModels, slab, bottom, top, full);
                blockModels.registerSimpleItemModel(slab, bottom);
            }

            // ── Walls ─────────────────────────────────────────────────────
            WallBlock wall = MARBLE_WALLS_BY_BASE.get(base);
            if (wall != null) {
                TextureMapping wallTex = new TextureMapping().put(TextureSlot.WALL, tex);
                Identifier post = ModelTemplates.WALL_POST.create(
                        ModelLocationUtils.getModelLocation(wall, "_post"), wallTex, blockModels.modelOutput);
                Identifier side = ModelTemplates.WALL_LOW_SIDE.create(
                        ModelLocationUtils.getModelLocation(wall, "_side"), wallTex, blockModels.modelOutput);
                Identifier sideTall = ModelTemplates.WALL_TALL_SIDE.create(
                        ModelLocationUtils.getModelLocation(wall, "_side_tall"), wallTex, blockModels.modelOutput);
                Identifier inventory = ModelTemplates.WALL_INVENTORY.create(
                        ModelLocationUtils.getModelLocation(wall, "_inventory"), wallTex, blockModels.modelOutput);
                wallBlock(blockModels, wall, post, side, sideTall, inventory);
                blockModels.registerSimpleItemModel(wall, inventory);
            }
        }
    }

    // ========================================================================
    // Vertical Slabs
    // ========================================================================

    private void registerVerticalSlab(BlockModelGenerators blockModels, Block vertSlab, Block fullBlock, String texturePath) {
        registerVerticalSlab(blockModels, vertSlab, fullBlock, texturePath, texturePath, texturePath);
    }

    private void registerVerticalSlab(BlockModelGenerators blockModels, Block vertSlab, Block fullBlock, String sideTexture, String bottomTexture, String topTexture) {
        ModelTemplate template = new ModelTemplate(
                Optional.of(modLoc("block/template_vertical_slab")),
                Optional.empty(),
                TextureSlot.SIDE,
                TextureSlot.BOTTOM,
                TextureSlot.TOP
        );

        Material sideMaterial = new Material(Identifier.fromNamespaceAndPath("minecraft", "block/" + sideTexture));
        Material bottomMaterial = new Material(Identifier.fromNamespaceAndPath("minecraft", "block/" + bottomTexture));
        Material topMaterial = new Material(Identifier.fromNamespaceAndPath("minecraft", "block/" + topTexture));

        TextureMapping textures = new TextureMapping().put(TextureSlot.SIDE, sideMaterial).put(TextureSlot.BOTTOM, bottomMaterial).put(TextureSlot.TOP, topMaterial);

        Identifier slabModel = template.create(
                ModelLocationUtils.getModelLocation(vertSlab),
                textures,
                blockModels.modelOutput
        );

        Identifier fullModel = ModelLocationUtils.getModelLocation(fullBlock);

        blockModels.blockStateOutput.accept(
                MultiPartGenerator.multiPart(vertSlab)
                        .with(new ConditionBuilder().term(VerticalSlabBlock.DOUBLE, true), BlockModelGenerators.plainVariant(fullModel))
                        .with(new ConditionBuilder().term(VerticalSlabBlock.DOUBLE, false).term(VerticalSlabBlock.FACING, Direction.NORTH), BlockModelGenerators.plainVariant(slabModel))
                        .with(new ConditionBuilder().term(VerticalSlabBlock.DOUBLE, false).term(VerticalSlabBlock.FACING, Direction.EAST), BlockModelGenerators.plainVariant(slabModel).with(BlockModelGenerators.Y_ROT_90))
                        .with(new ConditionBuilder().term(VerticalSlabBlock.DOUBLE, false).term(VerticalSlabBlock.FACING, Direction.SOUTH), BlockModelGenerators.plainVariant(slabModel).with(BlockModelGenerators.Y_ROT_180))
                        .with(new ConditionBuilder().term(VerticalSlabBlock.DOUBLE, false).term(VerticalSlabBlock.FACING, Direction.WEST), BlockModelGenerators.plainVariant(slabModel).with(BlockModelGenerators.Y_ROT_270))
        );

        blockModels.registerSimpleItemModel(vertSlab, slabModel);
    }

    // ========================================================================
    // Dyed Brick Family
    // ========================================================================

    private void registerDyedBrickFamily(BlockModelGenerators blockModels, ItemModelGenerators itemModels, DyedBrickType type) {
        Block brick   = ModBlocks.DYED_BRICKS.get(type).get();
        Block slab    = ModBlocks.DYED_BRICK_SLABS.get(type).get();
        Block stairs  = ModBlocks.DYED_BRICK_STAIRS.get(type).get();
        Block wall    = ModBlocks.DYED_BRICK_WALLS.get(type).get();
        Block vSlab   = ModBlocks.DYED_BRICK_VERTICAL_SLABS.get(type).get();

        Identifier brickModel     = modLoc("block/template_dyed_brick");
        Identifier slabBottom     = modLoc("block/template_dyed_brick_slab");
        Identifier slabTop        = modLoc("block/template_dyed_brick_slab_top");
        Identifier stairsModel    = modLoc("block/template_dyed_brick_stairs");
        Identifier stairsInner    = modLoc("block/template_dyed_brick_stairs_inner");
        Identifier stairsOuter    = modLoc("block/template_dyed_brick_stairs_outer");
        Identifier wallPost       = modLoc("block/template_dyed_brick_wall_post");
        Identifier wallSide       = modLoc("block/template_dyed_brick_wall_side");
        Identifier wallSideTall   = modLoc("block/template_dyed_brick_wall_side_tall");
        Identifier wallInventory  = modLoc("block/template_dyed_brick_wall_inventory");
        Identifier vSlabModel     = modLoc("block/template_dyed_brick_vertical_slab");

        simpleBlock(blockModels, brick, brickModel);
        slabBlock(blockModels, slab, slabBottom, slabTop, brickModel);
        stairsBlock(blockModels, stairs, stairsModel, stairsInner, stairsOuter);
        wallBlock(blockModels, wall, wallPost, wallSide, wallSideTall, wallInventory);
        verticalSlabBlock(blockModels, vSlab, vSlabModel, brickModel);

        applyDyedItemTint(itemModels, type, brick.asItem(), brickModel);
        applyDyedItemTint(itemModels, type, slab.asItem(), slabBottom);
        applyDyedItemTint(itemModels, type, stairs.asItem(), stairsModel);
        applyDyedItemTint(itemModels, type, wall.asItem(), wallInventory);
        applyDyedItemTint(itemModels, type, vSlab.asItem(), vSlabModel);
    }

    private void applyDyedItemTint(ItemModelGenerators itemModels, DyedBrickType type, Item item, Identifier model) {
        itemModels.itemModelOutput.accept(
                item,
                ItemModelUtils.tintedModel(model, new ItemTintSource[]{
                        new Constant(type.getBrickColor().getTextureDiffuseColor()),
                        new Constant(type.getMortarColor().getTextureDiffuseColor())
                })
        );
    }

    // ========================================================================
    // Blockstate Helper Methods
    // ========================================================================

    private void simpleBlock(BlockModelGenerators blockModels, Block block, Identifier model) {
        blockModels.blockStateOutput.accept(
                MultiVariantGenerator.dispatch(block, BlockModelGenerators.plainVariant(model))
        );
    }

    private void slabBlock(BlockModelGenerators blockModels, Block slab, Identifier bottom, Identifier top, Identifier doubleSlab) {
        PropertyDispatch.C1<MultiVariant, SlabType> dispatch = PropertyDispatch.initial(SlabBlock.TYPE)
                .select(SlabType.BOTTOM, BlockModelGenerators.plainVariant(bottom))
                .select(SlabType.TOP, BlockModelGenerators.plainVariant(top))
                .select(SlabType.DOUBLE, BlockModelGenerators.plainVariant(doubleSlab));

        blockModels.blockStateOutput.accept(MultiVariantGenerator.dispatch(slab).with(dispatch));
    }

    private void stairsBlock(BlockModelGenerators blockModels, Block stairs, Identifier straight, Identifier inner, Identifier outer) {
        PropertyDispatch.C3<MultiVariant, Direction, Half, StairsShape> dispatch = PropertyDispatch
                .initial(StairBlock.FACING, StairBlock.HALF, StairBlock.SHAPE);

        // BOTTOM half
        dispatch.select(Direction.EAST,  Half.BOTTOM, StairsShape.STRAIGHT,     BlockModelGenerators.plainVariant(straight));
        dispatch.select(Direction.WEST,  Half.BOTTOM, StairsShape.STRAIGHT,     BlockModelGenerators.plainVariant(straight).with(BlockModelGenerators.Y_ROT_180));
        dispatch.select(Direction.SOUTH, Half.BOTTOM, StairsShape.STRAIGHT,     BlockModelGenerators.plainVariant(straight).with(BlockModelGenerators.Y_ROT_90));
        dispatch.select(Direction.NORTH, Half.BOTTOM, StairsShape.STRAIGHT,     BlockModelGenerators.plainVariant(straight).with(BlockModelGenerators.Y_ROT_270));
        dispatch.select(Direction.EAST,  Half.BOTTOM, StairsShape.OUTER_RIGHT,  BlockModelGenerators.plainVariant(outer));
        dispatch.select(Direction.WEST,  Half.BOTTOM, StairsShape.OUTER_RIGHT,  BlockModelGenerators.plainVariant(outer).with(BlockModelGenerators.Y_ROT_180));
        dispatch.select(Direction.SOUTH, Half.BOTTOM, StairsShape.OUTER_RIGHT,  BlockModelGenerators.plainVariant(outer).with(BlockModelGenerators.Y_ROT_90));
        dispatch.select(Direction.NORTH, Half.BOTTOM, StairsShape.OUTER_RIGHT,  BlockModelGenerators.plainVariant(outer).with(BlockModelGenerators.Y_ROT_270));
        dispatch.select(Direction.EAST,  Half.BOTTOM, StairsShape.OUTER_LEFT,   BlockModelGenerators.plainVariant(outer).with(BlockModelGenerators.Y_ROT_270));
        dispatch.select(Direction.WEST,  Half.BOTTOM, StairsShape.OUTER_LEFT,   BlockModelGenerators.plainVariant(outer).with(BlockModelGenerators.Y_ROT_90));
        dispatch.select(Direction.SOUTH, Half.BOTTOM, StairsShape.OUTER_LEFT,   BlockModelGenerators.plainVariant(outer).with(BlockModelGenerators.Y_ROT_180));
        dispatch.select(Direction.NORTH, Half.BOTTOM, StairsShape.OUTER_LEFT,   BlockModelGenerators.plainVariant(outer));
        dispatch.select(Direction.EAST,  Half.BOTTOM, StairsShape.INNER_RIGHT,  BlockModelGenerators.plainVariant(inner));
        dispatch.select(Direction.WEST,  Half.BOTTOM, StairsShape.INNER_RIGHT,  BlockModelGenerators.plainVariant(inner).with(BlockModelGenerators.Y_ROT_180));
        dispatch.select(Direction.SOUTH, Half.BOTTOM, StairsShape.INNER_RIGHT,  BlockModelGenerators.plainVariant(inner).with(BlockModelGenerators.Y_ROT_90));
        dispatch.select(Direction.NORTH, Half.BOTTOM, StairsShape.INNER_RIGHT,  BlockModelGenerators.plainVariant(inner).with(BlockModelGenerators.Y_ROT_270));
        dispatch.select(Direction.EAST,  Half.BOTTOM, StairsShape.INNER_LEFT,   BlockModelGenerators.plainVariant(inner).with(BlockModelGenerators.Y_ROT_270));
        dispatch.select(Direction.WEST,  Half.BOTTOM, StairsShape.INNER_LEFT,   BlockModelGenerators.plainVariant(inner).with(BlockModelGenerators.Y_ROT_90));
        dispatch.select(Direction.SOUTH, Half.BOTTOM, StairsShape.INNER_LEFT,   BlockModelGenerators.plainVariant(inner).with(BlockModelGenerators.Y_ROT_180));
        dispatch.select(Direction.NORTH, Half.BOTTOM, StairsShape.INNER_LEFT,   BlockModelGenerators.plainVariant(inner));

        // TOP half
        dispatch.select(Direction.EAST,  Half.TOP, StairsShape.STRAIGHT,     BlockModelGenerators.plainVariant(straight).with(BlockModelGenerators.X_ROT_180).with(BlockModelGenerators.Y_ROT_90));
        dispatch.select(Direction.WEST,  Half.TOP, StairsShape.STRAIGHT,     BlockModelGenerators.plainVariant(straight).with(BlockModelGenerators.X_ROT_180).with(BlockModelGenerators.Y_ROT_270));
        dispatch.select(Direction.SOUTH, Half.TOP, StairsShape.STRAIGHT,     BlockModelGenerators.plainVariant(straight).with(BlockModelGenerators.X_ROT_180).with(BlockModelGenerators.Y_ROT_180));
        dispatch.select(Direction.NORTH, Half.TOP, StairsShape.STRAIGHT,     BlockModelGenerators.plainVariant(straight).with(BlockModelGenerators.X_ROT_180));
        dispatch.select(Direction.EAST,  Half.TOP, StairsShape.OUTER_RIGHT,  BlockModelGenerators.plainVariant(outer).with(BlockModelGenerators.X_ROT_180).with(BlockModelGenerators.Y_ROT_90));
        dispatch.select(Direction.WEST,  Half.TOP, StairsShape.OUTER_RIGHT,  BlockModelGenerators.plainVariant(outer).with(BlockModelGenerators.X_ROT_180).with(BlockModelGenerators.Y_ROT_270));
        dispatch.select(Direction.SOUTH, Half.TOP, StairsShape.OUTER_RIGHT,  BlockModelGenerators.plainVariant(outer).with(BlockModelGenerators.X_ROT_180).with(BlockModelGenerators.Y_ROT_180));
        dispatch.select(Direction.NORTH, Half.TOP, StairsShape.OUTER_RIGHT,  BlockModelGenerators.plainVariant(outer).with(BlockModelGenerators.X_ROT_180));
        dispatch.select(Direction.EAST,  Half.TOP, StairsShape.OUTER_LEFT,   BlockModelGenerators.plainVariant(outer).with(BlockModelGenerators.X_ROT_180));
        dispatch.select(Direction.WEST,  Half.TOP, StairsShape.OUTER_LEFT,   BlockModelGenerators.plainVariant(outer).with(BlockModelGenerators.X_ROT_180).with(BlockModelGenerators.Y_ROT_180));
        dispatch.select(Direction.SOUTH, Half.TOP, StairsShape.OUTER_LEFT,   BlockModelGenerators.plainVariant(outer).with(BlockModelGenerators.X_ROT_180).with(BlockModelGenerators.Y_ROT_90));
        dispatch.select(Direction.NORTH, Half.TOP, StairsShape.OUTER_LEFT,   BlockModelGenerators.plainVariant(outer).with(BlockModelGenerators.X_ROT_180).with(BlockModelGenerators.Y_ROT_270));
        dispatch.select(Direction.EAST,  Half.TOP, StairsShape.INNER_RIGHT,  BlockModelGenerators.plainVariant(inner).with(BlockModelGenerators.X_ROT_180).with(BlockModelGenerators.Y_ROT_90));
        dispatch.select(Direction.WEST,  Half.TOP, StairsShape.INNER_RIGHT,  BlockModelGenerators.plainVariant(inner).with(BlockModelGenerators.X_ROT_180).with(BlockModelGenerators.Y_ROT_270));
        dispatch.select(Direction.SOUTH, Half.TOP, StairsShape.INNER_RIGHT,  BlockModelGenerators.plainVariant(inner).with(BlockModelGenerators.X_ROT_180).with(BlockModelGenerators.Y_ROT_180));
        dispatch.select(Direction.NORTH, Half.TOP, StairsShape.INNER_RIGHT,  BlockModelGenerators.plainVariant(inner).with(BlockModelGenerators.X_ROT_180));
        dispatch.select(Direction.EAST,  Half.TOP, StairsShape.INNER_LEFT,   BlockModelGenerators.plainVariant(inner).with(BlockModelGenerators.X_ROT_180));
        dispatch.select(Direction.WEST,  Half.TOP, StairsShape.INNER_LEFT,   BlockModelGenerators.plainVariant(inner).with(BlockModelGenerators.X_ROT_180).with(BlockModelGenerators.Y_ROT_180));
        dispatch.select(Direction.SOUTH, Half.TOP, StairsShape.INNER_LEFT,   BlockModelGenerators.plainVariant(inner).with(BlockModelGenerators.X_ROT_180).with(BlockModelGenerators.Y_ROT_90));
        dispatch.select(Direction.NORTH, Half.TOP, StairsShape.INNER_LEFT,   BlockModelGenerators.plainVariant(inner).with(BlockModelGenerators.X_ROT_180).with(BlockModelGenerators.Y_ROT_270));

        blockModels.blockStateOutput.accept(MultiVariantGenerator.dispatch(stairs).with(dispatch));
    }

    private void wallBlock(BlockModelGenerators blockModels, Block wall,
                           Identifier post, Identifier side, Identifier sideTall, Identifier inventory) {
        blockModels.blockStateOutput.accept(
                MultiPartGenerator.multiPart(wall)
                        .with(new ConditionBuilder().term(WallBlock.UP, true), BlockModelGenerators.plainVariant(post))
                        .with(new ConditionBuilder().term(WallBlock.NORTH, WallSide.LOW), BlockModelGenerators.plainVariant(side).with(BlockModelGenerators.Y_ROT_270))
                        .with(new ConditionBuilder().term(WallBlock.NORTH, WallSide.TALL), BlockModelGenerators.plainVariant(sideTall).with(BlockModelGenerators.Y_ROT_270))
                        .with(new ConditionBuilder().term(WallBlock.EAST, WallSide.LOW), BlockModelGenerators.plainVariant(side))
                        .with(new ConditionBuilder().term(WallBlock.EAST, WallSide.TALL), BlockModelGenerators.plainVariant(sideTall))
                        .with(new ConditionBuilder().term(WallBlock.SOUTH, WallSide.LOW), BlockModelGenerators.plainVariant(side).with(BlockModelGenerators.Y_ROT_90))
                        .with(new ConditionBuilder().term(WallBlock.SOUTH, WallSide.TALL), BlockModelGenerators.plainVariant(sideTall).with(BlockModelGenerators.Y_ROT_90))
                        .with(new ConditionBuilder().term(WallBlock.WEST, WallSide.LOW), BlockModelGenerators.plainVariant(side).with(BlockModelGenerators.Y_ROT_180))
                        .with(new ConditionBuilder().term(WallBlock.WEST, WallSide.TALL), BlockModelGenerators.plainVariant(sideTall).with(BlockModelGenerators.Y_ROT_180))
        );
    }

    private void horizontalFacingBlock(BlockModelGenerators blockModels, Block block, Identifier model) {
        PropertyDispatch.C1<MultiVariant, Direction> dispatch =
                PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING)
                        .select(Direction.NORTH, BlockModelGenerators.plainVariant(model))
                        .select(Direction.EAST,  BlockModelGenerators.plainVariant(model).with(BlockModelGenerators.Y_ROT_90))
                        .select(Direction.SOUTH, BlockModelGenerators.plainVariant(model).with(BlockModelGenerators.Y_ROT_180))
                        .select(Direction.WEST,  BlockModelGenerators.plainVariant(model).with(BlockModelGenerators.Y_ROT_270));

        blockModels.blockStateOutput.accept(MultiVariantGenerator.dispatch(block).with(dispatch));
        blockModels.registerSimpleItemModel(block, model);
    }

    private void verticalSlabBlock(BlockModelGenerators blockModels, Block vSlab,
                                   Identifier slabModel, Identifier doubleModel) {
        blockModels.blockStateOutput.accept(
                MultiPartGenerator.multiPart(vSlab)
                        .with(new ConditionBuilder().term(VerticalSlabBlock.DOUBLE, true), BlockModelGenerators.plainVariant(doubleModel))
                        .with(new ConditionBuilder().term(VerticalSlabBlock.DOUBLE, false).term(VerticalSlabBlock.FACING, Direction.NORTH), BlockModelGenerators.plainVariant(slabModel))
                        .with(new ConditionBuilder().term(VerticalSlabBlock.DOUBLE, false).term(VerticalSlabBlock.FACING, Direction.EAST), BlockModelGenerators.plainVariant(slabModel).with(BlockModelGenerators.Y_ROT_90))
                        .with(new ConditionBuilder().term(VerticalSlabBlock.DOUBLE, false).term(VerticalSlabBlock.FACING, Direction.SOUTH), BlockModelGenerators.plainVariant(slabModel).with(BlockModelGenerators.Y_ROT_180))
                        .with(new ConditionBuilder().term(VerticalSlabBlock.DOUBLE, false).term(VerticalSlabBlock.FACING, Direction.WEST), BlockModelGenerators.plainVariant(slabModel).with(BlockModelGenerators.Y_ROT_270))
        );
    }

    // ========================================================================
    // Helpers
    // ========================================================================

    private Identifier mcLoc(String path) {
        return Identifier.fromNamespaceAndPath("minecraft", path);
    }

    private Identifier modLoc(String path) {
        return Identifier.fromNamespaceAndPath(BuildersZenith.MOD_ID, path);
    }
}