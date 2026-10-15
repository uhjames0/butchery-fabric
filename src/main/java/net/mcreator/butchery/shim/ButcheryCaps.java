package net.mcreator.butchery.shim;

import net.mcreator.butchery.shim.fluidcap.BlockEntityTankHandler;
import net.mcreator.butchery.shim.fluidcap.BlockFluidHandler;
import net.mcreator.butchery.shim.fluidcap.FluidBucketWrapper;
import net.mcreator.butchery.shim.fluidcap.FluidTank;
import net.mcreator.butchery.shim.itemcap.InvWrapper;
import net.mcreator.butchery.shim.itemcap.SidedInvWrapper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.Container;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.WorldlyContainerHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;

public class ButcheryCaps {
    public static final Object FLUID_BLOCK = new Object();
    public static final Object ITEM_BLOCK = new Object();
    public static final Object ITEM_ENTITY = new Object();
    public static final Object FLUID_ITEM = new Object();

    public static <T> T getCapability(Object provider, Object cap, Object ... extra) {
        block15: {
            try {
                if (cap == ITEM_BLOCK && provider instanceof Level) {
                    Level level = (Level)provider;
                    BlockPos pos = (BlockPos)extra[0];
                    Direction side = extra.length > 1 ? (Direction)extra[1] : null;
                    BlockEntity be = level.getBlockEntity(pos);
                    if (be instanceof WorldlyContainerHolder) {
                        WorldlyContainerHolder wch = (WorldlyContainerHolder)be;
                        return (T)new SidedInvWrapper(wch.getContainer(be.getBlockState(), (LevelAccessor)level, pos), side == null ? Direction.UP : side);
                    }
                    if (be instanceof WorldlyContainer) {
                        WorldlyContainer wc = (WorldlyContainer)be;
                        return (T)new SidedInvWrapper(wc, side == null ? Direction.UP : side);
                    }
                    if (be instanceof Container) {
                        Container c = (Container)be;
                        return (T)new InvWrapper(c);
                    }
                    break block15;
                }
                if (cap == FLUID_BLOCK && provider instanceof Level) {
                    Level level = (Level)provider;
                    BlockPos pos = (BlockPos)extra[0];
                    BlockEntity fbe = level.getBlockEntity(pos);
                    if (fbe != null) {
                        try {
                            Object tankObj = fbe.getClass().getMethod("getFluidTank", new Class[0]).invoke((Object)fbe, new Object[0]);
                            if (tankObj instanceof FluidTank) {
                                FluidTank ft = (FluidTank)tankObj;
                                return (T)new BlockEntityTankHandler(fbe, ft);
                            }
                        }
                        catch (Exception exception) {
                            // empty catch block
                        }
                    }
                    return (T)new BlockFluidHandler(level, pos);
                }
                if (cap == ITEM_ENTITY && provider instanceof Entity) {
                    Entity e = (Entity)provider;
                    if (e instanceof Player) {
                        Player p = (Player)e;
                        return (T)new InvWrapper((Container)p.getInventory());
                    }
                } else if (cap == FLUID_ITEM && provider instanceof ItemStack) {
                    ItemStack stack = (ItemStack)provider;
                    return (T)new FluidBucketWrapper(stack);
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return null;
    }
}

