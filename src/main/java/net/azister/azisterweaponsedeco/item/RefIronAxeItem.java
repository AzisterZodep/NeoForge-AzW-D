
package net.azister.azisterweaponsedeco.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

public class RefIronAxeItem extends AxeItem {
	private static final Tier TOOL_TIER = new Tier() {
		@Override
		public int getUses() {
			return 500;
		}

		@Override
		public float getSpeed() {
			return 0f;
		}

		@Override
		public float getAttackDamageBonus() {
			return 0;
		}

		public int getLevel() { return 2;}

		@Override
		public TagKey<Block> getIncorrectBlocksForDrops() {
			return BlockTags.INCORRECT_FOR_IRON_TOOL;
		}

		@Override
		public int getEnchantmentValue() {
			return 16;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return Ingredient.of(new ItemStack(Items.IRON_INGOT));
		}
	};

	public RefIronAxeItem() {
		super(TOOL_TIER, new Properties().attributes(AxeItem.createAttributes(TOOL_TIER, 9f, -3.1f)));
	}
}
