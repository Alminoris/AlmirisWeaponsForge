package net.alminoris.almirisweapons.item;

import net.alminoris.almirisweapons.AlmirisWeapons;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static net.alminoris.almirisweapons.util.helper.WeaponSetsHelper.MATERIALS;

@Mod.EventBusSubscriber(modid = AlmirisWeapons.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItemGroups
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AlmirisWeapons.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ALMIRISWEAPONS_TAB = CREATIVE_MODE_TABS.register("almweaptab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(Items.IRON_SWORD::getDefaultInstance)
            .title(Component.translatable("itemgroup.almweaptab"))
            .displayItems((parameters, entries) ->
            {
                for (String name : MATERIALS)
                {
                    entries.accept(ModItems.HALBERDS.get(name).get());
                    entries.accept(ModItems.RAPIERS.get(name).get());
                    entries.accept(ModItems.CLAYMORES.get(name).get());
                    entries.accept(ModItems.BATTLE_AXES.get(name).get());
                    entries.accept(ModItems.SAI.get(name).get());
                    entries.accept(ModItems.MACES.get(name).get());

                    entries.accept(ModItems.DAGGERS.get(name).get());
                    entries.accept(ModItems.GLAIVES.get(name).get());
                    entries.accept(ModItems.KATANAS.get(name).get());
                    entries.accept(ModItems.BATTLE_STAVES.get(name).get());
                    entries.accept(ModItems.SCYTHES.get(name).get());
                    entries.accept(ModItems.ODACHIS.get(name).get());

                    entries.accept(ModItems.DANE_AXES.get(name).get());
                    entries.accept(ModItems.BEARDED_AXES.get(name).get());
                    entries.accept(ModItems.KATARS.get(name).get());

                    entries.accept(ModItems.STABBING_TIPS.get(name).get());
                    entries.accept(ModItems.AXE_TIPS.get(name).get());
                    entries.accept(ModItems.MACE_TIPS.get(name).get());
                    entries.accept(ModItems.SINGLEEDGE_BLADES.get(name).get());
                    entries.accept(ModItems.DOUBLEEDGE_BLADES.get(name).get());
                    entries.accept(ModItems.CURVED_BLADES.get(name).get());
                }

                entries.accept(ModItems.ARQUEBUS.get());
                entries.accept(ModItems.BLUNDERBUSS.get());
                entries.accept(ModItems.MATCHLOCK_PISTOL.get());
                entries.accept(ModItems.BULLET.get());

                entries.accept(ModItems.ARQUEBUS_BARREL.get());
                entries.accept(ModItems.BLUNDERBUSS_BARREL.get());
                entries.accept(ModItems.PISTOL_BARREL.get());
                entries.accept(ModItems.MATCHLOCK_MECHANISM.get());
                entries.accept(ModItems.GUN_STOCK.get());

                entries.accept(ModItems.SMALL_STICK.get());
            }).build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}