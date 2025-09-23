package net.alminoris.almirisweapons.datagen;

import net.alminoris.almirisweapons.AlmirisWeapons;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = AlmirisWeapons.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators
{
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(event.includeServer(), new ModRecipeProvider(generator));

        BlockTagsProvider blockTagsProvider = new ModBlockTagProvider(generator, AlmirisWeapons.MOD_ID, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(event.includeServer(), new ModItemTagProvider(generator, blockTagsProvider, AlmirisWeapons.MOD_ID, existingFileHelper));

        generator.addProvider(event.includeClient(), new ModItemModelProvider(generator, AlmirisWeapons.MOD_ID, existingFileHelper));
    }
}