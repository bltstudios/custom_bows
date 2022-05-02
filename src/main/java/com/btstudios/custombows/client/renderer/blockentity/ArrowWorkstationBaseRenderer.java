package com.btstudios.custombows.client.renderer.blockentity;

import com.btstudios.custombows.blocks.entity.ArrowWorkstationBaseEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

public class ArrowWorkstationBaseRenderer implements BlockEntityRenderer<ArrowWorkstationBaseEntity> {
    @Override
    public void render(ArrowWorkstationBaseEntity entity, float p_112308_, PoseStack poseStack, MultiBufferSource mbSource, int p_112311_, int p_112312_) {
        ItemStack head = entity.itemHandler.getStackInSlot(0);
        ItemStack shaft = entity.itemHandler.getStackInSlot(1);
        ItemStack binding = entity.itemHandler.getStackInSlot(2);
        ItemStack feather = entity.itemHandler.getStackInSlot(3);

        DrawItems(head, shaft, binding, feather, 0, 0, p_112311_, p_112312_, poseStack, mbSource);
    }

    private boolean DrawItems(ItemStack head, ItemStack shaft, ItemStack binding, ItemStack feathers, int connect, int maxConnect, int un_int1, int un_int2, PoseStack poseStack, MultiBufferSource mbSource) {
        ItemRenderer rend = Minecraft.getInstance().getItemRenderer();
        rend.renderStatic(head, ItemTransforms.TransformType.GROUND, un_int1, un_int2, poseStack, mbSource, 0);
        rend.renderStatic(shaft, ItemTransforms.TransformType.GROUND, un_int1, un_int2, poseStack, mbSource, 1);
        rend.renderStatic(binding, ItemTransforms.TransformType.GROUND, un_int1, un_int2, poseStack, mbSource, 2);
        rend.renderStatic(feathers, ItemTransforms.TransformType.GROUND, un_int1, un_int2, poseStack, mbSource, 3);

        return true;
    }
}
