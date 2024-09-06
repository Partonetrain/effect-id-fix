package info.partonetrain.effectidfix;

import com.bawnorton.mixinsquared.api.MixinCanceller;

import java.util.List;

public class EffectidfixMixinCanceller implements MixinCanceller {
    @Override
    public boolean shouldCancel(List<String> targetClassNames, String mixinClassName) {
        return false;
    }
}