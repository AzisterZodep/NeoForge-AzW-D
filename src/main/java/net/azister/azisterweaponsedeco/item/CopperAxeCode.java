package net.azister.azisterweaponsedeco.item;


import net.azister.azisterweaponsedeco.init.AzisterweaponsedecoModItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.ItemLike;


/*    */ public class CopperAxeCode
/*    */   extends AxeItem
/*    */ {
/*    */   public CopperAxeCode(Tier tier, Properties properties) {
/* 18 */     super(tier, properties);
/*    */   }
/*    */   
/*    */   public ItemStack newItem() {
/* 22 */     return new ItemStack((ItemLike)AzisterweaponsedecoModItems.COPPER_AXE.get());
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