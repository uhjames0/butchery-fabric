package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModItems;
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
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

public class SculkbonemealrightclickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ButcheryModItems.SCULKBONEMEAL.get()) {
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == Blocks.GRASS_BLOCK) {
               if (Math.random() < 0.2) {
                  BlockPos _bp = BlockPos.containing(x, y, z);
                  BlockState _bs = Blocks.SCULK.defaultBlockState();
                  BlockState _bso = world.getBlockState(_bp);

                  for (Property<?> _propertyOld : _bso.getProperties()) {
                     Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
                     if (_propertyNew != null && _bs.getValue(_propertyNew) != null) {
                        try {
                           _bs = (BlockState)_bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
                        } catch (Exception var18) {
                        }
                     }
                  }

                  world.setBlock(_bp, _bs, 3);
               }

               if (entity instanceof LivingEntity _entity) {
                  _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
               }

               if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                  ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.SCULKBONEMEAL.get());
                  _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
               }

               if (world instanceof ServerLevel _level) {
                  _level.sendParticles(ParticleTypes.SCRAPE, x + 0.5, y + 1.5, z + 0.5, 15, 0.4, 0.3, 0.4, 0.02);
               }

               if (world instanceof Level _level) {
                  if (!_level.isClientSide()) {
                     _level.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.sculk.spread")),
                        SoundSource.NEUTRAL,
                        1.0F,
                        1.0F
                     );
                  } else {
                     _level.playLocalSound(
                        x,
                        y,
                        z,
                        (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.sculk.spread")),
                        SoundSource.NEUTRAL,
                        1.0F,
                        1.0F,
                        false
                     );
                  }
               }
            }
         } else if ((entity instanceof LivingEntity _livEntx ? _livEntx.getOffhandItem() : ItemStack.EMPTY).getItem() == ButcheryModItems.SCULKBONEMEAL.get()
            && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == Blocks.GRASS_BLOCK) {
            if (Math.random() < 0.2) {
               BlockPos _bp = BlockPos.containing(x, y, z);
               BlockState _bs = Blocks.SCULK.defaultBlockState();
               BlockState _bso = world.getBlockState(_bp);

               for (Property<?> _propertyOldx : _bso.getProperties()) {
                  Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOldx.getName());
                  if (_propertyNew != null && _bs.getValue(_propertyNew) != null) {
                     try {
                        _bs = (BlockState)_bs.setValue(_propertyNew, _bso.getValue(_propertyOldx));
                     } catch (Exception var17) {
                     }
                  }
               }

               world.setBlock(_bp, _bs, 3);
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.OFF_HAND, SwingAnimation.DEFAULT, true);
            }

            if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
               ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.SCULKBONEMEAL.get());
               _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
            }

            if (world instanceof ServerLevel _levelx) {
               _levelx.sendParticles(ParticleTypes.SCRAPE, x + 0.5, y + 1.5, z + 0.5, 15, 0.4, 0.3, 0.4, 0.02);
            }

            if (world instanceof Level _levelx) {
               if (!_levelx.isClientSide()) {
                  _levelx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.sculk.spread")),
                     SoundSource.NEUTRAL,
                     1.0F,
                     1.0F
                  );
               } else {
                  _levelx.playLocalSound(
                     x,
                     y,
                     z,
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.sculk.spread")),
                     SoundSource.NEUTRAL,
                     1.0F,
                     1.0F,
                     false
                  );
               }
            }
         }
      }
   }
}
