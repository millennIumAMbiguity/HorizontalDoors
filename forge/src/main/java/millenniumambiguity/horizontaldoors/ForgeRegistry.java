package millenniumambiguity.horizontaldoors;

import millenniumambiguity.horizontaldoors.blocks.HorizontalDoorBlock;
import millenniumambiguity.horizontaldoors.blocks.IHorizontalDoor;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.apache.commons.lang3.NotImplementedException;

import java.security.KeyPair;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ForgeRegistry extends CommonRegistry {

    private class CreativeTabItem {
        public Item ItemBefore;
        public Supplier<Item> Item;

        CreativeTabItem(Item itemBefore, Supplier<Item> item) {
            ItemBefore = itemBefore;
            Item = item;
        }
    }

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Constants.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
    public static final List<CreativeTabItem> CreativeTabItems = new ArrayList<CreativeTabItem>();;

    @Override
    public void Register(IHorizontalDoor hDoor) {
        DoorBlock baseBlock = hDoor.GetBaseDoorBlock();
        // Create the name based on the base door block
        String name = GetName(baseBlock);

        // Register the block lazily using a Supplier
        Supplier<Block> registeredBlock = RegisterBlock(name, () -> new HorizontalDoorBlock(baseBlock));

        // Register the item lazily using a Supplier
        Supplier<Item> registeredItem = RegisterItem(name, () -> new BlockItem(registeredBlock.get(), new Item.Properties()));

        // que item to CreativeTab
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
        // Register the block using a Supplier
        return BLOCKS.register(name, blockSupplier);
    }

    @Override
    public Supplier<Item> RegisterItem(String name, Item item) {
        return ITEMS.register(name, () -> item);
    }

    public Supplier<Item> RegisterItem(String name, Supplier<Item> itemSupplier) {
        // Register the item using a Supplier
        return ITEMS.register(name, itemSupplier);
    }

    @Override
    public void RenderBlockAsCutout(Block block) { } // Not needed on forge as its uses the data from the block.

    @Override
    public void AddItemToCreativeTabRedstone(Item itemBefore, Item item) { } // unused in forge

    @Override
    public void AddItemToCreativeTabBuilding(Item itemBefore, Item item) { } // unused in forge

    public void onCreativeModeTabBuildContents(BuildCreativeModeTabContentsEvent event)
    {
        var entries = event.getEntries();
        var vis = CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS;
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            for (CreativeTabItem item : CreativeTabItems){
                entries.putAfter(new ItemStack(item.ItemBefore), new ItemStack(item.Item.get()), vis);
            }
        }

        if (event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
            for (CreativeTabItem item : CreativeTabItems){
                if (item.ItemBefore == Items.OAK_DOOR || item.ItemBefore == Items.IRON_DOOR)
                {
                    entries.putAfter(new ItemStack(item.ItemBefore), new ItemStack(item.Item.get()), vis);
                }
            }
        }

    }
}