package com.btstudios.custombows.blocks.container;

import com.btstudios.custombows.blocks.entity.ArrowWorkstationBaseEntity;
import com.btstudios.custombows.init.ModBlocks;
import com.btstudios.custombows.init.ModContainers;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuConstructor;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ArrowWorkstationBaseContainer extends AbstractContainerMenu {
    private final ContainerLevelAccess containerLevelAccess;

    public ArrowWorkstationBaseContainer(int id, Inventory playerInv) {
        this(id, playerInv, new ItemStackHandler(5), BlockPos.ZERO);
    }

    public ArrowWorkstationBaseContainer(int id, Inventory playerInv, IItemHandler slots, BlockPos pos) {
        super(ModContainers.ARROW_WORKSTATION_BASE.get(), id);
        this.containerLevelAccess = ContainerLevelAccess.create(playerInv.player.level, pos);

        final int slotSizePlus2 = 18, startX = 8, startY = 86, hotbarY = 144, headY = 18, headX = 18, shaftX = 20, shaftY = 20, bindX = 22, bindY = 22, featherX = 24, featherY = 24;

        /*
        for (int row = 0; row < 3; row++) {
            for(int column = 0; column < 9; column++) {
                addSlot(new SlotItemHandler(slots, row * 9 + column, startX + column * slotSizePlus2, inventoryY + row * slotSizePlus2));
            }
        }
        */

        addSlot(new SlotItemHandler(slots, 0, headX, headY));
        addSlot(new SlotItemHandler(slots, 1, shaftX, shaftY));
        addSlot(new SlotItemHandler(slots, 2, bindX, bindY));
        addSlot(new SlotItemHandler(slots, 3, featherX, featherY));

        for (int row = 0; row < 3; row++) {
            for(int column = 0; column < 9; column++) {
                addSlot(new Slot(playerInv, 9 + row * 9 + column, startX + column * slotSizePlus2, startY + row * slotSizePlus2));
            }
        }

        for(int column = 0; column < 9; column++) {
            addSlot(new Slot(playerInv, column, startX + column * slotSizePlus2, hotbarY));
        }
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        var retStack = ItemStack.EMPTY;
        final Slot slot = getSlot(index);
        if(slot.hasItem()) {
            final ItemStack item = slot.getItem();
            retStack = item.copy();
            if(index < 5) {
                if(!moveItemStackTo(item, 5, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            }else if(!moveItemStackTo(item, 0, 5, false)) {
                return ItemStack.EMPTY;
            }

            if(item.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return retStack;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(this.containerLevelAccess, player, ModBlocks.ARROW_WORKSTATION_BASE.get());
    }

    public static MenuConstructor getServerContainer(ArrowWorkstationBaseEntity workstation, BlockPos pos) {
        return (id, playerInv, player) -> new ArrowWorkstationBaseContainer(id, playerInv, workstation.itemHandler, pos);
    }
}
