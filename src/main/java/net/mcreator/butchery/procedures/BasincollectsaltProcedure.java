package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModItems;
import net.mcreator.butchery.shim.ButcheryCaps;
import net.mcreator.butchery.shim.ILevelExtension;
import net.mcreator.butchery.shim.capabilities.ItemHandler;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.mcreator.butchery.shim.itemcap.IItemHandler;
import net.mcreator.butchery.shim.itemcap.IItemHandlerModifiable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import org.jetbrains.annotations.Nullable;

public class BasincollectsaltProcedure {
    public static void onRightClickBlock(ShimEvent.RightClickBlockShim event) {
        if (event.getHand() == InteractionHand.MAIN_HAND) {
            BasincollectsaltProcedure.execute(event, (LevelAccessor)event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getLevel().getBlockState(event.getPos()), (Entity)event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
        BasincollectsaltProcedure.execute(null, world, x, y, z, blockstate, entity);
    }

    /*
     * Enabled aggressive block sorting
     */
    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
        int n;
        LivingEntity _entity;
        ItemStack itemStack;
        if (entity == null) return;
        if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            itemStack = _livEnt.getMainHandItem();
        } else {
            itemStack = ItemStack.EMPTY;
        }
        if (itemStack.getItem() == Items.WATER_BUCKET) return;
        if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() == ButcheryModBlocks.BASIN.get()) {
            int n2;
            Property property = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property instanceof IntegerProperty) {
                Property<?> _getip5 = (IntegerProperty)property;
                n2 = (Integer)blockstate.getValue((Property)_getip5);
            } else {
                n2 = -1;
            }
            if (n2 == 7) {
                Object t;
                if (BasincollectsaltProcedure.itemFromBlockInventory(world, BlockPos.containing((double)x, (double)y, (double)z), 0).copy().getItem() != ButcheryModItems.SALT.get()) return;
                if (entity instanceof LivingEntity) {
                    _entity = (LivingEntity)entity;
                    _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                }
                if ((t = ButcheryCaps.getCapability(world, ItemHandler.BLOCK, BlockPos.containing((double)x, (double)y, (double)z), null)) instanceof IItemHandlerModifiable) {
                    IItemHandlerModifiable _itemHandlerModifiable = (IItemHandlerModifiable)t;
                    int _slotid = 0;
                    ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
                    _stk.shrink(1);
                    _itemHandlerModifiable.setStackInSlot(_slotid, _stk);
                }
                if (world instanceof Level) {
                    Level _level = (Level)world;
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"item.brush.brushing.generic")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                    } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"item.brush.brushing.generic")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                    }
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _levelx = (ServerLevel)world;
                    ItemEntity entityToSpawn = new ItemEntity((Level)_levelx, x, y + 1.0, z, new ItemStack((ItemLike)ButcheryModItems.SALT.get()));
                    entityToSpawn.setPickUpDelay(10);
                    _levelx.addFreshEntity((Entity)entityToSpawn);
                }
                if (BasincollectsaltProcedure.itemFromBlockInventory(world, BlockPos.containing((double)x, (double)y, (double)z), 0).copy().getItem() != Blocks.AIR.asItem()) return;
                int _value = 0;
                BlockPos _pos = BlockPos.containing((double)x, (double)y, (double)z);
                BlockState _bs = world.getBlockState(_pos);
                Property property2 = _bs.getBlock().getStateDefinition().getProperty("blockstate");
                if (!(property2 instanceof IntegerProperty)) return;
                Property<?> _integerProp = (IntegerProperty)property2;
                if (!_integerProp.getPossibleValues().contains(_value)) return;
                world.setBlock(_pos, (BlockState)_bs.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_value)), 3);
                return;
            }
        }
        if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() != ButcheryModBlocks.BASIN.get()) return;
        Property _value = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
        if (_value instanceof IntegerProperty) {
            Property<?> _getip18 = (IntegerProperty)_value;
            n = (Integer)blockstate.getValue((Property)_getip18);
        } else {
            n = -1;
        }
        if (n == 7) {
            int n3;
            _value = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (_value instanceof IntegerProperty) {
                IntegerProperty _getip20 = (IntegerProperty)_value;
                n3 = (Integer)blockstate.getValue((Property)_getip20);
            } else {
                n3 = -1;
            }
            if (n3 == 0) return;
        }
        if (BasincollectsaltProcedure.itemFromBlockInventory(world, BlockPos.containing((double)x, (double)y, (double)z), 0).copy().getItem() != ButcheryModItems.SALT.get()) return;
        if (entity instanceof LivingEntity) {
            _entity = (LivingEntity)entity;
            _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
        }
        if (!(entity instanceof Player)) return;
        Player _player = (Player)entity;
        if (_player.level().isClientSide()) return;
        _player.sendOverlayMessage((Component)Component.literal((String)"The salt is too wet to remove. Wait until the water has evaporated."));
    }

    private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
        ILevelExtension ext = new ILevelExtension(world);
        IItemHandler itemHandler = (IItemHandler)ButcheryCaps.getCapability(world, ItemHandler.BLOCK, pos, null);
        if (itemHandler != null) {
            return itemHandler.getStackInSlot(slot);
        }
        return ItemStack.EMPTY;
    }
}

