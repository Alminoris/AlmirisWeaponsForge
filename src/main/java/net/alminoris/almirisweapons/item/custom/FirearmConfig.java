package net.alminoris.almirisweapons.item.custom;

import net.minecraft.world.item.UseAnim;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.core.particles.ParticleOptions;

import java.util.function.Supplier;

public record FirearmConfig(
        UseAnim useAction,
        int maxUseTime,
        int minUseTicks,
        int reloadTicks,
        int ammoPerShot,
        int projectilesPerShot,
        double damage,
        float velocity,
        float inaccuracy,
        float spreadAngle,
        double recoilStrength,
        double recoilVertical,
        float misfireChance,
        Supplier<SoundEvent> reloadSound,
        float reloadVolume,
        float reloadPitch,
        Supplier<SoundEvent> shootSound,
        Supplier<SoundEvent> misfireSound,
        float soundVolume,
        float soundPitch,
        ParticleOptions reloadParticle,
        int reloadParticleCount,
        ParticleOptions smokeParticle,
        int smokeCount,
        double smokeSpread,
        double smokeSpeed,
        ParticleOptions flameParticle,
        int flameCount
) {
    public static class Builder {
        private UseAnim useAction = UseAnim.BOW;
        private int maxUseTime = 72000, minUseTicks = 5, reloadTicks = 40;
        private int ammoPerShot = 1, projectilesPerShot = 1;
        private double damage = 1.0, recoilStrength = 0.2, recoilVertical = 0.1;
        private float velocity = 1f, inaccuracy = 0f, spreadAngle = 0f, misfireChance = 0f;
        private Supplier<SoundEvent> reloadSound, shootSound, misfireSound;
        private float reloadVolume = 1f, reloadPitch = 1f, soundVolume = 1f, soundPitch = 1f;
        private ParticleOptions reloadParticle, smokeParticle, flameParticle;
        private int reloadParticleCount = 0, smokeCount = 0, flameCount = 0;
        private double smokeSpread = 0, smokeSpeed = 0;

        public Builder useAction(UseAnim val) { this.useAction = val; return this; }
        public Builder maxUseTime(int val) { this.maxUseTime = val; return this; }
        public Builder minUseTicks(int val) { this.minUseTicks = val; return this; }
        public Builder reloadTicks(int val) { this.reloadTicks = val; return this; }
        public Builder ammoPerShot(int val) { this.ammoPerShot = val; return this; }
        public Builder projectilesPerShot(int val) { this.projectilesPerShot = val; return this; }
        public Builder damage(double val) { this.damage = val; return this; }
        public Builder velocity(float val) { this.velocity = val; return this; }
        public Builder inaccuracy(float val) { this.inaccuracy = val; return this; }
        public Builder spreadAngle(float val) { this.spreadAngle = val; return this; }
        public Builder recoilStrength(double val) { this.recoilStrength = val; return this; }
        public Builder recoilVertical(double val) { this.recoilVertical = val; return this; }
        public Builder misfireChance(float val) { this.misfireChance = val; return this; }
        public Builder reloadSound(SoundEvent val) { this.reloadSound = () -> val; return this; }
        public Builder reloadSound(Supplier<SoundEvent> val) { this.reloadSound = val; return this; }
        public Builder shootSound(SoundEvent val) { this.shootSound = () -> val; return this; }
        public Builder shootSound(Supplier<SoundEvent> val) { this.shootSound = val; return this; }
        public Builder misfireSound(SoundEvent val) { this.misfireSound = () -> val; return this; }
        public Builder misfireSound(Supplier<SoundEvent> val) { this.misfireSound = val; return this; }
        public Builder reloadVolume(float val) { this.reloadVolume = val; return this; }
        public Builder reloadPitch(float val) { this.reloadPitch = val; return this; }
        public Builder soundVolume(float val) { this.soundVolume = val; return this; }
        public Builder soundPitch(float val) { this.soundPitch = val; return this; }
        public Builder reloadParticle(ParticleOptions val) { this.reloadParticle = val; return this; }
        public Builder reloadParticleCount(int val) { this.reloadParticleCount = val; return this; }
        public Builder smokeParticle(ParticleOptions val) { this.smokeParticle = val; return this; }
        public Builder smokeCount(int val) { this.smokeCount = val; return this; }
        public Builder smokeSpread(double val) { this.smokeSpread = val; return this; }
        public Builder smokeSpeed(double val) { this.smokeSpeed = val; return this; }
        public Builder flameParticle(ParticleOptions val) { this.flameParticle = val; return this; }
        public Builder flameCount(int val) { this.flameCount = val; return this; }

        public FirearmConfig build() {
            return new FirearmConfig(
                    useAction, maxUseTime, minUseTicks, reloadTicks,
                    ammoPerShot, projectilesPerShot, damage, velocity, inaccuracy, spreadAngle,
                    recoilStrength, recoilVertical, misfireChance,
                    reloadSound, reloadVolume, reloadPitch,
                    shootSound, misfireSound, soundVolume, soundPitch,
                    reloadParticle, reloadParticleCount,
                    smokeParticle, smokeCount, smokeSpread, smokeSpeed,
                    flameParticle, flameCount
            );
        }
    }
}
