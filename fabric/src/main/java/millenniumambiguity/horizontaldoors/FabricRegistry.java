package millenniumambiguity.horizontaldoors;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class FabricRegistry extends CommonRegistry {

    FabricRegistry() {
        registry = this;
    }

    @Override
    public void RenderBlockAsCutout(Block block) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderType.cutout());
    }
}