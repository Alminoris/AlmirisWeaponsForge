package net.alminoris.almirisweapons.item;

import net.alminoris.almirisweapons.AlmirisWeapons;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static net.alminoris.almirisweapons.util.helper.WeaponSetsHelper.MATERIALS;

@Mod.EventBusSubscriber(modid = AlmirisWeapons.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItemGroups
{
    public static CreativeModeTab ALMIRISWEAPONS_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event)
    {
        ALMIRISWEAPONS_TAB = event.registerCreativeModeTab(ResourceLocation.fromNamespaceAndPath(AlmirisWeapons.MOD_ID, "almweaptab"),
                builder -> builder.icon(() -> new ItemStack(Items.IRON_SWORD))
                        .title(Component.translatable("itemgroup.almweaptab")));
    }
}