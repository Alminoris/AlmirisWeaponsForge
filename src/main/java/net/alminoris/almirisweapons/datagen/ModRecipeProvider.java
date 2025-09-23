package net.alminoris.almirisweapons.datagen;

import net.alminoris.almirisweapons.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.RegistryObject;

import java.util.concurrent.CompletableFuture;

import static net.alminoris.almirisweapons.util.helper.WeaponSetsHelper.MATERIALS;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder
{
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries)
    {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput)
    {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BATTLE_STAVES.get("wood").get(), 1)
                .pattern("  #")
                .pattern(" / ")
                .pattern("#  ")
                .define('#', ItemTags.PLANKS)
                .define('/', Items.STICK)
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BATTLE_STAVES.get("stone").get(), 1)
                .pattern("  #")
                .pattern(" / ")
                .pattern("#  ")
                .define('#', ItemTags.STONE_TOOL_MATERIALS)
                .define('/', Items.STICK)
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BATTLE_STAVES.get("iron").get(), 1)
                .pattern("  #")
                .pattern(" / ")
                .pattern("#  ")
                .define('#', Items.IRON_INGOT)
                .define('/', Items.STICK)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BATTLE_STAVES.get("gold").get(), 1)
                .pattern("  #")
                .pattern(" / ")
                .pattern("#  ")
                .define('#', Items.GOLD_INGOT)
                .define('/', Items.STICK)
                .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BATTLE_STAVES.get("diamond").get(), 1)
                .pattern("  #")
                .pattern(" / ")
                .pattern("#  ")
                .define('#', Items.DIAMOND)
                .define('/', Items.STICK)
                .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BATTLE_STAVES.get("netherite").get(), 1)
                .pattern("  #")
                .pattern(" / ")
                .pattern("#  ")
                .define('#', Items.NETHERITE_INGOT)
                .define('/', Items.STICK)
                .unlockedBy(getHasName(Items.NETHERITE_INGOT), has(Items.NETHERITE_INGOT))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SMALL_STICK.get(), 2)
                .requires(Items.STICK)
                .group("small_stick")
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(recipeOutput);

        RegistryObject<Item> woodStabbingTip = ModItems.STABBING_TIPS.get("wood");
        if (woodStabbingTip == null) {
            throw new IllegalStateException("wood_stabbing_tip is not registered properly!");
        }

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STABBING_TIPS.get("wood").get(), 3)
                .pattern("/")
                .pattern("/")
                .pattern("/")
                .define('/', ItemTags.PLANKS)
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AXE_TIPS.get("wood").get(), 3)
                .pattern("/  ")
                .pattern("///")
                .pattern("/  ")
                .define('/', ItemTags.PLANKS)
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MACE_TIPS.get("wood").get(), 3)
                .pattern(" / ")
                .pattern("///")
                .pattern(" / ")
                .define('/', ItemTags.PLANKS)
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SINGLEEDGE_BLADES.get("wood").get(), 3)
                .pattern("  /")
                .pattern(" / ")
                .pattern("/  ")
                .define('/', ItemTags.PLANKS)
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CURVED_BLADES.get("wood").get(), 3)
                .pattern(" /")
                .pattern("/ ")
                .pattern(" /")
                .define('/', ItemTags.PLANKS)
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STABBING_TIPS.get("stone").get(), 3)
                .pattern("/")
                .pattern("/")
                .pattern("/")
                .define('/', ItemTags.STONE_TOOL_MATERIALS)
                .unlockedBy(getHasName(Items.COBBLESTONE), has(Items.COBBLESTONE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AXE_TIPS.get("stone").get(), 3)
                .pattern("/  ")
                .pattern("///")
                .pattern("/  ")
                .define('/', ItemTags.STONE_TOOL_MATERIALS)
                .unlockedBy(getHasName(Items.COBBLESTONE), has(Items.COBBLESTONE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MACE_TIPS.get("stone").get(), 3)
                .pattern(" / ")
                .pattern("///")
                .pattern(" / ")
                .define('/', ItemTags.STONE_TOOL_MATERIALS)
                .unlockedBy(getHasName(Items.COBBLESTONE), has(Items.COBBLESTONE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SINGLEEDGE_BLADES.get("stone").get(), 3)
                .pattern("  /")
                .pattern(" / ")
                .pattern("/  ")
                .define('/', ItemTags.STONE_TOOL_MATERIALS)
                .unlockedBy(getHasName(Items.COBBLESTONE), has(Items.COBBLESTONE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CURVED_BLADES.get("stone").get(), 3)
                .pattern(" /")
                .pattern("/ ")
                .pattern(" /")
                .define('/', ItemTags.STONE_TOOL_MATERIALS)
                .unlockedBy(getHasName(Items.COBBLESTONE), has(Items.COBBLESTONE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PISTOL_BARREL.get(), 1)
                .pattern("  #")
                .pattern("*/ ")
                .define('#', Items.IRON_INGOT)
                .define('*', Items.IRON_NUGGET)
                .define('/', ModItems.SMALL_STICK.get())
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .unlockedBy(getHasName(Items.IRON_NUGGET), has(Items.IRON_NUGGET))
                .unlockedBy(getHasName(ModItems.SMALL_STICK.get()), has(ModItems.SMALL_STICK.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BLUNDERBUSS_BARREL.get(), 1)
                .pattern("  #")
                .pattern("*# ")
                .pattern("*  ")
                .define('#', Items.IRON_INGOT)
                .define('*', Items.IRON_NUGGET)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .unlockedBy(getHasName(Items.IRON_NUGGET), has(Items.IRON_NUGGET))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ARQUEBUS_BARREL.get(), 1)
                .pattern("  #")
                .pattern("*/ ")
                .pattern("#  ")
                .define('#', Items.IRON_INGOT)
                .define('*', Items.IRON_NUGGET)
                .define('/', Items.STICK)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .unlockedBy(getHasName(Items.IRON_NUGGET), has(Items.IRON_NUGGET))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MATCHLOCK_MECHANISM.get(), 1)
                .pattern("*  ")
                .pattern("***")
                .pattern("* *")
                .define('*', Items.IRON_NUGGET)
                .unlockedBy(getHasName(Items.IRON_NUGGET), has(Items.IRON_NUGGET))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GUN_STOCK.get(), 1)
                .pattern(" #*")
                .pattern("#* ")
                .pattern("#  ")
                .define('#', Items.STICK)
                .define('*', ModItems.SMALL_STICK.get())
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .unlockedBy(getHasName(ModItems.SMALL_STICK.get()), has(ModItems.SMALL_STICK.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BULLET.get(), 2)
                .pattern(" * ")
                .pattern("*#*")
                .pattern(" * ")
                .define('#', Items.IRON_INGOT)
                .define('*', Items.IRON_NUGGET)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .unlockedBy(getHasName(Items.IRON_NUGGET), has(Items.IRON_NUGGET))
                .save(recipeOutput);

        for (String name : MATERIALS)
        {
            if (!name.equals("wood") && !name.equals("stone"))
            {
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STABBING_TIPS.get(name).get(), 3)
                        .pattern("/")
                        .pattern("/")
                        .pattern("/")
                        .define('/', ModItems.MATERIAL_ITEMS.get(name))
                        .unlockedBy(getHasName(ModItems.MATERIAL_ITEMS.get(name)), has(ModItems.MATERIAL_ITEMS.get(name)))
                        .save(recipeOutput);

                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AXE_TIPS.get(name).get(), 3)
                        .pattern("/  ")
                        .pattern("///")
                        .pattern("/  ")
                        .define('/', ModItems.MATERIAL_ITEMS.get(name))
                        .unlockedBy(getHasName(ModItems.MATERIAL_ITEMS.get(name)), has(ModItems.MATERIAL_ITEMS.get(name)))
                        .save(recipeOutput);

                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MACE_TIPS.get(name).get(), 3)
                        .pattern(" / ")
                        .pattern("///")
                        .pattern(" / ")
                        .define('/', ModItems.MATERIAL_ITEMS.get(name))
                        .unlockedBy(getHasName(ModItems.MATERIAL_ITEMS.get(name)), has(ModItems.MATERIAL_ITEMS.get(name)))
                        .save(recipeOutput);

                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SINGLEEDGE_BLADES.get(name).get(), 3)
                        .pattern("  /")
                        .pattern(" / ")
                        .pattern("/  ")
                        .define('/', ModItems.MATERIAL_ITEMS.get(name))
                        .unlockedBy(getHasName(ModItems.MATERIAL_ITEMS.get(name)), has(ModItems.MATERIAL_ITEMS.get(name)))
                        .save(recipeOutput);

                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CURVED_BLADES.get(name).get(), 3)
                        .pattern(" /")
                        .pattern("/ ")
                        .pattern(" /")
                        .define('/', ModItems.MATERIAL_ITEMS.get(name))
                        .unlockedBy(getHasName(ModItems.MATERIAL_ITEMS.get(name)), has(ModItems.MATERIAL_ITEMS.get(name)))
                        .save(recipeOutput);
            }

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DOUBLEEDGE_BLADES.get(name).get(), 1)
                    .pattern("//")
                    .define('/', ModItems.SINGLEEDGE_BLADES.get(name).get())
                    .unlockedBy(getHasName(ModItems.SINGLEEDGE_BLADES.get(name).get()), has(ModItems.SINGLEEDGE_BLADES.get(name).get()))
                    .save(recipeOutput);

            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.HALBERDS.get(name).get(), 1)
                    .pattern(" #*")
                    .pattern(" / ")
                    .pattern("/  ")
                    .define('*', ModItems.STABBING_TIPS.get(name).get())
                    .define('#', ModItems.AXE_TIPS.get(name).get())
                    .define('/', Items.STICK)
                    .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                    .unlockedBy(getHasName(ModItems.STABBING_TIPS.get(name).get()), has(ModItems.STABBING_TIPS.get(name).get()))
                    .unlockedBy(getHasName(ModItems.AXE_TIPS.get(name).get()), has(ModItems.AXE_TIPS.get(name).get()))
                    .save(recipeOutput);

            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.GLAIVES.get(name).get(), 1)
                    .pattern("  #")
                    .pattern(" / ")
                    .pattern("/  ")
                    .define('#', ModItems.SINGLEEDGE_BLADES.get(name).get())
                    .define('/', Items.STICK)
                    .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                    .unlockedBy(getHasName(ModItems.SINGLEEDGE_BLADES.get(name).get()), has(ModItems.SINGLEEDGE_BLADES.get(name).get()))
                    .save(recipeOutput);

            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SCYTHES.get(name).get(), 1)
                    .pattern("###")
                    .pattern(" / ")
                    .pattern("/  ")
                    .define('#', ModItems.CURVED_BLADES.get(name).get())
                    .define('/', Items.STICK)
                    .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                    .unlockedBy(getHasName(ModItems.CURVED_BLADES.get(name).get()), has(ModItems.CURVED_BLADES.get(name).get()))
                    .save(recipeOutput);

            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RAPIERS.get(name).get(), 1)
                    .pattern("  #")
                    .pattern(" # ")
                    .pattern("/  ")
                    .define('#', ModItems.STABBING_TIPS.get(name).get())
                    .define('/', ModItems.SMALL_STICK.get())
                    .unlockedBy(getHasName(ModItems.STABBING_TIPS.get(name).get()), has(ModItems.STABBING_TIPS.get(name).get()))
                    .unlockedBy(getHasName(ModItems.SMALL_STICK.get()), has(ModItems.SMALL_STICK.get()))
                    .save(recipeOutput);

            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.KATANAS.get(name).get(), 1)
                    .pattern("#  ")
                    .pattern(" # ")
                    .pattern("  /")
                    .define('#', ModItems.SINGLEEDGE_BLADES.get(name).get())
                    .define('/', ModItems.SMALL_STICK.get())
                    .unlockedBy(getHasName(ModItems.SINGLEEDGE_BLADES.get(name).get()), has(ModItems.SINGLEEDGE_BLADES.get(name).get()))
                    .unlockedBy(getHasName(ModItems.SMALL_STICK.get()), has(ModItems.SMALL_STICK.get()))
                    .save(recipeOutput);

            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BATTLE_AXES.get(name).get(), 1)
                    .pattern("#/#")
                    .pattern(" / ")
                    .define('#', ModItems.AXE_TIPS.get(name).get())
                    .define('/', ModItems.SMALL_STICK.get())
                    .unlockedBy(getHasName(ModItems.AXE_TIPS.get(name).get()), has(ModItems.AXE_TIPS.get(name).get()))
                    .unlockedBy(getHasName(ModItems.SMALL_STICK.get()), has(ModItems.SMALL_STICK.get()))
                    .save(recipeOutput);

            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.KATARS.get(name).get(), 1)
                    .pattern(" # ")
                    .pattern("/#/")
                    .pattern("/ /")
                    .define('#', ModItems.STABBING_TIPS.get(name).get())
                    .define('/', ModItems.SMALL_STICK.get())
                    .unlockedBy(getHasName(ModItems.STABBING_TIPS.get(name).get()), has(ModItems.STABBING_TIPS.get(name).get()))
                    .unlockedBy(getHasName(ModItems.SMALL_STICK.get()), has(ModItems.SMALL_STICK.get()))
                    .save(recipeOutput);

            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.DANE_AXES.get(name).get(), 1)
                    .pattern("## ")
                    .pattern("##/")
                    .pattern("  /")
                    .define('#', ModItems.AXE_TIPS.get(name).get())
                    .define('/', Items.STICK)
                    .unlockedBy(getHasName(ModItems.AXE_TIPS.get(name).get()), has(ModItems.AXE_TIPS.get(name).get()))
                    .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                    .save(recipeOutput);

            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BEARDED_AXES.get(name).get(), 1)
                    .pattern("## ")
                    .pattern("# /")
                    .pattern("  /")
                    .define('#', ModItems.AXE_TIPS.get(name).get())
                    .define('/', ModItems.SMALL_STICK.get())
                    .unlockedBy(getHasName(ModItems.AXE_TIPS.get(name).get()), has(ModItems.AXE_TIPS.get(name).get()))
                    .unlockedBy(getHasName(ModItems.SMALL_STICK.get()), has(ModItems.SMALL_STICK.get()))
                    .save(recipeOutput);

            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SAI.get(name).get(), 1)
                    .pattern("##")
                    .pattern("/#")
                    .define('#', ModItems.STABBING_TIPS.get(name).get())
                    .define('/', ModItems.SMALL_STICK.get())
                    .unlockedBy(getHasName(ModItems.STABBING_TIPS.get(name).get()), has(ModItems.STABBING_TIPS.get(name).get()))
                    .unlockedBy(getHasName(ModItems.SMALL_STICK.get()), has(ModItems.SMALL_STICK.get()))
                    .save(recipeOutput);

            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.DAGGERS.get(name).get(), 1)
                    .pattern(" #")
                    .pattern("/ ")
                    .define('#', ModItems.CURVED_BLADES.get(name).get())
                    .define('/', ModItems.SMALL_STICK.get())
                    .unlockedBy(getHasName(ModItems.CURVED_BLADES.get(name).get()), has(ModItems.CURVED_BLADES.get(name).get()))
                    .unlockedBy(getHasName(ModItems.SMALL_STICK.get()), has(ModItems.SMALL_STICK.get()))
                    .save(recipeOutput);

            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ODACHIS.get(name).get(), 1)
                    .pattern("*  ")
                    .pattern(" # ")
                    .pattern("  /")
                    .define('*', ModItems.SINGLEEDGE_BLADES.get(name).get())
                    .define('#', ModItems.KATANAS.get(name).get())
                    .define('/', ModItems.SMALL_STICK.get())
                    .unlockedBy(getHasName(ModItems.SINGLEEDGE_BLADES.get(name).get()), has(ModItems.SINGLEEDGE_BLADES.get(name).get()))
                    .unlockedBy(getHasName(ModItems.KATANAS.get(name).get()), has(ModItems.KATANAS.get(name).get()))
                    .unlockedBy(getHasName(ModItems.SMALL_STICK.get()), has(ModItems.SMALL_STICK.get()))
                    .save(recipeOutput);

            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.MACES.get(name).get(), 1)
                    .pattern(" #")
                    .pattern("/ ")
                    .define('#', ModItems.MACE_TIPS.get(name).get())
                    .define('/', Items.STICK)
                    .unlockedBy(getHasName(ModItems.MACE_TIPS.get(name).get()), has(ModItems.MACE_TIPS.get(name).get()))
                    .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                    .save(recipeOutput);
        }

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ARQUEBUS.get(), 1)
                .pattern("BL ")
                .pattern(" S ")
                .define('B', ModItems.ARQUEBUS_BARREL.get())
                .define('L', ModItems.MATCHLOCK_MECHANISM.get())
                .define('S', ModItems.GUN_STOCK.get())
                .unlockedBy(getHasName(ModItems.ARQUEBUS_BARREL.get()), has(ModItems.ARQUEBUS_BARREL.get()))
                .unlockedBy(getHasName(ModItems.MATCHLOCK_MECHANISM.get()), has(ModItems.MATCHLOCK_MECHANISM.get()))
                .unlockedBy(getHasName(ModItems.GUN_STOCK.get()), has(ModItems.GUN_STOCK.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BLUNDERBUSS.get(), 1)
                .pattern("B ")
                .pattern("L ")
                .pattern("S ")
                .define('B', ModItems.BLUNDERBUSS_BARREL.get())
                .define('L', ModItems.MATCHLOCK_MECHANISM.get())
                .define('S', ModItems.GUN_STOCK.get())
                .unlockedBy(getHasName(ModItems.BLUNDERBUSS_BARREL.get()), has(ModItems.BLUNDERBUSS_BARREL.get()))
                .unlockedBy(getHasName(ModItems.MATCHLOCK_MECHANISM.get()), has(ModItems.MATCHLOCK_MECHANISM.get()))
                .unlockedBy(getHasName(ModItems.GUN_STOCK.get()), has(ModItems.GUN_STOCK.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.MATCHLOCK_PISTOL.get(), 1)
                .pattern("B ")
                .pattern("L ")
                .pattern("S ")
                .define('B', ModItems.PISTOL_BARREL.get())
                .define('L', ModItems.MATCHLOCK_MECHANISM.get())
                .define('S', ModItems.GUN_STOCK.get())
                .unlockedBy(getHasName(ModItems.PISTOL_BARREL.get()), has(ModItems.PISTOL_BARREL.get()))
                .unlockedBy(getHasName(ModItems.MATCHLOCK_MECHANISM.get()), has(ModItems.MATCHLOCK_MECHANISM.get()))
                .unlockedBy(getHasName(ModItems.GUN_STOCK.get()), has(ModItems.GUN_STOCK.get()))
                .save(recipeOutput);


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CLAYMORES.get("wood").get(), 1)
                .pattern(" # ")
                .pattern("/  ")
                .define('/', Items.WOODEN_SWORD)
                .define('#', ModItems.DOUBLEEDGE_BLADES.get("wood").get())
                .unlockedBy(getHasName(Items.WOODEN_SWORD), has(Items.WOODEN_SWORD))
                .unlockedBy(getHasName(ModItems.DOUBLEEDGE_BLADES.get("wood").get()), has(ModItems.DOUBLEEDGE_BLADES.get("wood").get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CLAYMORES.get("stone").get(), 1)
                .pattern(" #")
                .pattern("/ ")
                .define('/', Items.STONE_SWORD)
                .define('#', ModItems.DOUBLEEDGE_BLADES.get("stone").get())
                .unlockedBy(getHasName(Items.STONE_SWORD), has(Items.STONE_SWORD))
                .unlockedBy(getHasName(ModItems.DOUBLEEDGE_BLADES.get("stone").get()), has(ModItems.DOUBLEEDGE_BLADES.get("stone").get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CLAYMORES.get("iron").get(), 1)
                .pattern(" #")
                .pattern("/ ")
                .define('/', Items.IRON_SWORD)
                .define('#', ModItems.DOUBLEEDGE_BLADES.get("iron").get())
                .unlockedBy(getHasName(Items.IRON_SWORD), has(Items.IRON_SWORD))
                .unlockedBy(getHasName(ModItems.DOUBLEEDGE_BLADES.get("iron").get()), has(ModItems.DOUBLEEDGE_BLADES.get("iron").get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CLAYMORES.get("gold").get(), 1)
                .pattern(" #")
                .pattern("/ ")
                .define('/', Items.GOLDEN_SWORD)
                .define('#', ModItems.DOUBLEEDGE_BLADES.get("gold").get())
                .unlockedBy(getHasName(Items.GOLDEN_SWORD), has(Items.GOLDEN_SWORD))
                .unlockedBy(getHasName(ModItems.DOUBLEEDGE_BLADES.get("gold").get()), has(ModItems.DOUBLEEDGE_BLADES.get("gold").get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CLAYMORES.get("diamond").get(), 1)
                .pattern(" #")
                .pattern("/ ")
                .define('/', Items.DIAMOND_SWORD)
                .define('#', ModItems.DOUBLEEDGE_BLADES.get("diamond").get())
                .unlockedBy(getHasName(Items.DIAMOND_SWORD), has(Items.DIAMOND_SWORD))
                .unlockedBy(getHasName(ModItems.DOUBLEEDGE_BLADES.get("diamond").get()), has(ModItems.DOUBLEEDGE_BLADES.get("diamond").get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CLAYMORES.get("netherite").get(), 1)
                .pattern(" #")
                .pattern("/ ")
                .define('/', Items.NETHERITE_SWORD)
                .define('#', ModItems.DOUBLEEDGE_BLADES.get("netherite").get())
                .unlockedBy(getHasName(Items.NETHERITE_SWORD), has(Items.NETHERITE_SWORD))
                .unlockedBy(getHasName(ModItems.DOUBLEEDGE_BLADES.get("netherite").get()), has(ModItems.DOUBLEEDGE_BLADES.get("netherite").get()))
                .save(recipeOutput);
    }

    private static void planksFromLog(RecipeOutput p_298877_, ItemLike output, ItemLike define)
    {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, output, 4)
                .requires(define)
                .group("planks")
                .unlockedBy("has_log", has(define))
                .save(p_298877_);
    }
}