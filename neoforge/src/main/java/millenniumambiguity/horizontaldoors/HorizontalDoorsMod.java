package millenniumambiguity.horizontaldoors;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class HorizontalDoorsMod {

    NeoForgeRegistry reg = new NeoForgeRegistry();

    public HorizontalDoorsMod(IEventBus eventBus) {
        CommonClass.init();
    }
}