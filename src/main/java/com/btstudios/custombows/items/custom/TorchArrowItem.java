package com.btstudios.custombows.items.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class TorchArrowItem extends ArrowItem {
    public final float damage;

    public TorchArrowItem(Properties builder, float damage) {
        super(builder);
        this.damage = damage;
    }

    @Override
    public AbstractArrow createArrow(Level world, ItemStack pStack, LivingEntity pShooter) {
        Arrow arrow = new Arrow(world, pShooter);
        arrow.setBaseDamage(this.damage);
        arrow.setEffectsFromItem(pStack);
        return arrow;
    }

    @Override
    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.world.entity.player.Player player) {
        int enchant = net.minecraft.world.item.enchantment.EnchantmentHelper.getItemEnchantmentLevel(net.minecraft.world.item.enchantment.Enchantments.INFINITY_ARROWS, bow);
        return enchant <= 0 ? false : this.getClass() == TorchArrowItem.class;
    }
}
