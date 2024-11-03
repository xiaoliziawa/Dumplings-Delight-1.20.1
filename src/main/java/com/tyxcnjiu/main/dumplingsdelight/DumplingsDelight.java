package com.tyxcnjiu.main.dumplingsdelight;

import com.mojang.serialization.Codec;
import com.tyxcnjiu.main.dumplingsdelight.event.loot.CalamariAdditionModifier;
import com.tyxcnjiu.main.dumplingsdelight.registry.BlockRegistry;
import com.tyxcnjiu.main.dumplingsdelight.registry.EffectRegistry;
import com.tyxcnjiu.main.dumplingsdelight.registry.ItemRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(DumplingsDelight.MOD_ID)
public class DumplingsDelight {
    public static final String MOD_ID = "dumplings_delight";

    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, MOD_ID);

    public static final CreativeModeTab DUMPLINGS_DELIGHT_TAB = new CreativeModeTab("dumplings_delight") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.PorkCabbageBoiledDumpling.get());
        }

        @Override
        public String getRecipeFolderName() {
            return "dumplings_delight";
        }

        @Override
        public Component getDisplayName() {
            return Component.translatable("itemGroup.dumplings_delight");
        }
    };

    static {
        LOOT_MODIFIER_SERIALIZERS.register("add_calamari", () -> CalamariAdditionModifier.CODEC);
    }

    public DumplingsDelight() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // 注册所有注册表
        ItemRegistry.ITEMS.register(modEventBus);
        BlockRegistry.BLOCKS.register(modEventBus);
        EffectRegistry.EFFECTS.register(modEventBus);
        LOOT_MODIFIER_SERIALIZERS.register(modEventBus);
    }
}
