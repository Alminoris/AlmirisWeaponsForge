package net.alminoris.almirisweapons;

import com.mojang.logging.LogUtils;
import net.alminoris.almirisweapons.entity.ModEntities;
import net.alminoris.almirisweapons.entity.client.projectile.BulletEntityRenderer;
import net.alminoris.almirisweapons.item.ModItems;
import net.alminoris.almirisweapons.sound.ModSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(AlmirisWeapons.MOD_ID)
public class AlmirisWeapons {
    public static final String MOD_ID = "almirisweapons";

    private static final Logger LOGGER = LogUtils.getLogger();

    public AlmirisWeapons()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModEntities.register(modEventBus);
        ModSounds.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.BULLET.get(), BulletEntityRenderer::new);

            event.enqueueWork(() -> {
                Minecraft mc = Minecraft.getInstance();

                ModelResourceLocation arquebusModel = new ModelResourceLocation(
                        ResourceLocation.fromNamespaceAndPath(AlmirisWeapons.MOD_ID, "arquebus_3d"), "inventory");

                ModelResourceLocation blunderbussModel = new ModelResourceLocation(
                        ResourceLocation.fromNamespaceAndPath(AlmirisWeapons.MOD_ID, "blunderbuss_3d"), "inventory");

                mc.getItemRenderer().getItemModelShaper().register(ModItems.ARQUEBUS.get(), arquebusModel);
                mc.getItemRenderer().getItemModelShaper().register(ModItems.BLUNDERBUSS.get(), blunderbussModel);
            });
        }
    }
}