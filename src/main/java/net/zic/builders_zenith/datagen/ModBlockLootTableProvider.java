package net.zic.builders_zenith.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.zic.builders_zenith.blocks.ModBlocks;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {

    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.CARPENTER.get());
        dropSelf(ModBlocks.COLOR_MIXER.get());



        // Wood vertical slabs - Axe mineable
        dropSelf(ModBlocks.OAK_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.SPRUCE_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.BIRCH_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.JUNGLE_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.ACACIA_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.DARK_OAK_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.MANGROVE_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.CHERRY_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.BAMBOO_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.CRIMSON_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.WARPED_VERTICAL_SLAB.get());

        // Stone vertical slabs - Pickaxe mineable
        dropSelf(ModBlocks.STONE_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.COBBLESTONE_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.MOSSY_COBBLESTONE_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.SMOOTH_STONE_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.STONE_BRICK_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.MOSSY_STONE_BRICK_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.GRANITE_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.POLISHED_GRANITE_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.DIORITE_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.POLISHED_DIORITE_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.ANDESITE_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.POLISHED_ANDESITE_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.COBBLED_DEEPSLATE_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.POLISHED_DEEPSLATE_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.DEEPSLATE_BRICK_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.DEEPSLATE_TILE_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.TUFF_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.POLISHED_TUFF_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.TUFF_BRICK_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.BRICK_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.MUD_BRICK_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.SANDSTONE_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.SMOOTH_SANDSTONE_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.CUT_SANDSTONE_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.RED_SANDSTONE_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.SMOOTH_RED_SANDSTONE_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.CUT_RED_SANDSTONE_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.PRISMARINE_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.PRISMARINE_BRICK_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.DARK_PRISMARINE_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.NETHER_BRICK_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.RED_NETHER_BRICK_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.BLACKSTONE_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.POLISHED_BLACKSTONE_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.POLISHED_BLACKSTONE_BRICK_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.END_STONE_BRICK_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.PURPUR_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.QUARTZ_VERTICAL_SLAB.get());
        dropSelf(ModBlocks.SMOOTH_QUARTZ_VERTICAL_SLAB.get());

        // ── Marble ────────────────────────────────────────────────────────────────

        // White
        dropSelf(ModBlocks.MARBLE.get());
        dropSelf(ModBlocks.MARBLE_BRICKS.get());
        dropSelf(ModBlocks.MARBLE_CHISELED.get());
        dropSelf(ModBlocks.MARBLE_TILES.get());
        dropSelf(ModBlocks.POLISHED_MARBLE.get());
        dropSelf(ModBlocks.MARBLE_BRICK_STAIRS.get());
        dropSelf(ModBlocks.MARBLE_TILE_STAIRS.get());
        dropSelf(ModBlocks.MARBLE_BRICK_SLABS.get());
        dropSelf(ModBlocks.MARBLE_TILE_SLABS.get());
        dropSelf(ModBlocks.MARBLE_BRICK_WALLS.get());
        dropSelf(ModBlocks.MARBLE_TILE_WALLS.get());

        // Light Gray
        dropSelf(ModBlocks.LIGHT_GRAY_MARBLE.get());
        dropSelf(ModBlocks.LIGHT_GRAY_MARBLE_BRICKS.get());
        dropSelf(ModBlocks.LIGHT_GRAY_MARBLE_CHISELED.get());
        dropSelf(ModBlocks.LIGHT_GRAY_MARBLE_TILES.get());
        dropSelf(ModBlocks.POLISHED_LIGHT_GRAY_MARBLE.get());
        dropSelf(ModBlocks.LIGHT_GRAY_MARBLE_BRICK_STAIRS.get());
        dropSelf(ModBlocks.LIGHT_GRAY_MARBLE_TILE_STAIRS.get());
        dropSelf(ModBlocks.LIGHT_GRAY_MARBLE_BRICK_SLABS.get());
        dropSelf(ModBlocks.LIGHT_GRAY_MARBLE_TILE_SLABS.get());
        dropSelf(ModBlocks.LIGHT_GRAY_MARBLE_BRICK_WALLS.get());
        dropSelf(ModBlocks.LIGHT_GRAY_MARBLE_TILE_WALLS.get());

        // Gray
        dropSelf(ModBlocks.GRAY_MARBLE.get());
        dropSelf(ModBlocks.GRAY_MARBLE_BRICKS.get());
        dropSelf(ModBlocks.GRAY_MARBLE_CHISELED.get());
        dropSelf(ModBlocks.GRAY_MARBLE_TILES.get());
        dropSelf(ModBlocks.GRAY_POLISHED_MARBLE.get());
        dropSelf(ModBlocks.GRAY_MARBLE_BRICK_STAIRS.get());
        dropSelf(ModBlocks.GRAY_MARBLE_TILE_STAIRS.get());
        dropSelf(ModBlocks.GRAY_MARBLE_BRICK_SLABS.get());
        dropSelf(ModBlocks.GRAY_MARBLE_TILE_SLABS.get());
        dropSelf(ModBlocks.GRAY_MARBLE_BRICK_WALLS.get());
        dropSelf(ModBlocks.GRAY_MARBLE_TILE_WALLS.get());

        // Black
        dropSelf(ModBlocks.BLACK_MARBLE.get());
        dropSelf(ModBlocks.BLACK_MARBLE_BRICKS.get());
        dropSelf(ModBlocks.BLACK_MARBLE_CHISELED.get());
        dropSelf(ModBlocks.BLACK_MARBLE_TILES.get());
        dropSelf(ModBlocks.BLACK_POLISHED_MARBLE.get());
        dropSelf(ModBlocks.BLACK_MARBLE_BRICK_STAIRS.get());
        dropSelf(ModBlocks.BLACK_MARBLE_TILE_STAIRS.get());
        dropSelf(ModBlocks.BLACK_MARBLE_BRICK_SLABS.get());
        dropSelf(ModBlocks.BLACK_MARBLE_TILE_SLABS.get());
        dropSelf(ModBlocks.BLACK_MARBLE_BRICK_WALLS.get());
        dropSelf(ModBlocks.BLACK_MARBLE_TILE_WALLS.get());

        // Brown
        dropSelf(ModBlocks.BROWN_MARBLE.get());
        dropSelf(ModBlocks.BROWN_MARBLE_BRICKS.get());
        dropSelf(ModBlocks.BROWN_MARBLE_CHISELED.get());
        dropSelf(ModBlocks.BROWN_MARBLE_TILES.get());
        dropSelf(ModBlocks.BROWN_POLISHED_MARBLE.get());
        dropSelf(ModBlocks.BROWN_MARBLE_BRICK_STAIRS.get());
        dropSelf(ModBlocks.BROWN_MARBLE_TILE_STAIRS.get());
        dropSelf(ModBlocks.BROWN_MARBLE_BRICK_SLABS.get());
        dropSelf(ModBlocks.BROWN_MARBLE_TILE_SLABS.get());
        dropSelf(ModBlocks.BROWN_MARBLE_BRICK_WALLS.get());
        dropSelf(ModBlocks.BROWN_MARBLE_TILE_WALLS.get());

        // Red
        dropSelf(ModBlocks.RED_MARBLE.get());
        dropSelf(ModBlocks.RED_MARBLE_BRICKS.get());
        dropSelf(ModBlocks.RED_MARBLE_CHISELED.get());
        dropSelf(ModBlocks.RED_MARBLE_TILES.get());
        dropSelf(ModBlocks.RED_POLISHED_MARBLE.get());
        dropSelf(ModBlocks.RED_MARBLE_BRICK_STAIRS.get());
        dropSelf(ModBlocks.RED_MARBLE_TILE_STAIRS.get());
        dropSelf(ModBlocks.RED_MARBLE_BRICK_SLABS.get());
        dropSelf(ModBlocks.RED_MARBLE_TILE_SLABS.get());
        dropSelf(ModBlocks.RED_MARBLE_BRICK_WALLS.get());
        dropSelf(ModBlocks.RED_MARBLE_TILE_WALLS.get());

        // Orange
        dropSelf(ModBlocks.ORANGE_MARBLE.get());
        dropSelf(ModBlocks.ORANGE_MARBLE_BRICKS.get());
        dropSelf(ModBlocks.ORANGE_MARBLE_CHISELED.get());
        dropSelf(ModBlocks.ORANGE_MARBLE_TILES.get());
        dropSelf(ModBlocks.ORANGE_POLISHED_MARBLE.get());
        dropSelf(ModBlocks.ORANGE_MARBLE_BRICK_STAIRS.get());
        dropSelf(ModBlocks.ORANGE_MARBLE_TILE_STAIRS.get());
        dropSelf(ModBlocks.ORANGE_MARBLE_BRICK_SLABS.get());
        dropSelf(ModBlocks.ORANGE_MARBLE_TILE_SLABS.get());
        dropSelf(ModBlocks.ORANGE_MARBLE_BRICK_WALLS.get());
        dropSelf(ModBlocks.ORANGE_MARBLE_TILE_WALLS.get());

        // Yellow
        dropSelf(ModBlocks.YELLOW_MARBLE.get());
        dropSelf(ModBlocks.YELLOW_MARBLE_BRICKS.get());
        dropSelf(ModBlocks.YELLOW_MARBLE_CHISELED.get());
        dropSelf(ModBlocks.YELLOW_MARBLE_TILES.get());
        dropSelf(ModBlocks.YELLOW_POLISHED_MARBLE.get());
        dropSelf(ModBlocks.YELLOW_MARBLE_BRICK_STAIRS.get());
        dropSelf(ModBlocks.YELLOW_MARBLE_TILE_STAIRS.get());
        dropSelf(ModBlocks.YELLOW_MARBLE_BRICK_SLABS.get());
        dropSelf(ModBlocks.YELLOW_MARBLE_TILE_SLABS.get());
        dropSelf(ModBlocks.YELLOW_MARBLE_BRICK_WALLS.get());
        dropSelf(ModBlocks.YELLOW_MARBLE_TILE_WALLS.get());

        // Lime
        dropSelf(ModBlocks.LIME_MARBLE.get());
        dropSelf(ModBlocks.LIME_MARBLE_BRICKS.get());
        dropSelf(ModBlocks.LIME_MARBLE_CHISELED.get());
        dropSelf(ModBlocks.LIME_MARBLE_TILES.get());
        dropSelf(ModBlocks.LIME_POLISHED_MARBLE.get());
        dropSelf(ModBlocks.LIME_MARBLE_BRICK_STAIRS.get());
        dropSelf(ModBlocks.LIME_MARBLE_TILE_STAIRS.get());
        dropSelf(ModBlocks.LIME_MARBLE_BRICK_SLABS.get());
        dropSelf(ModBlocks.LIME_MARBLE_TILE_SLABS.get());
        dropSelf(ModBlocks.LIME_MARBLE_BRICK_WALLS.get());
        dropSelf(ModBlocks.LIME_MARBLE_TILE_WALLS.get());

        // Green
        dropSelf(ModBlocks.GREEN_MARBLE.get());
        dropSelf(ModBlocks.GREEN_MARBLE_BRICKS.get());
        dropSelf(ModBlocks.GREEN_MARBLE_CHISELED.get());
        dropSelf(ModBlocks.GREEN_MARBLE_TILES.get());
        dropSelf(ModBlocks.GREEN_POLISHED_MARBLE.get());
        dropSelf(ModBlocks.GREEN_MARBLE_BRICK_STAIRS.get());
        dropSelf(ModBlocks.GREEN_MARBLE_TILE_STAIRS.get());
        dropSelf(ModBlocks.GREEN_MARBLE_BRICK_SLABS.get());
        dropSelf(ModBlocks.GREEN_MARBLE_TILE_SLABS.get());
        dropSelf(ModBlocks.GREEN_MARBLE_BRICK_WALLS.get());
        dropSelf(ModBlocks.GREEN_MARBLE_TILE_WALLS.get());

        // Cyan
        dropSelf(ModBlocks.CYAN_MARBLE.get());
        dropSelf(ModBlocks.CYAN_MARBLE_BRICKS.get());
        dropSelf(ModBlocks.CYAN_MARBLE_CHISELED.get());
        dropSelf(ModBlocks.CYAN_MARBLE_TILES.get());
        dropSelf(ModBlocks.CYAN_POLISHED_MARBLE.get());
        dropSelf(ModBlocks.CYAN_MARBLE_BRICK_STAIRS.get());
        dropSelf(ModBlocks.CYAN_MARBLE_TILE_STAIRS.get());
        dropSelf(ModBlocks.CYAN_MARBLE_BRICK_SLABS.get());
        dropSelf(ModBlocks.CYAN_MARBLE_TILE_SLABS.get());
        dropSelf(ModBlocks.CYAN_MARBLE_BRICK_WALLS.get());
        dropSelf(ModBlocks.CYAN_MARBLE_TILE_WALLS.get());

        // Light Blue
        dropSelf(ModBlocks.LIGHT_BLUE_MARBLE.get());
        dropSelf(ModBlocks.LIGHT_BLUE_MARBLE_BRICKS.get());
        dropSelf(ModBlocks.LIGHT_BLUE_MARBLE_CHISELED.get());
        dropSelf(ModBlocks.LIGHT_BLUE_MARBLE_TILES.get());
        dropSelf(ModBlocks.LIGHT_BLUE_POLISHED_MARBLE.get());
        dropSelf(ModBlocks.LIGHT_BLUE_MARBLE_BRICK_STAIRS.get());
        dropSelf(ModBlocks.LIGHT_BLUE_MARBLE_TILE_STAIRS.get());
        dropSelf(ModBlocks.LIGHT_BLUE_MARBLE_BRICK_SLABS.get());
        dropSelf(ModBlocks.LIGHT_BLUE_MARBLE_TILE_SLABS.get());
        dropSelf(ModBlocks.LIGHT_BLUE_MARBLE_BRICK_WALLS.get());
        dropSelf(ModBlocks.LIGHT_BLUE_MARBLE_TILE_WALLS.get());

        // Blue
        dropSelf(ModBlocks.BLUE_MARBLE.get());
        dropSelf(ModBlocks.BLUE_MARBLE_BRICKS.get());
        dropSelf(ModBlocks.BLUE_MARBLE_CHISELED.get());
        dropSelf(ModBlocks.BLUE_MARBLE_TILES.get());
        dropSelf(ModBlocks.BLUE_POLISHED_MARBLE.get());
        dropSelf(ModBlocks.BLUE_MARBLE_BRICK_STAIRS.get());
        dropSelf(ModBlocks.BLUE_MARBLE_TILE_STAIRS.get());
        dropSelf(ModBlocks.BLUE_MARBLE_BRICK_SLABS.get());
        dropSelf(ModBlocks.BLUE_MARBLE_TILE_SLABS.get());
        dropSelf(ModBlocks.BLUE_MARBLE_BRICK_WALLS.get());
        dropSelf(ModBlocks.BLUE_MARBLE_TILE_WALLS.get());

        // Purple
        dropSelf(ModBlocks.PURPLE_MARBLE.get());
        dropSelf(ModBlocks.PURPLE_MARBLE_BRICKS.get());
        dropSelf(ModBlocks.PURPLE_MARBLE_CHISELED.get());
        dropSelf(ModBlocks.PURPLE_MARBLE_TILES.get());
        dropSelf(ModBlocks.PURPLE_POLISHED_MARBLE.get());
        dropSelf(ModBlocks.PURPLE_MARBLE_BRICK_STAIRS.get());
        dropSelf(ModBlocks.PURPLE_MARBLE_TILE_STAIRS.get());
        dropSelf(ModBlocks.PURPLE_MARBLE_BRICK_SLABS.get());
        dropSelf(ModBlocks.PURPLE_MARBLE_TILE_SLABS.get());
        dropSelf(ModBlocks.PURPLE_MARBLE_BRICK_WALLS.get());
        dropSelf(ModBlocks.PURPLE_MARBLE_TILE_WALLS.get());

        // Magenta
        dropSelf(ModBlocks.MAGENTA_MARBLE.get());
        dropSelf(ModBlocks.MAGENTA_MARBLE_BRICKS.get());
        dropSelf(ModBlocks.MAGENTA_MARBLE_CHISELED.get());
        dropSelf(ModBlocks.MAGENTA_MARBLE_TILES.get());
        dropSelf(ModBlocks.MAGENTA_POLISHED_MARBLE.get());
        dropSelf(ModBlocks.MAGENTA_MARBLE_BRICK_STAIRS.get());
        dropSelf(ModBlocks.MAGENTA_MARBLE_TILE_STAIRS.get());
        dropSelf(ModBlocks.MAGENTA_MARBLE_BRICK_SLABS.get());
        dropSelf(ModBlocks.MAGENTA_MARBLE_TILE_SLABS.get());
        dropSelf(ModBlocks.MAGENTA_MARBLE_BRICK_WALLS.get());
        dropSelf(ModBlocks.MAGENTA_MARBLE_TILE_WALLS.get());

        // Pink
        dropSelf(ModBlocks.PINK_MARBLE.get());
        dropSelf(ModBlocks.PINK_MARBLE_BRICKS.get());
        dropSelf(ModBlocks.PINK_MARBLE_CHISELED.get());
        dropSelf(ModBlocks.PINK_MARBLE_TILES.get());
        dropSelf(ModBlocks.PINK_POLISHED_MARBLE.get());
        dropSelf(ModBlocks.PINK_MARBLE_BRICK_STAIRS.get());
        dropSelf(ModBlocks.PINK_MARBLE_TILE_STAIRS.get());
        dropSelf(ModBlocks.PINK_MARBLE_BRICK_SLABS.get());
        dropSelf(ModBlocks.PINK_MARBLE_TILE_SLABS.get());
        dropSelf(ModBlocks.PINK_MARBLE_BRICK_WALLS.get());
        dropSelf(ModBlocks.PINK_MARBLE_TILE_WALLS.get());



        ModBlocks.DYED_BRICKS.values().forEach(blockDeferred ->
                dropSelf(blockDeferred.get())
        );
        ModBlocks.DYED_BRICK_SLABS.values().forEach(blockDeferred ->
                dropSelf(blockDeferred.get())
        );
        ModBlocks.DYED_BRICK_STAIRS.values().forEach(blockDeferred ->
                dropSelf(blockDeferred.get())
        );
        ModBlocks.DYED_BRICK_WALLS.values().forEach(blockDeferred ->
                dropSelf(blockDeferred.get())
        );
        ModBlocks.DYED_BRICK_VERTICAL_SLABS.values().forEach(blockDeferred ->
                dropSelf(blockDeferred.get())
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCK.getEntries().stream().map(Holder::value)::iterator;
    }
}