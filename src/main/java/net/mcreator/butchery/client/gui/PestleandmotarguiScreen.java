package net.mcreator.butchery.client.gui;

import net.mcreator.butchery.init.ButcheryModScreens.ScreenAccessor;
import net.mcreator.butchery.procedures.Meatgrinderprogressdisplay2Procedure;
import net.mcreator.butchery.procedures.Meatgrinderprogressdisplay3Procedure;
import net.mcreator.butchery.procedures.Progressbardisplay0Procedure;
import net.mcreator.butchery.procedures.Progressbardisplay1Procedure;
import net.mcreator.butchery.procedures.Progressbardisplay2Procedure;
import net.mcreator.butchery.procedures.Progressbardisplay3Procedure;
import net.mcreator.butchery.procedures.Progressbardisplay4Procedure;
import net.mcreator.butchery.procedures.Progressbardisplay5Procedure;
import net.mcreator.butchery.procedures.Progressbardisplay6Procedure;
import net.mcreator.butchery.procedures.Progressbardisplay7Procedure;
import net.mcreator.butchery.procedures.Progressbardisplay8Procedure;
import net.mcreator.butchery.world.inventory.PestleandmotarguiMenu;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class PestleandmotarguiScreen extends AbstractContainerScreen<PestleandmotarguiMenu> implements ScreenAccessor {
   private final Level world;
   private final int x;
   private final int y;
   private final int z;
   private final Player entity;
   private boolean menuStateUpdateActive = false;
   private static final Identifier texture = Identifier.parse("butchery:textures/screens/pestleandmotargui.png");

   public PestleandmotarguiScreen(PestleandmotarguiMenu container, Inventory inventory, Component text) {
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
         Identifier.parse("butchery:textures/screens/pestleandmotarguibg.png"),
         this.leftPos + 0,
         this.topPos + 0,
         0.0F,
         0.0F,
         176,
         166,
         176,
         166
      );
      if (Progressbardisplay0Procedure.execute(this.world, this.x, this.y, this.z)) {
         guiGraphics.blit(
            RenderPipelines.GUI_TEXTURED,
            Identifier.parse("butchery:textures/screens/progressbardisplay0.png"),
            this.leftPos + 73,
            this.topPos + 60,
            0.0F,
            0.0F,
            32,
            19,
            32,
            19
         );
      }

      if (Progressbardisplay1Procedure.execute(this.world, this.x, this.y, this.z)) {
         guiGraphics.blit(
            RenderPipelines.GUI_TEXTURED,
            Identifier.parse("butchery:textures/screens/progressbardisplay1.png"),
            this.leftPos + 73,
            this.topPos + 60,
            0.0F,
            0.0F,
            32,
            19,
            32,
            19
         );
      }

      if (Progressbardisplay2Procedure.execute(this.world, this.x, this.y, this.z)) {
         guiGraphics.blit(
            RenderPipelines.GUI_TEXTURED,
            Identifier.parse("butchery:textures/screens/progressbardisplay2.png"),
            this.leftPos + 73,
            this.topPos + 60,
            0.0F,
            0.0F,
            32,
            19,
            32,
            19
         );
      }

      if (Progressbardisplay3Procedure.execute(this.world, this.x, this.y, this.z)) {
         guiGraphics.blit(
            RenderPipelines.GUI_TEXTURED,
            Identifier.parse("butchery:textures/screens/progressbardisplay3.png"),
            this.leftPos + 73,
            this.topPos + 60,
            0.0F,
            0.0F,
            32,
            19,
            32,
            19
         );
      }

      if (Progressbardisplay4Procedure.execute(this.world, this.x, this.y, this.z)) {
         guiGraphics.blit(
            RenderPipelines.GUI_TEXTURED,
            Identifier.parse("butchery:textures/screens/progressbardisplay4.png"),
            this.leftPos + 73,
            this.topPos + 60,
            0.0F,
            0.0F,
            32,
            19,
            32,
            19
         );
      }

      if (Progressbardisplay5Procedure.execute(this.world, this.x, this.y, this.z)) {
         guiGraphics.blit(
            RenderPipelines.GUI_TEXTURED,
            Identifier.parse("butchery:textures/screens/progressbardisplay5.png"),
            this.leftPos + 73,
            this.topPos + 60,
            0.0F,
            0.0F,
            32,
            19,
            32,
            19
         );
      }

      if (Progressbardisplay6Procedure.execute(this.world, this.x, this.y, this.z)) {
         guiGraphics.blit(
            RenderPipelines.GUI_TEXTURED,
            Identifier.parse("butchery:textures/screens/progressbardisplay6.png"),
            this.leftPos + 73,
            this.topPos + 60,
            0.0F,
            0.0F,
            32,
            19,
            32,
            19
         );
      }

      if (Progressbardisplay7Procedure.execute(this.world, this.x, this.y, this.z)) {
         guiGraphics.blit(
            RenderPipelines.GUI_TEXTURED,
            Identifier.parse("butchery:textures/screens/progressbardisplay7.png"),
            this.leftPos + 73,
            this.topPos + 60,
            0.0F,
            0.0F,
            32,
            19,
            32,
            19
         );
      }

      if (Progressbardisplay8Procedure.execute(this.world, this.x, this.y, this.z)) {
         guiGraphics.blit(
            RenderPipelines.GUI_TEXTURED,
            Identifier.parse("butchery:textures/screens/progressbardisplay8.png"),
            this.leftPos + 73,
            this.topPos + 60,
            0.0F,
            0.0F,
            32,
            19,
            32,
            19
         );
      }

      if (Progressbardisplay0Procedure.execute(this.world, this.x, this.y, this.z)) {
         guiGraphics.blit(
            RenderPipelines.GUI_TEXTURED,
            Identifier.parse("butchery:textures/screens/pestle_gui_1.png"),
            this.leftPos + 65,
            this.topPos + 25,
            0.0F,
            0.0F,
            42,
            38,
            42,
            38
         );
      }

      if (Progressbardisplay1Procedure.execute(this.world, this.x, this.y, this.z)) {
         guiGraphics.blit(
            RenderPipelines.GUI_TEXTURED,
            Identifier.parse("butchery:textures/screens/pestle_gui_2.png"),
            this.leftPos + 65,
            this.topPos + 25,
            0.0F,
            0.0F,
            42,
            38,
            42,
            38
         );
      }

      if (Meatgrinderprogressdisplay2Procedure.execute(this.world, this.x, this.y, this.z)) {
         guiGraphics.blit(
            RenderPipelines.GUI_TEXTURED,
            Identifier.parse("butchery:textures/screens/pestle_gui_3.png"),
            this.leftPos + 65,
            this.topPos + 25,
            0.0F,
            0.0F,
            42,
            38,
            42,
            38
         );
      }

      if (Meatgrinderprogressdisplay3Procedure.execute(this.world, this.x, this.y, this.z)) {
         guiGraphics.blit(
            RenderPipelines.GUI_TEXTURED,
            Identifier.parse("butchery:textures/screens/pestle_gui_2.png"),
            this.leftPos + 65,
            this.topPos + 25,
            0.0F,
            0.0F,
            42,
            38,
            42,
            38
         );
      }

      if (Progressbardisplay4Procedure.execute(this.world, this.x, this.y, this.z)) {
         guiGraphics.blit(
            RenderPipelines.GUI_TEXTURED,
            Identifier.parse("butchery:textures/screens/pestle_gui_1.png"),
            this.leftPos + 65,
            this.topPos + 25,
            0.0F,
            0.0F,
            42,
            38,
            42,
            38
         );
      }

      if (Progressbardisplay5Procedure.execute(this.world, this.x, this.y, this.z)) {
         guiGraphics.blit(
            RenderPipelines.GUI_TEXTURED,
            Identifier.parse("butchery:textures/screens/pestle_gui_2.png"),
            this.leftPos + 65,
            this.topPos + 25,
            0.0F,
            0.0F,
            42,
            38,
            42,
            38
         );
      }

      if (Progressbardisplay6Procedure.execute(this.world, this.x, this.y, this.z)) {
         guiGraphics.blit(
            RenderPipelines.GUI_TEXTURED,
            Identifier.parse("butchery:textures/screens/pestle_gui_3.png"),
            this.leftPos + 65,
            this.topPos + 25,
            0.0F,
            0.0F,
            42,
            38,
            42,
            38
         );
      }

      if (Progressbardisplay7Procedure.execute(this.world, this.x, this.y, this.z)) {
         guiGraphics.blit(
            RenderPipelines.GUI_TEXTURED,
            Identifier.parse("butchery:textures/screens/pestle_gui_2.png"),
            this.leftPos + 65,
            this.topPos + 25,
            0.0F,
            0.0F,
            42,
            38,
            42,
            38
         );
      }

      if (Progressbardisplay8Procedure.execute(this.world, this.x, this.y, this.z)) {
         guiGraphics.blit(
            RenderPipelines.GUI_TEXTURED,
            Identifier.parse("butchery:textures/screens/pestle_gui_1.png"),
            this.leftPos + 65,
            this.topPos + 25,
            0.0F,
            0.0F,
            42,
            38,
            42,
            38
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
   }

   public void init() {
      super.init();
   }
}
