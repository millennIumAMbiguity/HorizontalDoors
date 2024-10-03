package millenniumambiguity.horizontaldoors;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(Constants.MOD_ID)
public class HorizontalDoorsMod {

    static NeoForgeRegistry reg = new NeoForgeRegistry();


    public HorizontalDoorsMod(IEventBus modBus) {
        CommonClass.init();

        NeoForgeRegistry.BLOCKS.register(modBus);
        NeoForgeRegistry.ITEMS.register(modBus);
        reg.RegisterAll();

        modBus.addListener(HorizontalDoorsMod::onCreativeModeTabBuildContents);
    }

    private static void onCreativeModeTabBuildContents(BuildCreativeModeTabContentsEvent event) {
        reg.onCreativeModeTabBuildContents(event);
    }
}