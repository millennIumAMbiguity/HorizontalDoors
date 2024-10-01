package millenniumambiguity.horizontaldoors;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

public class ForgeRegistry extends CommonRegistry {

    ForgeRegistry() {
        registry = this;
    }

    @Override
    public void RenderBlockAsCutout(Block block) { }

    @Override
    public void AddItemToCreativeTabRedstone(Item itemBefore, Item item) { }

    @Override
    public void AddItemToCreativeTabBuilding(Item itemBefore, Item item) { }
}