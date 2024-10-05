package millenniumambiguity.horizontaldoors.blocks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;

public enum HorizontalDoors implements IHorizontalDoor {
    OAK_DOOR((DoorBlock)Blocks.OAK_DOOR),
    SPRUCE_DOOR((DoorBlock)Blocks.SPRUCE_DOOR),
    BIRCH_DOOR((DoorBlock)Blocks.BIRCH_DOOR),
    JUNGLE_DOOR((DoorBlock)Blocks.JUNGLE_DOOR),
    ACACIA_DOOR((DoorBlock)Blocks.ACACIA_DOOR),
    DARK_OAK_DOOR((DoorBlock)Blocks.DARK_OAK_DOOR),
    MANGROVE_DOOR((DoorBlock)Blocks.MANGROVE_DOOR),
    CHERRY_DOOR((DoorBlock)Blocks.CHERRY_DOOR),
    BAMBOO_DOOR((DoorBlock)Blocks.BAMBOO_DOOR),
    CRIMSON_DOOR((DoorBlock)Blocks.CRIMSON_DOOR),
    WARPED_DOOR((DoorBlock)Blocks.WARPED_DOOR),
    IRON_DOOR((DoorBlock)Blocks.IRON_DOOR),
    COPPER_DOOR((DoorBlock)Blocks.COPPER_DOOR),
    EXPOSED_COPPER_DOOR((DoorBlock)Blocks.EXPOSED_COPPER_DOOR),
    WEATHERED_COPPER_DOOR((DoorBlock)Blocks.WEATHERED_COPPER_DOOR),
    OXIDIZED_COPPER_DOOR((DoorBlock)Blocks.OXIDIZED_COPPER_DOOR),
    WAXED_COPPER_DOOR((DoorBlock)Blocks.WAXED_COPPER_DOOR),
    WAXED_EXPOSED_COPPER_DOOR((DoorBlock)Blocks.WAXED_EXPOSED_COPPER_DOOR),
    WAXED_WEATHERED_COPPER_DOOR((DoorBlock)Blocks.WAXED_WEATHERED_COPPER_DOOR),
    WAXED_OXIDIZED_COPPER_DOOR((DoorBlock)Blocks.WAXED_OXIDIZED_COPPER_DOOR)
    ;

    private final DoorBlock BaseDoorBlock;

    HorizontalDoors(DoorBlock baseDoorBlock){
        BaseDoorBlock = baseDoorBlock;
    }

    @Override
    public DoorBlock GetBaseDoorBlock() {
        return BaseDoorBlock;
    }
}
