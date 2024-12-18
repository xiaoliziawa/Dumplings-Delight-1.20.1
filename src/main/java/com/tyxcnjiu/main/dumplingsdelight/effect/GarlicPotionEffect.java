package com.tyxcnjiu.main.dumplingsdelight.effect;

import com.tyxcnjiu.main.dumplingsdelight.registry.EffectRegistry;
import net.minecraft.core.registries.Registries;
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
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GarlicPotionEffect extends MobEffect {
    public GarlicPotionEffect() {
        super(MobEffectCategory.BENEFICIAL, -4476269);
    }

    public static class StartEat {
        @Mod.EventBusSubscriber
        private static class GlobalTrigger {
            @SubscribeEvent
            public static void onUseItemStart(LivingEntityUseItemEvent.Start event) {
                if (event != null && event.getEntity() != null) {
                    Entity entity = event.getEntity();
                    double i = entity.getX();
                    double j = entity.getY();
                    double k = entity.getZ();
                    double duration = event.getDuration();
                    ItemStack itemstack = event.getItem();
                    Level world = entity.level();
                    Map<String, Object> dependencies = new HashMap<>();
                    dependencies.put("x", i);
                    dependencies.put("y", j);
                    dependencies.put("z", k);
                    dependencies.put("itemstack", itemstack);
                    dependencies.put("duration", duration);
                    dependencies.put("world", world);
                    dependencies.put("entity", entity);
                    dependencies.put("event", event);
                    isDumpling(dependencies);
                }
            }

            private static boolean isDumpling(Map<String, Object> dependencies) {
                ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
                TagKey<Item> dumplingTag = TagKey.create(Registries.ITEM, new ResourceLocation("dumplings_delight:dumpling"));
                return itemstack.is(dumplingTag);
            }

        }
    }

    public static class Finish {
        @Mod.EventBusSubscriber
        private static class GlobalTrigger {
            @SubscribeEvent
            public static void onUseItemStart(LivingEntityUseItemEvent.Finish event) {
                if (event != null && event.getEntity() != null) {
                    Entity entity = event.getEntity();
                    double i = entity.getX();
                    double j = entity.getY();
                    double k = entity.getZ();
                    double duration = event.getDuration();
                    ItemStack itemstack = event.getItem();
                    Level world = entity.level();
                    Map<String, Object> dependencies = new HashMap<>();
                    dependencies.put("x", i);
                    dependencies.put("y", j);
                    dependencies.put("z", k);
                    dependencies.put("itemstack", itemstack);
                    dependencies.put("duration", duration);
                    dependencies.put("world", world);
                    dependencies.put("entity", entity);
                    dependencies.put("event", event);
                    WithGarlicPotion(dependencies);
                }
            }

            public static void WithGarlicPotion(Map<String, Object> dependencies) {
                Entity entity = (Entity) dependencies.get("entity");
                ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
                if (GarlicPotionEffect.StartEat.GlobalTrigger.isDumpling(dependencies) && new Object() {
                    boolean check(Entity _entity) {
                        if (_entity instanceof LivingEntity) {
                            Collection<MobEffectInstance> effects = ((LivingEntity) _entity).getActiveEffects();
                            for (MobEffectInstance effect : effects) {
                                if (effect.getEffect() == EffectRegistry.Garlic.get())
                                    return true;
                            }
                        }
                        return false;
                    }
                }.check(entity)) {
                    if (entity instanceof Player player)
                        player.getFoodData().setFoodLevel(player.getFoodData().getFoodLevel() + 1);
                }
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
