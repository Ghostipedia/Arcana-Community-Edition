//package com.ghostipedia.arcana.blocks;
//
//import net.minecraft.core.BlockPos;
//import net.minecraft.core.particles.ParticleTypes;
//import net.minecraft.core.particles.SimpleParticleType;
//import net.minecraft.util.RandomSource;
//import net.minecraft.world.InteractionHand;
//import net.minecraft.world.InteractionResult;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.DyeItem;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.level.block.state.properties.IntegerProperty;
//import net.minecraft.world.phys.BlockHitResult;
//import net.minecraft.world.phys.shapes.VoxelShape;
//
//import java.util.Random;
//
//public class NitorBlock extends Block {
//    protected static final VoxelShape SHAPE = Block.box(6, 6, 6, 10, 10, 10);
//    public static final IntegerProperty COLOR = IntegerProperty.create("color", 0, 15);
//
//    public NitorBlock(Properties properties) {
//        super(properties);
//        this.defaultBlockState().setValue(COLOR,1);
//    }
//    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context){
//        return SHAPE;
//    }
//
//    public VoxelShape getCollisionShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context){
//        return VoxelShapes.empty();
//    }
//
//    public VoxelShape getRenderShape(BlockState state, IBlockReader world, BlockPos pos){
//        return VoxelShapes.empty();
//    }
//    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random){
//        // add a bunch of fire
//        double x = pos.getX() + .5;
//        double y = pos.getY() + .5;
//        double z = pos.getZ() + .5;
//        for(int i = 0; i < 3; i++){
//            double vX = random.nextGaussian() / 12;
//            double vY = random.nextGaussian() / 12;
//            double vZ = random.nextGaussian() / 12;
//            world.addParticle(ParticleTypes.FLAME, x + vX, y + vY, z + vZ, vX / 16, vY / 16, vZ / 16);
//        }
//    }
//
//    private SimpleParticleType getcolor(BlockState state) {
//        SimpleParticleType color = switch (state.getValue(COLOR)) {
//            case 0 -> ParticleTypes.SPIT;
//            case 1 -> ParticleTypes.FLAME;
//            case 2 -> ParticleTypes.PORTAL;
//            case 3 -> ParticleTypes.BUBBLE;
//            case 4 -> ParticleTypes.LANDING_HONEY;
//            case 5 -> ParticleTypes.SNEEZE;
//            case 6 -> ParticleTypes.HEART;
//            case 7 -> ParticleTypes.SMOKE;
//            case 8 -> ParticleTypes.CAMPFIRE_COSY_SMOKE;
//            case 9 -> ParticleTypes.SPLASH;
//            case 10 -> ParticleTypes.DRAGON_BREATH;
//            case 11 -> ParticleTypes.NAUTILUS;
//            case 12 -> ParticleTypes.MYCELIUM;
//            case 13 -> ParticleTypes.ITEM_SLIME;
//            case 14 -> ParticleTypes.LAVA;
//            case 15 -> ParticleTypes.SQUID_INK;
//            default -> ParticleTypes.CRIT;
//        };
//        return color;
//    }
//
//    @Override
//    public InteractionResult onBlockActivated(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
//        Item item = player.getMainHandItem().getItem();
//        if (player.getMainHandItem().getItem() instanceof DyeItem) {
//            worldIn.setBlock(pos, NitorBlock.);
//            worldIn.setBlockState(pos, state.with(color, ((DyeItem) item).getDyeColor().getId()));
//        }
//        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
//    }
//
//    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
//        builder.add(color);
//    }
//}
