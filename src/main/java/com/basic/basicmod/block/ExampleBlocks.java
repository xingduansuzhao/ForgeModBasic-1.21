package com.basic.basicmod.block;

import com.basic.basicmod.ExampleMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ExampleBlocks {
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ExampleMod.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MODID);

    // Creates a new Block with the id "examplemod:example_block", combining the namespace and path
    public static final RegistryObject<Block> ANIVERSARIO_STONE = BLOCKS.register("aniversario_stone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.EMERALD)
                    .instrument(NoteBlockInstrument.BELL)
                    .instabreak()
                    .pushReaction(PushReaction.PUSH_ONLY)
                    .lightLevel(param -> 15)
                    .lootFrom(() -> Blocks.DIAMOND_ORE)
                    .emissiveRendering((pState, pLevel, pPos) -> true)
                    .sound(SoundType.METAL)
            ));
    // Creates a new BlockItem with the id "examplemod:example_block", combining the namespace and path
    public static final RegistryObject<Item> ANIVERSARIO_STONE_ITEM = ITEMS.register("aniversario_stone", () -> new BlockItem(ANIVERSARIO_STONE.get(), new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        BLOCKS.register(eventBus);
    }

}
