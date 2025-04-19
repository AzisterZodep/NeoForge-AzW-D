package net.azister.azisterweaponsedeco.item;

import net.azister.azisterweaponsedeco.init.AzisterweaponsedecoModItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

 public class CopperAxeItem extends CopperSwordCode {
   public ItemStack newItem() {
     return new ItemStack((ItemLike)AzisterweaponsedecoModItems.EXPOSED_COPPER_AXE.get());
   }
   private static final Tier TOOL_TIER = new Tier()
     {
       public int getUses() {
/* 22 */         return 40;
/*    */       }

       public float getSpeed() {
         return 6.0F;
       }

       public float getAttackDamageBonus() {
/* 32 */         return 2.0F;
/*    */       }

       public TagKey<Block> getIncorrectBlocksForDrops() {
/* 37 */         return BlockTags.INCORRECT_FOR_WOODEN_TOOL;
/*    */       }

       public int getEnchantmentValue() {
/* 42 */         return 5;
/*    */       }

       public Ingredient getRepairIngredient() {
         return Ingredient.of(new ItemStack[] { new ItemStack((ItemLike)Items.COPPER_INGOT) });
       }
     };

   public CopperAxeItem() {
     super(TOOL_TIER, (new Properties()).attributes(AxeItem.createAttributes(TOOL_TIER, 5.0F, -2.8F)));
   }
}