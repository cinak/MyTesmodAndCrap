package com.cinak.test.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;
import java.util.stream.Stream;


public class Shroom extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(6, 0, 6, 10, 1, 10),
            Block.makeCuboidShape(7, 1, 7, 9, 2, 9),
            Block.makeCuboidShape(7, 2, 8, 9, 3, 9),
            Block.makeCuboidShape(7, 2, 7, 8, 3, 8),
            Block.makeCuboidShape(7, 3, 7, 9, 4, 9),
            Block.makeCuboidShape(5, 5, 5, 11, 6, 11),
            Block.makeCuboidShape(6, 5, 6, 10, 7, 10),
            Block.makeCuboidShape(4, 4, 4, 12, 5, 12)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(6, 0, 6, 10, 1, 10),
            Block.makeCuboidShape(7, 1, 7, 9, 2, 9),
            Block.makeCuboidShape(7, 2, 7, 8, 3, 9),
            Block.makeCuboidShape(8, 2, 7, 9, 3, 8),
            Block.makeCuboidShape(7, 3, 7, 9, 4, 9),
            Block.makeCuboidShape(5, 5, 5, 11, 6, 11),
            Block.makeCuboidShape(6, 5, 6, 10, 7, 10),
            Block.makeCuboidShape(4, 4, 4, 12, 5, 12)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(6, 0, 6, 10, 1, 10),
            Block.makeCuboidShape(7, 1, 7, 9, 2, 9),
            Block.makeCuboidShape(7, 2, 7, 9, 3, 8),
            Block.makeCuboidShape(8, 2, 8, 9, 3, 9),
            Block.makeCuboidShape(7, 3, 7, 9, 4, 9),
            Block.makeCuboidShape(5, 5, 5, 11, 6, 11),
            Block.makeCuboidShape(6, 5, 6, 10, 7, 10),
            Block.makeCuboidShape(4, 4, 4, 12, 5, 12)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(6, 0, 6, 10, 1, 10),
            Block.makeCuboidShape(7, 1, 7, 9, 2, 9),
            Block.makeCuboidShape(8, 2, 7, 9, 3, 9),
            Block.makeCuboidShape(7, 2, 8, 8, 3, 9),
            Block.makeCuboidShape(7, 3, 7, 9, 4, 9),
            Block.makeCuboidShape(5, 5, 5, 11, 6, 11),
            Block.makeCuboidShape(6, 5, 6, 10, 7, 10),
            Block.makeCuboidShape(4, 4, 4, 12, 5, 12)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();



    public Shroom() {
        super(AbstractBlock.Properties.create(Material.IRON)
                .hardnessAndResistance(1F, 1F)
                .sound(SoundType.WET_GRASS)
                .harvestLevel(0)
                .harvestTool(ToolType.SHOVEL)
                .setRequiresTool());
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case EAST:
                return SHAPE_E;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING,context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0.8F;
    }
}
