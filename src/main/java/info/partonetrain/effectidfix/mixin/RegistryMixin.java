package info.partonetrain.effectidfix.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import info.partonetrain.effectidfix.Effectidfix;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Registry.class)
public interface RegistryMixin {
    @Inject(method = "registerMapping", at=@At("HEAD"))
    private static <V, T extends V> void effectidfix_cancelMapping(CallbackInfoReturnable cir, @Local(argsOnly = true) Registry<V> registry, @Local(argsOnly = true) int i, @Local(argsOnly = true)String s){
        if(registry.equals(BuiltInRegistries.MOB_EFFECT) && i > 700){
            Effectidfix.LOGGER.info(s + " tried to register a mapping with an id of " + i);
            cir.cancel();
        }
    }
}
