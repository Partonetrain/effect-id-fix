package info.partonetrain.effectidfix.mixin;

import net.archers.effect.Effects;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Effects.class)
public class ArchersEffectsMixin {
	@Inject(method = "register()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Registry;registerMapping(Lnet/minecraft/core/Registry;ILjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", ordinal = 0), cancellable = true)
	private static void effectidfix_reregisterArchersEffects(CallbackInfo ci){
		Registry.register(BuiltInRegistries.MOB_EFFECT, "archers:hunters_mark", Effects.huntersMark);
		Registry.register(BuiltInRegistries.MOB_EFFECT, "archers:entangling_roots", Effects.entanglingRoots);
		ci.cancel();
	}
}