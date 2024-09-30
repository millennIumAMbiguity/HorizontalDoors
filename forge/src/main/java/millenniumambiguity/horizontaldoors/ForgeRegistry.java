package millenniumambiguity.horizontaldoors;

import net.minecraft.world.level.block.Block;

public class ForgeRegistry extends CommonRegistry {

    ForgeRegistry() {
        registry = this;
    }

    @Override
    public void RenderBlockAsCutout(Block block) {}
}