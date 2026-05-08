package net.azister.azisterweaponsedeco.item;


import net.azister.azisterweaponsedeco.init.AzisterweaponsedecoModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.ItemLike;


public class FlintPickaxeCode
   extends PickaxeItem
 {
   public FlintPickaxeCode(Tier tier, Properties properties) {
/* 18 */     super(tier, properties);
/*    */   }

   public ItemStack newItem() {
     return new ItemStack((ItemLike)AzisterweaponsedecoModItems.FLINT_PICKAXE.get());
   }
 }