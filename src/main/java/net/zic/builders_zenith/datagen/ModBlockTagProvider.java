package net.zic.builders_zenith.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.zic.builders_zenith.BuildersZenith;
import net.zic.builders_zenith.blocks.ModBlocks;
import net.zic.builders_zenith.blocks.custom.DyedBrickType;
import net.zic.builders_zenith.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, BuildersZenith.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.CARPENTER.get())
                .add(ModBlocks.OAK_VERTICAL_SLAB.get())
                .add(ModBlocks.SPRUCE_VERTICAL_SLAB.get())
                .add(ModBlocks.BIRCH_VERTICAL_SLAB.get())
                .add(ModBlocks.JUNGLE_VERTICAL_SLAB.get())
                .add(ModBlocks.ACACIA_VERTICAL_SLAB.get())
                .add(ModBlocks.DARK_OAK_VERTICAL_SLAB.get())
                .add(ModBlocks.MANGROVE_VERTICAL_SLAB.get())
                .add(ModBlocks.CHERRY_VERTICAL_SLAB.get())
                .add(ModBlocks.BAMBOO_VERTICAL_SLAB.get())
                .add(ModBlocks.CRIMSON_VERTICAL_SLAB.get())
                .add(ModBlocks.WARPED_VERTICAL_SLAB.get());

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.STONE_VERTICAL_SLAB.get())
                .add(ModBlocks.MUD_BRICK_VERTICAL_SLAB.get())
                .add(ModBlocks.COBBLESTONE_VERTICAL_SLAB.get())
                .add(ModBlocks.MOSSY_COBBLESTONE_VERTICAL_SLAB.get())
                .add(ModBlocks.SMOOTH_STONE_VERTICAL_SLAB.get())
                .add(ModBlocks.STONE_BRICK_VERTICAL_SLAB.get())
                .add(ModBlocks.MOSSY_STONE_BRICK_VERTICAL_SLAB.get())
                .add(ModBlocks.GRANITE_VERTICAL_SLAB.get())
                .add(ModBlocks.POLISHED_GRANITE_VERTICAL_SLAB.get())
                .add(ModBlocks.DIORITE_VERTICAL_SLAB.get())
                .add(ModBlocks.POLISHED_DIORITE_VERTICAL_SLAB.get())
                .add(ModBlocks.ANDESITE_VERTICAL_SLAB.get())
                .add(ModBlocks.POLISHED_ANDESITE_VERTICAL_SLAB.get())
                .add(ModBlocks.COBBLED_DEEPSLATE_VERTICAL_SLAB.get())
                .add(ModBlocks.POLISHED_DEEPSLATE_VERTICAL_SLAB.get())
                .add(ModBlocks.DEEPSLATE_BRICK_VERTICAL_SLAB.get())
                .add(ModBlocks.DEEPSLATE_TILE_VERTICAL_SLAB.get())
                .add(ModBlocks.TUFF_VERTICAL_SLAB.get())
                .add(ModBlocks.POLISHED_TUFF_VERTICAL_SLAB.get())
                .add(ModBlocks.TUFF_BRICK_VERTICAL_SLAB.get())
                .add(ModBlocks.BRICK_VERTICAL_SLAB.get())
                .add(ModBlocks.SANDSTONE_VERTICAL_SLAB.get())
                .add(ModBlocks.SMOOTH_SANDSTONE_VERTICAL_SLAB.get())
                .add(ModBlocks.CUT_SANDSTONE_VERTICAL_SLAB.get())
                .add(ModBlocks.RED_SANDSTONE_VERTICAL_SLAB.get())
                .add(ModBlocks.SMOOTH_RED_SANDSTONE_VERTICAL_SLAB.get())
                .add(ModBlocks.CUT_RED_SANDSTONE_VERTICAL_SLAB.get())
                .add(ModBlocks.PRISMARINE_VERTICAL_SLAB.get())
                .add(ModBlocks.PRISMARINE_BRICK_VERTICAL_SLAB.get())
                .add(ModBlocks.DARK_PRISMARINE_VERTICAL_SLAB.get())
                .add(ModBlocks.NETHER_BRICK_VERTICAL_SLAB.get())
                .add(ModBlocks.RED_NETHER_BRICK_VERTICAL_SLAB.get())
                .add(ModBlocks.BLACKSTONE_VERTICAL_SLAB.get())
                .add(ModBlocks.POLISHED_BLACKSTONE_VERTICAL_SLAB.get())
                .add(ModBlocks.POLISHED_BLACKSTONE_BRICK_VERTICAL_SLAB.get())
                .add(ModBlocks.END_STONE_BRICK_VERTICAL_SLAB.get())
                .add(ModBlocks.PURPUR_VERTICAL_SLAB.get())
                .add(ModBlocks.QUARTZ_VERTICAL_SLAB.get())
                .add(ModBlocks.SMOOTH_QUARTZ_VERTICAL_SLAB.get());

        var pickaxeBuilder = tag(BlockTags.MINEABLE_WITH_PICKAXE);
        ModBlocks.DYED_BRICKS.values().forEach(b -> pickaxeBuilder.add(b.get()));
        ModBlocks.DYED_BRICK_SLABS.values().forEach(b -> pickaxeBuilder.add(b.get()));
        ModBlocks.DYED_BRICK_STAIRS.values().forEach(b -> pickaxeBuilder.add(b.get()));
        ModBlocks.DYED_BRICK_WALLS.values().forEach(b -> pickaxeBuilder.add(b.get()));
        ModBlocks.DYED_BRICK_VERTICAL_SLABS.values().forEach(b -> pickaxeBuilder.add(b.get()));

        var dyedBrickBlocksBuilder = tag(ModTags.Blocks.DYED_BRICK_BLOCKS);
        for (DyedBrickType type : DyedBrickType.values()) {
            dyedBrickBlocksBuilder.add(ModBlocks.DYED_BRICKS.get(type).get());
        }

        var dyedBrickVerticalSlabsBuilder = tag(ModTags.Blocks.DYED_BRICK_VERTICAL_SLABS);
        for (DyedBrickType type : DyedBrickType.values()) {
            dyedBrickVerticalSlabsBuilder.add(ModBlocks.DYED_BRICK_VERTICAL_SLABS.get(type).get());
        }

        var dyedBrickSlabsBuilder = tag(ModTags.Blocks.DYED_BRICK_SLABS);
        for (DyedBrickType type : DyedBrickType.values()) {
            dyedBrickSlabsBuilder.add(ModBlocks.DYED_BRICK_SLABS.get(type).get());
        }

        var dyedBrickStairsBuilder = tag(ModTags.Blocks.DYED_BRICK_STAIRS);
        for (DyedBrickType type : DyedBrickType.values()) {
            dyedBrickStairsBuilder.add(ModBlocks.DYED_BRICK_STAIRS.get(type).get());
        }

        var dyedBrickWallsBuilder = tag(ModTags.Blocks.DYED_BRICK_WALLS);
        for (DyedBrickType type : DyedBrickType.values()) {
            dyedBrickWallsBuilder.add(ModBlocks.DYED_BRICK_WALLS.get(type).get());
        }

        var slabBuilder = tag(BlockTags.SLABS);
        for (DyedBrickType type : DyedBrickType.values()) {
            slabBuilder.add(ModBlocks.DYED_BRICK_SLABS.get(type).get());
        }

        var stairsBuilder = tag(BlockTags.STAIRS);
        for (DyedBrickType type : DyedBrickType.values()) {
            stairsBuilder.add(ModBlocks.DYED_BRICK_STAIRS.get(type).get());
        }

        var wallsBuilder = tag(BlockTags.WALLS);
        for (DyedBrickType type : DyedBrickType.values()) {
            wallsBuilder.add(ModBlocks.DYED_BRICK_WALLS.get(type).get());
        }

        var wallPostsBuilder = tag(BlockTags.WALL_POST_OVERRIDE);
        for (DyedBrickType type : DyedBrickType.values()) {
            wallPostsBuilder.add(ModBlocks.DYED_BRICK_WALLS.get(type).get());
        }



        var pickaxe = tag(BlockTags.MINEABLE_WITH_PICKAXE);

