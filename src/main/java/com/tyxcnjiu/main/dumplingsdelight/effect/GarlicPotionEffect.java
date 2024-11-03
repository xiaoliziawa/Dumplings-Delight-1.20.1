package com.tyxcnjiu.main.dumplingsdelight.effect;

import com.tyxcnjiu.main.dumplingsdelight.DumplingsDelight;
import com.tyxcnjiu.main.dumplingsdelight.registry.EffectRegistry;
import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GarlicPotionEffect extends MobEffect {
    public GarlicPotionEffect() {
        super(MobEffectCategory.BENEFICIAL, -4476269);
    }

    @Mod.EventBusSubscriber(modid = DumplingsDelight.MOD_ID)
    public static class EventHandler {
        private static boolean isDumpling(ItemStack itemstack) {
            TagKey<Item> dumplingTag = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("dumplings_delight:dumpling"));
            return itemstack.is(dumplingTag);
        }

        @SubscribeEvent
        public static void onUseItemStart(LivingEntityUseItemEvent.Start event) {
            if (event != null && event.getEntity() != null) {
                Entity entity = event.getEntity();
                ItemStack itemstack = event.getItem();
                if (isDumpling(itemstack)) {
                    // 可以在这里添加开始使用饺子时的逻辑
                }
            }
        }

        @SubscribeEvent
        public static void onUseItemFinish(LivingEntityUseItemEvent.Finish event) {
            if (event != null && event.getEntity() != null) {
                Entity entity = event.getEntity();
                ItemStack itemstack = event.getItem();
                
                if (isDumpling(itemstack) && hasGarlicEffect(entity)) {
                    if (entity instanceof Player player) {
                        player.getFoodData().setFoodLevel(player.getFoodData().getFoodLevel() + 1);
                    }
                }
            }
        }

        private static boolean hasGarlicEffect(Entity entity) {
            if (entity instanceof LivingEntity living) {
                Collection<MobEffectInstance> effects = living.getActiveEffects();
                for (MobEffectInstance effect : effects) {
                    if (effect.getEffect() == EffectRegistry.Garlic.get()) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
