package net.mcreator.butchery.procedures;
import net.minecraft.world.level.block.state.properties.Property;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: LlamacarcassbrokenProcedure.class */
public class LlamacarcassbrokenProcedure {
    public static void onBlockBreak(ShimEvent.BreakShim event) {
        execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getState(), event.getPlayer());
    }

    public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
        execute(null, world, x, y, z, blockstate, entity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
        int iIntValue;
        int iIntValue2;
        int iIntValue3;
        int iIntValue4;
        int iIntValue5;
        int iIntValue6;
        int iIntValue7;
        int iIntValue8;
        if (entity != null) {
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.BROWN_LLAMA_CARCASS.get()) {
                Property<?> property = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (property instanceof IntegerProperty) {
                    Property<?> _getip3 = property;
                    iIntValue7 = ((Integer) blockstate.getValue(_getip3)).intValue();
                } else {
                    iIntValue7 = -1;
                }
                if (iIntValue7 != 0) {
                    Property<?> property2 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property2 instanceof IntegerProperty) {
                        Property<?> _getip5 = property2;
                        iIntValue8 = ((Integer) blockstate.getValue(_getip5)).intValue();
                    } else {
                        iIntValue8 = -1;
                    }
                    if (iIntValue8 != 1) {
                        return;
                    }
                }
                if (entity instanceof Player) {
                    Player _plr = (Player) entity;
                    if (_plr.getAbilities().instabuild) {
                        return;
                    }
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel) world;
                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike) ButcheryModBlocks.BROWN_LLAMA_CARCASS.get()));
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity(entityToSpawn);
                    return;
                }
                return;
            }
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.CREAMY_LLAMA_CARCASS.get()) {
                Property<?> property3 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (property3 instanceof IntegerProperty) {
                    Property<?> _getip11 = property3;
                    iIntValue5 = ((Integer) blockstate.getValue(_getip11)).intValue();
                } else {
                    iIntValue5 = -1;
                }
                if (iIntValue5 != 0) {
                    Property<?> property4 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property4 instanceof IntegerProperty) {
                        Property<?> _getip13 = property4;
                        iIntValue6 = ((Integer) blockstate.getValue(_getip13)).intValue();
                    } else {
                        iIntValue6 = -1;
                    }
                    if (iIntValue6 != 1) {
                        return;
                    }
                }
                if (entity instanceof Player) {
                    Player _plr2 = (Player) entity;
                    if (_plr2.getAbilities().instabuild) {
                        return;
                    }
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level2 = (ServerLevel) world;
                    ItemEntity entityToSpawn2 = new ItemEntity(_level2, x, y, z, new ItemStack((ItemLike) ButcheryModBlocks.CREAMY_LLAMA_CARCASS.get()));
                    entityToSpawn2.setPickUpDelay(10);
                    _level2.addFreshEntity(entityToSpawn2);
                    return;
                }
                return;
            }
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.GRAY_LLAMA_CARCASS.get()) {
                Property<?> property5 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (property5 instanceof IntegerProperty) {
                    Property<?> _getip19 = property5;
                    iIntValue3 = ((Integer) blockstate.getValue(_getip19)).intValue();
                } else {
                    iIntValue3 = -1;
                }
                if (iIntValue3 != 0) {
                    Property<?> property6 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property6 instanceof IntegerProperty) {
                        Property<?> _getip21 = property6;
                        iIntValue4 = ((Integer) blockstate.getValue(_getip21)).intValue();
                    } else {
                        iIntValue4 = -1;
                    }
                    if (iIntValue4 != 1) {
                        return;
                    }
                }
                if (entity instanceof Player) {
                    Player _plr3 = (Player) entity;
                    if (_plr3.getAbilities().instabuild) {
                        return;
                    }
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level3 = (ServerLevel) world;
                    ItemEntity entityToSpawn3 = new ItemEntity(_level3, x, y, z, new ItemStack((ItemLike) ButcheryModBlocks.GRAY_LLAMA_CARCASS.get()));
                    entityToSpawn3.setPickUpDelay(10);
                    _level3.addFreshEntity(entityToSpawn3);
                    return;
                }
                return;
            }
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.WHITE_LLAMA_CARCASS.get()) {
                Property<?> property7 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (property7 instanceof IntegerProperty) {
                    Property<?> _getip27 = property7;
                    iIntValue = ((Integer) blockstate.getValue(_getip27)).intValue();
                } else {
                    iIntValue = -1;
                }
                if (iIntValue != 0) {
                    Property<?> property8 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property8 instanceof IntegerProperty) {
                        IntegerProperty _getip29 = (IntegerProperty) property8;
                        iIntValue2 = ((Integer) blockstate.getValue(_getip29)).intValue();
                    } else {
                        iIntValue2 = -1;
                    }
                    if (iIntValue2 != 1) {
                        return;
                    }
                }
                if (entity instanceof Player) {
                    Player _plr4 = (Player) entity;
                    if (_plr4.getAbilities().instabuild) {
                        return;
                    }
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level4 = (ServerLevel) world;
                    ItemEntity entityToSpawn4 = new ItemEntity(_level4, x, y, z, new ItemStack((ItemLike) ButcheryModBlocks.WHITE_LLAMA_CARCASS.get()));
                    entityToSpawn4.setPickUpDelay(10);
                    _level4.addFreshEntity(entityToSpawn4);
                }
            }
        }
    }
}
