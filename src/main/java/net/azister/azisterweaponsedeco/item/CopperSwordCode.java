/*    */ package net.azister.azisterweaponsedeco.item;
/*    */ 
/*    */ import net.azister.azisterweaponsedeco.init.AzisterweaponsedecoModItems;
/*    */ import net.minecraft.world.InteractionHand;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.SwordItem;
/*    */ import net.minecraft.world.item.Tier;
/*    */ import net.minecraft.world.level.ItemLike;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CopperSwordCode
/*    */   extends SwordItem
/*    */ {
/*    */   public CopperSwordCode(Tier tier, Item.Properties properties) {
/* 18 */     super(tier, properties);
/*    */   }
/*    */   
/*    */   public ItemStack newItem() {
/* 22 */     return new ItemStack((ItemLike)AzisterweaponsedecoModItems.COPPER_SWORD.get());
/*    */   }
/*    */   
/*    */   public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity, InteractionHand hand) {
/* 26 */     super.onEntitySwing(itemstack, entity, hand);
/* 27 */     if (itemstack.getDamageValue() >= itemstack.getMaxDamage() - 2) {
/* 28 */       if (hand == InteractionHand.MAIN_HAND) {
/* 29 */         entity.setItemInHand(InteractionHand.MAIN_HAND, newItem());
/* 30 */       } else if (hand == InteractionHand.OFF_HAND) {
/* 31 */         entity.setItemInHand(InteractionHand.OFF_HAND, newItem());
/*    */       } 
/* 33 */       entity.spawnAtLocation(itemstack);
/* 34 */       itemstack.shrink(1);
/*    */     } 
/* 36 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Documents\azisterweaponsedeco-0.2.1.jar!\net\azister\azisterweaponsedeco\item\CopperSwordCode.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */