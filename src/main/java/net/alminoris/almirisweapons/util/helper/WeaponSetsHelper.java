package net.alminoris.almirisweapons.util.helper;

import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.Tier;

import java.util.Dictionary;
import java.util.Hashtable;

public class WeaponSetsHelper
{
    public static final String[] MATERIALS =
            {
                    "wood", "stone", "iron", "gold", "diamond", "netherite"
            };

    public static final Dictionary<String, Tier> TOOL_MATERIALS = new Hashtable<>()
    {{
        put("wood", Tiers.WOOD);
        put("stone", Tiers.STONE);
        put("iron", Tiers.IRON);
        put("gold", Tiers.GOLD);
        put("diamond", Tiers.DIAMOND);
        put("netherite", Tiers.NETHERITE);
    }};
}
