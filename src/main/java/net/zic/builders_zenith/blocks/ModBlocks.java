package net.zic.builders_zenith.blocks;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.zic.builders_zenith.BuildersZenith;
import net.zic.builders_zenith.blocks.custom.*;
import net.zic.builders_zenith.blocks.custom.blockz.VerticalSlabBlock;
import net.zic.builders_zenith.items.ModItems;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCK =
            DeferredRegister.createBlocks(BuildersZenith.MOD_ID);

    // Maps for all dyed brick variants
    public static final Map<DyedBrickType, DeferredBlock<Block>> DYED_BRICKS = new HashMap<>();
    public static final Map<DyedBrickType, DeferredBlock<SlabBlock>> DYED_BRICK_SLABS = new HashMap<>();
    public static final Map<DyedBrickType, DeferredBlock<VerticalSlabBlock>> DYED_BRICK_VERTICAL_SLABS = new HashMap<>();
    public static final Map<DyedBrickType, DeferredBlock<StairBlock>> DYED_BRICK_STAIRS = new HashMap<>();
    public static final Map<DyedBrickType, DeferredBlock<WallBlock>> DYED_BRICK_WALLS = new HashMap<>();


    static {
        // Register all 256 dyed brick variants with custom BlockItem for tooltips
        for (DyedBrickType type : DyedBrickType.values()) {
            String baseName = type.getSerializedName();

            // Full block
            String blockName = "dyed_brick_" + baseName;
            DeferredBlock<Block> block = registerDyedBrickBlock(blockName, type);
            DYED_BRICKS.put(type, block);

            // Slab
            String slabName = "dyed_brick_slab_" + baseName;
            DeferredBlock<SlabBlock> slab = registerDyedBrickSlab(slabName, type);
            DYED_BRICK_SLABS.put(type, slab);

            // Stairs - use the full block's default state for stair properties
            String stairName = "dyed_brick_stairs_" + baseName;
            DeferredBlock<StairBlock> stairs = registerDyedBrickStairs(stairName, type, block);
            DYED_BRICK_STAIRS.put(type, stairs);

            // Wall
            String wallName = "dyed_brick_wall_" + baseName;
            DeferredBlock<WallBlock> wall = registerDyedBrickWall(wallName, type);
            DYED_BRICK_WALLS.put(type, wall);

            // Add vertical slabs
            String verticalSlabName = "dyed_brick_vertical_slab_" + baseName;
            DeferredBlock<VerticalSlabBlock> verticalSlab = registerDyedBrickVerticalSlab(verticalSlabName, type);
            DYED_BRICK_VERTICAL_SLABS.put(type, verticalSlab);
        }
    }

// ─────────────────────────────────────────────────────────────────────────
//  MARBLE
// ─────────────────────────────────────────────────────────────────────────

    private static Block makeBlockFrom(Block other) {
        return new Block(BlockBehaviour.Properties.ofFullCopy(other));
    }
    private static StairBlock makeStairsFrom(Supplier<Block> baseBlock) {
        return new StairBlock(
                baseBlock.get().defaultBlockState(),
                BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE_STAIRS)
        );
    }
    private static SlabBlock makeSlabFrom() {
        return new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE_SLAB));
    }
    private static WallBlock makeWallFrom() {
        return new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE_WALL));
    }

// ─────────────────────────────────────────────────────────────────────────
//  MARBLE — all 16 colors × 5 variants
// ─────────────────────────────────────────────────────────────────────────

    // ── White ────────────────────────────────────────────────────────────────
