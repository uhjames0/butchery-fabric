package net.mcreator.butchery.block;

import net.mcreator.butchery.init.ButcheryModFluids;
import net.mcreator.butchery.procedures.BloodMobplayerCollidesBlockProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class BloodBlock
extends LiquidBlock {
    public BloodBlock(BlockBehaviour.Properties properties) {
        super(ButcheryModFluids.BLOOD.get(), properties.mapColor(MapColor.WATER).strength(10.0f).noCollision().noLootTable().liquid().pushReaction(PushReaction.POPPED).sound(SoundType.EMPTY).replaceable());
    }

    public int getLightBlock(BlockState state) {
        return 5;
    }

    public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity, InsideBlockEffectApplier insideBlockEffectApplier, boolean insideBlockEffect) {
        super.entityInside(blockstate, world, pos, entity, insideBlockEffectApplier, false);
        BloodMobplayerCollidesBlockProcedure.execute();
    }
}

