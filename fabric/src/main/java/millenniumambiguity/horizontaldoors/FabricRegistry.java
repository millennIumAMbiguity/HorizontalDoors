package millenniumambiguity.horizontaldoors;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class FabricRegistry extends CommonRegistry {

    FabricRegistry() {
        registry = this;
    }

    public static Supplier<Item> HORIZONTAL_OAK_DOOR_ITEM() {
        return registerItem("horizontal_oak_door",
                () -> new BlockItem(RegisterHorizontalOakDoorBlock().get(), new Item.Properties()));
    }

    @Override
    public void RenderBlockAsCutout(Block block) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderType.cutout());
    }

    @Override
    public void AddItemToCreativeTabRedstone(Item itemBefore, Item item) {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.REDSTONE_BLOCKS).register(entries -> {
            entries.addBefore(new ItemStack(Items.OAK_DOOR), new ItemStack(item));
        });
    }

    public void AddItemToCreativeTabBuilding(Item itemBefore, Item item) {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(entries -> {
            entries.addBefore(new ItemStack(Items.OAK_DOOR), new ItemStack(item));
        });
    }
}