package info.partonetrain.effectidfix;

import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class EffectidfixMixinPlugin implements IMixinConfigPlugin {
    @Override
    public void onLoad(String mixinPackage) {}
    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        String lower = mixinClassName.toLowerCase();
        if (lower.contains("archers")) {
            return Effectidfix.ARCHERS;
        }
        if (lower.contains("paladins")) {
            return Effectidfix.PALADINS;
        }
        if (lower.contains("rogues")) {
            return Effectidfix.ROGUES;
        }
        if (lower.contains("spellpower")) {
            return Effectidfix.SPELLPOWER;
        }
        if (lower.contains("wizards")) {
            return Effectidfix.WIZARDS;
        }

        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {}

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}
}
