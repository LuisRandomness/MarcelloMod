package io.github.luisrandomness.marcellomod.item;

import io.github.luisrandomness.marcellomod.MarcelloMod;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.level.Level;

public class PhoneItem extends Item implements Vanishable {
    public EntityType<?> summoningEntity;
    private static final MutableComponent callMessage = Component.translatable("item." + MarcelloMod.MOD_NAMESPACE + ".phone.call");

    public PhoneItem(EntityType<?> summoningEntity, Item.Properties settings) {
        super(settings);
        this.summoningEntity = summoningEntity;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
            ItemStack phone = player.getItemInHand(usedHand);
            if (level.isClientSide() || !(level instanceof ServerLevel serverWorld) || summoningEntity == null)
                return super.use(level, player, usedHand);

            summoningEntity.spawn(serverWorld, player.blockPosition(), MobSpawnType.REINFORCEMENT);
            player.sendSystemMessage(callMessage);

            player.getCooldowns().addCooldown(this, 30);
            phone.hurtAndBreak(1, player, (e) -> {
                // Mojang why isn't there a helper function to convert from player type -> equipment slot?!?!
                e.broadcastBreakEvent(usedHand == InteractionHand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND);
            });
            return InteractionResultHolder.pass(phone);
    }
}
