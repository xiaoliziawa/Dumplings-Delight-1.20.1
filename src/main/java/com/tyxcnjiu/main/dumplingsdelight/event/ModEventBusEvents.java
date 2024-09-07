package com.tyxcnjiu.main.dumplingsdelight.event;

import com.tyxcnjiu.main.dumplingsdelight.DumplingsDelight;
import com.tyxcnjiu.main.dumplingsdelight.event.loot.CalamariAdditionModifier;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
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
}


