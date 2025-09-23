package net.alminoris.almirisweapons.sound;

import net.alminoris.almirisweapons.AlmirisWeapons;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, AlmirisWeapons.MOD_ID);

    public static final RegistryObject<SoundEvent> ARQUEBUS_SHOT = registerSound("arquebus_shot");
    public static final RegistryObject<SoundEvent> BLUNDERBUSS_SHOT = registerSound("blunderbuss_shot");
    public static final RegistryObject<SoundEvent> MATCHLOCK_PISTOL_SHOT = registerSound("matchlock_pistol_shot");
    public static final RegistryObject<SoundEvent> MISFIRE = registerSound("misfire");

    public static final RegistryObject<SoundEvent> ARQUEBUS_RELOAD = registerSound("arquebus_reload");
    public static final RegistryObject<SoundEvent> BLUNDERBUSS_RELOAD = registerSound("blunderbuss_reload");
    public static final RegistryObject<SoundEvent> MATCHLOCK_PISTOL_RELOAD = registerSound("matchlock_pistol_reload");
    public static final RegistryObject<SoundEvent> EMPTY = registerSound("empty");

    private static RegistryObject<SoundEvent> registerSound(String name) {
        return SOUND_EVENTS.register(name,
                () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(AlmirisWeapons.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus)
    {
        SOUND_EVENTS.register(eventBus);
    }
}
