package info.partonetrain.effectidfix.mixin;

import info.partonetrain.effectidfix.Effectidfix;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.spell_power.SpellPowerMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SpellPowerMod.class)
public class SpellpowerEffectsMixin {
    @Redirect(method = "registerStatusEffects", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Registry;registerMapping(Lnet/minecraft/core/Registry;ILjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", ordinal = 0))
    private static <V, T extends V> T effectidfix_reregisterSpellpowerEffects(Registry<V> registry, int i, String string, T object) {
        Registry.register(BuiltInRegistries.MOB_EFFECT, string, (MobEffect)object);
        MobEffect effect = (MobEffect)object;
        Effectidfix.LOGGER.info("effectidfix_reregisterSpellpowerEffects redirected " + BuiltInRegistries.MOB_EFFECT.getKey(effect).toString() + " " + i + " to " + BuiltInRegistries.MOB_EFFECT.getId(effect));
        return null;
    }

    @Redirect(method = "onInitialize", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Registry;registerMapping(Lnet/minecraft/core/Registry;ILjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", ordinal = 0))
    private <V, T extends V> T effectidfix_reregisterSpellpowerOtherEffects(Registry<V> registry, int i, String string, T object) {
        Registry.register(BuiltInRegistries.MOB_EFFECT, string, (MobEffect)object);
        MobEffect effect = (MobEffect)object;
        Effectidfix.LOGGER.info("effectidfix_reregisterSpellpowerOtherEffects redirected " + BuiltInRegistries.MOB_EFFECT.getKey(effect).toString() + " " + i + " to " + BuiltInRegistries.MOB_EFFECT.getId(effect));
        return null;
    }
}
