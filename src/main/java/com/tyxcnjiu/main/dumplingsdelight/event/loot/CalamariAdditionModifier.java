package com.tyxcnjiu.main.dumplingsdelight.event.loot;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;

import javax.annotation.Nonnull;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public class CalamariAdditionModifier extends LootModifier {
    private final Item item;

    protected CalamariAdditionModifier(LootItemCondition[] conditionsIn, Item item) {
        super(conditionsIn);
        this.item = item;
    }

    @Nonnull
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        generatedLoot.add(new ItemStack(item, 1));
        if (context.getRandom().nextFloat() > 0.7) {
            generatedLoot.add(new ItemStack(item, 1));
        }
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }

    public static final Codec<CalamariAdditionModifier> CODEC = RecordCodecBuilder.create(inst ->
            codecStart(inst).and(
                    ForgeRegistries.ITEMS.getCodec().fieldOf("item").forGetter(m -> m.item)
            ).apply(inst, CalamariAdditionModifier::new)
    );
}
