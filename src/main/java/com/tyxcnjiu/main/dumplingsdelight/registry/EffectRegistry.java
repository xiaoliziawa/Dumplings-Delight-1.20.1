package com.tyxcnjiu.main.dumplingsdelight.registry;

import com.tyxcnjiu.main.dumplingsdelight.DumplingsDelight;
import com.tyxcnjiu.main.dumplingsdelight.effect.GarlicPotionEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EffectRegistry {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, DumplingsDelight.MOD_ID);

    public static final RegistryObject<MobEffect> Garlic = EFFECTS.register("garlic",
            GarlicPotionEffect::new);
}
