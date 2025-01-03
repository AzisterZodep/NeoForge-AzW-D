package net.azister.azisterweaponsedeco.client.gui;

import net.azister.azisterweaponsedeco.procedures.CrushItemProcedure;
import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.PlainTextButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.azister.azisterweaponsedeco.world.inventory.CrucherMenu;
import net.azister.azisterweaponsedeco.procedures.CheckCrushItemProcedure;
import net.azister.azisterweaponsedeco.network.CrucherButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CrucherScreen extends AbstractContainerScreen<CrucherMenu> {
	private static final Logger LOGGER = LogManager.getLogger(CrucherScreen.class);
	private final static HashMap<String, Object> guistate = CrucherMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_empty;

	public CrucherScreen(CrucherMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("azisterweaponsedeco:textures/screens/crucher.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 133 && mouseX < leftPos + 157 && mouseY > topPos + 29 && mouseY < topPos + 53)
			guiGraphics.renderTooltip(font, Component.translatable("gui.azisterweaponsedeco.crucher.tooltip_funcionality"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(ResourceLocation.parse("azisterweaponsedeco:textures/screens/crushericon.png"), this.leftPos + 80, this.topPos + 30, 0, 0, 16, 16, 16, 16);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
		button_empty = new PlainTextButton(this.leftPos + 75, this.topPos + 28, 25, 20, Component.translatable("gui.azisterweaponsedeco.crucher.button_empty"), e -> {
			if (CheckCrushItemProcedure.execute(entity)) {
				PacketDistributor.sendToServer(new CrucherButtonMessage(0, x, y, z));
				CrucherButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}, this.font) {
			/*@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible = CheckCrushItemProcedure.execute(entity);
				LOGGER.debug("entity> "+entity+" "+this.visible);
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}*/
		};
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
	}
}
