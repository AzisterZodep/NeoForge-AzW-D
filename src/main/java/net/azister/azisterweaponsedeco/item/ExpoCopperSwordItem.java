/*    */ package net.azister.azisterweaponsedeco.item;
/*    */ 
/*    */ import net.azister.azisterweaponsedeco.init.AzisterweaponsedecoModItems;
/*    */ import net.minecraft.tags.BlockTags;
/*    */ import net.minecraft.tags.TagKey;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.SwordItem;
/*    */ import net.minecraft.world.item.Tier;
/*    */ import net.minecraft.world.item.crafting.Ingredient;
/*    */ import net.minecraft.world.level.ItemLike;
/*    */ import net.minecraft.world.level.block.Block;
/*    */ 
/*    */ public class ExpoCopperSwordItem
/*    */   extends CopperSwordCode {
/*    */   public ItemStack newItem() {
/* 17 */     return new ItemStack((ItemLike)AzisterweaponsedecoModItems.WEATHERED_COPPER_SWORD.get());
/*    */   }
/* 19 */   private static final Tier TOOL_TIER = new Tier()
/*    */     {
/*    */       public int getUses() {
/* 22 */         return 30;
/*    */       }
/*    */ 
/*    */       
/*    */       public float getSpeed() {
/* 27 */         return 0.0F;
/*    */       }
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
/* 42 */         return 5;
/*    */       }
/*    */ 
/*    */       
/*    */       public Ingredient getRepairIngredient() {
/* 47 */         return null;
/*    */       }
/*    */     };
/*    */   
/*    */   public ExpoCopperSwordItem() {
/* 52 */     super(TOOL_TIER, (new Item.Properties()).attributes(SwordItem.createAttributes(TOOL_TIER, 3.0F, -2.4F)));
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Documents\azisterweaponsedeco-0.2.1.jar!\net\azister\azisterweaponsedeco\item\ExpoCopperSwordItem.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */