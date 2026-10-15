package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import org.jetbrains.annotations.Nullable;

public class JarrightclickedbrainProcedure {
    public static void onRightClickBlock(ShimEvent.RightClickBlockShim event) {
        if (event.getHand() == InteractionHand.MAIN_HAND) {
            JarrightclickedbrainProcedure.execute(event, (LevelAccessor)event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), (Entity)event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        JarrightclickedbrainProcedure.execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity) {
        block16: {
            Property property;
            block17: {
                IntegerProperty _integerProp;
                block19: {
                    block18: {
                        ItemStack itemStack;
                        int n;
                        if (entity == null) break block16;
                        if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() != ButcheryModBlocks.JAR.get()) break block17;
                        property = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (property instanceof IntegerProperty) {
                            Property<?> _getip3 = (IntegerProperty)property;
                            n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip3);
                        } else {
                            n = -1;
                        }
                        if (n != 0) break block17;
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEnt = (LivingEntity)entity;
                            itemStack = _livEnt.getMainHandItem();
                        } else {
                            itemStack = ItemStack.EMPTY;
                        }
                        if (itemStack.getItem() != ((Block)ButcheryModBlocks.BRAIN.get()).asItem()) break block16;
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity = (LivingEntity)entity;
                            _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        if (!(entity instanceof Player)) break block18;
                        Player _plr = (Player)entity;
                        if (_plr.getAbilities().instabuild) break block19;
                    }
                    if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.BRAIN.get());
                        _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, (Container)_player.inventoryMenu.getCraftSlots());
                    }
                }
                int _value = 19;
                BlockPos _pos = BlockPos.containing((double)x, (double)y, (double)z);
                BlockState _bs = world.getBlockState(_pos);
                Property property2 = _bs.getBlock().getStateDefinition().getProperty("blockstate");
                if (property2 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property2).getPossibleValues().contains(_value)) {
                    world.setBlock(_pos, (BlockState)_bs.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_value)), 3);
                }
                break block16;
            }
            if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() == ButcheryModBlocks.JAR.get()) {
                Player _player;
                int n;
                property = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (property instanceof IntegerProperty) {
                    IntegerProperty _getip13 = (IntegerProperty)property;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip13);
                } else {
                    n = -1;
                }
                if (n == 19 && entity instanceof Player && !(_player = (Player)entity).level().isClientSide()) {
                    _player.sendOverlayMessage((Component)Component.literal((String)"You can only fit 1 organ in there!"));
                }
            }
        }
    }
}

