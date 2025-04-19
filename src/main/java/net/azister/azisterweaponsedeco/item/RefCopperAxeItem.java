package net.azister.azisterweaponsedeco.item;


import net.azister.azisterweaponsedeco.init.AzisterweaponsedecoModItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

 public class RefCopperAxeItem extends CopperAxeCode
 {
   public ItemStack newItem() {
     return new ItemStack((ItemLike)AzisterweaponsedecoModItems.COPPER_AXE.get());
   }
   private static final Tier TOOL_TIER = new Tier()
     {
       public int getUses() {
/* 23 */         return 100;
/*    */       }


       public float getSpeed() {
         return 6.0F;
       }


       public float getAttackDamageBonus() {
/* 33 */         return 2.0F;
/*    */       }

       public TagKey<Block> getIncorrectBlocksForDrops() {
         return BlockTags.INCORRECT_FOR_WOODEN_TOOL;
       }

       public int getEnchantmentValue() {
/* 43 */         return 5;
/*    */       }


       public Ingredient getRepairIngredient() {
/* 48 */         return null;
/*    */       }
     };
   public RefCopperAxeItem() {
     super(TOOL_TIER, (new Properties()).attributes(AxeItem.createAttributes(TOOL_TIER, 5.0F, -2.6F)));
   }
 }
