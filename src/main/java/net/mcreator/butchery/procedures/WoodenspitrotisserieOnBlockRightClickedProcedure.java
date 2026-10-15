package net.mcreator.butchery.procedures;

import java.util.Optional;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.functions.CommandFunction;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.permissions.PermissionSet;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class WoodenspitrotisserieOnBlockRightClickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        block18: {
            Optional _fopt;
            ServerLevel _level;
            IntegerProperty _integerProp;
            block19: {
                ItemStack itemStack;
                ItemStack itemStack2;
                int n;
                if (entity == null) break block18;
                Property property = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (property instanceof IntegerProperty) {
                    Property<?> _getip1 = (IntegerProperty)property;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip1);
                } else {
                    n = -1;
                }
                if (n != 2) break block18;
                if (entity instanceof LivingEntity) {
                    LivingEntity _livEntx = (LivingEntity)entity;
                    itemStack2 = _livEntx.getMainHandItem();
                } else {
                    itemStack2 = ItemStack.EMPTY;
                }
                if (itemStack2.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"forge:cleaver")))) break block19;
                if (entity instanceof LivingEntity) {
                    LivingEntity _livEnt = (LivingEntity)entity;
                    itemStack = _livEnt.getMainHandItem();
                } else {
                    itemStack = ItemStack.EMPTY;
                }
                if (!itemStack.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"c:cleaver")))) break block18;
            }
            if (entity instanceof LivingEntity) {
                LivingEntity _entity = (LivingEntity)entity;
                _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }
            int _value = 0;
            BlockPos _pos = BlockPos.containing((double)x, (double)y, (double)z);
            BlockState _bs = world.getBlockState(_pos);
            Property property = _bs.getBlock().getStateDefinition().getProperty("blockstate");
            if (property instanceof IntegerProperty && (_integerProp = (IntegerProperty)property).getPossibleValues().contains(_value)) {
                world.setBlock(_pos, (BlockState)_bs.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_value)), 3);
            }
            if (world instanceof ServerLevel && (_level = (ServerLevel)world).getServer() != null && (_fopt = _level.getServer().getFunctions().get(Identifier.parse((String)"/loot spawn ~ ~-1 ~ loot butchery:blocks/pig_spitroast_drop"))).isPresent()) {
                _level.getServer().getFunctions().execute((CommandFunction)_fopt.get(), new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, PermissionSet.ALL_PERMISSIONS, _level.getServer(), null));
            }
            if (world instanceof Level) {
                Level _levelx = (Level)world;
                if (!_levelx.isClientSide()) {
                    _levelx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.honey_block.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                } else {
                    _levelx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.honey_block.break")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                }
            }
            if (world instanceof ServerLevel) {
                ItemStack itemStack;
                ServerLevel _levelxx = (ServerLevel)world;
                if (entity instanceof LivingEntity) {
                    LivingEntity _livEntxx = (LivingEntity)entity;
                    itemStack = _livEntxx.getMainHandItem();
                } else {
                    itemStack = ItemStack.EMPTY;
                }
                itemStack.hurtAndBreak(1, _levelxx, null, _stkprov -> {});
            }
        }
    }
}

