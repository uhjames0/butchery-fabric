package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModItems;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.mcreator.butchery.shim.itemcap.ItemHandlerHelper;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import org.jetbrains.annotations.Nullable;

public class ItsafloateradvancementgrantedProcedure {
    public static void onAdvancement(ShimEvent.AdvancementEarnShim event) {
        ItsafloateradvancementgrantedProcedure.execute(event, (LevelAccessor)event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getAdvancement().value(), (Entity)event.getEntity());
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Advancement advancement, Entity entity) {
        ItsafloateradvancementgrantedProcedure.execute(null, world, x, y, z, advancement, entity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Advancement advancement, Entity entity) {
        Level _lvl0;
        if (advancement != null && entity != null && world instanceof Level && (_lvl0 = (Level)world).getServer() != null && _lvl0.getServer().getAdvancements().get(Identifier.parse((String)"butchery:itsafloater")).value().equals((Object)advancement)) {
            if (world instanceof Level) {
                Level _level = (Level)world;
                if (!_level.isClientSide()) {
                    _level.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"butchery:coin")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                } else {
                    _level.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"butchery:coin")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                }
            }
            if (entity instanceof Player) {
                Player _player = (Player)entity;
                ItemStack _setstack = new ItemStack((ItemLike)ButcheryModItems.COIN.get()).copy();
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
            }
        }
    }
}

