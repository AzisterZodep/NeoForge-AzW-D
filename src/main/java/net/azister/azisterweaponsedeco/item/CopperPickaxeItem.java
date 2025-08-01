package net.azister.azisterweaponsedeco.item;

import net.azister.azisterweaponsedeco.init.AzisterweaponsedecoModItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

public class CopperPickaxeItem extends CopperPickaxeCode {
  public ItemStack newItem() {
    return new ItemStack((ItemLike)AzisterweaponsedecoModItems.EXPOSED_COPPER_PICKAXE.get());
  }
  private static final Tier TOOL_TIER = new Tier()
    {
      public int getUses() {
/* 22 */         return 15;
/*    */       }

      public float getSpeed() {
        return 6.0F;
      }

      public float getAttackDamageBonus() {
/* 32 */         return 2.0F;
/*    */       }

      public int getLevel() { return 2; }

      public TagKey<Block> getIncorrectBlocksForDrops() {
        return BlockTags.INCORRECT_FOR_IRON_TOOL;
      }

      public int getEnchantmentValue() {
/* 42 */         return 0;
/*    */       }

      public Ingredient getRepairIngredient() {
        return Ingredient.of(new ItemStack[] { new ItemStack((ItemLike) Items.COPPER_INGOT) });
      }
    };

  public CopperPickaxeItem() {
    super(TOOL_TIER, (new Properties()).attributes(PickaxeItem.createAttributes(TOOL_TIER, 1.0F, -2.8F)));
  }
}