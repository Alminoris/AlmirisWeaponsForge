package net.alminoris.almirisweapons.datagen;

import net.alminoris.almirisweapons.AlmirisWeapons;
import net.alminoris.almirisweapons.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static net.alminoris.almirisweapons.util.helper.WeaponSetsHelper.MATERIALS;

public class ModItemTagProvider extends ItemTagsProvider
{
    public ModItemTagProvider(DataGenerator p_126530_, BlockTagsProvider p_126531_, String modId, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(p_126530_, p_126531_, modId, existingFileHelper);
    }

    @Override
    protected void addTags()
    {
        for (String name : MATERIALS)
        {
            tag(Tags.Items.TOOLS_SWORDS)
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

            tag(Tags.Items.TOOLS_AXES)
                    .add(ModItems.BATTLE_AXES.get(name).get())
                    .add(ModItems.DANE_AXES.get(name).get())
                    .add(ModItems.BEARDED_AXES.get(name).get());
        }
    }
}