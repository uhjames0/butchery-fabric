package net.mcreator.butchery.procedures;

import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.shim.ButcheryCaps;
import net.mcreator.butchery.shim.ILevelExtension;
import net.mcreator.butchery.shim.capabilities.FluidHandler;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent.RightClickBlockShim;
import net.mcreator.butchery.shim.fluidcap.IFluidHandler;
import net.mcreator.butchery.shim.fluidcap.IFluidHandler.FluidAction;
import net.mcreator.butchery.shim.itemcap.ItemHandlerHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.Nullable;

public class EmptybasinProcedure {
   public static void onRightClickBlock(RightClickBlockShim event) {
      if (event.getHand() == InteractionHand.MAIN_HAND) {
         execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
      }
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      execute(null, world, x, y, z, entity);
   }

   private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.BASIN.get()) {
         if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.BUCKET) {
            if (getFluidTankLevel(world, BlockPos.containing(x, y, z), 1, null) == 1000) {
               int _value = 0;
               BlockPos _pos = BlockPos.containing(x, y, z);
               BlockState _bs = world.getBlockState(_pos);
               if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                  && _integerProp.getPossibleValues().contains(_value)) {
                  world.setBlock(_pos, (BlockState)_bs.setValue(_integerProp, _value), 3);
               }

               new ILevelExtension(world);
               IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(
                  world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null}
               );
               if (_fluidHandler != null) {
                  _fluidHandler.drain(1000, FluidAction.EXECUTE);
               }

               if (world instanceof Level _level) {
                  if (!_level.isClientSide()) {
                     _level.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.bucket.fill")),
                        SoundSource.NEUTRAL,
                        1.0F,
                        1.0F
                     );
                  } else {
                     _level.playLocalSound(
                        x,
                        y,
                        z,
                        (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.bucket.fill")),
                        SoundSource.NEUTRAL,
                        1.0F,
                        1.0F,
                        false
                     );
                  }
               }

               if (entity instanceof LivingEntity _entity) {
                  _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
               }

               if (entity instanceof Player _player) {
                  ItemStack _stktoremove = new ItemStack(Items.BUCKET);
                  _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
               }

               ButcheryMod.queueServerWork(3, () -> {
                  if (entity instanceof Player _playerx) {
                     ItemStack _setstack = new ItemStack(Items.WATER_BUCKET).copy();
                     _setstack.setCount(1);
                     ItemHandlerHelper.giveItemToPlayer(_playerx, _setstack);
                  }
               });
            }
         } else if ((entity instanceof LivingEntity _livEntx ? _livEntx.getOffhandItem() : ItemStack.EMPTY).getItem() == Items.BUCKET
            && getFluidTankLevel(world, BlockPos.containing(x, y, z), 1, null) == 1000) {
            int _valuex = 0;
            BlockPos _posx = BlockPos.containing(x, y, z);
            BlockState _bsx = world.getBlockState(_posx);
            if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
               && _integerProp.getPossibleValues().contains(_valuex)) {
               world.setBlock(_posx, (BlockState)_bsx.setValue(_integerProp, _valuex), 3);
            }

            new ILevelExtension(world);
            IFluidHandler _fluidHandlerx = (IFluidHandler)ButcheryCaps.getCapability(
               world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null}
            );
            if (_fluidHandlerx != null) {
               _fluidHandlerx.drain(1000, FluidAction.EXECUTE);
            }

            if (world instanceof Level _levelx) {
               if (!_levelx.isClientSide()) {
                  _levelx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.bucket.fill")),
                     SoundSource.NEUTRAL,
                     1.0F,
                     1.0F
                  );
               } else {
                  _levelx.playLocalSound(
                     x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.bucket.fill")), SoundSource.NEUTRAL, 1.0F, 1.0F, false
                  );
               }
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.OFF_HAND, SwingAnimation.DEFAULT, true);
            }

            if (entity instanceof Player _player) {
               ItemStack _stktoremove = new ItemStack(Items.BUCKET);
               _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
            }

            ButcheryMod.queueServerWork(3, () -> {
               if (entity instanceof Player _playerx) {
                  ItemStack _setstack = new ItemStack(Items.WATER_BUCKET).copy();
                  _setstack.setCount(1);
                  ItemHandlerHelper.giveItemToPlayer(_playerx, _setstack);
               }
            });
         }
      }
   }

   private static int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank, Direction direction) {
      new ILevelExtension(level);
      IFluidHandler fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(level, FluidHandler.BLOCK, new Object[]{pos, direction});
      return fluidHandler != null ? fluidHandler.getFluidInTank(tank).getAmount() : 0;
   }
}
