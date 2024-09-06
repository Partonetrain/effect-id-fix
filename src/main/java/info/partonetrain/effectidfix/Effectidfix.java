package info.partonetrain.effectidfix;

import com.llamalad7.mixinextras.sugar.Local;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.protocol.game.ClientboundPingPacket;
import net.minecraft.world.effect.MobEffect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Effectidfix implements ModInitializer {
	public static final String MOD_ID = "effect-id-fix";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final boolean ARCHERS = FabricLoader.getInstance().isModLoaded("archers");
	public static final boolean PALADINS = FabricLoader.getInstance().isModLoaded("paladins");
	public static final boolean ROGUES = FabricLoader.getInstance().isModLoaded("rogues");
	public static final boolean SPELLPOWER = FabricLoader.getInstance().isModLoaded("spell_power");
	public static final boolean WIZARDS = FabricLoader.getInstance().isModLoaded("wizards");

	@Override
	public void onInitialize() {
		LOGGER.info("Train's Effect ID Fix intialized");

		ServerLifecycleEvents.SERVER_STARTED.register(server -> {
			List<MobEffect> mes = BuiltInRegistries.MOB_EFFECT.stream().toList();
			for(MobEffect me : mes){
				LOGGER.info(BuiltInRegistries.MOB_EFFECT.getKey(me).toString() + " " + BuiltInRegistries.MOB_EFFECT.getId(me));
//				if(BuiltInRegistries.MOB_EFFECT.getId(me) >= 700){
//					throw new RuntimeException("mob effect ID was over 700, meaning effect-id-fix failed");
//				}
			}
		});
	}
}