// every marble block
        pickaxe.add(ModBlocks.MARBLE.get(), ModBlocks.MARBLE_BRICKS.get(), ModBlocks.MARBLE_CHISELED.get(), ModBlocks.MARBLE_TILES.get(), ModBlocks.POLISHED_MARBLE.get());
        pickaxe.add(ModBlocks.LIGHT_GRAY_MARBLE.get(), ModBlocks.LIGHT_GRAY_MARBLE_BRICKS.get(), ModBlocks.LIGHT_GRAY_MARBLE_CHISELED.get(), ModBlocks.LIGHT_GRAY_MARBLE_TILES.get(), ModBlocks.POLISHED_LIGHT_GRAY_MARBLE.get());
        pickaxe.add(ModBlocks.GRAY_MARBLE.get(), ModBlocks.GRAY_MARBLE_BRICKS.get(), ModBlocks.GRAY_MARBLE_CHISELED.get(), ModBlocks.GRAY_MARBLE_TILES.get(), ModBlocks.GRAY_POLISHED_MARBLE.get());
        pickaxe.add(ModBlocks.BLACK_MARBLE.get(), ModBlocks.BLACK_MARBLE_BRICKS.get(), ModBlocks.BLACK_MARBLE_CHISELED.get(), ModBlocks.BLACK_MARBLE_TILES.get(), ModBlocks.BLACK_POLISHED_MARBLE.get());
        pickaxe.add(ModBlocks.BROWN_MARBLE.get(), ModBlocks.BROWN_MARBLE_BRICKS.get(), ModBlocks.BROWN_MARBLE_CHISELED.get(), ModBlocks.BROWN_MARBLE_TILES.get(), ModBlocks.BROWN_POLISHED_MARBLE.get());
        pickaxe.add(ModBlocks.RED_MARBLE.get(), ModBlocks.RED_MARBLE_BRICKS.get(), ModBlocks.RED_MARBLE_CHISELED.get(), ModBlocks.RED_MARBLE_TILES.get(), ModBlocks.RED_POLISHED_MARBLE.get());
        pickaxe.add(ModBlocks.ORANGE_MARBLE.get(), ModBlocks.ORANGE_MARBLE_BRICKS.get(), ModBlocks.ORANGE_MARBLE_CHISELED.get(), ModBlocks.ORANGE_MARBLE_TILES.get(), ModBlocks.ORANGE_POLISHED_MARBLE.get());
        pickaxe.add(ModBlocks.YELLOW_MARBLE.get(), ModBlocks.YELLOW_MARBLE_BRICKS.get(), ModBlocks.YELLOW_MARBLE_CHISELED.get(), ModBlocks.YELLOW_MARBLE_TILES.get(), ModBlocks.YELLOW_POLISHED_MARBLE.get());
        pickaxe.add(ModBlocks.LIME_MARBLE.get(), ModBlocks.LIME_MARBLE_BRICKS.get(), ModBlocks.LIME_MARBLE_CHISELED.get(), ModBlocks.LIME_MARBLE_TILES.get(), ModBlocks.LIME_POLISHED_MARBLE.get());
        pickaxe.add(ModBlocks.GREEN_MARBLE.get(), ModBlocks.GREEN_MARBLE_BRICKS.get(), ModBlocks.GREEN_MARBLE_CHISELED.get(), ModBlocks.GREEN_MARBLE_TILES.get(), ModBlocks.GREEN_POLISHED_MARBLE.get());
        pickaxe.add(ModBlocks.CYAN_MARBLE.get(), ModBlocks.CYAN_MARBLE_BRICKS.get(), ModBlocks.CYAN_MARBLE_CHISELED.get(), ModBlocks.CYAN_MARBLE_TILES.get(), ModBlocks.CYAN_POLISHED_MARBLE.get());
        pickaxe.add(ModBlocks.LIGHT_BLUE_MARBLE.get(), ModBlocks.LIGHT_BLUE_MARBLE_BRICKS.get(), ModBlocks.LIGHT_BLUE_MARBLE_CHISELED.get(), ModBlocks.LIGHT_BLUE_MARBLE_TILES.get(), ModBlocks.LIGHT_BLUE_POLISHED_MARBLE.get());
        pickaxe.add(ModBlocks.BLUE_MARBLE.get(), ModBlocks.BLUE_MARBLE_BRICKS.get(), ModBlocks.BLUE_MARBLE_CHISELED.get(), ModBlocks.BLUE_MARBLE_TILES.get(), ModBlocks.BLUE_POLISHED_MARBLE.get());
        pickaxe.add(ModBlocks.PURPLE_MARBLE.get(), ModBlocks.PURPLE_MARBLE_BRICKS.get(), ModBlocks.PURPLE_MARBLE_CHISELED.get(), ModBlocks.PURPLE_MARBLE_TILES.get(), ModBlocks.PURPLE_POLISHED_MARBLE.get());
        pickaxe.add(ModBlocks.MAGENTA_MARBLE.get(), ModBlocks.MAGENTA_MARBLE_BRICKS.get(), ModBlocks.MAGENTA_MARBLE_CHISELED.get(), ModBlocks.MAGENTA_MARBLE_TILES.get(), ModBlocks.MAGENTA_POLISHED_MARBLE.get());
        pickaxe.add(ModBlocks.PINK_MARBLE.get(), ModBlocks.PINK_MARBLE_BRICKS.get(), ModBlocks.PINK_MARBLE_CHISELED.get(), ModBlocks.PINK_MARBLE_TILES.get(), ModBlocks.PINK_POLISHED_MARBLE.get());

