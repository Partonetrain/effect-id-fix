package info.partonetrain.effectidfix.mixin;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.paladins.effect.Effects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Effects.class)
public class PaladinsEffectsMixin {
    @Inject(method = "register()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Registry;registerMapping(Lnet/minecraft/core/Registry;ILjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", ordinal = 0), cancellable = true)
    private static void effectidfix_reregisterPaladinsEffects(CallbackInfo ci){
        Registry.register(BuiltInRegistries.MOB_EFFECT, "paladins:divine_protection", Effects.DIVINE_PROTECTION);
        Registry.register(BuiltInRegistries.MOB_EFFECT, "paladins:battle_banner", Effects.BATTLE_BANNER);
        Registry.register(BuiltInRegistries.MOB_EFFECT, "paladins:judgement", Effects.JUDGEMENT);
        Registry.register(BuiltInRegistries.MOB_EFFECT, "paladins:priest_absorption", Effects.ABSORPTION);
        ci.cancel();
    }
}
