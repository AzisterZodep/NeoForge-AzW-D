/*    */ package net.azister.azisterweaponsedeco.item;
/*    */ 
/*    */ import net.minecraft.tags.BlockTags;
/*    */ import net.minecraft.tags.TagKey;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.SwordItem;
/*    */ import net.minecraft.world.item.Tier;
/*    */ import net.minecraft.world.item.crafting.Ingredient;
/*    */ import net.minecraft.world.level.block.Block;
/*    */ 
/*    */ public class OxiCopperSwordItem
/*    */   extends SwordItem
/*    */ {
/* 14 */   private static final Tier TOOL_TIER = new Tier()
/*    */     {
/*    */       public int getUses() {
/* 17 */         return 200;
/*    */       }
/*    */ 
/*    */       
/*    */       public float getSpeed() {
/* 22 */         return 0.0F;
/*    */       }
/*    */ 
/*    */       
/*    */       public float getAttackDamageBonus() {
/* 27 */         return 2.0F;
/*    */       }
/*    */ 
/*    */       
/*    */       public TagKey<Block> getIncorrectBlocksForDrops() {
/* 32 */         return BlockTags.INCORRECT_FOR_WOODEN_TOOL;
/*    */       }
/*    */ 
/*    */       
/*    */       public int getEnchantmentValue() {
/* 37 */         return 5;
/*    */       }
/*    */ 
/*    */       
/*    */       public Ingredient getRepairIngredient() {
/* 42 */         return null;
/*    */       }
/*    */     };
/*    */   
/*    */   public OxiCopperSwordItem() {
/* 47 */     super(TOOL_TIER, (new Item.Properties()).attributes(SwordItem.createAttributes(TOOL_TIER, 5.0F, -2.8F)));
/*    */   }
/*    */ }