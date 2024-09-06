package info.partonetrain.effectidfix.mixin;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.rogues.effect.Effects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Effects.class)
public class RoguesEffectsMixin {
    @Inject(method = "register()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Registry;registerMapping(Lnet/minecraft/core/Registry;ILjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", ordinal = 0), cancellable = true)
    private static void effectidfix_reregisterRougesEffects(CallbackInfo ci){
        Registry.register(BuiltInRegistries.MOB_EFFECT, "rogues:slice_and_dice", Effects.SLICE_AND_DICE);
        Registry.register(BuiltInRegistries.MOB_EFFECT, "rogues:shock", Effects.SHOCK);
        Registry.register(BuiltInRegistries.MOB_EFFECT, "rogues:shadow_step", Effects.SHADOW_STEP);
        Registry.register(BuiltInRegistries.MOB_EFFECT, "rogues:stealth", Effects.STEALTH);
        Registry.register(BuiltInRegistries.MOB_EFFECT, "rogues:shatter", Effects.SHATTER);
        Registry.register(BuiltInRegistries.MOB_EFFECT, "rogues:demoralize", Effects.DEMORALIZE);
        Registry.register(BuiltInRegistries.MOB_EFFECT, "rogues:charge", Effects.CHARGE);
        ci.cancel();
    }
}
