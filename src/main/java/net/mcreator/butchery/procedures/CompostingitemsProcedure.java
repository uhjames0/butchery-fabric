package net.mcreator.butchery.procedures;

import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import org.jetbrains.annotations.Nullable;

public class CompostingitemsProcedure {
    public static void onRightClickBlock(ShimEvent.RightClickBlockShim event) {
        if (event.getHand() == InteractionHand.MAIN_HAND) {
            CompostingitemsProcedure.execute(event, (LevelAccessor)event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), (Entity)event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        CompostingitemsProcedure.execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity) {
        block14: {
            block15: {
                ItemStack itemStack;
                if (entity == null || world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() != Blocks.COMPOSTER) break block14;
                if (entity instanceof LivingEntity) {
                    LivingEntity _livEnt = (LivingEntity)entity;
                    itemStack = _livEnt.getMainHandItem();
                } else {
                    itemStack = ItemStack.EMPTY;
                }
                if (!itemStack.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"butchery:compostable")))) break block14;
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((ParticleOptions)ParticleTypes.COMPOSTER, (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(), (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ(), 20, 0.5, 0.5, 0.5, 0.01);
                }
                if (entity instanceof LivingEntity) {
                    LivingEntity _entity = (LivingEntity)entity;
                    _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                }
                if (Math.random() < 0.3) {
                    IntegerProperty _integerProp;
                    int n;
                    Property property = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("level");
                    if (property instanceof IntegerProperty) {
                        Property<?> _getip10 = (IntegerProperty)property;
                        n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip10);
                    } else {
                        n = -1;
                    }
                    int _value = n + 1;
                    BlockPos _pos = BlockPos.containing((double)x, (double)y, (double)z);
                    BlockState _bs = world.getBlockState(_pos);
                    Property property2 = _bs.getBlock().getStateDefinition().getProperty("level");
                    if (property2 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property2).getPossibleValues().contains(_value)) {
                        world.setBlock(_pos, (BlockState)_bs.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_value)), 3);
                    }
                }
                if (!(entity instanceof Player)) break block15;
                Player _plr = (Player)entity;
                if (_plr.getAbilities().instabuild) break block14;
            }
            if (entity instanceof Player) {
                ItemStack itemStack;
                Player _player = (Player)entity;
                if (entity instanceof LivingEntity) {
                    LivingEntity _livEntx = (LivingEntity)entity;
                    itemStack = _livEntx.getMainHandItem();
                } else {
                    itemStack = ItemStack.EMPTY;
                }
                ItemStack _stktoremove = itemStack;
                ItemStack var25 = itemStack;
                _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, (Container)_player.inventoryMenu.getCraftSlots());
            }
        }
    }
}

