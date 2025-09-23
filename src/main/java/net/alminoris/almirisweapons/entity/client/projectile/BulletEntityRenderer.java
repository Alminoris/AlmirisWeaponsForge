package net.alminoris.almirisweapons.entity.client.projectile;

import net.alminoris.almirisweapons.AlmirisWeapons;
import net.alminoris.almirisweapons.entity.custom.projectile.BulletEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import org.jetbrains.annotations.NotNull;

public class BulletEntityRenderer extends ArrowRenderer<BulletEntity>
{
    public BulletEntityRenderer(EntityRendererProvider.Context context)
    {
        super(context);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull BulletEntity entity)
    {
        return ResourceLocation.fromNamespaceAndPath(AlmirisWeapons.MOD_ID, "textures/entity/projectiles/bullet.png");
    }
}