// Stairs / Slabs / Walls
        var slabTag = tag(BlockTags.SLABS);
        slabTag.add(ModBlocks.MARBLE_BRICK_SLABS.get(), ModBlocks.MARBLE_TILE_SLABS.get());
        slabTag.add(ModBlocks.LIGHT_GRAY_MARBLE_BRICK_SLABS.get(), ModBlocks.LIGHT_GRAY_MARBLE_TILE_SLABS.get());
        slabTag.add(ModBlocks.GRAY_MARBLE_BRICK_SLABS.get(), ModBlocks.GRAY_MARBLE_TILE_SLABS.get());
        slabTag.add(ModBlocks.BLACK_MARBLE_BRICK_SLABS.get(), ModBlocks.BLACK_MARBLE_TILE_SLABS.get());
        slabTag.add(ModBlocks.BROWN_MARBLE_BRICK_SLABS.get(), ModBlocks.BROWN_MARBLE_TILE_SLABS.get());
        slabTag.add(ModBlocks.RED_MARBLE_BRICK_SLABS.get(), ModBlocks.RED_MARBLE_TILE_SLABS.get());
        slabTag.add(ModBlocks.ORANGE_MARBLE_BRICK_SLABS.get(), ModBlocks.ORANGE_MARBLE_TILE_SLABS.get());
        slabTag.add(ModBlocks.YELLOW_MARBLE_BRICK_SLABS.get(), ModBlocks.YELLOW_MARBLE_TILE_SLABS.get());
        slabTag.add(ModBlocks.LIME_MARBLE_BRICK_SLABS.get(), ModBlocks.LIME_MARBLE_TILE_SLABS.get());
        slabTag.add(ModBlocks.GREEN_MARBLE_BRICK_SLABS.get(), ModBlocks.GREEN_MARBLE_TILE_SLABS.get());
        slabTag.add(ModBlocks.CYAN_MARBLE_BRICK_SLABS.get(), ModBlocks.CYAN_MARBLE_TILE_SLABS.get());
        slabTag.add(ModBlocks.LIGHT_BLUE_MARBLE_BRICK_SLABS.get(), ModBlocks.LIGHT_BLUE_MARBLE_TILE_SLABS.get());
        slabTag.add(ModBlocks.BLUE_MARBLE_BRICK_SLABS.get(), ModBlocks.BLUE_MARBLE_TILE_SLABS.get());
        slabTag.add(ModBlocks.PURPLE_MARBLE_BRICK_SLABS.get(), ModBlocks.PURPLE_MARBLE_TILE_SLABS.get());
        slabTag.add(ModBlocks.MAGENTA_MARBLE_BRICK_SLABS.get(), ModBlocks.MAGENTA_MARBLE_TILE_SLABS.get());
        slabTag.add(ModBlocks.PINK_MARBLE_BRICK_SLABS.get(), ModBlocks.PINK_MARBLE_TILE_SLABS.get());

        var stairsTag = tag(BlockTags.STAIRS);
        stairsTag.add(ModBlocks.MARBLE_BRICK_STAIRS.get(),       ModBlocks.MARBLE_TILE_STAIRS.get());
        stairsTag.add(ModBlocks.LIGHT_GRAY_MARBLE_BRICK_STAIRS.get(),  ModBlocks.LIGHT_GRAY_MARBLE_TILE_STAIRS.get());
        stairsTag.add(ModBlocks.GRAY_MARBLE_BRICK_STAIRS.get(),        ModBlocks.GRAY_MARBLE_TILE_STAIRS.get());
        stairsTag.add(ModBlocks.BLACK_MARBLE_BRICK_STAIRS.get(),       ModBlocks.BLACK_MARBLE_TILE_STAIRS.get());
        stairsTag.add(ModBlocks.BROWN_MARBLE_BRICK_STAIRS.get(),       ModBlocks.BROWN_MARBLE_TILE_STAIRS.get());
        stairsTag.add(ModBlocks.RED_MARBLE_BRICK_STAIRS.get(),         ModBlocks.RED_MARBLE_TILE_STAIRS.get());
        stairsTag.add(ModBlocks.ORANGE_MARBLE_BRICK_STAIRS.get(),      ModBlocks.ORANGE_MARBLE_TILE_STAIRS.get());
        stairsTag.add(ModBlocks.YELLOW_MARBLE_BRICK_STAIRS.get(),      ModBlocks.YELLOW_MARBLE_TILE_STAIRS.get());
        stairsTag.add(ModBlocks.LIME_MARBLE_BRICK_STAIRS.get(),        ModBlocks.LIME_MARBLE_TILE_STAIRS.get());
        stairsTag.add(ModBlocks.GREEN_MARBLE_BRICK_STAIRS.get(),       ModBlocks.GREEN_MARBLE_TILE_STAIRS.get());
        stairsTag.add(ModBlocks.CYAN_MARBLE_BRICK_STAIRS.get(),        ModBlocks.CYAN_MARBLE_TILE_STAIRS.get());
        stairsTag.add(ModBlocks.LIGHT_BLUE_MARBLE_BRICK_STAIRS.get(),  ModBlocks.LIGHT_BLUE_MARBLE_TILE_STAIRS.get());
        stairsTag.add(ModBlocks.BLUE_MARBLE_BRICK_STAIRS.get(),        ModBlocks.BLUE_MARBLE_TILE_STAIRS.get());
        stairsTag.add(ModBlocks.PURPLE_MARBLE_BRICK_STAIRS.get(),      ModBlocks.PURPLE_MARBLE_TILE_STAIRS.get());
        stairsTag.add(ModBlocks.MAGENTA_MARBLE_BRICK_STAIRS.get(),     ModBlocks.MAGENTA_MARBLE_TILE_STAIRS.get());
        stairsTag.add(ModBlocks.PINK_MARBLE_BRICK_STAIRS.get(),        ModBlocks.PINK_MARBLE_TILE_STAIRS.get());

        var wallsTag = tag(BlockTags.WALLS);
        wallsTag.add(ModBlocks.MARBLE_BRICK_WALLS.get(),       ModBlocks.MARBLE_TILE_WALLS.get());
        wallsTag.add(ModBlocks.LIGHT_GRAY_MARBLE_BRICK_WALLS.get(),  ModBlocks.LIGHT_GRAY_MARBLE_TILE_WALLS.get());
        wallsTag.add(ModBlocks.GRAY_MARBLE_BRICK_WALLS.get(),        ModBlocks.GRAY_MARBLE_TILE_WALLS.get());
        wallsTag.add(ModBlocks.BLACK_MARBLE_BRICK_WALLS.get(),       ModBlocks.BLACK_MARBLE_TILE_WALLS.get());
        wallsTag.add(ModBlocks.BROWN_MARBLE_BRICK_WALLS.get(),       ModBlocks.BROWN_MARBLE_TILE_WALLS.get());
        wallsTag.add(ModBlocks.RED_MARBLE_BRICK_WALLS.get(),         ModBlocks.RED_MARBLE_TILE_WALLS.get());
        wallsTag.add(ModBlocks.ORANGE_MARBLE_BRICK_WALLS.get(),      ModBlocks.ORANGE_MARBLE_TILE_WALLS.get());
        wallsTag.add(ModBlocks.YELLOW_MARBLE_BRICK_WALLS.get(),      ModBlocks.YELLOW_MARBLE_TILE_WALLS.get());
        wallsTag.add(ModBlocks.LIME_MARBLE_BRICK_WALLS.get(),        ModBlocks.LIME_MARBLE_TILE_WALLS.get());
        wallsTag.add(ModBlocks.GREEN_MARBLE_BRICK_WALLS.get(),       ModBlocks.GREEN_MARBLE_TILE_WALLS.get());
        wallsTag.add(ModBlocks.CYAN_MARBLE_BRICK_WALLS.get(),        ModBlocks.CYAN_MARBLE_TILE_WALLS.get());
        wallsTag.add(ModBlocks.LIGHT_BLUE_MARBLE_BRICK_WALLS.get(),  ModBlocks.LIGHT_BLUE_MARBLE_TILE_WALLS.get());
        wallsTag.add(ModBlocks.BLUE_MARBLE_BRICK_WALLS.get(),        ModBlocks.BLUE_MARBLE_TILE_WALLS.get());
        wallsTag.add(ModBlocks.PURPLE_MARBLE_BRICK_WALLS.get(),      ModBlocks.PURPLE_MARBLE_TILE_WALLS.get());
        wallsTag.add(ModBlocks.MAGENTA_MARBLE_BRICK_WALLS.get(),     ModBlocks.MAGENTA_MARBLE_TILE_WALLS.get());
        wallsTag.add(ModBlocks.PINK_MARBLE_BRICK_WALLS.get(),        ModBlocks.PINK_MARBLE_TILE_WALLS.get());

        var wallPostsTag = tag(BlockTags.WALL_POST_OVERRIDE);
        wallPostsTag.add(ModBlocks.MARBLE_BRICK_WALLS.get(),       ModBlocks.MARBLE_TILE_WALLS.get());
        wallPostsTag.add(ModBlocks.LIGHT_GRAY_MARBLE_BRICK_WALLS.get(),  ModBlocks.LIGHT_GRAY_MARBLE_TILE_WALLS.get());
        wallPostsTag.add(ModBlocks.GRAY_MARBLE_BRICK_WALLS.get(),        ModBlocks.GRAY_MARBLE_TILE_WALLS.get());
        wallPostsTag.add(ModBlocks.BLACK_MARBLE_BRICK_WALLS.get(),       ModBlocks.BLACK_MARBLE_TILE_WALLS.get());
        wallPostsTag.add(ModBlocks.BROWN_MARBLE_BRICK_WALLS.get(),       ModBlocks.BROWN_MARBLE_TILE_WALLS.get());
        wallPostsTag.add(ModBlocks.RED_MARBLE_BRICK_WALLS.get(),         ModBlocks.RED_MARBLE_TILE_WALLS.get());
        wallPostsTag.add(ModBlocks.ORANGE_MARBLE_BRICK_WALLS.get(),      ModBlocks.ORANGE_MARBLE_TILE_WALLS.get());
        wallPostsTag.add(ModBlocks.YELLOW_MARBLE_BRICK_WALLS.get(),      ModBlocks.YELLOW_MARBLE_TILE_WALLS.get());
        wallPostsTag.add(ModBlocks.LIME_MARBLE_BRICK_WALLS.get(),        ModBlocks.LIME_MARBLE_TILE_WALLS.get());
        wallPostsTag.add(ModBlocks.GREEN_MARBLE_BRICK_WALLS.get(),       ModBlocks.GREEN_MARBLE_TILE_WALLS.get());
        wallPostsTag.add(ModBlocks.CYAN_MARBLE_BRICK_WALLS.get(),        ModBlocks.CYAN_MARBLE_TILE_WALLS.get());
        wallPostsTag.add(ModBlocks.LIGHT_BLUE_MARBLE_BRICK_WALLS.get(),  ModBlocks.LIGHT_BLUE_MARBLE_TILE_WALLS.get());
        wallPostsTag.add(ModBlocks.BLUE_MARBLE_BRICK_WALLS.get(),        ModBlocks.BLUE_MARBLE_TILE_WALLS.get());
        wallPostsTag.add(ModBlocks.PURPLE_MARBLE_BRICK_WALLS.get(),      ModBlocks.PURPLE_MARBLE_TILE_WALLS.get());
        wallPostsTag.add(ModBlocks.MAGENTA_MARBLE_BRICK_WALLS.get(),     ModBlocks.MAGENTA_MARBLE_TILE_WALLS.get());
        wallPostsTag.add(ModBlocks.PINK_MARBLE_BRICK_WALLS.get(),        ModBlocks.PINK_MARBLE_TILE_WALLS.get());
    }
}