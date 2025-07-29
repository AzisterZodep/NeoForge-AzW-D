/*    */ package net.azister.azisterweaponsedeco.item;


import net.azister.azisterweaponsedeco.init.AzisterweaponsedecoModItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;


/*    */ public class ExpoCopperAxeItem extends CopperAxeCode {
/*    */   public ItemStack newItem() {
/* 17 */     return new ItemStack((ItemLike)AzisterweaponsedecoModItems.WEATHERED_COPPER_AXE.get());
/*    */   }
/* 19 */   private static final Tier TOOL_TIER = new Tier()
/*    */     {
/*    */       public int getUses() {
/* 22 */         return 30;
/*    */       }
/*    */
/*    */
/*    */       public float getSpeed() {
    return 5.0F;
}
/*    */
/*    */
/*    */       public float getAttackDamageBonus() {
/* 32 */         return 2.0F;
/*    */       }
/*    */
/*    */
/*    */       public TagKey<Block> getIncorrectBlocksForDrops() {
/* 37 */         return BlockTags.INCORRECT_FOR_WOODEN_TOOL;
/*    */       }
/*    */
/*    */
/*    */       public int getEnchantmentValue() {
/* 42 */         return 0;
/*    */       }
/*    */
/*    */
/*    */       public Ingredient getRepairIngredient() {
/* 47 */         return null;
/*    */       }
/*    */     };
/*    */
/*    */   public ExpoCopperAxeItem() {
/* 52 */     super(TOOL_TIER, (new Properties()).attributes(AxeItem.createAttributes(TOOL_TIER, 6.0F, -3.0F)));
/*    */   }
/*    */ }
