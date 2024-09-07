package com.tyxcnjiu.main.dumplingsdelight.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.stats.Stats;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import vectorwing.farmersdelight.common.utility.TextUtils;

import javax.annotation.Nullable;
import java.util.List;

public class GarlicItem extends BlockItem {
    private final boolean hasFoodEffectTooltip;
    private final boolean hasCustomTooltip;

    public GarlicItem(Block block, Item.Properties properties) {
        super(block, properties);
        this.hasFoodEffectTooltip = false;
        this.hasCustomTooltip = false;
    }

    public GarlicItem(Block block, Item.Properties properties, boolean hasFoodEffectTooltip) {
        super(block, properties);
        this.hasFoodEffectTooltip = hasFoodEffectTooltip;
        this.hasCustomTooltip = false;
    }

    public GarlicItem(Block block, Item.Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
        super(block, properties);
        this.hasFoodEffectTooltip = hasFoodEffectTooltip;
        this.hasCustomTooltip = hasCustomTooltip;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity consumer) {
        if (!level.isClientSide) {
            this.affectConsumer(stack, level, consumer);
        }

        ItemStack containerStack = stack.getCraftingRemainingItem();
        Player player = consumer instanceof Player ? (Player) consumer : null;

        if (stack.isEdible()) {
            super.finishUsingItem(stack, level, consumer);
        } else {
            if (player instanceof ServerPlayer) {
                CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer) player, stack);
            }

            if (player != null) {
                player.awardStat(Stats.ITEM_USED.get(this));
                if (!player.getAbilities().instabuild) {
                    stack.shrink(1);
                }
            }
        }

        if (stack.isEmpty()) {
            return containerStack;
        } else {
            if (player != null && !player.getAbilities().instabuild) {
                if (!player.getInventory().add(containerStack)) {
                    player.drop(containerStack, false);
                }
            }

            return stack;
        }
    }

    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flagIn) {
        if (this.hasCustomTooltip) {
            Component textEmpty = Component.translatable("tooltip." + this.getDescriptionId());
            tooltip.add((Component) textEmpty.getStyle().withColor(ChatFormatting.BLUE));
        }

        if (this.hasFoodEffectTooltip) {
            TextUtils.addFoodEffectTooltip(stack, tooltip, 1.0F);
        }
    }
}
