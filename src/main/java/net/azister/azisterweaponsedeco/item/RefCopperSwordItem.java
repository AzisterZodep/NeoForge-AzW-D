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
/*    */ public class RefCopperSwordItem
/*    */   extends CopperSwordCode
/*    */ {
/*    */   public ItemStack newItem() {
/* 18 */     return new ItemStack((ItemLike)AzisterweaponsedecoModItems.COPPER_SWORD.get());
/*    */   }
/* 20 */   private static final Tier TOOL_TIER = new Tier()
/*    */     {
/*    */       public int getUses() {
/* 23 */         return 100;
/*    */       }
/*    */ 
/*    */       
/*    */       public float getSpeed() {
/* 28 */         return 0.0F;
/*    */       }
/*    */ 
/*    */       
/*    */       public float getAttackDamageBonus() {
/* 33 */         return 2.0F;
/*    */       }
/*    */ 
/*    */       
/*    */       public TagKey<Block> getIncorrectBlocksForDrops() {
/* 38 */         return BlockTags.INCORRECT_FOR_WOODEN_TOOL;
/*    */       }
/*    */ 
/*    */       
/*    */       public int getEnchantmentValue() {
/* 43 */         return 5;
/*    */       }
/*    */ 
/*    */       
/*    */       public Ingredient getRepairIngredient() {
/* 48 */         return null;
/*    */       }
/*    */     };
/*    */   public RefCopperSwordItem() {
/* 52 */     super(TOOL_TIER, (new Item.Properties()).attributes(SwordItem.createAttributes(TOOL_TIER, 2.0F, -2.0F)));
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Documents\azisterweaponsedeco-0.2.1.jar!\net\azister\azisterweaponsedeco\item\RefCopperSwordItem.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */