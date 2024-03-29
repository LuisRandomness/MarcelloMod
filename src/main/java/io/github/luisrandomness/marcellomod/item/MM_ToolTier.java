package io.github.luisrandomness.marcellomod.item;

import io.github.luisrandomness.marcellomod.init.MM_Blocks;
import io.github.luisrandomness.marcellomod.init.MM_Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

public enum MM_ToolTier implements Tier {
   MARCELLO(2, 384, 6.0F, 2.0F, 8, Ingredient.of(MM_Blocks.MARCELLO_BLOCK)),
   JUMPERITE(4, 1999, 9.5F, 5.0F, 12, Ingredient.of(MM_Items.JUMPERITE_INGOT));

   private final int level;
   private final int uses;
   private final float speed;
   private final float damage;
   private final int enchantmentValue;
   private final Ingredient repairIngredient;

   private MM_ToolTier(int miningLevel, int durability, float efficiency, float attackDamage, int enchantability, Ingredient repairMaterial) {
      this.level = miningLevel;
      this.uses = durability;
      this.speed = efficiency;
      this.damage = attackDamage;
      this.enchantmentValue = enchantability;
      this.repairIngredient = repairMaterial;
   }

   public int getUses() {
      return this.uses;
   }

   public float getSpeed() {
      return this.speed;
   }

   public float getAttackDamageBonus() {
      return this.damage;
   }

   public int getLevel() {
      return this.level;
   }

   public int getEnchantmentValue() {
      return this.enchantmentValue;
   }

   public @NotNull Ingredient getRepairIngredient() {
      return this.repairIngredient;
   }
}