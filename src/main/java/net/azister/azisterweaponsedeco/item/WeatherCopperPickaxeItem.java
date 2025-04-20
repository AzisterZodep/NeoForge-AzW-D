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

 public class WeatherCopperPickaxeItem extends CopperPickaxeCode {
   public ItemStack newItem() {
     return new ItemStack((ItemLike)AzisterweaponsedecoModItems.OXIDIZED_COPPER_PICKAXE.get());
   }
   private static final Tier TOOL_TIER = new Tier()
     {
       public int getUses() {
/* 22 */         return 20;
/*    */       }

       public float getSpeed() {
    return 5.0F;
}

       public float getAttackDamageBonus() {
         return 2.0F;
       }

       public int getLevel() { return 2;}

       public TagKey<Block> getIncorrectBlocksForDrops() {
/* 37 */         return BlockTags.INCORRECT_FOR_STONE_TOOL;
/*    */       }

       public int getEnchantmentValue() {
/* 42 */         return 5;
/*    */       }

       public Ingredient getRepairIngredient() {
/* 47 */         return null;
/*    */       }
     };

   public WeatherCopperPickaxeItem() {
     super(TOOL_TIER, (new Properties()).attributes(PickaxeItem.createAttributes(TOOL_TIER, 2.0F, -3.2F)));
   }
 }