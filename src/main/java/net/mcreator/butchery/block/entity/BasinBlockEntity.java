package net.mcreator.butchery.block.entity;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import net.mcreator.butchery.init.ButcheryModBlockEntities;
import net.mcreator.butchery.shim.fluidcap.FluidStack;
import net.mcreator.butchery.shim.fluidcap.FluidTank;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jetbrains.annotations.Nullable;

public class BasinBlockEntity extends RandomizableContainerBlockEntity implements WorldlyContainer {
   private NonNullList<ItemStack> stacks = NonNullList.withSize(9, ItemStack.EMPTY);
   private final FluidTank fluidTank = new FluidTank(1000, fs -> fs.getFluid() == Fluids.WATER) {
      {
         Objects.requireNonNull(BasinBlockEntity.this);
      }

      protected void onContentsChanged() {
         super.onContentsChanged();
         BasinBlockEntity.this.setChanged();
         BasinBlockEntity.this.level
            .sendBlockUpdated(
               BasinBlockEntity.this.worldPosition,
               BasinBlockEntity.this.level.getBlockState(BasinBlockEntity.this.worldPosition),
               BasinBlockEntity.this.level.getBlockState(BasinBlockEntity.this.worldPosition),
               2
            );
      }
   };

   public BasinBlockEntity(BlockPos position, BlockState state) {
      super((BlockEntityType)ButcheryModBlockEntities.BASIN.get(), position, state);
   }

   public void loadAdditional(ValueInput valueInput) {
      super.loadAdditional(valueInput);
      if (!this.tryLoadLootTable(valueInput)) {
         this.stacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
      }

      ContainerHelper.loadAllItems(valueInput, this.stacks);
      valueInput.child("fluidTank").ifPresent(input -> this.fluidTank.deserialize(input));
   }

   public void saveAdditional(ValueOutput valueOutput) {
      super.saveAdditional(valueOutput);
      if (!this.trySaveLootTable(valueOutput)) {
         ContainerHelper.saveAllItems(valueOutput, this.stacks);
      }

      this.fluidTank.serialize(valueOutput.child("fluidTank"));
   }

   public ClientboundBlockEntityDataPacket getUpdatePacket() {
      return ClientboundBlockEntityDataPacket.create(this);
   }

   public CompoundTag getUpdateTag(Provider lookupProvider) {
      return this.saveWithFullMetadata(lookupProvider);
   }

   public int getContainerSize() {
      return this.stacks.size();
   }

   public boolean isEmpty() {
      for (ItemStack itemstack : this.stacks) {
         if (!itemstack.isEmpty()) {
            return false;
         }
      }

      return true;
   }

   public Component getDefaultName() {
      return Component.literal("basin");
   }

   public int getMaxStackSize() {
      return 64;
   }

   public AbstractContainerMenu createMenu(int id, Inventory inventory) {
      return ChestMenu.threeRows(id, inventory);
   }

   public Component getDisplayName() {
      return Component.literal("Basin");
   }

   protected NonNullList<ItemStack> getItems() {
      return this.stacks;
   }

   protected void setItems(NonNullList<ItemStack> stacks) {
      this.stacks = stacks;
   }

   public boolean canPlaceItem(int index, ItemStack stack) {
      return true;
   }

   public int[] getSlotsForFace(Direction side) {
      return IntStream.range(0, this.getContainerSize()).toArray();
   }

   public boolean canPlaceItemThroughFace(int index, ItemStack itemstack, @Nullable Direction direction) {
      return this.canPlaceItem(index, itemstack);
   }

   public boolean canTakeItemThroughFace(int index, ItemStack itemstack, Direction direction) {
      return true;
   }

   public FluidTank getFluidTank() {
      return this.fluidTank;
   }
}
