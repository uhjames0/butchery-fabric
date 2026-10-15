package net.mcreator.butchery.client.gui;

import net.mcreator.butchery.init.ButcheryModScreens.ScreenAccessor;
import net.mcreator.butchery.procedures.MEATGRINDERPROGRESSDEFAULTProcedure;
import net.mcreator.butchery.procedures.Meatgrinderprogressdisplay0Procedure;
import net.mcreator.butchery.procedures.Meatgrinderprogressdisplay1Procedure;
import net.mcreator.butchery.procedures.Meatgrinderprogressdisplay2Procedure;
import net.mcreator.butchery.procedures.Meatgrinderprogressdisplay3Procedure;
import net.mcreator.butchery.procedures.Meatgrinderprogressdisplay4Procedure;
import net.mcreator.butchery.procedures.Meatgrinderprogressdisplay5Procedure;
import net.mcreator.butchery.procedures.Meatgrinderprogressdisplay6Procedure;
import net.mcreator.butchery.procedures.Meatgrinderprogressdisplay7Procedure;
import net.mcreator.butchery.procedures.Meatgrinderprogressdisplay8Procedure;
import net.mcreator.butchery.procedures.Meatgrinderprogressdisplay9Procedure;
import net.mcreator.butchery.world.inventory.MeatgrinderguiMenu;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class MeatgrinderguiScreen extends AbstractContainerScreen<MeatgrinderguiMenu> implements ScreenAccessor {
   private final Level world;
   private final int x;
   private final int y;
   private final int z;
   private final Player entity;
   private boolean menuStateUpdateActive = false;
   private static final Identifier texture = Identifier.parse("butchery:textures/screens/meatgrindergui.png");

   public MeatgrinderguiScreen(MeatgrinderguiMenu container, Inventory inventory, Component text) {
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
         Identifier.parse("butchery:textures/screens/meat_grinder_gui.png"),
         this.leftPos + 0,
         this.topPos + 0,
         0.0F,
         0.0F,
         256,
         256,
         256,
         256
      );
      if (Meatgrinderprogressdisplay0Procedure.execute(this.world, this.x, this.y, this.z)) {
         guiGraphics.blit(
            RenderPipelines.GUI_TEXTURED,
            Identifier.parse("butchery:textures/screens/meat_grinder_0.png"),
            this.leftPos + 67,
            this.topPos + 42,
            0.0F,
            0.0F,
            37,
            27,
            37,
            27
         );
      }

      if (Meatgrinderprogressdisplay1Procedure.execute(this.world, this.x, this.y, this.z)) {
         guiGraphics.blit(
            RenderPipelines.GUI_TEXTURED,
            Identifier.parse("butchery:textures/screens/meat_grinder_1.png"),
            this.leftPos + 67,
            this.topPos + 42,
            0.0F,
            0.0F,
            37,
            27,
            37,
            27
         );
      }

      if (Meatgrinderprogressdisplay2Procedure.execute(this.world, this.x, this.y, this.z)) {
         guiGraphics.blit(
            RenderPipelines.GUI_TEXTURED,
            Identifier.parse("butchery:textures/screens/meat_grinder_2.png"),
            this.leftPos + 67,
            this.topPos + 42,
            0.0F,
            0.0F,
            37,
            27,
            37,
            27
         );
      }

      if (Meatgrinderprogressdisplay3Procedure.execute(this.world, this.x, this.y, this.z)) {
         guiGraphics.blit(
            RenderPipelines.GUI_TEXTURED,
            Identifier.parse("butchery:textures/screens/meat_grinder_3.png"),
            this.leftPos + 67,
            this.topPos + 42,
            0.0F,
            0.0F,
            37,
            27,
            37,
            27
         );
      }

      if (Meatgrinderprogressdisplay4Procedure.execute(this.world, this.x, this.y, this.z)) {
         guiGraphics.blit(
            RenderPipelines.GUI_TEXTURED,
            Identifier.parse("butchery:textures/screens/meat_grinder_4.png"),
            this.leftPos + 67,
            this.topPos + 42,
            0.0F,
            0.0F,
            37,
            27,
            37,
            27
         );
      }

      if (Meatgrinderprogressdisplay5Procedure.execute(this.world, this.x, this.y, this.z)) {
         guiGraphics.blit(
            RenderPipelines.GUI_TEXTURED,
            Identifier.parse("butchery:textures/screens/meat_grinder_5.png"),
            this.leftPos + 67,
            this.topPos + 42,
            0.0F,
            0.0F,
            37,
            27,
            37,
            27
         );
      }

      if (Meatgrinderprogressdisplay6Procedure.execute(this.world, this.x, this.y, this.z)) {
         guiGraphics.blit(
            RenderPipelines.GUI_TEXTURED,
            Identifier.parse("butchery:textures/screens/meat_grinder_6.png"),
            this.leftPos + 67,
            this.topPos + 42,
            0.0F,
            0.0F,
            37,
            27,
            37,
            27
         );
      }

      if (Meatgrinderprogressdisplay7Procedure.execute(this.world, this.x, this.y, this.z)) {
         guiGraphics.blit(
            RenderPipelines.GUI_TEXTURED,
            Identifier.parse("butchery:textures/screens/meat_grinder_7.png"),
            this.leftPos + 67,
            this.topPos + 42,
            0.0F,
            0.0F,
            37,
            27,
            37,
            27
         );
      }

      if (Meatgrinderprogressdisplay8Procedure.execute(this.world, this.x, this.y, this.z)) {
         guiGraphics.blit(
            RenderPipelines.GUI_TEXTURED,
            Identifier.parse("butchery:textures/screens/meat_grinder_8.png"),
            this.leftPos + 67,
            this.topPos + 42,
            0.0F,
            0.0F,
            37,
            27,
            37,
            27
         );
      }

      if (Meatgrinderprogressdisplay9Procedure.execute(this.world, this.x, this.y, this.z)) {
         guiGraphics.blit(
            RenderPipelines.GUI_TEXTURED,
            Identifier.parse("butchery:textures/screens/meat_grinder_9.png"),
            this.leftPos + 67,
            this.topPos + 42,
            0.0F,
            0.0F,
            37,
            27,
            37,
            27
         );
      }

      if (MEATGRINDERPROGRESSDEFAULTProcedure.execute(this.world, this.x, this.y, this.z)) {
         guiGraphics.blit(
            RenderPipelines.GUI_TEXTURED,
            Identifier.parse("butchery:textures/screens/meat_grinder_0.png"),
            this.leftPos + 67,
            this.topPos + 42,
            0.0F,
            0.0F,
            37,
            27,
            37,
            27
         );
      }

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
      guiGraphics.text(this.font, Component.translatable("gui.butchery.meatgrindergui.label_meat_grinder"), 57, 4, -12829636, false);
   }

   public void init() {
      super.init();
   }
}
