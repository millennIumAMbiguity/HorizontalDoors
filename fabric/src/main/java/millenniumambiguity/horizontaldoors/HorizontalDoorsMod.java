package millenniumambiguity.horizontaldoors;

import net.fabricmc.api.ModInitializer;

public class HorizontalDoorsMod implements ModInitializer {

    FabricRegistry Reg = new FabricRegistry();

    @Override
    public void onInitialize() {
        CommonClass.init();
    }
}
