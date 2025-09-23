package net.alminoris.almirisweapons.datagen;

import net.alminoris.almirisweapons.AlmirisWeapons;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider
{

    public ModBlockTagProvider(DataGenerator p_126511_, String modId, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(p_126511_, modId, existingFileHelper);
    }

    @Override
    protected void addTags()
    {
        super.addTags();
    }
}