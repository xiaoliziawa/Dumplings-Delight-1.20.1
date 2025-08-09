package com.tyxcnjiu.main.dumplingsdelight.registry;

import com.tyxcnjiu.main.dumplingsdelight.DumplingsDelight;
import com.tyxcnjiu.main.dumplingsdelight.item.FoodList;
import com.tyxcnjiu.main.dumplingsdelight.item.GarlicItem;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DumplingsDelight.MOD_ID);

    //Crate
    public static final RegistryObject<Item> ChineseCabbageCrate = ITEMS.register("chinese_cabbage_crate",
            ()-> new BlockItem(BlockRegistry.ChineseCabbageCrate.get(), new Item.Properties()));
    public static final RegistryObject<Item> GarlicCrate = ITEMS.register("garlic_crate",
            ()-> new BlockItem(BlockRegistry.GarlicCrate.get(), new Item.Properties()));
    public static final RegistryObject<Item> GreenOnionCrate = ITEMS.register("greenonion_crate",
            ()-> new BlockItem(BlockRegistry.GreenOnionCrate.get(), new Item.Properties()));
    public static final RegistryObject<Item> EggplantCrate = ITEMS.register("eggplant_crate",
            ()-> new BlockItem(BlockRegistry.EggplantCrate.get(), new Item.Properties()));
    public static final RegistryObject<Item> GarlicChiveCrate = ITEMS.register("garlic_chive_crate",
            ()-> new BlockItem(BlockRegistry.GarlicChiveCrate.get(), new Item.Properties()));
    public static final RegistryObject<Item> FennelCrate = ITEMS.register("fennel_crate",
            ()-> new BlockItem(BlockRegistry.FennelCrate.get(), new Item.Properties()));
    //Feast
    public static final RegistryObject<Item> DumplingMedley = ITEMS.register("dumpling_medley",
            ()-> new BlockItem(BlockRegistry.DumplingMedley.get(), new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> Vinegar = ITEMS.register("vinegar",
            () -> new ConsumableItem(new Item.Properties().stacksTo(1).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> Calamari = ITEMS.register("calamari",
            ()-> new Item(new Item.Properties().food(FoodList.Calamari)));
    //Crops
    public static final RegistryObject<Item> ChineseCabbage = ITEMS.register("chinese_cabbage",
            ()-> new Item(new Item.Properties().food(FoodList.ChineseCabbage)));
    public static final RegistryObject<Item> ChineseCabbageSeeds = ITEMS.register("chinese_cabbage_seeds",
            ()-> new ItemNameBlockItem(BlockRegistry.ChineseCabbages.get(), new Item.Properties()));
    public static final RegistryObject<Item> ChineseCabbageLeaf = ITEMS.register("chinese_cabbage_leaf",
            ()-> new Item(new Item.Properties().food(FoodList.ChineseCabbageLeaf)));
    public static final RegistryObject<Item> Garlic = ITEMS.register("garlic",
            ()-> new GarlicItem(BlockRegistry.Garlic.get(), new Item.Properties().food(FoodList.Garlic), true));
    public static final RegistryObject<Item> GarlicClove = ITEMS.register("garlic_clove",
            ()-> new ConsumableItem(new Item.Properties().food(FoodList.GarlicClove),true));
    public static final RegistryObject<Item> GreenOnion = ITEMS.register("greenonion",
            ()-> new BlockItem(BlockRegistry.GreenOnion.get(), new Item.Properties().food(FoodList.GreenOnion)));
    public static final RegistryObject<Item> Eggplant = ITEMS.register("eggplant",
            ()-> new Item(new Item.Properties().food(FoodList.Eggplant)));
    public static final RegistryObject<Item> EggplantSeeds = ITEMS.register("eggplant_seeds",
            ()-> new ItemNameBlockItem(BlockRegistry.Eggplant.get(), new Item.Properties()));
    public static final RegistryObject<Item> GarlicChive = ITEMS.register("garlic_chive",
            ()-> new Item(new Item.Properties().food(FoodList.GarlicChive)));
    public static final RegistryObject<Item> GarlicChiveSeeds = ITEMS.register("garlic_chive_seeds",
            ()-> new ItemNameBlockItem(BlockRegistry.GarlicChive.get(), new Item.Properties()));
    public static final RegistryObject<Item> Fennel = ITEMS.register("fennel",
            ()-> new Item(new Item.Properties().food(FoodList.Fennel)));
    public static final RegistryObject<Item> FennelSeeds = ITEMS.register("fennel_seeds",
            ()-> new ItemNameBlockItem(BlockRegistry.Fennel.get(), new Item.Properties()));
    //Dumplings
    public static final RegistryObject<Item> PorkCabbageBoiledDumpling = ITEMS.register("pork_cabbage_boiled_dumpling",
            () -> new Item(new Item.Properties().food(FoodList.PorkCabbageBoiledDumpling)));
    public static final RegistryObject<Item> PorkKelpBoiledDumpling = ITEMS.register("pork_kelp_boiled_dumpling",
            () -> new Item(new Item.Properties().food(FoodList.PorkKelpBoiledDumpling)));
    public static final RegistryObject<Item> PorkPotatoBoiledDumpling = ITEMS.register("pork_potato_boiled_dumpling",
            () -> new Item(new Item.Properties().food(FoodList.PorkPotatoBoiledDumpling)));
    public static final RegistryObject<Item> PorkFennelBoiledDumpling= ITEMS.register("pork_fennel_boiled_dumpling",
            () -> new Item(new Item.Properties().food(FoodList.PorkFennelBoiledDumpling)));
    public static final RegistryObject<Item> TomatoEggBoiledDumpling = ITEMS.register("tomato_egg_boiled_dumpling",
            () -> new Item(new Item.Properties().food(FoodList.TomatoEggBoiledDumpling)));
    public static final RegistryObject<Item> BeefTomatoBoiledDumpling = ITEMS.register("beef_tomato_boiled_dumpling",
            () -> new Item(new Item.Properties().food(FoodList.BeefTomatoBoiledDumpling)));
    public static final RegistryObject<Item> MuttonBoiledDumpling = ITEMS.register("mutton_boiled_dumpling",
            () -> new Item(new Item.Properties().food(FoodList.MuttonBoiledDumpling)));
    public static final RegistryObject<Item> ChickenMushroomBoiledDumpling = ITEMS.register("chicken_mushroom_boiled_dumpling",
            () -> new Item(new Item.Properties().food(FoodList.ChickenMushroomBoiledDumpling)));
    public static final RegistryObject<Item> CodBoiledDumpling = ITEMS.register("cod_boiled_dumpling",
            () -> new Item(new Item.Properties().food(FoodList.CodBoiledDumpling)));
    public static final RegistryObject<Item> SalmonBoiledDumpling = ITEMS.register("salmon_boiled_dumpling",
            () -> new Item(new Item.Properties().food(FoodList.SalmonBoiledDumpling)));
    public static final RegistryObject<Item> EggplantEggBoiledDumpling = ITEMS.register("eggplant_egg_boiled_dumpling",
            () -> new Item(new Item.Properties().food(FoodList.EggplantEggBoiledDumpling)));
    public static final RegistryObject<Item> MushroomBoiledDumpling = ITEMS.register("mushroom_boiled_dumpling",
            () -> new Item(new Item.Properties().food(FoodList.MushroomBoiledDumpling)));
    public static final RegistryObject<Item> FungusBoiledDumpling = ITEMS.register("fungus_boiled_dumpling",
            () -> new Item(new Item.Properties().food(FoodList.FungusBoiledDumpling)));
    public static final RegistryObject<Item> CalamariBoiledDumpling = ITEMS.register("calamari_boiled_dumpling",
            () -> new Item(new Item.Properties().food(FoodList.CalamariBoiledDumpling)));
    public static final RegistryObject<Item> GarlicChiveEggBoiledDumpling = ITEMS.register("garlic_chive_egg_boiled_dumpling",
            () -> new Item(new Item.Properties().food(FoodList.GarlicChiveEggBoiledDumpling)));
    public static final RegistryObject<Item> DandelionLeafBoiledDumpling = ITEMS.register("dandelion_leaf_boiled_dumpling",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.DandelionLeafBoiledDumpling), true));
    public static final RegistryObject<Item> PufferfishBoiledDumpling = ITEMS.register("pufferfish_boiled_dumpling",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.PufferfishBoiledDumpling), true));
    public static final RegistryObject<Item> RabbitMeatBoiledDumpling = ITEMS.register("rabbit_meat_boiled_dumpling",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.RabbitMeatBoiledDumpling), true));

    //Wonton
    public static final RegistryObject<Item> PorkCarrotWonton = ITEMS.register("pork_carrot_wonton",
            () -> new ConsumableItem(new Item.Properties().craftRemainder(Items.BOWL).stacksTo(16).food(FoodList.PorkCarrotWonton)));
    public static final RegistryObject<Item> PorkMushroomWonton = ITEMS.register("pork_mushroom_wonton",
            () -> new ConsumableItem(new Item.Properties().craftRemainder(Items.BOWL).stacksTo(16).food(FoodList.PorkMushroomWonton)));
    public static final RegistryObject<Item> PorkCabbageWonton = ITEMS.register("pork_cabbage_wonton",
            () -> new ConsumableItem(new Item.Properties().craftRemainder(Items.BOWL).stacksTo(16).food(FoodList.PorkCabbageWonton)));
}
