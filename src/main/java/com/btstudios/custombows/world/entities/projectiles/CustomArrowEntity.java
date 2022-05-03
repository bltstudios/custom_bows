package com.btstudios.custombows.world.entities.projectiles;

import com.btstudios.custombows.init.ModItems;
import com.btstudios.custombows.init.ModEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

public class CustomArrowEntity extends AbstractArrow {

    private final Item refItem;

    public CustomArrowEntity(EntityType<? extends AbstractArrow> type, Level world) {
        super(type, world);
        this.refItem = ModItems.TORCH_ARROW.get();
    }

    public CustomArrowEntity(LivingEntity pShooter, Level world, Item refItem) {
        super(ModEntityType.CUSTOM_ARROW.get(), pShooter, world);
        this.refItem = refItem;
    }

    @Override
    protected void onHitEntity(EntityHitResult entity) {
        super.onHitEntity(entity);
        entity.getEntity().setSecondsOnFire(15);


    }

    @Override
    protected void onHitBlock(BlockHitResult block) {
        super.onHitBlock(block);
        Direction face = block.getDirection();
        BlockPos pos = block.getBlockPos();
        boolean isAir = this.level.getBlockState(pos).isAir();

        if(face == Direction.DOWN || !isAir) {
            ItemEntity torch = new ItemEntity(this.level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.TORCH));
            level.addFreshEntity(torch);
        }
        else if(face == Direction.UP) {
            BlockState state = Blocks.WALL_TORCH.defaultBlockState();

            level.setBlockAndUpdate(pos, state);
        }

    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(this.refItem);
    }
}
