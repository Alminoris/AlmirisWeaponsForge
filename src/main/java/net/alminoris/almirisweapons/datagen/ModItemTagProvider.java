package net.alminoris.almirisweapons.datagen;

import net.alminoris.almirisweapons.AlmirisWeapons;
import net.alminoris.almirisweapons.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static net.alminoris.almirisweapons.util.helper.WeaponSetsHelper.MATERIALS;

public class ModItemTagProvider extends ItemTagsProvider
{
    public ModItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture,
                              CompletableFuture<TagLookup<Block>> lookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(packOutput, completableFuture, lookupCompletableFuture, AlmirisWeapons.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider)
    {
        for (String name : MATERIALS)
        {
            tag(ItemTags.SWORDS)
                    .add(ModItems.HALBERDS.get(name).get())
                    .add(ModItems.SAI.get(name).get())
                    .add(ModItems.CLAYMORES.get(name).get())
                    .add(ModItems.SCYTHES.get(name).get())
                    .add(ModItems.ODACHIS.get(name).get())
                    .add(ModItems.KATANAS.get(name).get())
                    .add(ModItems.KATARS.get(name).get())
                    .add(ModItems.DAGGERS.get(name).get())
                    .add(ModItems.GLAIVES.get(name).get())
                    .add(ModItems.BATTLE_STAVES.get(name).get())
                    .add(ModItems.RAPIERS.get(name).get());

            tag(ItemTags.AXES)
                    .add(ModItems.BATTLE_AXES.get(name).get())
                    .add(ModItems.DANE_AXES.get(name).get())
                    .add(ModItems.BEARDED_AXES.get(name).get());
        }
    }
}