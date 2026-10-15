package net.mcreator.butchery.client.renderer;

import net.mcreator.butchery.client.model.Modelender_dragon;
import net.mcreator.butchery.entity.DragonEntity;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

public class DragonRenderer extends MobRenderer<DragonEntity, LivingEntityRenderState, Modelender_dragon> {
   private DragonEntity entity = null;

   public DragonRenderer(Context context) {
      super(context, new Modelender_dragon(context.bakeLayer(Modelender_dragon.LAYER_LOCATION)), 0.5F);
   }

   public LivingEntityRenderState createRenderState() {
      return new LivingEntityRenderState();
   }

   public void extractRenderState(DragonEntity entity, LivingEntityRenderState state, float partialTicks) {
      super.extractRenderState(entity, state, partialTicks);
      this.entity = entity;
   }

   public Identifier getTextureLocation(LivingEntityRenderState state) {
      return Identifier.parse("butchery:textures/entities/end_dragon.png");
   }
}
