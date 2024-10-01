package millenniumambiguity.horizontaldoors;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class NeoForgeRegistry extends CommonRegistry {

    NeoForgeRegistry() {
        registry = this;
    }

    @Override
    public void RenderBlockAsCutout(Block block) { }

    @Override
    public void AddItemToCreativeTabRedstone(Item itemBefore, Item item) { }

    @Override
    public void AddItemToCreativeTabBuilding(Item itemBefore, Item item) { }
}