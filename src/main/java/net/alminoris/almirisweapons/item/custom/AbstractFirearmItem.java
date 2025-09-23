package net.alminoris.almirisweapons.item.custom;

import net.alminoris.almirisweapons.entity.custom.projectile.BulletEntity;
import net.alminoris.almirisweapons.item.ModItems;
import net.alminoris.almirisweapons.item.render.FirearmItemRenderer;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public abstract class AbstractFirearmItem extends Item
{
    public AbstractFirearmItem(Item.Properties settings)
    {
        super(settings);
    }

    protected abstract FirearmConfig getConfig();

    protected abstract Map<UUID, Integer> getPullTicks();

    private final Map<UUID, Integer> reloadTimers = new HashMap<>();

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player user, InteractionHand hand)
    {
        if (user.getCooldowns().isOnCooldown(this))
            return InteractionResultHolder.fail(user.getItemInHand(hand));
        getPullTicks().put(user.getUUID(), 0);
        user.startUsingItem(hand);
        return InteractionResultHolder.consume(user.getItemInHand(hand));
    }

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int slot, boolean selected)
    {
        if (!(entity instanceof Player player) || world.isClientSide) return;

        UUID uuid = player.getUUID();

        if (getPullTicks().containsKey(uuid))
        {
            int ticks = getPullTicks().get(uuid) + 1;
            getPullTicks().put(uuid, ticks);

            if (ticks >= getConfig().minUseTicks())
            {
                getPullTicks().remove(uuid);
                player.stopUsingItem();
                fire(world, player, player.getItemInHand(player.getUsedItemHand()), player.getUsedItemHand());
            }
        }

        if (reloadTimers.containsKey(uuid))
        {
            int ticksLeft = reloadTimers.get(uuid) - 1;
            if (ticksLeft <= 0)
            {
                playSound(world, player,
                        getConfig().reloadSound(),
                        getConfig().reloadVolume(),
                        getConfig().reloadPitch());

                reloadTimers.remove(uuid);
            }
            else
            {
                reloadTimers.put(uuid, ticksLeft);
            }
        }
    }

    private void startReload(Level world, Player player, ItemStack stack, InteractionHand hand)
    {
        int reloadTime = getConfig().reloadTicks();

        player.getCooldowns().addCooldown(this, reloadTime);
        reloadTimers.put(player.getUUID(), reloadTime);

        if (world instanceof ServerLevel serverWorld && getConfig().reloadParticle() != null)
        {
            serverWorld.sendParticles(getConfig().reloadParticle(),
                    player.getX(), player.getEyeY() - 0.2, player.getZ(),
                    getConfig().reloadParticleCount(), 0.05, 0.05, 0.05, 0.01);
        }

        if (world.isClientSide)
        {
            FirearmItemRenderer.startReload(player.getUUID(), hand, reloadTime);
        }
    }

    private void playSound(Level world, Player player, SoundEvent sound, float volume, float pitch)
    {
        world.playSound(null, player.getX(), player.getY(), player.getZ(),
                sound, player.getSoundSource(), volume, pitch);
    }



    @Override
    public void onStopUsing(ItemStack stack, LivingEntity user, int count)
    {
        if (!(user instanceof Player player) || user.getCommandSenderWorld().isClientSide) return;

        UUID uuid = player.getUUID();
        int usedTicks = getPullTicks().getOrDefault(uuid, 0);
        getPullTicks().remove(uuid);

        if (usedTicks >= getConfig().minUseTicks())
        {
            fire(user.getCommandSenderWorld(), player, stack, player.getUsedItemHand());
        }
    }

    private void fire(Level world, Player player, ItemStack stack, InteractionHand hand)
    {
        if (player.getCooldowns().isOnCooldown(this))
        {
            return;
        }

        if (world.random.nextFloat() < getConfig().misfireChance())
        {
            player.sendSystemMessage(Component.translatable("message.almirisweapons.misfire"));
            playSound(world, player, getConfig().misfireSound(), 1f, 1f);
            startReload(world, player, stack, hand);
            return;
        }

        ItemStack ammo = findAmmo(player);
        if (ammo.isEmpty() || ammo.getCount() < getConfig().ammoPerShot())
        {
            player.sendSystemMessage(Component.translatable("message.almirisweapons.no_ammo"));
            return;
        }
        ammo.shrink(getConfig().ammoPerShot());

        for (int i = 0; i < getConfig().projectilesPerShot(); i++)
        {
            ItemStack bulletStack = new ItemStack(ModItems.BULLET.get());
            BulletEntity bullet = new BulletEntity(world, player, bulletStack, stack);
            bullet.setDamage(getConfig().damage());

            bullet.shootFromRotation(player,
                    player.getXRot(),
                    player.getYRot() + (world.random.nextFloat() - 0.5F) * getConfig().spreadAngle(),
                    0.0F,
                    getConfig().velocity(),
                    getConfig().inaccuracy());

            world.addFreshEntity(bullet);
        }

        stack.hurtAndBreak(1, player, EquipmentSlot.MAINHAND);

        playSound(world, player, getConfig().shootSound(), getConfig().soundVolume(), getConfig().soundPitch());

        if (world instanceof ServerLevel serverWorld)
        {
            serverWorld.sendParticles(getConfig().smokeParticle(),
                    player.getX(), player.getEyeY(), player.getZ(),
                    getConfig().smokeCount(), getConfig().smokeSpread(), getConfig().smokeSpread(),
                    getConfig().smokeSpread(), getConfig().smokeSpeed());

            if (getConfig().flameParticle() != null)
            {
                serverWorld.sendParticles(getConfig().flameParticle(),
                        player.getX(), player.getEyeY(), player.getZ(),
                        getConfig().flameCount(), 0.05, 0.05, 0.05, 0.01);
            }
        }

        if (world.isClientSide)
        {
            FirearmItemRenderer.triggerRecoil(player.getUUID(), hand, getConfig().recoilStrength());
        }

        applyRecoil(player);
        startReload(world, player, stack, hand);
    }

    protected void applyRecoil(LivingEntity user)
    {
        double yawRad = Math.toRadians(user.getYRot());
        double rx = -Math.sin(yawRad) * getConfig().recoilStrength();
        double rz = Math.cos(yawRad) * getConfig().recoilStrength();
        double ry = getConfig().recoilVertical();
        user.setDeltaMovement(user.getDeltaMovement().add(rx, ry, rz));
    }

    private ItemStack findAmmo(Player player)
    {
        if (player.getOffhandItem().is(ModItems.BULLET.get())) return player.getOffhandItem();
        if (player.getMainHandItem().is(ModItems.BULLET.get())) return player.getMainHandItem();
        for (ItemStack stack : player.getInventory().items)
        {
            if (stack.is(ModItems.BULLET.get())) return stack;
        }
        return ItemStack.EMPTY;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag type)
    {
        super.appendHoverText(stack, context, tooltip, type);

        FirearmConfig cfg = getConfig();

        tooltip.add(Component.empty());

        tooltip.add(Component.translatable("item.modifiers.mainhand").withStyle(ChatFormatting.GRAY));

        tooltip.add(Component.literal(" ")
                .append(cfg.damage() + " ").withStyle(ChatFormatting.DARK_GREEN)
                .append(Component.translatable("tooltip.almirisweapons.damage")
                        .withStyle(ChatFormatting.DARK_GREEN)));

        tooltip.add(Component.literal(" ")
                .append((cfg.reloadTicks() / 20f) + "s ").withStyle(ChatFormatting.DARK_GREEN)
                .append(Component.translatable("tooltip.almirisweapons.reload_time")
                        .withStyle(ChatFormatting.DARK_GREEN)));

        tooltip.add(Component.literal(" ")
                .append(cfg.ammoPerShot() + " ").withStyle(ChatFormatting.DARK_GREEN)
                .append(Component.translatable("tooltip.almirisweapons.ammo_per_shot")
                        .withStyle(ChatFormatting.DARK_GREEN)));

        tooltip.add(Component.literal(" ")
                .append((int)(cfg.misfireChance() * 100) + "% ").withStyle(ChatFormatting.DARK_GREEN)
                .append(Component.translatable("tooltip.almirisweapons.misfire")
                        .withStyle(ChatFormatting.DARK_GREEN)));
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack)
    {
        return getConfig().useAction();
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity)
    {
        return getConfig().maxUseTime();
    }

    @Override
    public void initializeClient(java.util.function.Consumer<net.minecraftforge.client.extensions.common.IClientItemExtensions> consumer)
    {
        consumer.accept(new net.minecraftforge.client.extensions.common.IClientItemExtensions()
        {
            private final FirearmItemRenderer renderer = new FirearmItemRenderer();

            @Override
            public net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer getCustomRenderer()
            {
                return renderer;
            }
        });
    }
}