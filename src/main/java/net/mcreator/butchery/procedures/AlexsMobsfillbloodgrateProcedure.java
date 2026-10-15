package net.mcreator.butchery.procedures;

import java.util.function.Function;
import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModFluids;
import net.mcreator.butchery.shim.ButcheryCaps;
import net.mcreator.butchery.shim.ILevelExtension;
import net.mcreator.butchery.shim.capabilities.FluidHandler;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent.RightClickBlockShim;
import net.mcreator.butchery.shim.fluidcap.FluidStack;
import net.mcreator.butchery.shim.fluidcap.IFluidHandler;
import net.mcreator.butchery.shim.fluidcap.IFluidHandler.FluidAction;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Fluid;
import org.jetbrains.annotations.Nullable;

public class AlexsMobsfillbloodgrateProcedure {
   public static void onRightClickBlock(RightClickBlockShim event) {
      if (event.getHand() == InteractionHand.MAIN_HAND) {
         execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
      }
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      execute(null, world, x, y, z, entity);
   }

   private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null
         && world.getBlockState(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BLOCK, Identifier.parse("butchery_alexs_mobs:regular_carcass")))
         && (
               world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip3
                  ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip3)
                  : -1
            )
            == 1
         && (
            (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                  .is(TagKey.create(Registries.ITEM, Identifier.parse("forge:cleaver")))
               || (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
                  .is(TagKey.create(Registries.ITEM, Identifier.parse("c:cleaver")))
         )) {
         new AlexsMobsfillbloodgrateProcedure.RedwiresTimedLoop(
               20,
               45,
               _timedLoop -> {
                  if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip11
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getValue(_getip11)
                              : -1
                        )
                        == 0) {
                     new ILevelExtension(world);
                     IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(
                        world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 1.0, z), null}
                     );
                     if (_fluidHandler != null) {
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 50), FluidAction.EXECUTE);
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip16
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getValue(_getip16)
                              : -1
                        )
                        == 0) {
                     new ILevelExtension(world);
                     IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(
                        world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 2.0, z), null}
                     );
                     if (_fluidHandler != null) {
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 50), FluidAction.EXECUTE);
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip21
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getValue(_getip21)
                              : -1
                        )
                        == 0) {
                     new ILevelExtension(world);
                     IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(
                        world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 3.0, z), null}
                     );
                     if (_fluidHandler != null) {
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 50), FluidAction.EXECUTE);
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip26
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getValue(_getip26)
                              : -1
                        )
                        == 0) {
                     new ILevelExtension(world);
                     IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(
                        world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 4.0, z), null}
                     );
                     if (_fluidHandler != null) {
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 50), FluidAction.EXECUTE);
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip31
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getValue(_getip31)
                              : -1
                        )
                        == 0) {
                     new ILevelExtension(world);
                     IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(
                        world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 5.0, z), null}
                     );
                     if (_fluidHandler != null) {
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 50), FluidAction.EXECUTE);
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip36
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getValue(_getip36)
                              : -1
                        )
                        == 0) {
                     new ILevelExtension(world);
                     IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(
                        world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 6.0, z), null}
                     );
                     if (_fluidHandler != null) {
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 50), FluidAction.EXECUTE);
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip41
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getValue(_getip41)
                              : -1
                        )
                        == 0) {
                     new ILevelExtension(world);
                     IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(
                        world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 7.0, z), null}
                     );
                     if (_fluidHandler != null) {
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 50), FluidAction.EXECUTE);
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip46
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getValue(_getip46)
                              : -1
                        )
                        == 0) {
                     new ILevelExtension(world);
                     IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(
                        world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 8.0, z), null}
                     );
                     if (_fluidHandler != null) {
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 50), FluidAction.EXECUTE);
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip51
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getValue(_getip51)
                              : -1
                        )
                        == 0) {
                     new ILevelExtension(world);
                     IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(
                        world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 9.0, z), null}
                     );
                     if (_fluidHandler != null) {
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 50), FluidAction.EXECUTE);
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip56
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getValue(_getip56)
                              : -1
                        )
                        == 0) {
                     ILevelExtension _extxxxxxxxxx = new ILevelExtension(world);
                     IFluidHandler _fluidHandler = (IFluidHandler)_extxxxxxxxxx.getCapability(
                        FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 10.0, z), null}
                     );
                     if (_fluidHandler != null) {
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 50), FluidAction.EXECUTE);
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip61
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getValue(_getip61)
                              : -1
                        )
                        == 0) {
                     ILevelExtension _extxxxxxxxxxx = new ILevelExtension(world);
                     IFluidHandler _fluidHandler = (IFluidHandler)_extxxxxxxxxxx.getCapability(
                        FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 11.0, z), null}
                     );
                     if (_fluidHandler != null) {
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 50), FluidAction.EXECUTE);
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip66
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getValue(_getip66)
                              : -1
                        )
                        == 0) {
                     ILevelExtension _extxxxxxxxxxxx = new ILevelExtension(world);
                     IFluidHandler _fluidHandler = (IFluidHandler)_extxxxxxxxxxxx.getCapability(
                        FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 12.0, z), null}
                     );
                     if (_fluidHandler != null) {
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 50), FluidAction.EXECUTE);
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip71
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getValue(_getip71)
                              : -1
                        )
                        == 0) {
                     ILevelExtension _extxxxxxxxxxxxx = new ILevelExtension(world);
                     IFluidHandler _fluidHandler = (IFluidHandler)_extxxxxxxxxxxxx.getCapability(
                        FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 13.0, z), null}
                     );
                     if (_fluidHandler != null) {
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 50), FluidAction.EXECUTE);
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip76
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getValue(_getip76)
                              : -1
                        )
                        == 0) {
                     ILevelExtension _extxxxxxxxxxxxxx = new ILevelExtension(world);
                     IFluidHandler _fluidHandler = (IFluidHandler)_extxxxxxxxxxxxxx.getCapability(
                        FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 14.0, z), null}
                     );
                     if (_fluidHandler != null) {
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 50), FluidAction.EXECUTE);
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip81
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getValue(_getip81)
                              : -1
                        )
                        == 0) {
                     ILevelExtension _extxxxxxxxxxxxxxx = new ILevelExtension(world);
                     IFluidHandler _fluidHandler = (IFluidHandler)_extxxxxxxxxxxxxxx.getCapability(
                        FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 15.0, z), null}
                     );
                     if (_fluidHandler != null) {
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 50), FluidAction.EXECUTE);
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip86
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getValue(_getip86)
                              : -1
                        )
                        == 0) {
                     ILevelExtension _extxxxxxxxxxxxxxxx = new ILevelExtension(world);
                     IFluidHandler _fluidHandler = (IFluidHandler)_extxxxxxxxxxxxxxxx.getCapability(
                        FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 16.0, z), null}
                     );
                     if (_fluidHandler != null) {
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 50), FluidAction.EXECUTE);
                     }
                  }

                  if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip91
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getValue(_getip91)
                              : -1
                        )
                        == 0) {
                     ILevelExtension _extxxxxxxxxxxxxxxxx = new ILevelExtension(world);
                     IFluidHandler _fluidHandler = (IFluidHandler)_extxxxxxxxxxxxxxxxx.getCapability(
                        FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 1.0, z), null}
                     );
                     if (_fluidHandler != null) {
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.INFECTED_BLOOD.get(), 50), FluidAction.EXECUTE);
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip96
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getValue(_getip96)
                              : -1
                        )
                        == 0) {
                     ILevelExtension _extxxxxxxxxxxxxxxxxx = new ILevelExtension(world);
                     IFluidHandler _fluidHandler = (IFluidHandler)_extxxxxxxxxxxxxxxxxx.getCapability(
                        FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 2.0, z), null}
                     );
                     if (_fluidHandler != null) {
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.INFECTED_BLOOD.get(), 50), FluidAction.EXECUTE);
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip101
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getValue(_getip101)
                              : -1
                        )
                        == 0) {
                     ILevelExtension _extxxxxxxxxxxxxxxxxxx = new ILevelExtension(world);
                     IFluidHandler _fluidHandler = (IFluidHandler)_extxxxxxxxxxxxxxxxxxx.getCapability(
                        FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 3.0, z), null}
                     );
                     if (_fluidHandler != null) {
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.INFECTED_BLOOD.get(), 50), FluidAction.EXECUTE);
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip106
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getValue(_getip106)
                              : -1
                        )
                        == 0) {
                     ILevelExtension _extxxxxxxxxxxxxxxxxxxx = new ILevelExtension(world);
                     IFluidHandler _fluidHandler = (IFluidHandler)_extxxxxxxxxxxxxxxxxxxx.getCapability(
                        FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 4.0, z), null}
                     );
                     if (_fluidHandler != null) {
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.INFECTED_BLOOD.get(), 50), FluidAction.EXECUTE);
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip111
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getValue(_getip111)
                              : -1
                        )
                        == 0) {
                     ILevelExtension _extxxxxxxxxxxxxxxxxxxxx = new ILevelExtension(world);
                     IFluidHandler _fluidHandler = (IFluidHandler)_extxxxxxxxxxxxxxxxxxxxx.getCapability(
                        FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 5.0, z), null}
                     );
                     if (_fluidHandler != null) {
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.INFECTED_BLOOD.get(), 50), FluidAction.EXECUTE);
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip116
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getValue(_getip116)
                              : -1
                        )
                        == 0) {
                     ILevelExtension _extxxxxxxxxxxxxxxxxxxxxx = new ILevelExtension(world);
                     IFluidHandler _fluidHandler = (IFluidHandler)_extxxxxxxxxxxxxxxxxxxxxx.getCapability(
                        FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 6.0, z), null}
                     );
                     if (_fluidHandler != null) {
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.INFECTED_BLOOD.get(), 50), FluidAction.EXECUTE);
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip121
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getValue(_getip121)
                              : -1
                        )
                        == 0) {
                     ILevelExtension _extxxxxxxxxxxxxxxxxxxxxxx = new ILevelExtension(world);
                     IFluidHandler _fluidHandler = (IFluidHandler)_extxxxxxxxxxxxxxxxxxxxxxx.getCapability(
                        FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 7.0, z), null}
                     );
                     if (_fluidHandler != null) {
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.INFECTED_BLOOD.get(), 50), FluidAction.EXECUTE);
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip126
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getValue(_getip126)
                              : -1
                        )
                        == 0) {
                     ILevelExtension _extxxxxxxxxxxxxxxxxxxxxxxx = new ILevelExtension(world);
                     IFluidHandler _fluidHandler = (IFluidHandler)_extxxxxxxxxxxxxxxxxxxxxxxx.getCapability(
                        FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 8.0, z), null}
                     );
                     if (_fluidHandler != null) {
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.INFECTED_BLOOD.get(), 50), FluidAction.EXECUTE);
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip131
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getValue(_getip131)
                              : -1
                        )
                        == 0) {
                     ILevelExtension _extxxxxxxxxxxxxxxxxxxxxxxxx = new ILevelExtension(world);
                     IFluidHandler _fluidHandler = (IFluidHandler)_extxxxxxxxxxxxxxxxxxxxxxxxx.getCapability(
                        FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 9.0, z), null}
                     );
                     if (_fluidHandler != null) {
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.INFECTED_BLOOD.get(), 50), FluidAction.EXECUTE);
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip136
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getValue(_getip136)
                              : -1
                        )
                        == 0) {
                     ILevelExtension _extxxxxxxxxxxxxxxxxxxxxxxxxx = new ILevelExtension(world);
                     IFluidHandler _fluidHandler = (IFluidHandler)_extxxxxxxxxxxxxxxxxxxxxxxxxx.getCapability(
                        FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 10.0, z), null}
                     );
                     if (_fluidHandler != null) {
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.INFECTED_BLOOD.get(), 50), FluidAction.EXECUTE);
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip141
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getValue(_getip141)
                              : -1
                        )
                        == 0) {
                     ILevelExtension _extxxxxxxxxxxxxxxxxxxxxxxxxxx = new ILevelExtension(world);
                     IFluidHandler _fluidHandler = (IFluidHandler)_extxxxxxxxxxxxxxxxxxxxxxxxxxx.getCapability(
                        FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 11.0, z), null}
                     );
                     if (_fluidHandler != null) {
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.INFECTED_BLOOD.get(), 50), FluidAction.EXECUTE);
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip146
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getValue(_getip146)
                              : -1
                        )
                        == 0) {
                     ILevelExtension _extxxxxxxxxxxxxxxxxxxxxxxxxxxx = new ILevelExtension(world);
                     IFluidHandler _fluidHandler = (IFluidHandler)_extxxxxxxxxxxxxxxxxxxxxxxxxxxx.getCapability(
                        FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 12.0, z), null}
                     );
                     if (_fluidHandler != null) {
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.INFECTED_BLOOD.get(), 50), FluidAction.EXECUTE);
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip151
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getValue(_getip151)
                              : -1
                        )
                        == 0) {
                     ILevelExtension _extxxxxxxxxxxxxxxxxxxxxxxxxxxxx = new ILevelExtension(world);
                     IFluidHandler _fluidHandler = (IFluidHandler)_extxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getCapability(
                        FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 13.0, z), null}
                     );
                     if (_fluidHandler != null) {
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.INFECTED_BLOOD.get(), 50), FluidAction.EXECUTE);
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip156
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getValue(_getip156)
                              : -1
                        )
                        == 0) {
                     ILevelExtension _extxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = new ILevelExtension(world);
                     IFluidHandler _fluidHandler = (IFluidHandler)_extxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getCapability(
                        FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 14.0, z), null}
                     );
                     if (_fluidHandler != null) {
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.INFECTED_BLOOD.get(), 50), FluidAction.EXECUTE);
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip161
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getValue(_getip161)
                              : -1
                        )
                        == 0) {
                     ILevelExtension _extxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = new ILevelExtension(world);
                     IFluidHandler _fluidHandler = (IFluidHandler)_extxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getCapability(
                        FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 15.0, z), null}
                     );
                     if (_fluidHandler != null) {
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.INFECTED_BLOOD.get(), 50), FluidAction.EXECUTE);
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip166
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getValue(_getip166)
                              : -1
                        )
                        == 0) {
                     ILevelExtension _extxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = new ILevelExtension(world);
                     IFluidHandler _fluidHandler = (IFluidHandler)_extxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getCapability(
                        FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 16.0, z), null}
                     );
                     if (_fluidHandler != null) {
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.INFECTED_BLOOD.get(), 50), FluidAction.EXECUTE);
                     }
                  }

                  return true;
               }
            )
            .run();
      }
   }

   private static class RedwiresTimedLoop {
      private int iterator = 0;
      private int ticks = 0;
      private final int total;
      private final Function<AlexsMobsfillbloodgrateProcedure.RedwiresTimedLoop, Boolean> forEach;

      private RedwiresTimedLoop(int total, int ticks, Function<AlexsMobsfillbloodgrateProcedure.RedwiresTimedLoop, Boolean> forEach) {
         this.total = total;
         this.ticks = ticks;
         this.forEach = forEach;
      }

      private void run() {
         if (this.forEach.apply(this)) {
            ButcheryMod.queueServerWork(this.ticks, this::next);
         }
      }

      private void setTicks(int ticks) {
         this.ticks = ticks;
      }

      private int getIterator() {
         return this.iterator;
      }

      private void next() {
         if (this.total > ++this.iterator) {
            this.run();
         }
      }
   }
}
