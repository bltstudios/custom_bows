package com.btstudios.custombows.client.screen;

import com.btstudios.custombows.CustomBows;
import com.btstudios.custombows.init.ModTags;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ForgeItemTagsProvider;
import org.apache.logging.log4j.core.Logger;
import org.jetbrains.annotations.Debug;

public class ArrowWorkstationBaseScreen extends AbstractContainerScreen<ArrowWorkstationBaseMenu> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(CustomBows.MOD_ID, "textures/gui/arrow_workstation_base_gui_bg.png");

    private static final ResourceLocation HEAD_BUTTON_TEX =
            new ResourceLocation(CustomBows.MOD_ID, "textures/gui/arrow_workstation_base_head_gui.png");

    private static final ResourceLocation SHAFT_BUTTON_TEX =
            new ResourceLocation(CustomBows.MOD_ID, "textures/gui/arrow_workstation_base_head_gui.png");

    private static final ResourceLocation BINDING_BUTTON_TEX =
            new ResourceLocation(CustomBows.MOD_ID, "textures/gui/arrow_workstation_base_head_gui.png");

    private static final ResourceLocation FEATHER_BUTTON_TEX =
            new ResourceLocation(CustomBows.MOD_ID, "textures/gui/arrow_workstation_base_head_gui.png");

    public boolean showInv = false;
    public boolean showHeads = false;
    public boolean showShaft = false;
    public boolean showBinding = false;
    public boolean showFeather = false;

    private ImageButton headButton;
    private ImageButton shaftButton;
    private ImageButton bindingButton;
    private ImageButton featherButton;

    private Inventory pInv;

    public ArrowWorkstationBaseScreen(ArrowWorkstationBaseMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        this.pInv = pPlayerInventory;
    }

    @Override
    protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {

            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.setShaderTexture(0, TEXTURE);
            int x = (width - imageWidth) / 2;
            int y = (height - imageHeight) / 2;

            this.blit(pPoseStack, x, y, 0, 0, imageWidth, imageHeight);

            if (menu.isCrafting()) {
                blit(pPoseStack, x + 102, y + 41, 176, 0, 8, menu.getScaledProgress());
            }

    }

    @Override
    protected void init() {
        super.init();
        this.headButton = addRenderableWidget(
                new ImageButton(ArrowWorkstationBaseMenu.TE_HEAD_SLOT_X, ArrowWorkstationBaseMenu.TE_HEAD_SLOT_Y, ArrowWorkstationBaseMenu.TE_HEAD_SLOT_WIDTH, ArrowWorkstationBaseMenu.TE_HEAD_SLOT_HEIGHT, 0, 0, 0, HEAD_BUTTON_TEX, btn -> {
                    int x = ArrowWorkstationBaseMenu.TE_HEAD_SLOT_X + ArrowWorkstationBaseMenu.TE_HEAD_SLOT_WIDTH;
                    int y = ArrowWorkstationBaseMenu.TE_HEAD_SLOT_Y;
                    int width = ArrowWorkstationBaseMenu.TE_HEAD_SLOT_WIDTH;
                    int height = ArrowWorkstationBaseMenu.TE_HEAD_SLOT_HEIGHT;
                    if(getAllOfType(ModTags.Items.ACCEPTABLE_HEADS, pInv) != null) {
                        for (ItemStack a : getAllOfType(ModTags.Items.ACCEPTABLE_HEADS, pInv)) {
                            renderImageButton(x, y, width, height, 0, 0, 0, HEAD_BUTTON_TEX, a, 0);
                            x += width;
                        }
                    }
                    else {
                        CustomBows.LOGGER.debug("Did not render buttons as inventory was empty");
                    }
                }));

        /*
        this.shaftButton = addRenderableWidget(
                new ImageButton(ArrowWorkstationBaseMenu.TE_SHAFT_SLOT_X, ArrowWorkstationBaseMenu.TE_HEAD_SLOT_Y, ArrowWorkstationBaseMenu.TE_HEAD_SLOT_WIDTH, ArrowWorkstationBaseMenu.TE_HEAD_SLOT_HEIGHT, 0,0,0, SHAFT_BUTTON_TEX, btn -> {
                    showShaft = true;
                    showHeads = false;
                    showBinding = false;
                    showFeather = false;
                    showInv = false;
                }));

        if(showShaft) {
            int x = ArrowWorkstationBaseMenu.TE_SHAFT_SLOT_X + ArrowWorkstationBaseMenu.TE_SHAFT_SLOT_WIDTH;
            int y = ArrowWorkstationBaseMenu.TE_SHAFT_SLOT_Y;
            int width = ArrowWorkstationBaseMenu.TE_SHAFT_SLOT_WIDTH;
            int height = ArrowWorkstationBaseMenu.TE_SHAFT_SLOT_HEIGHT;
            for (ItemStack a: getAllOfType(ACCEPTABLE_SHAFT_TAGS, pInv)) {
                renderImageButton(x, y, width, height, 0,0,0, SHAFT_BUTTON_TEX, a, 1);
                x += width;
            }
        }
        */
    }

    @Override
    public void render(PoseStack pPoseStack, int mouseX, int mouseY, float delta) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, mouseX, mouseY, delta);

        renderTooltip(pPoseStack, mouseX, mouseY);


    }

    protected ImageButton renderImageButton(int x, int y, int width, int height, int startX, int startY, int textStartY, ResourceLocation resLoc, ItemStack itemSelection, int ind) {
        return addRenderableWidget(new ImageButton(x, y, width, height, startX, startY, textStartY, resLoc, btn -> {
            menu.blockEntity.itemHandler.setStackInSlot(ind, itemSelection);
        }));
    }

    protected NonNullList<ItemStack> getAllOfType(TagKey<Item> tagKey, Inventory pInv) {
        NonNullList<ItemStack> items = null;
        String invEmptyCheck = pInv.isEmpty() ? "Empty" : "not Empty";
        CustomBows.LOGGER.debug("pInv is " + invEmptyCheck);
        if(!pInv.isEmpty()) {
            for (ItemStack a : pInv.items) {
                if (Registry.ITEM.getHolderOrThrow(Registry.ITEM.getResourceKey(a.getItem()).get()).is(tagKey)) {
                    items.add(a);
                }
            }
        }
        return items;
    }
}
