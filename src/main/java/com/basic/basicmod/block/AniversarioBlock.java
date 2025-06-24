package com.basic.basicmod.block;

import com.basic.basicmod.ExampleMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

public class AniversarioBlock extends Block implements EntityBlock{
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    protected static final VoxelShape SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 15.9, 16.0);

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ExampleMod.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MODID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ExampleMod.MODID);

    public static final RegistryObject<Block> ANIVERSARIO_BLOCK = BLOCKS.register("aniversario_block",
            () -> new AniversarioBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.EMERALD)
                    .instrument(NoteBlockInstrument.BELL)
                    .instabreak()
                    .pushReaction(PushReaction.PUSH_ONLY)
                    .lightLevel(param -> 15)
                    .lootFrom(() -> Blocks.DIAMOND_ORE)
                    .emissiveRendering((pState, pLevel, pPos) -> true)
                    .sound(SoundType.METAL)
            ));

    public static final RegistryObject<Item> ANIVERSARIO_BLOCK_ITEM = ITEMS.register("aniversario_block", () -> new BlockItem(ANIVERSARIO_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<BlockEntityType<AniversarioBlockEntity>> ANIVERSARIO_BLOCK_ENTITY = BLOCK_ENTITIES.register("aniversario_block_entity",
            () -> BlockEntityType.Builder.of(AniversarioBlockEntity::new, ANIVERSARIO_BLOCK.get()).build(null));

    public AniversarioBlock(Properties p_49795_) {
        super(p_49795_);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH));
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        BLOCKS.register(eventBus);
        BLOCK_ENTITIES.register(eventBus);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new AniversarioBlockEntity(pPos, pState);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
//        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(FACING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
//        return super.getStateForPlacement(pContext);
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }
}
