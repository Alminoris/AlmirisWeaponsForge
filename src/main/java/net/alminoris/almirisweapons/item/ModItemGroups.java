package net.alminoris.almirisweapons.item;

import net.alminoris.almirisweapons.AlmirisWeapons;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModItemGroups {
    public static final CreativeModeTab ALMIRISWEAPONS_TAB = new CreativeModeTab(AlmirisWeapons.MOD_ID + ".almweaptab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.IRON_SWORD);
        }

        @Override
        public Component getDisplayName() {
            return new TranslatableComponent("itemGroup." + AlmirisWeapons.MOD_ID + ".almweaptab");
        }
    };
}