package millenniumambiguity.horizontaldoors;

import millenniumambiguity.horizontaldoors.blocks.IHorizontalDoor;
import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;
import java.util.function.Supplier;

public class FabricRegistry extends CommonRegistry {

    private EnvType environmentType;

    FabricRegistry() {
        environmentType = FabricLoader.getInstance().getEnvironmentType();
    }

    public void AddItemToCreativeTab() {
        for (Map.Entry<IHorizontalDoor, Item> entry : CommonClass.HORIZONTAL_DOOR_ITEMS.entrySet()){
            Block baseBlock = entry.getKey().GetBaseDoorBlock();
            if (baseBlock == Blocks.OAK_DOOR || baseBlock == Blocks.IRON_DOOR) {
                ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.REDSTONE_BLOCKS).register(entries -> {
                    entries.addBefore(new ItemStack(baseBlock), new ItemStack(entry.getValue()));
                });
            }
            ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(entries -> {
                entries.addBefore(new ItemStack(baseBlock), new ItemStack(entry.getValue()));
            });

        }
    }

    @Override
    public void Register(IHorizontalDoor hDoor) {
        String name = GetName(hDoor);
        RegisterBlock(name, GetDoorBlock(hDoor)).get();
        RegisterItem(name, GetDoorItem(hDoor)).get();
    }

    @Override
    public Supplier<Block> RegisterBlock(String name, Supplier<Block> block) {
        return () -> {
            Block b = block.get();
            RenderBlockAsCutout(b);
            Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(Constants.MOD_ID, name), b);
            return b;
        };
    }

    public void RenderBlockAsCutout(Block block) {
        if (environmentType == EnvType.CLIENT) {
            BlockRenderLayerMap.INSTANCE.putBlock(block, RenderType.cutout());
        }
    }
}