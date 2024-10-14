package com.tyxcnjiu.main.dumplingsdelight;

import com.mojang.serialization.Codec;
import com.tyxcnjiu.main.dumplingsdelight.event.loot.CalamariAdditionModifier;
import com.tyxcnjiu.main.dumplingsdelight.registry.BlockRegistry;
import com.tyxcnjiu.main.dumplingsdelight.registry.EffectRegistry;
import com.tyxcnjiu.main.dumplingsdelight.registry.ItemRegistry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.Parameter;

@Mod(DumplingsDelight.MOD_ID)
public class DumplingsDelight {
    public static final String MOD_ID = "dumplings_delight";

    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, MOD_ID);

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final RegistryObject<CreativeModeTab> DUMPLINGS_DELIGHT_GROUP = CREATIVE_MODE_TABS.register("dumplings_delight", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.dumplings_delight"))
            .icon(() -> new ItemStack(ItemRegistry.PorkCabbageBoiledDumpling.get()))
            .displayItems((parameters, output) -> {
                ItemRegistry.ITEMS.getEntries().forEach(item -> output.accept(item.get()));
            })
            .build());

    static {
        LOOT_MODIFIER_SERIALIZERS.register("add_calamari", () -> CalamariAdditionModifier.CODEC);
    }

    public DumplingsDelight() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemRegistry.ITEMS.register(modEventBus);
        BlockRegistry.BLOCKS.register(modEventBus);
        EffectRegistry.EFFECTS.register(modEventBus);
        LOOT_MODIFIER_SERIALIZERS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
    }
}
