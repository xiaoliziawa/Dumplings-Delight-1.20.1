package com.tyxcnjiu.main.dumplingsdelight.block;

import com.tyxcnjiu.main.dumplingsdelight.registry.EffectRegistry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.Level;
import net.minecraft.tags.BlockTags;

import java.util.Collection;

public class DumplingMedleyBlock extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final IntegerProperty SERVINGS = IntegerProperty.create("servings", 0, 7);
    public final boolean hasLeftovers;
    protected static final VoxelShape[] SHAPES = new VoxelShape[]{
            Block.box(1.0, 0.0, 1.0, 15.0, 3.0, 15.0),
            Block.box(1.0, 0.0, 1.0, 15.0, 3.0, 15.0),
            Block.box(1.0, 0.0, 1.0, 15.0, 3.0, 15.0),
            Block.box(1.0, 0.0, 1.0, 15.0, 3.0, 15.0),
            Block.box(1.0, 0.0, 1.0, 15.0, 3.0, 15.0),
            Block.box(1.0, 0.0, 1.0, 15.0, 3.0, 15.0),
            Block.box(1.0, 0.0, 1.0, 15.0, 3.0, 15.0),
            Block.box(1.0, 0.0, 1.0, 15.0, 3.0, 15.0)
    };

    public DumplingMedleyBlock(Properties properties, boolean hasLeftovers) {
        super(properties);
        this.hasLeftovers = hasLeftovers;
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(SERVINGS, 7));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return SHAPES[state.getValue(SERVINGS)];
    }

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        if (worldIn.isClientSide) {
            if (this.takeServing(worldIn, pos, state, player, handIn).consumesAction()) {
                return InteractionResult.SUCCESS;
            }
        }
        return this.takeServing(worldIn, pos, state, player, handIn);
    }

    private boolean garlic(Player player) {
        Collection<MobEffectInstance> effects = player.getActiveEffects();
        for (MobEffectInstance effect : effects) {
            if (effect.getEffect() == EffectRegistry.Garlic.get()) {
                return true;
            }
        }
        return false;
    }

    private InteractionResult takeServing(LevelAccessor worldIn, BlockPos pos, BlockState state, Player player, InteractionHand handIn) {
        int servings = state.getValue(SERVINGS);
        ItemStack heldStack = player.getItemInHand(handIn);
        if (servings == 0) {
            worldIn.playSound(null, pos, SoundEvents.WOOD_BREAK, SoundSource.PLAYERS, 0.8F, 0.8F);
            worldIn.destroyBlock(pos, true);
            return InteractionResult.SUCCESS;
        }
        if (heldStack.isEmpty() && player.canEat(false)) {
            if (servings == 7 || servings == 6) {
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 50, 0));
                if (!player.getAbilities().instabuild) {
                    player.getFoodData().setFoodLevel(player.getFoodData().getFoodLevel() + 5);
                    if (garlic(player)) {
                        player.getFoodData().setFoodLevel(player.getFoodData().getFoodLevel() + 1);
                    }
                    player.getFoodData().setSaturation(player.getFoodData().getSaturationLevel() + 5 * 2 * 0.7F);
                }
                worldIn.setBlock(pos, state.setValue(SERVINGS, servings - 1), 3);
                return InteractionResult.SUCCESS;
            }
            if (servings == 5 || servings == 4 || servings == 3) {
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 50, 0));
                if (!player.getAbilities().instabuild) {
                    player.getFoodData().setFoodLevel(player.getFoodData().getFoodLevel() + 6);
                    if (garlic(player)) {
                        player.getFoodData().setFoodLevel(player.getFoodData().getFoodLevel() + 1);
                    }
                    player.getFoodData().setSaturation(player.getFoodData().getSaturationLevel() + 6 * 2 * 0.7F);
                }
                worldIn.setBlock(pos, state.setValue(SERVINGS, servings - 1), 3);
                return InteractionResult.SUCCESS;
            }
            if (servings == 2 || servings == 1) {
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 50, 0));
                if (!player.getAbilities().instabuild) {
                    player.getFoodData().setFoodLevel(player.getFoodData().getFoodLevel() + 8);
                    if (garlic(player)) {
                        player.getFoodData().setFoodLevel(player.getFoodData().getFoodLevel() + 1);
                    }
                    player.getFoodData().setSaturation(player.getFoodData().getSaturationLevel() + 8 * 2 * 0.9F);
                }
                worldIn.setBlock(pos, state.setValue(SERVINGS, servings - 1), 3);
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
        return facing == Direction.DOWN && !stateIn.canSurvive(worldIn, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
        return worldIn.getBlockState(pos.below()).getMaterial().isSolid();
    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, SERVINGS);
    }

    @Override
    public int getAnalogOutputSignal(BlockState blockState, Level worldIn, BlockPos pos) {
        return blockState.getValue(SERVINGS);
    }

    public int getMaxServings() {
        return 7;
    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter worldIn, BlockPos pos, PathComputationType type) {
        return false;
    }
}
