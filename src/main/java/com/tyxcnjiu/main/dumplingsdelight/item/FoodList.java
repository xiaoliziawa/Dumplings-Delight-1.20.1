package com.tyxcnjiu.main.dumplingsdelight.item;

import com.tyxcnjiu.main.dumplingsdelight.registry.EffectRegistry;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

public class FoodList {
    public static final FoodProperties PorkCabbageBoiledDumpling = new FoodProperties.Builder().nutrition(8).saturationMod(0.9F).build();
    public static final FoodProperties PorkCarrotWonton = new FoodProperties.Builder().nutrition(17).saturationMod(0.5F).build();
    public static final FoodProperties PorkMushroomWonton = new FoodProperties.Builder().nutrition(16).saturationMod(0.6F).build();
    public static final FoodProperties PorkCabbageWonton = new FoodProperties.Builder().nutrition(12).saturationMod(0.8F).build();
    public static final FoodProperties FungusBoiledDumpling = new FoodProperties.Builder().nutrition(6).saturationMod(0.7F).build();
    public static final FoodProperties PorkKelpBoiledDumpling = new FoodProperties.Builder().nutrition(7).saturationMod(0.8F).build();
    public static final FoodProperties CalamariBoiledDumpling = new FoodProperties.Builder().nutrition(7).saturationMod(0.8F).build();
    public static final FoodProperties DandelionLeafBoiledDumpling = new FoodProperties.Builder().nutrition(5).saturationMod(0.7F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 3*20, 0), 1).build();
    public static final FoodProperties PufferfishBoiledDumpling = new FoodProperties.Builder().nutrition(5).saturationMod(0.7F).effect(() -> new MobEffectInstance(MobEffects.POISON, 3*20, 0), 0.01F).effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 3*20, 0), 1).build();
    public static final FoodProperties RabbitMeatBoiledDumpling = new FoodProperties.Builder().nutrition(5).saturationMod(0.7F).effect(() -> new MobEffectInstance(MobEffects.JUMP, 15*20, 0), 1).build();
    public static final FoodProperties TomatoEggBoiledDumpling = new FoodProperties.Builder().nutrition(6).saturationMod(0.7F).build();
    public static final FoodProperties MuttonBoiledDumpling = new FoodProperties.Builder().nutrition(6).saturationMod(0.7F).build();
    public static final FoodProperties BeefTomatoBoiledDumpling = new FoodProperties.Builder().nutrition(8).saturationMod(0.9F).build();
    public static final FoodProperties ChickenMushroomBoiledDumpling = new FoodProperties.Builder().nutrition(7).saturationMod(0.8F).build();
    public static final FoodProperties MushroomBoiledDumpling = new FoodProperties.Builder().nutrition(6).saturationMod(0.7F).build();
    public static final FoodProperties CodBoiledDumpling = new FoodProperties.Builder().nutrition(6).saturationMod(0.7F).build();
    public static final FoodProperties PorkPotatoBoiledDumpling = new FoodProperties.Builder().nutrition(10).saturationMod(0.6F).build();
    public static final FoodProperties SalmonBoiledDumpling = new FoodProperties.Builder().nutrition(5).saturationMod(0.7F).build();
    public static final FoodProperties EggplantEggBoiledDumpling = new FoodProperties.Builder().nutrition(6).saturationMod(0.7F).build();
    public static final FoodProperties GarlicClove = new FoodProperties.Builder().nutrition(0).saturationMod(0).effect(() -> new MobEffectInstance(EffectRegistry.Garlic.get(), 18*20, 0), 1).alwaysEat().build();
    public static final FoodProperties Calamari = new FoodProperties.Builder().nutrition(1).saturationMod(0.4F).build();
    public static final FoodProperties ChineseCabbage = new FoodProperties.Builder().nutrition(3).saturationMod(0.2F).build();
    public static final FoodProperties ChineseCabbageLeaf = new FoodProperties.Builder().nutrition(1).saturationMod(0.4F).build();
    public static final FoodProperties Garlic = new FoodProperties.Builder().nutrition(1).saturationMod(0.2F).effect(() -> new MobEffectInstance(EffectRegistry.Garlic.get(), 75*20, 0), 1).alwaysEat().build();
    public static final FoodProperties GreenOnion = new FoodProperties.Builder().nutrition(1).saturationMod(0.2F).build();
    public static final FoodProperties Eggplant = new FoodProperties.Builder().nutrition(2).saturationMod(0.2F).build();
    public static final FoodProperties GarlicChive = new FoodProperties.Builder().nutrition(1).saturationMod(0.2F).build();
    public static final FoodProperties Fennel = new FoodProperties.Builder().nutrition(1).saturationMod(0.2F).build();
    public static final FoodProperties GarlicChiveEggBoiledDumpling = new FoodProperties.Builder().nutrition(5).saturationMod(0.7F).build();
    public static final FoodProperties PorkFennelBoiledDumpling = new FoodProperties.Builder().nutrition(6).saturationMod(0.7F).build();
}
