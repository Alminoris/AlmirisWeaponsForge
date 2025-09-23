package net.alminoris.almirisweapons.datagen;

import net.alminoris.almirisweapons.AlmirisWeapons;
import net.alminoris.almirisweapons.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import static net.alminoris.almirisweapons.util.helper.WeaponSetsHelper.MATERIALS;

public class ModItemModelProvider extends ItemModelProvider
{
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, AlmirisWeapons.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        generatedItem(ModItems.SMALL_STICK);
        generatedItem(ModItems.BULLET);
        generatedItem(ModItems.ARQUEBUS_BARREL);
        generatedItem(ModItems.BLUNDERBUSS_BARREL);
        generatedItem(ModItems.PISTOL_BARREL);
        generatedItem(ModItems.MATCHLOCK_MECHANISM);
        generatedItem(ModItems.GUN_STOCK);

        for (String name : MATERIALS)
        {
            handheldItem(ModItems.DAGGERS.get(name));
            handheldItem(ModItems.BATTLE_AXES.get(name));
            handheldItem(ModItems.BEARDED_AXES.get(name));
            handheldItem(ModItems.MACES.get(name));

            generatedItem(ModItems.STABBING_TIPS.get(name));
            generatedItem(ModItems.MACE_TIPS.get(name));
            generatedItem(ModItems.AXE_TIPS.get(name));
            generatedItem(ModItems.CURVED_BLADES.get(name));
            generatedItem(ModItems.SINGLEEDGE_BLADES.get(name));
            generatedItem(ModItems.DOUBLEEDGE_BLADES.get(name));
        }
    }

    private ItemModelBuilder generatedItem(RegistryObject<Item> item)
    {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(AlmirisWeapons.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item)
    {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(AlmirisWeapons.MOD_ID,"item/" + item.getId().getPath()));
    }
}