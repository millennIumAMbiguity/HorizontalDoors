package millenniumambiguity.horizontaldoors;

import millenniumambiguity.horizontaldoors.blocks.HorizontalDoorBlock;
import millenniumambiguity.horizontaldoors.blocks.IHorizontalDoor;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.apache.commons.lang3.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class NeoForgeRegistry extends CommonRegistry {

    private class CreativeTabItem {
        public Item ItemBefore;
        public Supplier<Item> Item;

        CreativeTabItem(Item itemBefore, Supplier<Item> item) {
            ItemBefore = itemBefore;
            Item = item;
        }
    }

    // Adjust DeferredRegister registration for NeoForge (if needed)
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.createBlocks(Constants.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(Constants.MOD_ID);
    public static final List<CreativeTabItem> CreativeTabItems = new ArrayList<>();

    @Override
    public void Register(IHorizontalDoor hDoor) {
        DoorBlock baseBlock = hDoor.GetBaseDoorBlock();
        String name = GetName(baseBlock);

        Supplier<Block> registeredBlock = RegisterBlock(name, () -> new HorizontalDoorBlock(baseBlock));
        Supplier<Item> registeredItem = RegisterItem(name, () -> new BlockItem(registeredBlock.get(), new Item.Properties()));

        CreativeTabItems.add(new CreativeTabItem(baseBlock.asItem(), registeredItem));
    }

    @Override
    public Supplier<Block> RegisterBlock(IHorizontalDoor hDoor) {
        throw new NotImplementedException();
    }

    @Override
    public Supplier<Item> RegisterItem(IHorizontalDoor hDoor) {
        throw new NotImplementedException();
    }

    @Override
    public Supplier<Block> RegisterBlock(String name, Block block) {
        return BLOCKS.register(name, () -> block);
    }

    public Supplier<Block> RegisterBlock(String name, Supplier<Block> blockSupplier) {
        return BLOCKS.register(name, blockSupplier);
    }

    @Override
    public Supplier<Item> RegisterItem(String name, Item item) {
        return ITEMS.register(name, () -> item);
    }

    public Supplier<Item> RegisterItem(String name, Supplier<Item> itemSupplier) {
        return ITEMS.register(name, itemSupplier);
    }

    @Override
    public void RenderBlockAsCutout(Block block) {
        // Not needed on NeoForge as well (depending on render type specifics)
    }

    @Override
    public void AddItemToCreativeTabRedstone(Item itemBefore, Item item) {
        // Unused in NeoForge
    }

    @Override
    public void AddItemToCreativeTabBuilding(Item itemBefore, Item item) {
        // Unused in NeoForge
    }

    public void onCreativeModeTabBuildContents(BuildCreativeModeTabContentsEvent event) {
        var entries = event.getEntries();
        var vis = CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS;

        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            for (CreativeTabItem item : CreativeTabItems) {
                entries.putAfter(new ItemStack(item.ItemBefore), new ItemStack(item.Item.get()), vis);
            }
        }

        if (event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
            for (CreativeTabItem item : CreativeTabItems) {
                if (item.ItemBefore == Items.OAK_DOOR || item.ItemBefore == Items.IRON_DOOR) {
                    entries.putAfter(new ItemStack(item.ItemBefore), new ItemStack(item.Item.get()), vis);
                }
            }
        }
    }
}
