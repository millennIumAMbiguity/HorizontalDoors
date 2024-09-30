package millenniumambiguity.horizontaldoors;

import net.minecraft.world.level.block.Block;

public class NeoForgeRegistry extends CommonRegistry {

    NeoForgeRegistry() {
        registry = this;
    }

    @Override
    public void RenderBlockAsCutout(Block block) {}
}