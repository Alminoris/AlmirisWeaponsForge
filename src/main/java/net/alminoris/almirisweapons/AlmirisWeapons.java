package net.alminoris.almirisweapons;

import com.mojang.logging.LogUtils;
import net.alminoris.almirisweapons.entity.ModEntities;
import net.alminoris.almirisweapons.entity.client.projectile.BulletEntityRenderer;
import net.alminoris.almirisweapons.item.ModItemGroups;
import net.alminoris.almirisweapons.item.ModItems;
import net.alminoris.almirisweapons.sound.ModSounds;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import static net.alminoris.almirisweapons.util.helper.WeaponSetsHelper.MATERIALS;

@Mod(net.alminoris.almirisweapons.AlmirisWeapons.MOD_ID)
public class AlmirisWeapons
{
    public static final String MOD_ID = "almirisweapons";

    private static final Logger LOGGER = LogUtils.getLogger();

    public AlmirisWeapons(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        ModItems.register(modEventBus);

        ModEntities.register(modEventBus);

        ModSounds.register(modEventBus);

        modEventBus.addListener(this::addCreative);

        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    private void addCreative(CreativeModeTabEvent.BuildContents entries)
    {
        if(entries.getTab() == ModItemGroups.ALMIRISWEAPONS_TAB)
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
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        LOGGER.info("HELLO from server starting");
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(ModEntities.BULLET.get(), BulletEntityRenderer::new);
        }
    }
}