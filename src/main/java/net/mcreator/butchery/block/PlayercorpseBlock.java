package net.mcreator.butchery.block;

import java.util.Collections;
import java.util.List;
import net.mcreator.butchery.block.entity.PlayercorpseBlockEntity;
import net.mcreator.butchery.procedures.PlayercorpsebleedingProcedure;
import net.mcreator.butchery.procedures.PlayercorpsebrokenProcedure;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.mcreator.butchery.shim.ButcheryBlockHooks.DestroyHook;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class PlayercorpseBlock extends Block implements EntityBlock, DestroyHook {
   public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 20);
   public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

   public PlayercorpseBlock(Properties properties) {
      super(properties.sound(SoundType.HONEY_BLOCK).strength(1.0F, 10.0F).lightLevel(s -> (new Object() {
         public int getLightLevel() {
            return s.getValue(PlayercorpseBlock.BLOCKSTATE) == 1 ? 0 : 0;
         }
      }).getLightLevel()).noOcclusion().isRedstoneConductor((bs, br, bp) -> false).dynamicShape());
      this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH));
   }

   public RenderShape getRenderShape(BlockState state) {
      return RenderShape.INVISIBLE;
   }

   public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
      return true;
   }

   public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 0;
   }

   public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
      return Shapes.empty();
   }

   public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
      int corpseState = (Integer)state.getValue(BLOCKSTATE);
      boolean hanging = corpseState >= 1 && corpseState <= 10 || corpseState == 20;
      if (hanging) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> box(4.0, 10.09215, 6.39928, 12.0, 22.09215, 10.39928);
            case EAST -> box(5.60072, 10.09215, 4.0, 9.60072, 22.09215, 12.0);
            case WEST -> box(6.39928, 10.09215, 4.0, 10.39928, 22.09215, 12.0);
            default -> box(4.0, 10.09215, 5.60072, 12.0, 22.09215, 9.60072);
         };
      } else {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> Shapes.or(box(4.0, 4.09215, 6.39928, 12.0, 9.09215, 10.39928), box(4.0, 9.09215, 5.39928, 12.0, 14.09215, 9.39928));
            case EAST -> Shapes.or(box(5.60072, 4.09215, 4.0, 9.60072, 9.09215, 12.0), box(6.60072, 9.09215, 4.0, 10.60072, 14.09215, 12.0));
            case WEST -> Shapes.or(box(6.39928, 4.09215, 4.0, 10.39928, 9.09215, 12.0), box(5.39928, 9.09215, 4.0, 9.39928, 14.09215, 12.0));
            default -> Shapes.or(box(4.0, 4.09215, 5.60072, 12.0, 9.09215, 9.60072), box(4.0, 9.09215, 6.60072, 12.0, 14.09215, 10.60072));
         };
      }
   }

   protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
      super.createBlockStateDefinition(builder);
      builder.add(new Property[]{FACING, BLOCKSTATE});
   }

   public BlockState getStateForPlacement(BlockPlaceContext context) {
      BlockPos pos = context.getClickedPos();
      Player player = context.getPlayer();
      if (player != null) {
         double dx = player.getX() - (pos.getX() + 0.5);
         double dz = player.getZ() - (pos.getZ() + 0.5);
         Direction facing = Direction.getApproximateNearest(dx, 0.0, dz);
         if (facing.getAxis().isHorizontal()) {
            return (BlockState)super.getStateForPlacement(context).setValue(FACING, facing);
         }
      }

      return (BlockState)super.getStateForPlacement(context).setValue(FACING, context.getHorizontalDirection());
   }

   public void setPlacedBy(Level world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
      super.setPlacedBy(world, pos, state, placer, stack);
      if (!world.isClientSide() && world.getBlockEntity(pos) instanceof PlayercorpseBlockEntity corpseBlockEntity) {
         if (getCustomData(stack).contains("PlayerUUID")) {
            corpseBlockEntity.setPlayerUUID(getCustomData(stack).getString("PlayerUUID").orElse(""));
         }

         if (getCustomData(stack).contains("PlayerName")) {
            corpseBlockEntity.setPlayerName(getCustomData(stack).getString("PlayerName").orElse(""));
         }

         if (getCustomData(stack).contains("isBleeding")) {
            ButcheryPersistentData.of(corpseBlockEntity).putBoolean("isBleeding", getCustomData(stack).getBoolean("isBleeding").orElse(false));
         }

         if (getCustomData(stack).contains("isDrained")) {
            ButcheryPersistentData.of(corpseBlockEntity).putBoolean("isDrained", getCustomData(stack).getBoolean("isDrained").orElse(false));
         }

         corpseBlockEntity.setChanged();
         world.sendBlockUpdated(pos, state, state, 3);
      }
   }

   protected ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state, boolean includeData) {
      ItemStack stack = new ItemStack(this.asItem());
      if (level.getBlockEntity(pos) instanceof PlayercorpseBlockEntity corpseBlockEntity) {
         String playerUUID = corpseBlockEntity.getPlayerUUID();
         String playerName = corpseBlockEntity.getPlayerName();
         if (playerUUID != null && !playerUUID.isEmpty()) {
            putCustomString(stack, "PlayerUUID", playerUUID);
         }

         if (playerName != null && !playerName.isEmpty()) {
            putCustomString(stack, "PlayerName", playerName);
            stack.set(DataComponents.CUSTOM_NAME, Component.literal(playerName + " Corpse").withStyle(style -> style.withItalic(false)));
         }

         putCustomBoolean(stack, "isBleeding", ButcheryPersistentData.of(corpseBlockEntity).getBoolean("isBleeding").orElse(false));
         putCustomBoolean(stack, "isDrained", ButcheryPersistentData.of(corpseBlockEntity).getBoolean("isDrained").orElse(false));
      }

      return stack;
   }

   public List<ItemStack> getDrops(BlockState state, net.minecraft.world.level.storage.loot.LootParams.Builder builder) {
      int corpseState = (Integer)state.getValue(BLOCKSTATE);
      if (corpseState != 0 && corpseState != 1) {
         ItemStack rawHumanMeat = new ItemStack((ItemLike)BuiltInRegistries.ITEM.getValue(Identifier.parse("butchery:raw_human_meat")));
         ItemStack flesh = new ItemStack((ItemLike)BuiltInRegistries.ITEM.getValue(Identifier.parse("butchery:flesh")));
         return List.of(rawHumanMeat, flesh);
      } else {
         ItemStack stack = new ItemStack(this.asItem());
         BlockEntity blockEntity = (BlockEntity)builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
         if (blockEntity instanceof PlayercorpseBlockEntity corpseBlockEntity) {
            String playerUUID = corpseBlockEntity.getPlayerUUID();
            String playerName = corpseBlockEntity.getPlayerName();
            if (playerUUID != null && !playerUUID.isEmpty()) {
               putCustomString(stack, "PlayerUUID", playerUUID);
            }

            if (playerName != null && !playerName.isEmpty()) {
               putCustomString(stack, "PlayerName", playerName);
               stack.set(DataComponents.CUSTOM_NAME, Component.literal(playerName + " Corpse").withStyle(style -> style.withItalic(false)));
            }

            putCustomBoolean(stack, "isBleeding", ButcheryPersistentData.of(corpseBlockEntity).getBoolean("isBleeding").orElse(false));
            putCustomBoolean(stack, "isDrained", ButcheryPersistentData.of(corpseBlockEntity).getBoolean("isDrained").orElse(false));
         }

         return Collections.singletonList(stack);
      }
   }

   private static CompoundTag getCustomData(ItemStack stack) {
      return ((CustomData)stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY)).copyTag();
   }

   private static void putCustomString(ItemStack stack, String key, String value) {
      CompoundTag tag = getCustomData(stack);
      tag.putString(key, value);
      stack.set(DataComponents.CUSTOM_DATA, CustomData.of(tag));
   }

   private static void putCustomBoolean(ItemStack stack, String key, boolean value) {
      CompoundTag tag = getCustomData(stack);
      tag.putBoolean(key, value);
      stack.set(DataComponents.CUSTOM_DATA, CustomData.of(tag));
   }

   public BlockState rotate(BlockState state, Rotation rot) {
      return (BlockState)state.setValue(FACING, rot.rotate((Direction)state.getValue(FACING)));
   }

   public BlockState mirror(BlockState state, Mirror mirrorIn) {
      return state.rotate(mirrorIn.getRotation((Direction)state.getValue(FACING)));
   }

   public boolean butchery$onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
      boolean retval = true;
      PlayercorpsebrokenProcedure.execute();
      return retval;
   }

   protected InteractionResult useWithoutItem(BlockState blockstate, Level world, BlockPos pos, Player entity, BlockHitResult hit) {
      int x = pos.getX();
      int y = pos.getY();
      int z = pos.getZ();
      PlayercorpsebleedingProcedure.execute(world, x, y, z, entity);
      return InteractionResult.SUCCESS;
   }

   public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
      return worldIn.getBlockEntity(pos) instanceof MenuProvider menuProvider ? menuProvider : null;
   }

   public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
      return new PlayercorpseBlockEntity(pos, state);
   }

   public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
      super.triggerEvent(state, world, pos, eventID, eventParam);
      BlockEntity blockEntity = world.getBlockEntity(pos);
      return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
   }

   protected void affectNeighborsAfterRemoval(BlockState state, ServerLevel world, BlockPos pos, boolean isMoving) {
      Containers.updateNeighboursAfterDestroy(state, world, pos);
      super.affectNeighborsAfterRemoval(state, world, pos, isMoving);
   }

   public boolean hasAnalogOutputSignal(BlockState state) {
      return true;
   }

   public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
      return world.getBlockEntity(pos) instanceof PlayercorpseBlockEntity be ? AbstractContainerMenu.getRedstoneSignalFromContainer(be) : 0;
   }
}
