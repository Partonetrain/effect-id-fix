package info.partonetrain.effectidfix.mixin;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.wizards.effect.Effects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Effects.class)
public class WizardsEffectsMixin {
    @Inject(method = "register()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Registry;registerMapping(Lnet/minecraft/core/Registry;ILjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", ordinal = 0), cancellable = true)
    private static void effectidfix_reregisterWizardsEffects(CallbackInfo ci){
        Registry.register(BuiltInRegistries.MOB_EFFECT, "wizards:frozen", Effects.frozen);
        Registry.register(BuiltInRegistries.MOB_EFFECT, "wizards:frost_shield", Effects.frostShield);
        Registry.register(BuiltInRegistries.MOB_EFFECT, "wizards:frost_slowness", Effects.frostSlowness);
        Registry.register(BuiltInRegistries.MOB_EFFECT, "wizards:arcane_charge", Effects.arcaneCharge);
        ci.cancel();
    }
}
