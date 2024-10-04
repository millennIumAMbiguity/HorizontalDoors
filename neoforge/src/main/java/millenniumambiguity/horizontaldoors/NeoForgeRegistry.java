package millenniumambiguity.horizontaldoors;

import millenniumambiguity.horizontaldoors.blocks.IHorizontalDoor;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Map;
import java.util.function.Supplier;

public class NeoForgeRegistry extends CommonRegistry {

    // Adjust DeferredRegister registration for NeoForge (if needed)
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.createBlocks(Constants.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(Constants.MOD_ID);

    @Override
    public void Register(IHorizontalDoor hDoor) {

        // Create the name based on the base door block
        String name = GetName(hDoor);

        // Register the block lazily using a Supplier
        RegisterBlock(name, GetDoorBlock(hDoor));

        // Register the item lazily using a Supplier
        RegisterItem(name, GetDoorItem(hDoor));
    }

    @Override
    public Supplier<Block> RegisterBlock(String name, Supplier<Block> block) {
        return BLOCKS.register(name, block);
    }

    @Override
    public Supplier<Item> RegisterItem(String name, Supplier<Item> itemSupplier) {
        return ITEMS.register(name, itemSupplier);
    }

    public void onCreativeModeTabBuildContents(BuildCreativeModeTabContentsEvent event)
    {
        var entries = event.getEntries();
        var vis = CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS;
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            for (Map.Entry<IHorizontalDoor, Item> entry : CommonClass.HORIZONTAL_DOOR_ITEMS.entrySet()) {
                entries.putAfter(new ItemStack(entry.getKey().GetBaseDoorBlock()), new ItemStack(entry.getValue()), vis);
            }
        }

        if (event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
            for (Map.Entry<IHorizontalDoor, Item> entry : CommonClass.HORIZONTAL_DOOR_ITEMS.entrySet()) {
                Block baseBlock = entry.getKey().GetBaseDoorBlock();
                if (baseBlock == Blocks.OAK_DOOR || baseBlock == Blocks.IRON_DOOR)
                {
                    entries.putAfter(new ItemStack(baseBlock), new ItemStack(entry.getValue()), vis);
                }
            }
        }
    }
}
