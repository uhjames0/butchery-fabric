package net.mcreator.butchery.mixin;

import it.unimi.dsi.fastutil.objects.Object2FloatMap;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ComposterBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={ComposterBlock.class})
public interface ComposterBlockMixin {
    @Accessor(value="COMPOSTABLES")
    public static Object2FloatMap<ItemLike> getCompostables() {
        throw new AssertionError();
    }
}

