package net.mcreator.butchery.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class FreezerguisisclosedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        IntegerProperty _integerProp;
        int _value = 0;
        BlockPos _pos = BlockPos.containing((double)x, (double)y, (double)z);
        BlockState _bs = world.getBlockState(_pos);
        Property property = _bs.getBlock().getStateDefinition().getProperty("blockstate");
        if (property instanceof IntegerProperty && (_integerProp = (IntegerProperty)property).getPossibleValues().contains(_value)) {
            world.setBlock(_pos, (BlockState)_bs.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_value)), 3);
        }
        if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
                _level.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.iron_trapdoor.close")), SoundSource.NEUTRAL, 1.0f, 1.0f);
            } else {
                _level.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.iron_trapdoor.close")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
            }
        }
    }
}

