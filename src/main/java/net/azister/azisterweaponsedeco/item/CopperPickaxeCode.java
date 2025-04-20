package net.azister.azisterweaponsedeco.item;


import net.azister.azisterweaponsedeco.init.AzisterweaponsedecoModItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.ItemLike;


public class CopperPickaxeCode
   extends PickaxeItem
 {
   public CopperPickaxeCode(Tier tier, Properties properties) {
/* 18 */     super(tier, properties);
/*    */   }

   public ItemStack newItem() {
     return new ItemStack((ItemLike)AzisterweaponsedecoModItems.COPPER_PICKAXE.get());
   }

   public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity, InteractionHand hand) {
     super.onEntitySwing(itemstack, entity, hand);
     if (itemstack.getDamageValue() >= itemstack.getMaxDamage() - 2) {
       if (hand == InteractionHand.MAIN_HAND) {
         entity.setItemInHand(InteractionHand.MAIN_HAND, newItem());
       } else if (hand == InteractionHand.OFF_HAND) {
         entity.setItemInHand(InteractionHand.OFF_HAND, newItem());
       }
       entity.spawnAtLocation(itemstack);
       itemstack.shrink(1);
     }
     return false;
   }
 }