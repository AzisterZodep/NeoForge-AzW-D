package net.azister.azisterweaponsedeco.block.entity;

import net.azister.azisterweaponsedeco.procedures.CrushItemProcedure;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.ContainerHelper;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.NonNullList;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.azister.azisterweaponsedeco.world.inventory.CrucherMenu;
import net.azister.azisterweaponsedeco.init.AzisterweaponsedecoModBlockEntities;

import javax.annotation.Nullable;

import java.util.stream.IntStream;

import io.netty.buffer.Unpooled;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CrusherblockBlockEntity extends RandomizableContainerBlockEntity implements WorldlyContainer {
	private static final Logger LOGGER = LogManager.getLogger(CrushItemProcedure.class);
	private NonNullList<ItemStack> stacks = NonNullList.<ItemStack>withSize(5, ItemStack.EMPTY);
	private final SidedInvWrapper handler = new SidedInvWrapper(this, null);

	public CrusherblockBlockEntity(BlockPos position, BlockState state) {
		super(AzisterweaponsedecoModBlockEntities.CRUSHERBLOCK.get(), position, state);
	}

	@Override
	public void loadAdditional(CompoundTag compound, HolderLookup.Provider lookupProvider) {
		super.loadAdditional(compound, lookupProvider);
		if (!this.tryLoadLootTable(compound))
			this.stacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		ContainerHelper.loadAllItems(compound, this.stacks, lookupProvider);
	}

	@Override
	public void saveAdditional(CompoundTag compound, HolderLookup.Provider lookupProvider) {
		super.saveAdditional(compound, lookupProvider);
		if (!this.trySaveLootTable(compound)) {
			ContainerHelper.saveAllItems(compound, this.stacks, lookupProvider);
		}
	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public CompoundTag getUpdateTag(HolderLookup.Provider lookupProvider) {
		return this.saveWithFullMetadata(lookupProvider);
	}

	@Override
	public int getContainerSize() {
		return stacks.size();
	}

	@Override
	public boolean isEmpty() {
		for (ItemStack itemstack : this.stacks)
			if (!itemstack.isEmpty())
				return false;
		return true;
	}

	@Override
	public Component getDefaultName() {
		return Component.literal("crusherblock");
	}

	@Override
	public int getMaxStackSize() {
		return 32;
	}

	@Override
	public AbstractContainerMenu createMenu(int id, Inventory inventory) {
		LOGGER.debug("createMenu");
		return new CrucherMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(this.worldPosition));
	}

	@Override
	public Component getDisplayName() {
		return Component.literal("Crusherblock");
	}

	@Override
	protected NonNullList<ItemStack> getItems() {
		return this.stacks;
	}

	@Override
	protected void setItems(NonNullList<ItemStack> stacks) {
		this.stacks = stacks;
	}

	@Override
	public boolean canPlaceItem(int index, ItemStack stack) {
		if (index == 1)
			return false;
		if (index == 2)
			return false;
		if (index == 3)
			return false;
		return true;
	}

	@Override
	public int[] getSlotsForFace(Direction side) {
		return IntStream.range(0, this.getContainerSize()).toArray();
	}

	@Override
	public boolean canPlaceItemThroughFace(int index, ItemStack stack, @Nullable Direction direction) {
		return this.canPlaceItem(index, stack);
	}

	@Override
	public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
		return true;
	}

	public SidedInvWrapper getItemHandler() {
		return handler;
	}
}
