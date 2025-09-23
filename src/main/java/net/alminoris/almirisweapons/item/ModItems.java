package net.alminoris.almirisweapons.item;

import net.alminoris.almirisweapons.AlmirisWeapons;
import net.alminoris.almirisweapons.item.custom.*;
import net.alminoris.almirisweapons.sound.ModSounds;
import net.alminoris.almirisweapons.util.helper.WeaponSetsHelper;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.function.Supplier;

import static net.alminoris.almirisweapons.util.helper.WeaponSetsHelper.TOOL_MATERIALS;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AlmirisWeapons.MOD_ID);

    public static final Dictionary<String, RegistryObject<Item>> HALBERDS = new Hashtable<>();
    public static final Dictionary<String, RegistryObject<Item>> RAPIERS = new Hashtable<>();
    public static final Dictionary<String, RegistryObject<Item>> CLAYMORES = new Hashtable<>();
    public static final Dictionary<String, RegistryObject<Item>> BATTLE_AXES = new Hashtable<>();
    public static final Dictionary<String, RegistryObject<Item>> SAI = new Hashtable<>();
    public static final Dictionary<String, RegistryObject<Item>> MACES = new Hashtable<>();

    public static final Dictionary<String, RegistryObject<Item>> SCYTHES = new Hashtable<>();
    public static final Dictionary<String, RegistryObject<Item>> KATANAS = new Hashtable<>();
    public static final Dictionary<String, RegistryObject<Item>> ODACHIS = new Hashtable<>();
    public static final Dictionary<String, RegistryObject<Item>> BATTLE_STAVES = new Hashtable<>();
    public static final Dictionary<String, RegistryObject<Item>> DAGGERS = new Hashtable<>();
    public static final Dictionary<String, RegistryObject<Item>> GLAIVES = new Hashtable<>();

    public static final Dictionary<String, RegistryObject<Item>> DANE_AXES = new Hashtable<>();
    public static final Dictionary<String, RegistryObject<Item>> BEARDED_AXES = new Hashtable<>();
    public static final Dictionary<String, RegistryObject<Item>> KATARS = new Hashtable<>();

    public static final Dictionary<String, RegistryObject<Item>> STABBING_TIPS = new Hashtable<>();
    public static final Dictionary<String, RegistryObject<Item>> MACE_TIPS = new Hashtable<>();
    public static final Dictionary<String, RegistryObject<Item>> AXE_TIPS = new Hashtable<>();
    public static final Dictionary<String, RegistryObject<Item>> DOUBLEEDGE_BLADES = new Hashtable<>();
    public static final Dictionary<String, RegistryObject<Item>> SINGLEEDGE_BLADES = new Hashtable<>();
    public static final Dictionary<String, RegistryObject<Item>> CURVED_BLADES = new Hashtable<>();

    public static final RegistryObject<Item> ARQUEBUS_BARREL =
            registerItem("arquebus_barrel", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BLUNDERBUSS_BARREL =
            registerItem("blunderbuss_barrel", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PISTOL_BARREL =
            registerItem("pistol_barrel", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MATCHLOCK_MECHANISM =
            registerItem("matchlock_mechanism", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GUN_STOCK =
            registerItem("gun_stock", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SMALL_STICK =
            registerItem("small_stick", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BULLET =
            registerItem("bullet", () -> new Item(new Item.Properties()));

    public static final Dictionary<String, Item> MATERIAL_ITEMS = new Hashtable<>();

    static {
        MATERIAL_ITEMS.put("iron", Items.IRON_INGOT);
        MATERIAL_ITEMS.put("diamond", Items.DIAMOND);
        MATERIAL_ITEMS.put("gold", Items.GOLD_INGOT);
        MATERIAL_ITEMS.put("netherite", Items.NETHERITE_INGOT);

        for (String name : WeaponSetsHelper.MATERIALS) {
            STABBING_TIPS.put(name, registerItem(name + "_stabbing_tip", () -> new Item(new Item.Properties())));
            MACE_TIPS.put(name, registerItem(name + "_mace_tip", () -> new Item(new Item.Properties())));
            AXE_TIPS.put(name, registerItem(name + "_axe_tip", () -> new Item(new Item.Properties())));
            DOUBLEEDGE_BLADES.put(name, registerItem(name + "_doubleedge_blade", () -> new Item(new Item.Properties())));
            SINGLEEDGE_BLADES.put(name, registerItem(name + "_singleedge_blade", () -> new Item(new Item.Properties())));
            CURVED_BLADES.put(name, registerItem(name + "_curved_blade", () -> new Item(new Item.Properties())));

            HALBERDS.put(name, registerItem(name + "_halberd",
                    () -> new SwordItem(TOOL_MATERIALS.get(name), 3, -3.0F, new Item.Properties())));

            RAPIERS.put(name, registerItem(name + "_rapier",
                    () -> new SwordItem(TOOL_MATERIALS.get(name), 1, -2.0F, new Item.Properties())));

            CLAYMORES.put(name, registerItem(name + "_claymore",
                    () -> new SwordItem(TOOL_MATERIALS.get(name), 4, -3.0F, new Item.Properties())));

            BATTLE_AXES.put(name, registerItem(name + "_battle_axe",
                    () -> new AxeItem(TOOL_MATERIALS.get(name), 6.0F, -3.1F, new Item.Properties())));

            SAI.put(name, registerItem(name + "_sai",
                    () -> new SwordItem(TOOL_MATERIALS.get(name), 0, -1.5F, new Item.Properties())));

            MACES.put(name, registerItem(name + "_mace",
                    () -> new SwordItem(TOOL_MATERIALS.get(name), 5, -3.5F, new Item.Properties())));

            DAGGERS.put(name, registerItem(name + "_dagger",
                    () -> new SwordItem(TOOL_MATERIALS.get(name), 1, -1.75F, new Item.Properties())));

            GLAIVES.put(name, registerItem(name + "_glaive",
                    () -> new SwordItem(TOOL_MATERIALS.get(name), 3, -2.5F, new Item.Properties())));

            KATANAS.put(name, registerItem(name + "_katana",
                    () -> new SwordItem(TOOL_MATERIALS.get(name), 4, -2.25F, new Item.Properties())));

            BATTLE_STAVES.put(name, registerItem(name + "_battle_staff",
                    () -> new SwordItem(TOOL_MATERIALS.get(name), 4, -2.7F, new Item.Properties())));

            SCYTHES.put(name, registerItem(name + "_scythe",
                    () -> new SwordItem(TOOL_MATERIALS.get(name), 4, -2.6F, new Item.Properties())));

            ODACHIS.put(name, registerItem(name + "_odachi",
                    () -> new SwordItem(TOOL_MATERIALS.get(name), 5, -3.25F, new Item.Properties())));

            DANE_AXES.put(name, registerItem(name + "_dane_axe",
                    () -> new AxeItem(TOOL_MATERIALS.get(name), 7.0F, -3.2F, new Item.Properties())));

            BEARDED_AXES.put(name, registerItem(name + "_bearded_axe",
                    () -> new AxeItem(TOOL_MATERIALS.get(name), 5.0F, -2.8F, new Item.Properties())));

            KATARS.put(name, registerItem(name + "_katar",
                    () -> new SwordItem(TOOL_MATERIALS.get(name), 2, -2.0F, new Item.Properties())));
        }
    }

    public static final RegistryObject<Item> ARQUEBUS =
            registerItem("arquebus", () -> new ArquebusItem(new Item.Properties().stacksTo(1),
                    new FirearmConfig.Builder()
                            .useAction(UseAnim.BOW)
                            .maxUseTime(72000)
                            .minUseTicks(15)
                            .reloadTicks(80)
                            .ammoPerShot(1)
                            .projectilesPerShot(1)
                            .damage(16.0)
                            .velocity(5.0f)
                            .inaccuracy(0.5f)
                            .spreadAngle(1.5f)
                            .recoilStrength(0.6)
                            .recoilVertical(0.2)
                            .misfireChance(0.12f)
                            .shootSound(ModSounds.ARQUEBUS_SHOT.get())
                            .misfireSound(ModSounds.MISFIRE.get())
                            .reloadSound(ModSounds.ARQUEBUS_RELOAD.get())
                            .soundVolume(1f)
                            .soundPitch(1f)
                            .reloadVolume(1f)
                            .reloadPitch(1f)
                            .reloadParticle(ParticleTypes.SMOKE)
                            .reloadParticleCount(12)
                            .smokeParticle(ParticleTypes.SMOKE)
                            .smokeCount(16)
                            .smokeSpread(0.2)
                            .smokeSpeed(0.04)
                            .flameParticle(ParticleTypes.FLAME)
                            .flameCount(5)
                            .build()
            ));

    public static final RegistryObject<Item> BLUNDERBUSS =
            registerItem("blunderbuss", () -> new BlunderbussItem(new Item.Properties().stacksTo(1),
                    new FirearmConfig.Builder()
                            .useAction(UseAnim.BOW)
                            .maxUseTime(72000)
                            .minUseTicks(10)
                            .reloadTicks(70)
                            .ammoPerShot(5)
                            .projectilesPerShot(5)
                            .damage(2.5)
                            .velocity(2.8f)
                            .inaccuracy(3.5f)
                            .spreadAngle(25f)
                            .recoilStrength(0.9)
                            .recoilVertical(0.25)
                            .misfireChance(0.15f)
                            .shootSound(ModSounds.BLUNDERBUSS_SHOT.get())
                            .misfireSound(ModSounds.MISFIRE.get())
                            .reloadSound(ModSounds.BLUNDERBUSS_RELOAD.get())
                            .soundVolume(1f)
                            .soundPitch(1f)
                            .reloadVolume(1f)
                            .reloadPitch(1f)
                            .reloadParticle(ParticleTypes.SMOKE)
                            .reloadParticleCount(15)
                            .smokeParticle(ParticleTypes.SMOKE)
                            .smokeCount(20)
                            .smokeSpread(0.4)
                            .smokeSpeed(0.06)
                            .flameParticle(ParticleTypes.FLAME)
                            .flameCount(8)
                            .build()
            ));

    public static final RegistryObject<Item> MATCHLOCK_PISTOL =
            registerItem("matchlock_pistol", () -> new MatchlockPistolItem(new Item.Properties().stacksTo(1),
                    new FirearmConfig.Builder()
                            .useAction(UseAnim.SPYGLASS)
                            .maxUseTime(72000)
                            .minUseTicks(4)
                            .reloadTicks(25)
                            .ammoPerShot(1)
                            .projectilesPerShot(1)
                            .damage(6.0)
                            .velocity(3.5f)
                            .inaccuracy(2.0f)
                            .spreadAngle(6f)
                            .recoilStrength(0.2)
                            .recoilVertical(0.1)
                            .misfireChance(0.06f)
                            .shootSound(ModSounds.MATCHLOCK_PISTOL_SHOT.get())
                            .misfireSound(ModSounds.MISFIRE.get())
                            .reloadSound(ModSounds.MATCHLOCK_PISTOL_RELOAD.get())
                            .soundVolume(0.7f)
                            .soundPitch(1f)
                            .reloadVolume(1f)
                            .reloadPitch(1f)
                            .reloadParticle(ParticleTypes.SMOKE)
                            .reloadParticleCount(3)
                            .smokeParticle(ParticleTypes.SMOKE)
                            .smokeCount(5)
                            .smokeSpread(0.1)
                            .smokeSpeed(0.02)
                            .flameParticle(ParticleTypes.FLAME)
                            .flameCount(1)
                            .flameParticle(ParticleTypes.FLAME)
                            .build()
            ));

    private static <T extends Item> RegistryObject<T> registerItem(String name, Supplier<T> item)
    {
        return ITEMS.register(name, item);
    }

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}