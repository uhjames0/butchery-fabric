package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModItems;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent.RightClickItemShim;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.HitResult.Type;
import org.jetbrains.annotations.Nullable;

public class IceybonemealuseProcedure {
   public static void onRightClickItem(RightClickItemShim event) {
      if (event.getHand() == event.getEntity().getUsedItemHand()) {
         execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
      }
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      execute(null, world, x, y, z, entity);
   }

   private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null
         && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ButcheryModItems.ICEY_BONE_MEAL.get()
         && entity.level()
               .clip(
                  new ClipContext(
                     entity.getEyePosition(1.0F),
                     entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)),
                     Block.OUTLINE,
                     Fluid.SOURCE_ONLY,
                     entity
                  )
               )
               .getType()
            == Type.BLOCK
         && world.getFluidState(
                  new BlockPos(
                     entity.level()
                        .clip(
                           new ClipContext(
                              entity.getEyePosition(1.0F),
                              entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)),
                              Block.OUTLINE,
                              Fluid.SOURCE_ONLY,
                              entity
                           )
                        )
                        .getBlockPos()
                        .getX(),
                     entity.level()
                        .clip(
                           new ClipContext(
                              entity.getEyePosition(1.0F),
                              entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)),
                              Block.OUTLINE,
                              Fluid.SOURCE_ONLY,
                              entity
                           )
                        )
                        .getBlockPos()
                        .getY(),
                     entity.level()
                        .clip(
                           new ClipContext(
                              entity.getEyePosition(1.0F),
                              entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)),
                              Block.OUTLINE,
                              Fluid.SOURCE_ONLY,
                              entity
                           )
                        )
                        .getBlockPos()
                        .getZ()
                  )
               )
               .createLegacyBlock()
               .getBlock()
            == Blocks.WATER) {
         if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof LivingEntity _entity) {
            ItemStack _setstack11 = new ItemStack((ItemLike)ButcheryModItems.ICEY_BONE_MEAL.get()).copy();
            _setstack11.setCount((entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack11);
            if (_entity instanceof Player _player) {
               _player.getInventory().setChanged();
            }
         }

         if (entity instanceof LivingEntity _entityx) {
            _entityx.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
         }

         BlockPos _bp = new BlockPos(
            entity.level()
               .clip(
                  new ClipContext(
                     entity.getEyePosition(1.0F),
                     entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)),
                     Block.OUTLINE,
                     Fluid.SOURCE_ONLY,
                     entity
                  )
               )
               .getBlockPos()
               .getX(),
            entity.level()
               .clip(
                  new ClipContext(
                     entity.getEyePosition(1.0F),
                     entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)),
                     Block.OUTLINE,
                     Fluid.SOURCE_ONLY,
                     entity
                  )
               )
               .getBlockPos()
               .getY(),
            entity.level()
               .clip(
                  new ClipContext(
                     entity.getEyePosition(1.0F),
                     entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)),
                     Block.OUTLINE,
                     Fluid.SOURCE_ONLY,
                     entity
                  )
               )
               .getBlockPos()
               .getZ()
         );
         BlockState _bs = Blocks.ICE.defaultBlockState();
         BlockState _bso = world.getBlockState(_bp);

         for (Property<?> _propertyOld : _bso.getProperties()) {
            Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
            if (_propertyNew != null && _bs.getValue(_propertyNew) != null) {
               try {
                  _bs = (BlockState)_bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
               } catch (Exception var17) {
               }
            }
         }

         world.setBlock(_bp, _bs, 3);
         if (world instanceof ServerLevel _level) {
            _level.sendParticles(
               ParticleTypes.SNOWFLAKE,
               entity.level()
                     .clip(
                        new ClipContext(
                           entity.getEyePosition(1.0F),
                           entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)),
                           Block.OUTLINE,
                           Fluid.NONE,
                           entity
                        )
                     )
                     .getBlockPos()
                     .getX()
                  + 0.5,
               entity.level()
                     .clip(
                        new ClipContext(
                           entity.getEyePosition(1.0F),
                           entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)),
                           Block.OUTLINE,
                           Fluid.NONE,
                           entity
                        )
                     )
                     .getBlockPos()
                     .getY()
                  + 1,
               entity.level()
                     .clip(
                        new ClipContext(
                           entity.getEyePosition(1.0F),
                           entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)),
                           Block.OUTLINE,
                           Fluid.NONE,
                           entity
                        )
                     )
                     .getBlockPos()
                     .getZ()
                  + 0.5,
               15,
               0.4,
               0.1,
               0.4,
               0.02
            );
         }

         if (world instanceof Level _level) {
            if (!_level.isClientSide()) {
               _level.playSound(
                  null,
                  BlockPos.containing(x, y, z),
                  (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:water_freezing")),
                  SoundSource.NEUTRAL,
                  0.3F,
                  1.0F
               );
            } else {
               _level.playLocalSound(
                  x,
                  y,
                  z,
                  (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:water_freezing")),
                  SoundSource.NEUTRAL,
                  0.3F,
                  1.0F,
                  false
               );
            }
         }
      }
   }
}
