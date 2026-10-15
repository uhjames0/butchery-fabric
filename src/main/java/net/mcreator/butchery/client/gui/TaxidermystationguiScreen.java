package net.mcreator.butchery.client.gui;

import net.mcreator.butchery.init.ButcheryModScreens.ScreenAccessor;
import net.mcreator.butchery.world.inventory.TaxidermystationguiMenu;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class TaxidermystationguiScreen extends AbstractContainerScreen<TaxidermystationguiMenu> implements ScreenAccessor {
   private final Level world;
   private final int x;
   private final int y;
   private final int z;
   private final Player entity;
   private boolean menuStateUpdateActive = false;
   private static final Identifier texture = Identifier.parse("butchery:textures/screens/taxidermystationgui.png");

   public TaxidermystationguiScreen(TaxidermystationguiMenu container, Inventory inventory, Component text) {
      super(container, inventory, text, 176, 166);
      this.world = container.world;
      this.x = container.x;
      this.y = container.y;
      this.z = container.z;
      this.entity = container.entity;
   }

   public void updateMenuState(int elementType, String name, Object elementState) {
      this.menuStateUpdateActive = true;
      this.menuStateUpdateActive = false;
   }

   public void extractRenderState(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
      super.extractRenderState(guiGraphics, mouseX, mouseY, partialTicks);
   }

   public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
      guiGraphics.blit(
         RenderPipelines.GUI_TEXTURED, texture, this.leftPos, this.topPos, 0.0F, 0.0F, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight
      );
      guiGraphics.blit(
         RenderPipelines.GUI_TEXTURED,
         Identifier.parse("butchery:textures/screens/taxidermy_gui.png"),
         this.leftPos + 0,
         this.topPos + 0,
         0.0F,
         0.0F,
         256,
         256,
         256,
         256
      );
      super.extractContents(guiGraphics, mouseX, mouseY, partialTicks);
   }

   public boolean keyPressed(KeyEvent event) {
      if (event.key() == 256) {
         this.minecraft.player.closeContainer();
         return true;
      } else {
         return super.keyPressed(event);
      }
   }

   protected void extractLabels(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY) {
      guiGraphics.text(this.font, Component.translatable("gui.butchery.taxidermystationgui.label_taxidermy_station"), 43, 1, -1, false);
   }

   public void init() {
      super.init();
   }
}
