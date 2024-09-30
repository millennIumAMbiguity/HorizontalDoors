package millenniumambiguity.horizontaldoors;

import net.minecraftforge.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class HorizontalDoorsMod {

    ForgeRegistry reg = new ForgeRegistry();

    public HorizontalDoorsMod() {
        CommonClass.init();
    }
}