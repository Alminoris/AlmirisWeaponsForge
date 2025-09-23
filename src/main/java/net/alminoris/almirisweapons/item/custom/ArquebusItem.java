package net.alminoris.almirisweapons.item.custom;

import net.minecraft.world.item.Item;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ArquebusItem extends AbstractFirearmItem
{
    private static final Map<UUID, Integer> pullTicks = new HashMap<>();

    private final FirearmConfig config;

    public ArquebusItem(Item.Properties settings, FirearmConfig config)
    {
        super(settings.durability(100));
        this.config = config;
    }

    @Override
    protected Map<UUID, Integer> getPullTicks()
    {
        return pullTicks;
    }

    @Override
    protected FirearmConfig getConfig()
    {
        return config;
    }
}