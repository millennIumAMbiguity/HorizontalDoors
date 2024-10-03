package millenniumambiguity.horizontaldoors;

import millenniumambiguity.horizontaldoors.blocks.HorizontalDoorBlock;
import millenniumambiguity.horizontaldoors.blocks.IHorizontalDoor;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

public abstract class CommonRegistry {

    protected final String namePrefix = "horizontal_";

    protected String GetName(Block block){
        String[] hits = block.getDescriptionId().split("\\.", 3);
        return namePrefix + hits[hits.length -1];
    }

    public void RegisterAll() {
        for (IHorizontalDoor door : CommonClass.DOOR_TYPES){
            Register(door);
        }
    }

    public void Register(IHorizontalDoor hDoor) {
        DoorBlock baseBlock = hDoor.GetBaseDoorBlock();
        Block block = new HorizontalDoorBlock(baseBlock);
        String name = GetName(baseBlock);
        RegisterBlock(name, block);
        Item item = new BlockItem(block, new Item.Properties());
        RegisterItem(name, item);
        AddItemToCreativeTabBuilding(baseBlock.asItem(), item);
        if (baseBlock == Blocks.OAK_DOOR || baseBlock == Blocks.IRON_DOOR) {
            AddItemToCreativeTabRedstone(baseBlock.asItem(), item);
        }
    }

    public Supplier<Block> RegisterBlock(IHorizontalDoor hDoor) {
        DoorBlock baseBlock = hDoor.GetBaseDoorBlock();
        Block block = new HorizontalDoorBlock(baseBlock);
        String name = GetName(baseBlock);
        return RegisterBlock(name, block);
    }

    public Supplier<Block> RegisterBlock(String name, Block block) {
        RenderBlockAsCutout(block);
        Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(Constants.MOD_ID, name), block);
        return () -> block;
    }

    public Supplier<Item> RegisterItem(IHorizontalDoor hDoor) {
        DoorBlock baseBlock = hDoor.GetBaseDoorBlock();
        Block block = new HorizontalDoorBlock(baseBlock);
        String name = GetName(baseBlock);
        Item item = new BlockItem(block, new Item.Properties());
        return RegisterItem(name, item);
    }

    public Supplier<Item> RegisterItem(String name, Item item) {
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Constants.MOD_ID, name), item);
        return () -> item;
    }

    public abstract void RenderBlockAsCutout(Block block);

    public abstract void AddItemToCreativeTabRedstone(Item itemBefore, Item item);

    public abstract void AddItemToCreativeTabBuilding(Item itemBefore, Item item);
}