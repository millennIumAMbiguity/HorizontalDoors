package millenniumambiguity.horizontaldoors;

import millenniumambiguity.horizontaldoors.blocks.HorizontalDoors;
import millenniumambiguity.horizontaldoors.blocks.IHorizontalDoor;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CommonClass {

    public static ConcurrentLinkedQueue<IHorizontalDoor> DOOR_TYPES = new ConcurrentLinkedQueue<>(List.of(HorizontalDoors.values()));

    public static void init() { }
}