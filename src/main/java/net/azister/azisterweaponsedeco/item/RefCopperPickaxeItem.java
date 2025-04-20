package net.azister.azisterweaponsedeco.item;


import net.azister.azisterweaponsedeco.init.AzisterweaponsedecoModItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

public class RefCopperPickaxeItem extends CopperPickaxeCode
{
  public ItemStack newItem() {
    return new ItemStack((ItemLike)AzisterweaponsedecoModItems.COPPER_PICKAXE.get());
  }
  private static final Tier TOOL_TIER = new Tier()
    {
      public int getUses() {
/* 23 */         return 150;
/*    */       }


      public float getSpeed() {
        return 6.0F;
      }


      public float getAttackDamageBonus() {
         return 2.0F;
      }

      public int getLevel() { return 2;}

      public TagKey<Block> getIncorrectBlocksForDrops() {
        return BlockTags.INCORRECT_FOR_IRON_TOOL;
      }

      public int getEnchantmentValue() {
/* 43 */         return 5;
/*    */       }


      public Ingredient getRepairIngredient() {
/* 48 */         return null;
/*    */       }
    };
  public RefCopperPickaxeItem() {
    super(TOOL_TIER, (new Properties()).attributes(PickaxeItem.createAttributes(TOOL_TIER, 0.0F, -2.6F)));
  }
}
