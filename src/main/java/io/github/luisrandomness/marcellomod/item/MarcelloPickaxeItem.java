package io.github.luisrandomness.marcellomod.item;

import io.github.luisrandomness.marcellomod.init.MM_Tags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.state.BlockState;

public class MarcelloPickaxeItem extends PickaxeItem implements MarcelloEffectiveWeapon {
    public MarcelloPickaxeItem(Tier material, int attackDamage, float attackSpeed, Item.Properties settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        float speed = super.getDestroySpeed(stack,state);
        return speed * (state.is(MM_Tags.BLOCK_MARCELLO_EFFICIENT) && speed >= this.speed ? 3F : 1F);
    }

    @Override
    public float getMarcelloDamageBonus() {
        return 2F;
    }
}
