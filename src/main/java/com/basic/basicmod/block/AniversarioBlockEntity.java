package com.basic.basicmod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class AniversarioBlockEntity extends BlockEntity {
    public AniversarioBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(AniversarioBlock.ANIVERSARIO_BLOCK_ENTITY.get(), pPos, pBlockState);
    }
}
