package net.mcreator.butchery.procedures;

import java.util.function.Function;
import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModFluids;
import net.mcreator.butchery.shim.ButcheryCaps;
import net.mcreator.butchery.shim.ILevelExtension;
import net.mcreator.butchery.shim.capabilities.FluidHandler;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.mcreator.butchery.shim.fluidcap.FluidStack;
import net.mcreator.butchery.shim.fluidcap.IFluidHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluid;
import org.jetbrains.annotations.Nullable;

public class AlexsSmallMobsfillbloodgrateProcedure {
    public static void onRightClickBlock(ShimEvent.RightClickBlockShim event) {
        if (event.getHand() == InteractionHand.MAIN_HAND) {
            AlexsSmallMobsfillbloodgrateProcedure.execute(event, (LevelAccessor)event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), (Entity)event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        AlexsSmallMobsfillbloodgrateProcedure.execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity) {
        block9: {
            block10: {
                ItemStack itemStack;
                ItemStack itemStack2;
                int n;
                if (entity == null || !world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery_alexs_mobs:small_carcass")))) break block9;
                Property property = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (property instanceof IntegerProperty) {
                    Property<?> _getip3 = (IntegerProperty)property;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip3);
                } else {
                    n = -1;
                }
                if (n != 1) break block9;
                if (entity instanceof LivingEntity) {
                    LivingEntity _livEntx = (LivingEntity)entity;
                    itemStack2 = _livEntx.getMainHandItem();
                } else {
                    itemStack2 = ItemStack.EMPTY;
                }
                if (itemStack2.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"forge:cleaver")))) break block10;
                if (entity instanceof LivingEntity) {
                    LivingEntity _livEnt = (LivingEntity)entity;
                    itemStack = _livEnt.getMainHandItem();
                } else {
                    itemStack = ItemStack.EMPTY;
                }
                if (!itemStack.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"c:cleaver")))) break block9;
            }
            new RedwiresTimedLoop(10, 45, _timedLoop -> {
                int n;
                if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
                    int n2;
                    Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (patt0$temp instanceof IntegerProperty) {
                        Property<?> _getip11 = (IntegerProperty)patt0$temp;
                        n2 = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getValue((Property)_getip11);
                    } else {
                        n2 = -1;
                    }
                    if (n2 == 0) {
                        ILevelExtension _ext = new ILevelExtension(world);
                        IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(world, FluidHandler.BLOCK, BlockPos.containing((double)x, (double)(y - 1.0), (double)z), null);
                        if (_fluidHandler == null) return true;
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
                        return true;
                    }
                }
                if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 2.0), (double)z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
                    int n3;
                    Property patt1$temp = world.getBlockState(BlockPos.containing((double)x, (double)(y - 2.0), (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (patt1$temp instanceof IntegerProperty) {
                        Property<?> _getip16 = (IntegerProperty)patt1$temp;
                        n3 = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)(y - 2.0), (double)z)).getValue((Property)_getip16);
                    } else {
                        n3 = -1;
                    }
                    if (n3 == 0) {
                        ILevelExtension _extx = new ILevelExtension(world);
                        IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(world, FluidHandler.BLOCK, BlockPos.containing((double)x, (double)(y - 2.0), (double)z), null);
                        if (_fluidHandler == null) return true;
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
                        return true;
                    }
                }
                if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 3.0), (double)z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
                    int n4;
                    Property patt2$temp = world.getBlockState(BlockPos.containing((double)x, (double)(y - 3.0), (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (patt2$temp instanceof IntegerProperty) {
                        Property<?> _getip21 = (IntegerProperty)patt2$temp;
                        n4 = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)(y - 3.0), (double)z)).getValue((Property)_getip21);
                    } else {
                        n4 = -1;
                    }
                    if (n4 == 0) {
                        ILevelExtension _extxx = new ILevelExtension(world);
                        IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(world, FluidHandler.BLOCK, BlockPos.containing((double)x, (double)(y - 3.0), (double)z), null);
                        if (_fluidHandler == null) return true;
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
                        return true;
                    }
                }
                if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 4.0), (double)z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
                    int n5;
                    Property patt3$temp = world.getBlockState(BlockPos.containing((double)x, (double)(y - 4.0), (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (patt3$temp instanceof IntegerProperty) {
                        Property<?> _getip26 = (IntegerProperty)patt3$temp;
                        n5 = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)(y - 4.0), (double)z)).getValue((Property)_getip26);
                    } else {
                        n5 = -1;
                    }
                    if (n5 == 0) {
                        ILevelExtension _extxxx = new ILevelExtension(world);
                        IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(world, FluidHandler.BLOCK, BlockPos.containing((double)x, (double)(y - 4.0), (double)z), null);
                        if (_fluidHandler == null) return true;
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
                        return true;
                    }
                }
                if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 5.0), (double)z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
                    int n6;
                    Property patt4$temp = world.getBlockState(BlockPos.containing((double)x, (double)(y - 5.0), (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (patt4$temp instanceof IntegerProperty) {
                        Property<?> _getip31 = (IntegerProperty)patt4$temp;
                        n6 = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)(y - 5.0), (double)z)).getValue((Property)_getip31);
                    } else {
                        n6 = -1;
                    }
                    if (n6 == 0) {
                        ILevelExtension _extxxxx = new ILevelExtension(world);
                        IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(world, FluidHandler.BLOCK, BlockPos.containing((double)x, (double)(y - 5.0), (double)z), null);
                        if (_fluidHandler == null) return true;
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
                        return true;
                    }
                }
                if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 6.0), (double)z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
                    int n7;
                    Property patt5$temp = world.getBlockState(BlockPos.containing((double)x, (double)(y - 6.0), (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (patt5$temp instanceof IntegerProperty) {
                        Property<?> _getip36 = (IntegerProperty)patt5$temp;
                        n7 = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)(y - 6.0), (double)z)).getValue((Property)_getip36);
                    } else {
                        n7 = -1;
                    }
                    if (n7 == 0) {
                        ILevelExtension _extxxxxx = new ILevelExtension(world);
                        IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(world, FluidHandler.BLOCK, BlockPos.containing((double)x, (double)(y - 6.0), (double)z), null);
                        if (_fluidHandler == null) return true;
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
                        return true;
                    }
                }
                if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 7.0), (double)z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
                    int n8;
                    Property patt6$temp = world.getBlockState(BlockPos.containing((double)x, (double)(y - 7.0), (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (patt6$temp instanceof IntegerProperty) {
                        Property<?> _getip41 = (IntegerProperty)patt6$temp;
                        n8 = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)(y - 7.0), (double)z)).getValue((Property)_getip41);
                    } else {
                        n8 = -1;
                    }
                    if (n8 == 0) {
                        ILevelExtension _extxxxxxx = new ILevelExtension(world);
                        IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(world, FluidHandler.BLOCK, BlockPos.containing((double)x, (double)(y - 7.0), (double)z), null);
                        if (_fluidHandler == null) return true;
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
                        return true;
                    }
                }
                if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 8.0), (double)z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
                    int n9;
                    Property patt7$temp = world.getBlockState(BlockPos.containing((double)x, (double)(y - 8.0), (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (patt7$temp instanceof IntegerProperty) {
                        Property<?> _getip46 = (IntegerProperty)patt7$temp;
                        n9 = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)(y - 8.0), (double)z)).getValue((Property)_getip46);
                    } else {
                        n9 = -1;
                    }
                    if (n9 == 0) {
                        ILevelExtension _extxxxxxxx = new ILevelExtension(world);
                        IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(world, FluidHandler.BLOCK, BlockPos.containing((double)x, (double)(y - 8.0), (double)z), null);
                        if (_fluidHandler == null) return true;
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
                        return true;
                    }
                }
                if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 9.0), (double)z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
                    int n10;
                    Property patt8$temp = world.getBlockState(BlockPos.containing((double)x, (double)(y - 9.0), (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (patt8$temp instanceof IntegerProperty) {
                        Property<?> _getip51 = (IntegerProperty)patt8$temp;
                        n10 = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)(y - 9.0), (double)z)).getValue((Property)_getip51);
                    } else {
                        n10 = -1;
                    }
                    if (n10 == 0) {
                        ILevelExtension _extxxxxxxxx = new ILevelExtension(world);
                        IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(world, FluidHandler.BLOCK, BlockPos.containing((double)x, (double)(y - 9.0), (double)z), null);
                        if (_fluidHandler == null) return true;
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
                        return true;
                    }
                }
                if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 10.0), (double)z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
                    int n11;
                    Property patt9$temp = world.getBlockState(BlockPos.containing((double)x, (double)(y - 10.0), (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (patt9$temp instanceof IntegerProperty) {
                        Property<?> _getip56 = (IntegerProperty)patt9$temp;
                        n11 = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)(y - 10.0), (double)z)).getValue((Property)_getip56);
                    } else {
                        n11 = -1;
                    }
                    if (n11 == 0) {
                        ILevelExtension _extxxxxxxxxx = new ILevelExtension(world);
                        IFluidHandler _fluidHandler = (IFluidHandler)_extxxxxxxxxx.getCapability(FluidHandler.BLOCK, BlockPos.containing((double)x, (double)(y - 10.0), (double)z), null);
                        if (_fluidHandler == null) return true;
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
                        return true;
                    }
                }
                if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 11.0), (double)z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
                    int n12;
                    Property patt10$temp = world.getBlockState(BlockPos.containing((double)x, (double)(y - 11.0), (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (patt10$temp instanceof IntegerProperty) {
                        Property<?> _getip61 = (IntegerProperty)patt10$temp;
                        n12 = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)(y - 11.0), (double)z)).getValue((Property)_getip61);
                    } else {
                        n12 = -1;
                    }
                    if (n12 == 0) {
                        ILevelExtension _extxxxxxxxxxx = new ILevelExtension(world);
                        IFluidHandler _fluidHandler = (IFluidHandler)_extxxxxxxxxxx.getCapability(FluidHandler.BLOCK, BlockPos.containing((double)x, (double)(y - 11.0), (double)z), null);
                        if (_fluidHandler == null) return true;
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
                        return true;
                    }
                }
                if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 12.0), (double)z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
                    int n13;
                    Property patt11$temp = world.getBlockState(BlockPos.containing((double)x, (double)(y - 12.0), (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (patt11$temp instanceof IntegerProperty) {
                        Property<?> _getip66 = (IntegerProperty)patt11$temp;
                        n13 = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)(y - 12.0), (double)z)).getValue((Property)_getip66);
                    } else {
                        n13 = -1;
                    }
                    if (n13 == 0) {
                        ILevelExtension _extxxxxxxxxxxx = new ILevelExtension(world);
                        IFluidHandler _fluidHandler = (IFluidHandler)_extxxxxxxxxxxx.getCapability(FluidHandler.BLOCK, BlockPos.containing((double)x, (double)(y - 12.0), (double)z), null);
                        if (_fluidHandler == null) return true;
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
                        return true;
                    }
                }
                if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 13.0), (double)z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
                    int n14;
                    Property patt12$temp = world.getBlockState(BlockPos.containing((double)x, (double)(y - 13.0), (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (patt12$temp instanceof IntegerProperty) {
                        Property<?> _getip71 = (IntegerProperty)patt12$temp;
                        n14 = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)(y - 13.0), (double)z)).getValue((Property)_getip71);
                    } else {
                        n14 = -1;
                    }
                    if (n14 == 0) {
                        ILevelExtension _extxxxxxxxxxxxx = new ILevelExtension(world);
                        IFluidHandler _fluidHandler = (IFluidHandler)_extxxxxxxxxxxxx.getCapability(FluidHandler.BLOCK, BlockPos.containing((double)x, (double)(y - 13.0), (double)z), null);
                        if (_fluidHandler == null) return true;
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
                        return true;
                    }
                }
                if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 14.0), (double)z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
                    int n15;
                    Property patt13$temp = world.getBlockState(BlockPos.containing((double)x, (double)(y - 14.0), (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (patt13$temp instanceof IntegerProperty) {
                        Property<?> _getip76 = (IntegerProperty)patt13$temp;
                        n15 = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)(y - 14.0), (double)z)).getValue((Property)_getip76);
                    } else {
                        n15 = -1;
                    }
                    if (n15 == 0) {
                        ILevelExtension _extxxxxxxxxxxxxx = new ILevelExtension(world);
                        IFluidHandler _fluidHandler = (IFluidHandler)_extxxxxxxxxxxxxx.getCapability(FluidHandler.BLOCK, BlockPos.containing((double)x, (double)(y - 14.0), (double)z), null);
                        if (_fluidHandler == null) return true;
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
                        return true;
                    }
                }
                if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 15.0), (double)z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
                    int n16;
                    Property patt14$temp = world.getBlockState(BlockPos.containing((double)x, (double)(y - 15.0), (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (patt14$temp instanceof IntegerProperty) {
                        Property<?> _getip81 = (IntegerProperty)patt14$temp;
                        n16 = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)(y - 15.0), (double)z)).getValue((Property)_getip81);
                    } else {
                        n16 = -1;
                    }
                    if (n16 == 0) {
                        ILevelExtension _extxxxxxxxxxxxxxx = new ILevelExtension(world);
                        IFluidHandler _fluidHandler = (IFluidHandler)_extxxxxxxxxxxxxxx.getCapability(FluidHandler.BLOCK, BlockPos.containing((double)x, (double)(y - 15.0), (double)z), null);
                        if (_fluidHandler == null) return true;
                        _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
                        return true;
                    }
                }
                if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 16.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()) return true;
                Property patt15$temp = world.getBlockState(BlockPos.containing((double)x, (double)(y - 16.0), (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (patt15$temp instanceof IntegerProperty) {
                    IntegerProperty _getip86 = (IntegerProperty)patt15$temp;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)(y - 16.0), (double)z)).getValue((Property)_getip86);
                } else {
                    n = -1;
                }
                if (n != 0) return true;
                ILevelExtension _extxxxxxxxxxxxxxxx = new ILevelExtension(world);
                IFluidHandler _fluidHandler = (IFluidHandler)_extxxxxxxxxxxxxxxx.getCapability(FluidHandler.BLOCK, BlockPos.containing((double)x, (double)(y - 16.0), (double)z), null);
                if (_fluidHandler == null) return true;
                _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
                return true;
            }).run();
        }
    }

    private static class RedwiresTimedLoop {
        private int iterator = 0;
        private int ticks = 0;
        private final int total;
        private final Function<RedwiresTimedLoop, Boolean> forEach;

        private RedwiresTimedLoop(int total, int ticks, Function<RedwiresTimedLoop, Boolean> forEach) {
            this.total = total;
            this.ticks = ticks;
            this.forEach = forEach;
        }

        private void run() {
            if (this.forEach.apply(this).booleanValue()) {
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

