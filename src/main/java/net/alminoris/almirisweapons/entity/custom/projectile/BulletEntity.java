package net.alminoris.almirisweapons.entity.custom.projectile;

import net.alminoris.almirisweapons.entity.ModEntities;
import net.alminoris.almirisweapons.item.ModItems;
import net.alminoris.almirisweapons.sound.ModSounds;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BulletEntity extends AbstractArrow
{
    private double damage = 8.0D;

    private ItemStack bulletStack = ItemStack.EMPTY;
    private ItemStack shotFrom = ItemStack.EMPTY;
    private ItemStack pickupStack = ItemStack.EMPTY;

    public BulletEntity(EntityType<? extends AbstractArrow> entityType, Level world) {
        super(entityType, world);
    }

    public BulletEntity(Level world, LivingEntity owner, ItemStack stack, @Nullable ItemStack shotFrom) {
        super(ModEntities.BULLET.get(), owner, world);
        this.pickup = Pickup.DISALLOWED;

        if (stack != null) {
            this.bulletStack = stack.copy();
        }
        if (shotFrom != null) {
            this.shotFrom = shotFrom.copy();
        }
    }

    @Override
    protected @NotNull SoundEvent getDefaultHitGroundSoundEvent() {
        return ModSounds.EMPTY.get();
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getCommandSenderWorld().isClientSide && !this.inGround) {
            this.getCommandSenderWorld().addParticle(
                    ParticleTypes.SMOKE,
                    this.getX(), this.getY(), this.getZ(),
                    0.0, 0.0, 0.0
            );
        }
    }

    @Override
    protected void onHitEntity(@NotNull EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);

        if (!this.getCommandSenderWorld().isClientSide) {
            if (entityHitResult.getEntity() instanceof LivingEntity target) {
                DamageSource source = this.getCommandSenderWorld()
                        .damageSources()
                        .arrow(this, this.getOwner() instanceof LivingEntity shooter ? shooter : null);

                target.hurt(source, (float) this.damage);
                this.discard();
            }
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult blockHitResult)
    {
        super.onHitBlock(blockHitResult);

        if (!this.level().isClientSide)
        {
            int count = this.random.nextInt(3);
            if (count > 0) {
                ItemEntity drop = new ItemEntity(
                        this.level(),
                        this.getX(),
                        this.getY(),
                        this.getZ(),
                        new ItemStack(Items.IRON_NUGGET, count)
                );
                this.level().addFreshEntity(drop);
            }
        }
    }

    @Override
    protected ItemStack getPickupItem()
    {
        return new ItemStack(ModItems.BULLET.get());
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);

        if (nbt.contains("BulletDamage")) {
            this.damage = nbt.getDouble("BulletDamage");
        }
        if (nbt.contains("BulletStack")) {
            this.bulletStack = ItemStack.of(nbt.getCompound("BulletStack"));
        }
        if (nbt.contains("ShotFrom")) {
            this.shotFrom = ItemStack.of(nbt.getCompound("ShotFrom"));
        }
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);

        nbt.putDouble("BulletDamage", this.damage);

        if (!this.bulletStack.isEmpty()) {
            nbt.put("BulletStack", this.bulletStack.save(new CompoundTag()));
        }
        if (!this.shotFrom.isEmpty()) {
            nbt.put("ShotFrom", this.shotFrom.save(new CompoundTag()));
        }
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public ItemStack getBulletStack() {
        return this.bulletStack;
    }

    public ItemStack getShotFrom() {
        return this.shotFrom;
    }
}