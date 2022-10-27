package net.maxmag_change.harbingerofhistory.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;


public class WideTombStone extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public WideTombStone(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.createCuboidShape(4, 2, 2, 12, 3, 14),
            Block.createCuboidShape(7, 3, 2, 9, 20, 14),
            Block.createCuboidShape(7, 20, 3, 9, 21, 13),
            Block.createCuboidShape(7, 21, 3.8000000000000007, 9, 22, 12),
            Block.createCuboidShape(7, 22, 4.800000000000001, 9, 23, 11),
            Block.createCuboidShape(1, 1, 1, 15, 2, 15),
            Block.createCuboidShape(0, 0, 0, 16, 1, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
                    Block.createCuboidShape(2, 2, 4, 14, 3, 12),
                    Block.createCuboidShape(2, 3, 7, 14, 20, 9),
                    Block.createCuboidShape(3, 20, 7, 13, 21, 9),
                    Block.createCuboidShape(3.8000000000000007, 21, 7, 12, 22, 9),
                    Block.createCuboidShape(4.800000000000001, 22, 7, 11, 23, 9),
                    Block.createCuboidShape(1, 1, 1, 15, 2, 15),
                    Block.createCuboidShape(0, 0, 0, 16, 1, 16)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_S = Stream.of(
            Block.createCuboidShape(4, 2, 2, 12, 3, 14),
            Block.createCuboidShape(7, 3, 2, 9, 20, 14),
            Block.createCuboidShape(7, 20, 3, 9, 21, 13),
            Block.createCuboidShape(7, 21, 3.8000000000000007, 9, 22, 12),
            Block.createCuboidShape(7, 22, 4.800000000000001, 9, 23, 11),
            Block.createCuboidShape(1, 1, 1, 15, 2, 15),
            Block.createCuboidShape(0, 0, 0, 16, 1, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.createCuboidShape(2, 2, 4, 14, 3, 12),
            Block.createCuboidShape(2, 3, 7, 14, 20, 9),
            Block.createCuboidShape(3, 20, 7, 13, 21, 9),
            Block.createCuboidShape(3.8000000000000007, 21, 7, 12, 22, 9),
            Block.createCuboidShape(4.800000000000001, 22, 7, 11, 23, 9),
            Block.createCuboidShape(1, 1, 1, 15, 2, 15),
            Block.createCuboidShape(0, 0, 0, 16, 1, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case EAST:
                return SHAPE_E;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        player.playSound(SoundEvents.ENTITY_SKELETON_AMBIENT, 0.15F, 1.0F);
    }
}
