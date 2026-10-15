package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class FreezerguiopenedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null && !entity.isShiftKeyDown()) {
            ServerLevel _levelx;
            IntegerProperty _integerProp;
            if (entity instanceof LivingEntity) {
                LivingEntity _entity = (LivingEntity)entity;
                _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }
            int _value = 1;
            BlockPos _pos = BlockPos.containing((double)x, (double)y, (double)z);
            BlockState _bs = world.getBlockState(_pos);
            Property property = _bs.getBlock().getStateDefinition().getProperty("blockstate");
            if (property instanceof IntegerProperty && (_integerProp = (IntegerProperty)property).getPossibleValues().contains(_value)) {
                world.setBlock(_pos, (BlockState)_bs.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_value)), 3);
            }
            if (world instanceof Level) {
                Level _level = (Level)world;
                if (!_level.isClientSide()) {
                    _level.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                } else {
                    _level.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                }
            }
            if (world instanceof ServerLevel) {
                _levelx = (ServerLevel)world;
                _levelx.sendParticles((ParticleOptions)ButcheryModParticleTypes.FREEZERSMOKE.get(), x + 0.6, y + 0.5, z + 0.6, 5, 0.1, 0.3, 0.2, 0.0);
            }
            if (world instanceof ServerLevel) {
                _levelx = (ServerLevel)world;
                _levelx.sendParticles((ParticleOptions)ButcheryModParticleTypes.FREEZERSMOKE.get(), x + 0.5, y + 1.0, z + 0.5, 5, 0.2, 0.2, 0.2, 0.0);
            }
            if (world instanceof ServerLevel) {
                _levelx = (ServerLevel)world;
                _levelx.sendParticles((ParticleOptions)ButcheryModParticleTypes.FREEZERSMOKE.get(), x + 0.2, y + 0.5, z + 0.5, 5, 0.1, 0.3, 0.2, 0.0);
            }
            if (world instanceof ServerLevel) {
                _levelx = (ServerLevel)world;
                _levelx.sendParticles((ParticleOptions)ButcheryModParticleTypes.FREEZERSMOKE.get(), x + 0.5, y + 1.0, z + 0.2, 5, 0.2, 0.2, 0.2, 0.0);
            }
        }
    }
}

