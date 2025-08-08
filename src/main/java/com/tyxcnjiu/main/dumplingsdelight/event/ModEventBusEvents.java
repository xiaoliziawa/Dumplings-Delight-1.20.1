package com.tyxcnjiu.main.dumplingsdelight.event;

import com.tyxcnjiu.main.dumplingsdelight.DumplingsDelight;
import com.tyxcnjiu.main.dumplingsdelight.event.loot.CalamariAdditionModifier;
import com.tyxcnjiu.main.dumplingsdelight.registry.ItemRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

@Mod.EventBusSubscriber(modid = DumplingsDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerModifierSerializers(final RegisterEvent event) {
        event.register(
                ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS,
                helper -> {
                    helper.register(new ResourceLocation(DumplingsDelight.MOD_ID, "add_calamari"),
                            CalamariAdditionModifier.CODEC);
                }
        );
    }

    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            // 种子(30%)
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.ChineseCabbageSeeds.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.EggplantSeeds.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.GarlicChiveSeeds.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.FennelSeeds.get(), 0.3f);
            // 作物(65%)
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.ChineseCabbage.get(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.ChineseCabbageLeaf.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.Garlic.get(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.GarlicClove.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.GreenOnion.get(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.Eggplant.get(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.GarlicChive.get(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.Fennel.get(), 0.65f);
        });
    }
}


