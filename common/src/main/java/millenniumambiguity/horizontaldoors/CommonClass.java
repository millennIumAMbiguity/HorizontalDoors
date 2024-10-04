package millenniumambiguity.horizontaldoors;

import millenniumambiguity.horizontaldoors.blocks.HorizontalDoorBlock;
import millenniumambiguity.horizontaldoors.blocks.HorizontalDoors;
import millenniumambiguity.horizontaldoors.blocks.IHorizontalDoor;
import net.minecraft.world.item.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonClass {

    public static List<IHorizontalDoor> DOOR_TYPES = List.of(HorizontalDoors.values());
    public static Map<IHorizontalDoor, HorizontalDoorBlock> HORIZONTAL_DOOR_BLOCKS = new HashMap<>();
    public static Map<IHorizontalDoor, Item> HORIZONTAL_DOOR_ITEMS = new HashMap<>();

    public static void init() { }
}