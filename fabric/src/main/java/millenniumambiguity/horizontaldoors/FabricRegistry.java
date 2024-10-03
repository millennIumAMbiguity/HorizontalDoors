package millenniumambiguity.horizontaldoors;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;

public class FabricRegistry extends CommonRegistry {

    @Override
    public void RenderBlockAsCutout(Block block) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderType.cutout());
    }

    @Override
    public void AddItemToCreativeTabRedstone(Item itemBefore, Item item) {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.REDSTONE_BLOCKS).register(entries -> {
            entries.addBefore(new ItemStack(itemBefore), new ItemStack(item));
        });
    }

    public void AddItemToCreativeTabBuilding(Item itemBefore, Item item) {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(entries -> {
            entries.addBefore(new ItemStack(itemBefore), new ItemStack(item));
        });
    }
}