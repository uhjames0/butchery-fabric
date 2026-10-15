package net.mcreator.butchery.procedures;

import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModItems;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.mcreator.butchery.shim.events.ShimEvent.RightClickBlockShim;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import org.jetbrains.annotations.Nullable;

/*
 * Biome-variant animal skins (cold/warm pig and cow) on the skin rack.
 * Extends the rack's existing 0-31 states with 32-35:
 *   32 = cold pig skin, 33 = warm pig skin, 34 = cold cow skin, 35 = warm cow skin,
 *   36-50 = dyed sheep skins (orange..black)
 * Salting (state -> 26) and the generic salted -> dried -> leather pipeline
 * of the existing ConvertingskinProcedure / SkinrackOnTickUpdateProcedure work
 * for these states unchanged.
 */
public class VariantSkinrackProcedure {
    private static final Item[] SKINS = new Item[]{
        ButcheryModItems.COLD_PIG_SKIN.get(), ButcheryModItems.WARM_PIG_SKIN.get(),
        ButcheryModItems.COLD_COW_SKIN.get(), ButcheryModItems.WARM_COW_SKIN.get(),
        ButcheryModItems.ORANGE_SHEEP_SKIN.get(), ButcheryModItems.MAGENTA_SHEEP_SKIN.get(),
        ButcheryModItems.LIGHT_BLUE_SHEEP_SKIN.get(), ButcheryModItems.YELLOW_SHEEP_SKIN.get(),
        ButcheryModItems.LIME_SHEEP_SKIN.get(), ButcheryModItems.PINK_SHEEP_SKIN.get(),
        ButcheryModItems.GRAY_SHEEP_SKIN.get(), ButcheryModItems.LIGHT_GRAY_SHEEP_SKIN.get(),
        ButcheryModItems.CYAN_SHEEP_SKIN.get(), ButcheryModItems.PURPLE_SHEEP_SKIN.get(),
        ButcheryModItems.BLUE_SHEEP_SKIN.get(), ButcheryModItems.BROWN_SHEEP_SKIN.get(),
        ButcheryModItems.GREEN_SHEEP_SKIN.get(), ButcheryModItems.RED_SHEEP_SKIN.get(),
        ButcheryModItems.BLACK_SHEEP_SKIN.get()};
    private static final int BASE_STATE = 32;

    public static void onRightClickBlock(RightClickBlockShim event) {
        if (event.getHand() == InteractionHand.MAIN_HAND) {
            VariantSkinrackProcedure.execute(event, (LevelAccessor)event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), (Entity)event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        VariantSkinrackProcedure.execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null) return;
        if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() != ButcheryModBlocks.SKIN_RACK.get()) return;
        int state = rackState(world, x, y, z);
        ItemStack held = entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY;

        if (state == 0 && !held.isEmpty()) {
            // hang a variant skin
            int idx = -1;
            for (int i = 0; i < SKINS.length; i++) {
                if (held.getItem() == SKINS[i]) { idx = i; break; }
            }
            if (idx < 0) return;
            if (event instanceof net.mcreator.butchery.shim.events.ICancellableEvent) {
                event.setCanceled(true);
            }
            if (entity instanceof LivingEntity _entity) {
                _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }
            held.shrink(1);
            setRackState(world, x, y, z, BASE_STATE + idx);
            playSound(world, x, y, z, "block.wool.place");
            return;
        }

        if (held.isEmpty() && state >= BASE_STATE && state < BASE_STATE + SKINS.length) {
            // retrieve a variant skin
            if (entity instanceof LivingEntity _entity) {
                _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }
            setRackState(world, x, y, z, 0);
            if (world instanceof Level _level && !_level.isClientSide() && world instanceof net.minecraft.server.level.ServerLevel _sl) {
                ItemEntity entityToSpawn = new ItemEntity(_sl, x, y, z, new ItemStack(SKINS[state - BASE_STATE]));
                entityToSpawn.setPickUpDelay(10);
                _sl.addFreshEntity(entityToSpawn);
            }
            playSound(world, x, y, z, "block.wool.break");
        }
    }

    private static int rackState(LevelAccessor world, double x, double y, double z) {
        Property<?> property = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
        if (property instanceof IntegerProperty _ip) {
            return (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_ip);
        }
        return -1;
    }

    private static void setRackState(LevelAccessor world, double x, double y, double z, int value) {
        BlockPos _pos = BlockPos.containing(x, y, z);
        BlockState _bs = world.getBlockState(_pos);
        Property<?> property = _bs.getBlock().getStateDefinition().getProperty("blockstate");
        if (property instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(value)) {
            world.setBlock(_pos, (BlockState)_bs.setValue(_integerProp, Integer.valueOf(value)), 3);
        }
    }

    private static void playSound(LevelAccessor world, double x, double y, double z, String sound) {
        if (world instanceof Level _level) {
            if (!_level.isClientSide()) {
                _level.playSound(null, BlockPos.containing(x, y, z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse(sound)), SoundSource.NEUTRAL, 1.0F, 1.0F);
            } else {
                _level.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse(sound)), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
            }
        }
    }
}
