package com.tyxcnjiu.main.dumplingsdelight.registry;

import com.tyxcnjiu.main.dumplingsdelight.DumplingsDelight;
import com.tyxcnjiu.main.dumplingsdelight.block.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DumplingsDelight.MOD_ID);

    public static final RegistryObject<Block> ChineseCabbages = BLOCKS.register("chinese_cabbages",
            () -> new ChineseCabbageBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> Garlic = BLOCKS.register("garlic",
            () -> new GarlicBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> GreenOnion = BLOCKS.register("greenonion",
            () -> new GreenOnionBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> Eggplant = BLOCKS.register("eggplant",
            () -> new EggplantBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> GarlicChive = BLOCKS.register("garlic_chive",
            () -> new GarlicChiveBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> Fennel = BLOCKS.register("fennel",
            () -> new FennelBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> ChineseCabbageCrate = BLOCKS.register("chinese_cabbage_crate",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> GarlicCrate = BLOCKS.register("garlic_crate",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> GreenOnionCrate = BLOCKS.register("greenonion_crate",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> EggplantCrate = BLOCKS.register("eggplant_crate",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> GarlicChiveCrate = BLOCKS.register("garlic_chive_crate",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> FennelCrate = BLOCKS.register("fennel_crate",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> DumplingMedley = BLOCKS.register("dumpling_medley",
            () -> new DumplingMedleyBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL), true));

    public static void registerBlockItems(DeferredRegister<Item> items) {
        items.register("chinese_cabbage_crate", 
            () -> new BlockItem(ChineseCabbageCrate.get(),
                new Item.Properties().tab(DumplingsDelight.DUMPLINGS_DELIGHT_TAB)));
    }
}