// ── Marble (white = plain "marble") ─────────────────────────────────────
    public static final DeferredBlock<Block> MARBLE = registerBlock("marble",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> MARBLE_BRICKS = registerBlock("marble_bricks",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> MARBLE_CHISELED = registerBlock("marble_chiseled",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> MARBLE_TILES = registerBlock("marble_tiles",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> POLISHED_MARBLE = registerBlock("polished_marble",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<StairBlock> MARBLE_BRICK_STAIRS = registerBlock("marble_brick_stairs",
            props -> new StairBlock(MARBLE_BRICKS.get().defaultBlockState(), props),
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<StairBlock> MARBLE_TILE_STAIRS = registerBlock("marble_tile_stairs",
            props -> new StairBlock(MARBLE_TILES.get().defaultBlockState(), props),
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<SlabBlock> MARBLE_BRICK_SLABS = registerBlock("marble_brick_slabs",
            SlabBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<SlabBlock> MARBLE_TILE_SLABS = registerBlock("marble_tile_slabs",
            SlabBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<WallBlock> MARBLE_BRICK_WALLS = registerBlock("marble_brick_wall",
            WallBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<WallBlock> MARBLE_TILE_WALLS = registerBlock("marble_tile_wall",
            WallBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    // ── Light Gray ───────────────────────────────────────────────────────────
    public static final DeferredBlock<Block> LIGHT_GRAY_MARBLE = registerBlock("light_gray_marble",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> LIGHT_GRAY_MARBLE_BRICKS = registerBlock("light_gray_marble_bricks",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> LIGHT_GRAY_MARBLE_CHISELED = registerBlock("light_gray_marble_chiseled",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> LIGHT_GRAY_MARBLE_TILES = registerBlock("light_gray_marble_tiles",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> POLISHED_LIGHT_GRAY_MARBLE = registerBlock("polished_light_gray_marble",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<StairBlock> LIGHT_GRAY_MARBLE_BRICK_STAIRS = registerBlock("light_gray_marble_brick_stairs",
            props -> new StairBlock(LIGHT_GRAY_MARBLE_BRICKS.get().defaultBlockState(), props),
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<StairBlock> LIGHT_GRAY_MARBLE_TILE_STAIRS = registerBlock("light_gray_marble_tile_stairs",
            props -> new StairBlock(LIGHT_GRAY_MARBLE_TILES.get().defaultBlockState(), props),
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<SlabBlock> LIGHT_GRAY_MARBLE_BRICK_SLABS = registerBlock("light_gray_marble_brick_slabs",
            SlabBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<SlabBlock> LIGHT_GRAY_MARBLE_TILE_SLABS = registerBlock("light_gray_marble_tile_slabs",
            SlabBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<WallBlock> LIGHT_GRAY_MARBLE_BRICK_WALLS = registerBlock("light_gray_marble_brick_wall",
            WallBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<WallBlock> LIGHT_GRAY_MARBLE_TILE_WALLS = registerBlock("light_gray_marble_tile_wall",
            WallBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    // ── Gray ─────────────────────────────────────────────────────────────────
    public static final DeferredBlock<Block> GRAY_MARBLE = registerBlock("gray_marble",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> GRAY_MARBLE_BRICKS = registerBlock("gray_marble_bricks",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> GRAY_MARBLE_CHISELED = registerBlock("gray_marble_chiseled",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> GRAY_MARBLE_TILES = registerBlock("gray_marble_tiles",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> GRAY_POLISHED_MARBLE = registerBlock("gray_polished_marble",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<StairBlock> GRAY_MARBLE_BRICK_STAIRS = registerBlock("gray_marble_brick_stairs",
            props -> new StairBlock(GRAY_MARBLE_BRICKS.get().defaultBlockState(), props),
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<StairBlock> GRAY_MARBLE_TILE_STAIRS = registerBlock("gray_marble_tile_stairs",
            props -> new StairBlock(GRAY_MARBLE_TILES.get().defaultBlockState(), props),
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<SlabBlock> GRAY_MARBLE_BRICK_SLABS = registerBlock("gray_marble_brick_slabs",
            SlabBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<SlabBlock> GRAY_MARBLE_TILE_SLABS = registerBlock("gray_marble_tile_slabs",
            SlabBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<WallBlock> GRAY_MARBLE_BRICK_WALLS = registerBlock("gray_marble_brick_wall",
            WallBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<WallBlock> GRAY_MARBLE_TILE_WALLS = registerBlock("gray_marble_tile_wall",
            WallBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    // ── Black ────────────────────────────────────────────────────────────────
    public static final DeferredBlock<Block> BLACK_MARBLE = registerBlock("black_marble",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> BLACK_MARBLE_BRICKS = registerBlock("black_marble_bricks",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> BLACK_MARBLE_CHISELED = registerBlock("black_marble_chiseled",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> BLACK_MARBLE_TILES = registerBlock("black_marble_tiles",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> BLACK_POLISHED_MARBLE = registerBlock("black_polished_marble",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<StairBlock> BLACK_MARBLE_BRICK_STAIRS = registerBlock("black_marble_brick_stairs",
            props -> new StairBlock(BLACK_MARBLE_BRICKS.get().defaultBlockState(), props),
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<StairBlock> BLACK_MARBLE_TILE_STAIRS = registerBlock("black_marble_tile_stairs",
            props -> new StairBlock(BLACK_MARBLE_TILES.get().defaultBlockState(), props),
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<SlabBlock> BLACK_MARBLE_BRICK_SLABS = registerBlock("black_marble_brick_slabs",
            SlabBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<SlabBlock> BLACK_MARBLE_TILE_SLABS = registerBlock("black_marble_tile_slabs",
            SlabBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<WallBlock> BLACK_MARBLE_BRICK_WALLS = registerBlock("black_marble_brick_wall",
            WallBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<WallBlock> BLACK_MARBLE_TILE_WALLS = registerBlock("black_marble_tile_wall",
            WallBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    // ── Brown ────────────────────────────────────────────────────────────────
    public static final DeferredBlock<Block> BROWN_MARBLE = registerBlock("brown_marble",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> BROWN_MARBLE_BRICKS = registerBlock("brown_marble_bricks",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> BROWN_MARBLE_CHISELED = registerBlock("brown_marble_chiseled",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> BROWN_MARBLE_TILES = registerBlock("brown_marble_tiles",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> BROWN_POLISHED_MARBLE = registerBlock("brown_polished_marble",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<StairBlock> BROWN_MARBLE_BRICK_STAIRS = registerBlock("brown_marble_brick_stairs",
            props -> new StairBlock(BROWN_MARBLE_BRICKS.get().defaultBlockState(), props),
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<StairBlock> BROWN_MARBLE_TILE_STAIRS = registerBlock("brown_marble_tile_stairs",
            props -> new StairBlock(BROWN_MARBLE_TILES.get().defaultBlockState(), props),
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<SlabBlock> BROWN_MARBLE_BRICK_SLABS = registerBlock("brown_marble_brick_slabs",
            SlabBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<SlabBlock> BROWN_MARBLE_TILE_SLABS = registerBlock("brown_marble_tile_slabs",
            SlabBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<WallBlock> BROWN_MARBLE_BRICK_WALLS = registerBlock("brown_marble_brick_wall",
            WallBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<WallBlock> BROWN_MARBLE_TILE_WALLS = registerBlock("brown_marble_tile_wall",
            WallBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    // ── Red ──────────────────────────────────────────────────────────────────
    public static final DeferredBlock<Block> RED_MARBLE = registerBlock("red_marble",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> RED_MARBLE_BRICKS = registerBlock("red_marble_bricks",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> RED_MARBLE_CHISELED = registerBlock("red_marble_chiseled",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> RED_MARBLE_TILES = registerBlock("red_marble_tiles",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> RED_POLISHED_MARBLE = registerBlock("red_polished_marble",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<StairBlock> RED_MARBLE_BRICK_STAIRS = registerBlock("red_marble_brick_stairs",
            props -> new StairBlock(RED_MARBLE_BRICKS.get().defaultBlockState(), props),
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<StairBlock> RED_MARBLE_TILE_STAIRS = registerBlock("red_marble_tile_stairs",
            props -> new StairBlock(RED_MARBLE_TILES.get().defaultBlockState(), props),
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<SlabBlock> RED_MARBLE_BRICK_SLABS = registerBlock("red_marble_brick_slabs",
            SlabBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<SlabBlock> RED_MARBLE_TILE_SLABS = registerBlock("red_marble_tile_slabs",
            SlabBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<WallBlock> RED_MARBLE_BRICK_WALLS = registerBlock("red_marble_brick_wall",
            WallBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<WallBlock> RED_MARBLE_TILE_WALLS = registerBlock("red_marble_tile_wall",
            WallBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    // ── Orange ───────────────────────────────────────────────────────────────
    public static final DeferredBlock<Block> ORANGE_MARBLE = registerBlock("orange_marble",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> ORANGE_MARBLE_BRICKS = registerBlock("orange_marble_bricks",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> ORANGE_MARBLE_CHISELED = registerBlock("orange_marble_chiseled",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> ORANGE_MARBLE_TILES = registerBlock("orange_marble_tiles",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> ORANGE_POLISHED_MARBLE = registerBlock("orange_polished_marble",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<StairBlock> ORANGE_MARBLE_BRICK_STAIRS = registerBlock("orange_marble_brick_stairs",
            props -> new StairBlock(ORANGE_MARBLE_BRICKS.get().defaultBlockState(), props),
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<StairBlock> ORANGE_MARBLE_TILE_STAIRS = registerBlock("orange_marble_tile_stairs",
            props -> new StairBlock(ORANGE_MARBLE_TILES.get().defaultBlockState(), props),
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<SlabBlock> ORANGE_MARBLE_BRICK_SLABS = registerBlock("orange_marble_brick_slabs",
            SlabBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<SlabBlock> ORANGE_MARBLE_TILE_SLABS = registerBlock("orange_marble_tile_slabs",
            SlabBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<WallBlock> ORANGE_MARBLE_BRICK_WALLS = registerBlock("orange_marble_brick_wall",
            WallBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<WallBlock> ORANGE_MARBLE_TILE_WALLS = registerBlock("orange_marble_tile_wall",
            WallBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    // ── Yellow ───────────────────────────────────────────────────────────────
    public static final DeferredBlock<Block> YELLOW_MARBLE = registerBlock("yellow_marble",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> YELLOW_MARBLE_BRICKS = registerBlock("yellow_marble_bricks",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> YELLOW_MARBLE_CHISELED = registerBlock("yellow_marble_chiseled",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> YELLOW_MARBLE_TILES = registerBlock("yellow_marble_tiles",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> YELLOW_POLISHED_MARBLE = registerBlock("yellow_polished_marble",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<StairBlock> YELLOW_MARBLE_BRICK_STAIRS = registerBlock("yellow_marble_brick_stairs",
            props -> new StairBlock(YELLOW_MARBLE_BRICKS.get().defaultBlockState(), props),
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<StairBlock> YELLOW_MARBLE_TILE_STAIRS = registerBlock("yellow_marble_tile_stairs",
            props -> new StairBlock(YELLOW_MARBLE_TILES.get().defaultBlockState(), props),
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<SlabBlock> YELLOW_MARBLE_BRICK_SLABS = registerBlock("yellow_marble_brick_slabs",
            SlabBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<SlabBlock> YELLOW_MARBLE_TILE_SLABS = registerBlock("yellow_marble_tile_slabs",
            SlabBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<WallBlock> YELLOW_MARBLE_BRICK_WALLS = registerBlock("yellow_marble_brick_wall",
            WallBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<WallBlock> YELLOW_MARBLE_TILE_WALLS = registerBlock("yellow_marble_tile_wall",
            WallBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    // ── Lime ─────────────────────────────────────────────────────────────────
    public static final DeferredBlock<Block> LIME_MARBLE = registerBlock("lime_marble",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> LIME_MARBLE_BRICKS = registerBlock("lime_marble_bricks",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> LIME_MARBLE_CHISELED = registerBlock("lime_marble_chiseled",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> LIME_MARBLE_TILES = registerBlock("lime_marble_tiles",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> LIME_POLISHED_MARBLE = registerBlock("lime_polished_marble",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<StairBlock> LIME_MARBLE_BRICK_STAIRS = registerBlock("lime_marble_brick_stairs",
            props -> new StairBlock(LIME_MARBLE_BRICKS.get().defaultBlockState(), props),
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<StairBlock> LIME_MARBLE_TILE_STAIRS = registerBlock("lime_marble_tile_stairs",
            props -> new StairBlock(LIME_MARBLE_TILES.get().defaultBlockState(), props),
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<SlabBlock> LIME_MARBLE_BRICK_SLABS = registerBlock("lime_marble_brick_slabs",
            SlabBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<SlabBlock> LIME_MARBLE_TILE_SLABS = registerBlock("lime_marble_tile_slabs",
            SlabBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<WallBlock> LIME_MARBLE_BRICK_WALLS = registerBlock("lime_marble_brick_wall",
            WallBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<WallBlock> LIME_MARBLE_TILE_WALLS = registerBlock("lime_marble_tile_wall",
            WallBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    // ── Green ────────────────────────────────────────────────────────────────
    public static final DeferredBlock<Block> GREEN_MARBLE = registerBlock("green_marble",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> GREEN_MARBLE_BRICKS = registerBlock("green_marble_bricks",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> GREEN_MARBLE_CHISELED = registerBlock("green_marble_chiseled",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> GREEN_MARBLE_TILES = registerBlock("green_marble_tiles",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> GREEN_POLISHED_MARBLE = registerBlock("green_polished_marble",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<StairBlock> GREEN_MARBLE_BRICK_STAIRS = registerBlock("green_marble_brick_stairs",
            props -> new StairBlock(GREEN_MARBLE_BRICKS.get().defaultBlockState(), props),
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<StairBlock> GREEN_MARBLE_TILE_STAIRS = registerBlock("green_marble_tile_stairs",
            props -> new StairBlock(GREEN_MARBLE_TILES.get().defaultBlockState(), props),
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<SlabBlock> GREEN_MARBLE_BRICK_SLABS = registerBlock("green_marble_brick_slabs",
            SlabBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<SlabBlock> GREEN_MARBLE_TILE_SLABS = registerBlock("green_marble_tile_slabs",
            SlabBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<WallBlock> GREEN_MARBLE_BRICK_WALLS = registerBlock("green_marble_brick_wall",
            WallBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<WallBlock> GREEN_MARBLE_TILE_WALLS = registerBlock("green_marble_tile_wall",
            WallBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    // ── Cyan ─────────────────────────────────────────────────────────────────
    public static final DeferredBlock<Block> CYAN_MARBLE = registerBlock("cyan_marble",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> CYAN_MARBLE_BRICKS = registerBlock("cyan_marble_bricks",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> CYAN_MARBLE_CHISELED = registerBlock("cyan_marble_chiseled",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> CYAN_MARBLE_TILES = registerBlock("cyan_marble_tiles",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> CYAN_POLISHED_MARBLE = registerBlock("cyan_polished_marble",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<StairBlock> CYAN_MARBLE_BRICK_STAIRS = registerBlock("cyan_marble_brick_stairs",
            props -> new StairBlock(CYAN_MARBLE_BRICKS.get().defaultBlockState(), props),
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<StairBlock> CYAN_MARBLE_TILE_STAIRS = registerBlock("cyan_marble_tile_stairs",
            props -> new StairBlock(CYAN_MARBLE_TILES.get().defaultBlockState(), props),
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<SlabBlock> CYAN_MARBLE_BRICK_SLABS = registerBlock("cyan_marble_brick_slabs",
            SlabBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<SlabBlock> CYAN_MARBLE_TILE_SLABS = registerBlock("cyan_marble_tile_slabs",
            SlabBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<WallBlock> CYAN_MARBLE_BRICK_WALLS = registerBlock("cyan_marble_brick_wall",
            WallBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<WallBlock> CYAN_MARBLE_TILE_WALLS = registerBlock("cyan_marble_tile_wall",
            WallBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    // ── Light Blue ───────────────────────────────────────────────────────────
    public static final DeferredBlock<Block> LIGHT_BLUE_MARBLE = registerBlock("light_blue_marble",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> LIGHT_BLUE_MARBLE_BRICKS = registerBlock("light_blue_marble_bricks",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> LIGHT_BLUE_MARBLE_CHISELED = registerBlock("light_blue_marble_chiseled",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> LIGHT_BLUE_MARBLE_TILES = registerBlock("light_blue_marble_tiles",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> LIGHT_BLUE_POLISHED_MARBLE = registerBlock("light_blue_polished_marble",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<StairBlock> LIGHT_BLUE_MARBLE_BRICK_STAIRS = registerBlock("light_blue_marble_brick_stairs",
            props -> new StairBlock(LIGHT_BLUE_MARBLE_BRICKS.get().defaultBlockState(), props),
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<StairBlock> LIGHT_BLUE_MARBLE_TILE_STAIRS = registerBlock("light_blue_marble_tile_stairs",
            props -> new StairBlock(LIGHT_BLUE_MARBLE_TILES.get().defaultBlockState(), props),
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<SlabBlock> LIGHT_BLUE_MARBLE_BRICK_SLABS = registerBlock("light_blue_marble_brick_slabs",
            SlabBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<SlabBlock> LIGHT_BLUE_MARBLE_TILE_SLABS = registerBlock("light_blue_marble_tile_slabs",
            SlabBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<WallBlock> LIGHT_BLUE_MARBLE_BRICK_WALLS = registerBlock("light_blue_marble_brick_wall",
            WallBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<WallBlock> LIGHT_BLUE_MARBLE_TILE_WALLS = registerBlock("light_blue_marble_tile_wall",
            WallBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    // ── Blue ─────────────────────────────────────────────────────────────────
    public static final DeferredBlock<Block> BLUE_MARBLE = registerBlock("blue_marble",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> BLUE_MARBLE_BRICKS = registerBlock("blue_marble_bricks",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> BLUE_MARBLE_CHISELED = registerBlock("blue_marble_chiseled",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> BLUE_MARBLE_TILES = registerBlock("blue_marble_tiles",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> BLUE_POLISHED_MARBLE = registerBlock("blue_polished_marble",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<StairBlock> BLUE_MARBLE_BRICK_STAIRS = registerBlock("blue_marble_brick_stairs",
            props -> new StairBlock(BLUE_MARBLE_BRICKS.get().defaultBlockState(), props),
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<StairBlock> BLUE_MARBLE_TILE_STAIRS = registerBlock("blue_marble_tile_stairs",
            props -> new StairBlock(BLUE_MARBLE_TILES.get().defaultBlockState(), props),
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<SlabBlock> BLUE_MARBLE_BRICK_SLABS = registerBlock("blue_marble_brick_slabs",
            SlabBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<SlabBlock> BLUE_MARBLE_TILE_SLABS = registerBlock("blue_marble_tile_slabs",
            SlabBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<WallBlock> BLUE_MARBLE_BRICK_WALLS = registerBlock("blue_marble_brick_wall",
            WallBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<WallBlock> BLUE_MARBLE_TILE_WALLS = registerBlock("blue_marble_tile_wall",
            WallBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    // ── Purple ───────────────────────────────────────────────────────────────
    public static final DeferredBlock<Block> PURPLE_MARBLE = registerBlock("purple_marble",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> PURPLE_MARBLE_BRICKS = registerBlock("purple_marble_bricks",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> PURPLE_MARBLE_CHISELED = registerBlock("purple_marble_chiseled",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> PURPLE_MARBLE_TILES = registerBlock("purple_marble_tiles",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> PURPLE_POLISHED_MARBLE = registerBlock("purple_polished_marble",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<StairBlock> PURPLE_MARBLE_BRICK_STAIRS = registerBlock("purple_marble_brick_stairs",
            props -> new StairBlock(PURPLE_MARBLE_BRICKS.get().defaultBlockState(), props),
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<StairBlock> PURPLE_MARBLE_TILE_STAIRS = registerBlock("purple_marble_tile_stairs",
            props -> new StairBlock(PURPLE_MARBLE_TILES.get().defaultBlockState(), props),
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<SlabBlock> PURPLE_MARBLE_BRICK_SLABS = registerBlock("purple_marble_brick_slabs",
            SlabBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<SlabBlock> PURPLE_MARBLE_TILE_SLABS = registerBlock("purple_marble_tile_slabs",
            SlabBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<WallBlock> PURPLE_MARBLE_BRICK_WALLS = registerBlock("purple_marble_brick_wall",
            WallBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<WallBlock> PURPLE_MARBLE_TILE_WALLS = registerBlock("purple_marble_tile_wall",
            WallBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    // ── Magenta ──────────────────────────────────────────────────────────────
    public static final DeferredBlock<Block> MAGENTA_MARBLE = registerBlock("magenta_marble",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> MAGENTA_MARBLE_BRICKS = registerBlock("magenta_marble_bricks",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> MAGENTA_MARBLE_CHISELED = registerBlock("magenta_marble_chiseled",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> MAGENTA_MARBLE_TILES = registerBlock("magenta_marble_tiles",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> MAGENTA_POLISHED_MARBLE = registerBlock("magenta_polished_marble",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<StairBlock> MAGENTA_MARBLE_BRICK_STAIRS = registerBlock("magenta_marble_brick_stairs",
            props -> new StairBlock(MAGENTA_MARBLE_BRICKS.get().defaultBlockState(), props),
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<StairBlock> MAGENTA_MARBLE_TILE_STAIRS = registerBlock("magenta_marble_tile_stairs",
            props -> new StairBlock(MAGENTA_MARBLE_TILES.get().defaultBlockState(), props),
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<SlabBlock> MAGENTA_MARBLE_BRICK_SLABS = registerBlock("magenta_marble_brick_slabs",
            SlabBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<SlabBlock> MAGENTA_MARBLE_TILE_SLABS = registerBlock("magenta_marble_tile_slabs",
            SlabBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<WallBlock> MAGENTA_MARBLE_BRICK_WALLS = registerBlock("magenta_marble_brick_wall",
            WallBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<WallBlock> MAGENTA_MARBLE_TILE_WALLS = registerBlock("magenta_marble_tile_wall",
            WallBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    // ── Pink ─────────────────────────────────────────────────────────────────
    public static final DeferredBlock<Block> PINK_MARBLE = registerBlock("pink_marble",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> PINK_MARBLE_BRICKS = registerBlock("pink_marble_bricks",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> PINK_MARBLE_CHISELED = registerBlock("pink_marble_chiseled",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> PINK_MARBLE_TILES = registerBlock("pink_marble_tiles",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<Block> PINK_POLISHED_MARBLE = registerBlock("pink_polished_marble",
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<StairBlock> PINK_MARBLE_BRICK_STAIRS = registerBlock("pink_marble_brick_stairs",
            props -> new StairBlock(PINK_MARBLE_BRICKS.get().defaultBlockState(), props),
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<StairBlock> PINK_MARBLE_TILE_STAIRS = registerBlock("pink_marble_tile_stairs",
            props -> new StairBlock(PINK_MARBLE_TILES.get().defaultBlockState(), props),
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<SlabBlock> PINK_MARBLE_BRICK_SLABS = registerBlock("pink_marble_brick_slabs",
            SlabBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<SlabBlock> PINK_MARBLE_TILE_SLABS = registerBlock("pink_marble_tile_slabs",
            SlabBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));

    public static final DeferredBlock<WallBlock> PINK_MARBLE_BRICK_WALLS = registerBlock("pink_marble_brick_wall",
            WallBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));
    public static final DeferredBlock<WallBlock> PINK_MARBLE_TILE_WALLS = registerBlock("pink_marble_tile_wall",
            WallBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE));





    public static final DeferredBlock<Block> CARPENTER = registerBlock("carpenterblock",
            CarpenterBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.WOOD)
                    .requiresCorrectToolForDrops()
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.5F)
                    .sound(SoundType.WOOD)
                    .noOcclusion());

    public static final DeferredBlock<Block> COLOR_MIXER = registerBlock("color_mixer",
            ColorMixerBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .requiresCorrectToolForDrops()
                    .strength(3.5F)
                    .sound(SoundType.STONE)
                    .noOcclusion());

    /*public static final DeferredBlock<Block> WINGED_TABLE = registerBlock("winged_table",
            () -> new WingedTableBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.WOOD)
                    .requiresCorrectToolForDrops()
                    .strength(2.5F)
                    .sound(SoundType.WOOD)
                    .noOcclusion()
            ));*/

    public static final DeferredBlock<Block> PREVIEW_BLOCK = registerBlock("preview_block",
            Block::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .strength(0.0F, 0.0F)
                    .sound(SoundType.AMETHYST)
                    .noLootTable()
                    .noOcclusion()
                    .instabreak()
                    .replaceable());


    //VerticalSlabs
//Wood Vert Slabs
    public static final DeferredBlock<Block> OAK_VERTICAL_SLAB = registerBlock("oak_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB));
    public static final DeferredBlock<Block> SPRUCE_VERTICAL_SLAB = registerBlock("spruce_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_SLAB));
    public static final DeferredBlock<Block> BIRCH_VERTICAL_SLAB = registerBlock("birch_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_SLAB));
    public static final DeferredBlock<Block> JUNGLE_VERTICAL_SLAB = registerBlock("jungle_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_SLAB));
    public static final DeferredBlock<Block> ACACIA_VERTICAL_SLAB = registerBlock("acacia_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_SLAB));
    public static final DeferredBlock<Block> DARK_OAK_VERTICAL_SLAB = registerBlock("dark_oak_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_SLAB));
    public static final DeferredBlock<Block> MANGROVE_VERTICAL_SLAB = registerBlock("mangrove_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_SLAB));
    public static final DeferredBlock<Block> CHERRY_VERTICAL_SLAB = registerBlock("cherry_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_SLAB));
    public static final DeferredBlock<Block> BAMBOO_VERTICAL_SLAB = registerBlock("bamboo_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_SLAB));
    public static final DeferredBlock<Block> CRIMSON_VERTICAL_SLAB = registerBlock("crimson_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_SLAB));
    public static final DeferredBlock<Block> WARPED_VERTICAL_SLAB = registerBlock("warped_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_SLAB));

    //Stone Vert Slabs
    public static final DeferredBlock<Block> STONE_VERTICAL_SLAB = registerBlock("stone_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB));
    public static final DeferredBlock<Block> COBBLESTONE_VERTICAL_SLAB = registerBlock("cobblestone_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_SLAB));
    public static final DeferredBlock<Block> MOSSY_COBBLESTONE_VERTICAL_SLAB = registerBlock("mossy_cobblestone_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE_SLAB));
    public static final DeferredBlock<Block> SMOOTH_STONE_VERTICAL_SLAB = registerBlock("smooth_stone_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE_SLAB));
    public static final DeferredBlock<Block> STONE_BRICK_VERTICAL_SLAB = registerBlock("stone_brick_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB));
    public static final DeferredBlock<Block> MOSSY_STONE_BRICK_VERTICAL_SLAB = registerBlock("mossy_stone_brick_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_SLAB));
    public static final DeferredBlock<Block> GRANITE_VERTICAL_SLAB = registerBlock("granite_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE_SLAB));
    public static final DeferredBlock<Block> POLISHED_GRANITE_VERTICAL_SLAB = registerBlock("polished_granite_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_GRANITE_SLAB));
    public static final DeferredBlock<Block> DIORITE_VERTICAL_SLAB = registerBlock("diorite_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE_SLAB));
    public static final DeferredBlock<Block> POLISHED_DIORITE_VERTICAL_SLAB = registerBlock("polished_diorite_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_DIORITE_SLAB));
    public static final DeferredBlock<Block> ANDESITE_VERTICAL_SLAB = registerBlock("andesite_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE_SLAB));
    public static final DeferredBlock<Block> POLISHED_ANDESITE_VERTICAL_SLAB = registerBlock("polished_andesite_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_ANDESITE_SLAB));
    public static final DeferredBlock<Block> COBBLED_DEEPSLATE_VERTICAL_SLAB = registerBlock("cobbled_deepslate_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLED_DEEPSLATE_SLAB));
    public static final DeferredBlock<Block> POLISHED_DEEPSLATE_VERTICAL_SLAB = registerBlock("polished_deepslate_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_DEEPSLATE_SLAB));
    public static final DeferredBlock<Block> DEEPSLATE_BRICK_VERTICAL_SLAB = registerBlock("deepslate_brick_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICK_SLAB));
    public static final DeferredBlock<Block> DEEPSLATE_TILE_VERTICAL_SLAB = registerBlock("deepslate_tile_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_TILE_SLAB));
    public static final DeferredBlock<Block> TUFF_VERTICAL_SLAB = registerBlock("tuff_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF_SLAB));
    public static final DeferredBlock<Block> POLISHED_TUFF_VERTICAL_SLAB = registerBlock("polished_tuff_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_TUFF_SLAB));
    public static final DeferredBlock<Block> TUFF_BRICK_VERTICAL_SLAB = registerBlock("tuff_brick_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF_BRICK_SLAB));
    public static final DeferredBlock<Block> BRICK_VERTICAL_SLAB = registerBlock("brick_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BRICK_SLAB));
    public static final DeferredBlock<Block> MUD_BRICK_VERTICAL_SLAB = registerBlock("mud_brick_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICK_SLAB));
    public static final DeferredBlock<Block> SANDSTONE_VERTICAL_SLAB = registerBlock("sandstone_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE_SLAB));
    public static final DeferredBlock<Block> SMOOTH_SANDSTONE_VERTICAL_SLAB = registerBlock("smooth_sandstone_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_SANDSTONE_SLAB));
    public static final DeferredBlock<Block> CUT_SANDSTONE_VERTICAL_SLAB = registerBlock("cut_sandstone_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_SANDSTONE_SLAB));
    public static final DeferredBlock<Block> RED_SANDSTONE_VERTICAL_SLAB = registerBlock("red_sandstone_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE_SLAB));
    public static final DeferredBlock<Block> SMOOTH_RED_SANDSTONE_VERTICAL_SLAB = registerBlock("smooth_red_sandstone_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_RED_SANDSTONE_SLAB));
    public static final DeferredBlock<Block> CUT_RED_SANDSTONE_VERTICAL_SLAB = registerBlock("cut_red_sandstone_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_RED_SANDSTONE_SLAB));
    public static final DeferredBlock<Block> PRISMARINE_VERTICAL_SLAB = registerBlock("prismarine_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE_SLAB));
    public static final DeferredBlock<Block> PRISMARINE_BRICK_VERTICAL_SLAB = registerBlock("prismarine_brick_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE_BRICK_SLAB));
    public static final DeferredBlock<Block> DARK_PRISMARINE_VERTICAL_SLAB = registerBlock("dark_prismarine_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE_SLAB));
    public static final DeferredBlock<Block> NETHER_BRICK_VERTICAL_SLAB = registerBlock("nether_brick_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICK_SLAB));
    public static final DeferredBlock<Block> RED_NETHER_BRICK_VERTICAL_SLAB = registerBlock("red_nether_brick_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICK_SLAB));
    public static final DeferredBlock<Block> BLACKSTONE_VERTICAL_SLAB = registerBlock("blackstone_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE_SLAB));
    public static final DeferredBlock<Block> POLISHED_BLACKSTONE_VERTICAL_SLAB = registerBlock("polished_blackstone_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_SLAB));
    public static final DeferredBlock<Block> POLISHED_BLACKSTONE_BRICK_VERTICAL_SLAB = registerBlock("polished_blackstone_brick_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICK_SLAB));
    public static final DeferredBlock<Block> END_STONE_BRICK_VERTICAL_SLAB = registerBlock("end_stone_brick_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE_BRICK_SLAB));

    //Other Blocks
    public static final DeferredBlock<Block> PURPUR_VERTICAL_SLAB = registerBlock("purpur_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_SLAB));
    public static final DeferredBlock<Block> QUARTZ_VERTICAL_SLAB = registerBlock("quartz_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_SLAB));
    public static final DeferredBlock<Block> SMOOTH_QUARTZ_VERTICAL_SLAB = registerBlock("smooth_quartz_vertical_slab",
            VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_QUARTZ_SLAB));



    private static DeferredBlock<Block> registerDyedBrickBlock(String name, DyedBrickType type) {
        DeferredBlock<Block> deferredBlock = BLOCK.registerBlock(name,
                Block::new,
                () -> BlockBehaviour.Properties.of()
                        .mapColor(MapColor.STONE)
                        .requiresCorrectToolForDrops()
                        .strength(2.0F, 6.0F)
                        .sound(SoundType.STONE));

        // Register custom BlockItem with type for tooltips
        ModItems.ITEMS.registerItem(name,
                props -> new DyedBrickBlockItem(deferredBlock.get(), props, type));

        return deferredBlock;
    }

    private static DeferredBlock<VerticalSlabBlock> registerDyedBrickVerticalSlab(String name, DyedBrickType type) {
        DeferredBlock<VerticalSlabBlock> deferredBlock = BLOCK.registerBlock(name,
                VerticalSlabBlock::new,
                () -> BlockBehaviour.Properties.of()
                        .mapColor(MapColor.STONE)
                        .requiresCorrectToolForDrops()
                        .strength(2.0F, 6.0F)
                        .sound(SoundType.STONE));

        // Register custom BlockItem
        ModItems.ITEMS.registerItem(name,
                props -> new DyedBrickBlockItem(deferredBlock.get(), props, type));

        return deferredBlock;
    }

    private static DeferredBlock<SlabBlock> registerDyedBrickSlab(String name, DyedBrickType type) {
        DeferredBlock<SlabBlock> deferredBlock = BLOCK.registerBlock(name,
                SlabBlock::new,
                () -> BlockBehaviour.Properties.of()
                        .mapColor(MapColor.STONE)
                        .requiresCorrectToolForDrops()
                        .strength(2.0F, 6.0F)
                        .sound(SoundType.STONE));

        // Register custom BlockItem with type for tooltips
        ModItems.ITEMS.registerItem(name,
                props -> new DyedBrickBlockItem(deferredBlock.get(), props, type));

        return deferredBlock;
    }

    private static DeferredBlock<StairBlock> registerDyedBrickStairs(String name, DyedBrickType type,
                                                                     DeferredBlock<Block> baseBlock) {
        DeferredBlock<StairBlock> deferredBlock = BLOCK.registerBlock(name,
                props -> new StairBlock(baseBlock.get().defaultBlockState(), props),
                () -> BlockBehaviour.Properties.of()
                        .mapColor(MapColor.STONE)
                        .requiresCorrectToolForDrops()
                        .strength(2.0F, 6.0F)
                        .sound(SoundType.STONE));

        // Register custom BlockItem with type for tooltips
        ModItems.ITEMS.registerItem(name,
                props -> new DyedBrickBlockItem(deferredBlock.get(), props, type));

        return deferredBlock;
    }

    private static DeferredBlock<WallBlock> registerDyedBrickWall(String name, DyedBrickType type) {
        DeferredBlock<WallBlock> deferredBlock = BLOCK.registerBlock(name,
                WallBlock::new,
                () -> BlockBehaviour.Properties.of()
                        .mapColor(MapColor.STONE)
                        .requiresCorrectToolForDrops()
                        .strength(2.0F, 6.0F)
                        .sound(SoundType.STONE));

        // Register custom BlockItem with type for tooltips
        ModItems.ITEMS.registerItem(name,
                props -> new DyedBrickBlockItem(deferredBlock.get(), props, type));

        return deferredBlock;


    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> block, BlockBehaviour.Properties properties) {
        DeferredBlock<T> toReturn = BLOCK.registerBlock(name, block, () -> properties);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> DeferredBlock<T> registerBlockWithoutItem(String name, Function<BlockBehaviour.Properties, T> block, BlockBehaviour.Properties properties) {
        return BLOCK.registerBlock(name, block, () -> properties);
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.registerSimpleBlockItem(name, block);
    }

    public static void register(IEventBus eventBus) {
        BLOCK.register(eventBus);
    }
}