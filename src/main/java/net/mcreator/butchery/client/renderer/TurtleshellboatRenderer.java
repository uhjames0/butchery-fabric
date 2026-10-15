package net.mcreator.butchery.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.mcreator.butchery.client.model.Modelshell_boat;
import net.mcreator.butchery.entity.TurtleshellboatEntity;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

public class TurtleshellboatRenderer extends MobRenderer<TurtleshellboatEntity, LivingEntityRenderState, Modelshell_boat> {
   private TurtleshellboatEntity entity = null;

   public TurtleshellboatRenderer(Context context) {
      super(context, new Modelshell_boat(context.bakeLayer(Modelshell_boat.LAYER_LOCATION)), 0.0F);
   }

   public LivingEntityRenderState createRenderState() {
      return new LivingEntityRenderState();
   }

   public void extractRenderState(TurtleshellboatEntity entity, LivingEntityRenderState state, float partialTicks) {
      super.extractRenderState(entity, state, partialTicks);
      this.entity = entity;
   }

   public Identifier getTextureLocation(LivingEntityRenderState state) {
      return Identifier.parse("butchery:textures/entities/turtle_drained.png");
   }

   protected void scale(LivingEntityRenderState state, PoseStack poseStack) {
      poseStack.scale(1.1F, 1.1F, 1.1F);
   }
}
