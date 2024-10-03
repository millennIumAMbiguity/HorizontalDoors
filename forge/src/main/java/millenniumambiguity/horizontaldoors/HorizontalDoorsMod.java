package millenniumambiguity.horizontaldoors;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(Constants.MOD_ID)
public class HorizontalDoorsMod {

    static ForgeRegistry reg = new ForgeRegistry();


    public HorizontalDoorsMod() {
        CommonClass.init();

        ForgeRegistry.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ForgeRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        reg.RegisterAll();

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(HorizontalDoorsMod::onCreativeModeTabBuildContents);
    }

    private static void onCreativeModeTabBuildContents(BuildCreativeModeTabContentsEvent event) {
        reg.onCreativeModeTabBuildContents(event);
    }
}