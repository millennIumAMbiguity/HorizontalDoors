package millenniumambiguity.horizontaldoors;

import millenniumambiguity.horizontaldoors.blocks.HorizontalDoorBlock;
import millenniumambiguity.horizontaldoors.blocks.IHorizontalDoor;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

public abstract class CommonRegistry {

    protected final String namePrefix = "horizontal_";

    protected String GetName(IHorizontalDoor hDoor){
        String[] hits = hDoor.GetBaseDoorBlock().getDescriptionId().split("\\.", 3);
        return namePrefix + hits[hits.length -1];
    }

    public Supplier<Block> GetDoorBlock(IHorizontalDoor hDoor) {
        return () -> CommonClass.HORIZONTAL_DOOR_BLOCKS.computeIfAbsent(hDoor, key ->
                new HorizontalDoorBlock(key.GetBaseDoorBlock()));
    }

    public Supplier<Item> GetDoorItem(IHorizontalDoor hDoor) {
        return () -> CommonClass.HORIZONTAL_DOOR_ITEMS.computeIfAbsent(hDoor, key ->
                new BlockItem(GetDoorBlock(hDoor).get(), new Item.Properties()));
    }

    public void RegisterAll() {
        for (IHorizontalDoor door : CommonClass.DOOR_TYPES){
            Register(door);
        }
    }

    public void Register(IHorizontalDoor hDoor) {
        String name = GetName(hDoor);
        RegisterBlock(name, GetDoorBlock(hDoor));
        RegisterItem(name, GetDoorItem(hDoor));
    }

    public Supplier<Block> RegisterBlock(IHorizontalDoor hDoor) {
        return RegisterBlock(GetName(hDoor), GetDoorBlock(hDoor));
    }

    public Supplier<Block> RegisterBlock(String name, Supplier<Block> block) {
        return () -> {
            Block b = block.get();
            Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(Constants.MOD_ID, name), b);
            return b;
        };
    }

    public Supplier<Item> RegisterItem(IHorizontalDoor hDoor) {
        return RegisterItem(GetName(hDoor), GetDoorItem(hDoor));
    }

    public Supplier<Item> RegisterItem(String name, Supplier<Item> item) {
        return () -> {
            Item i = item.get();
            Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Constants.MOD_ID, name), i);
            return i;
        };
    }
}