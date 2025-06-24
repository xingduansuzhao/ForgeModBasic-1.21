package com.basic.basicmod.tab;

import com.basic.basicmod.ExampleMod;
import com.basic.basicmod.block.AniversarioBlock;
import com.basic.basicmod.block.ExampleBlocks;
import com.basic.basicmod.item.ExampleItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ExampleCreativeModeTabs {
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExampleMod.MODID);

    // Creates a creative tab with the id "examplemod:example_tab" for the example item, that is placed after the combat tab
    public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .title(Component.translatable("creativetab.basicmod.example_tab"))
            .icon(() -> new ItemStack(ExampleItems.MEDALLA_ANIVERSARIO.get()))
            .withSearchBar()
            .displayItems((parameters, output) -> {
                output.accept(ExampleItems.MEDALLA_ANIVERSARIO.get());
                output.accept(ExampleBlocks.ANIVERSARIO_STONE_ITEM.get());
                output.accept(AniversarioBlock.ANIVERSARIO_BLOCK_ITEM.get());
            }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
