package millenniumambiguity.horizontaldoors;

import millenniumambiguity.horizontaldoors.blocks.HorizontalDoorBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Supplier;

import static net.minecraft.world.level.block.Blocks.OAK_PLANKS;

public abstract class CommonRegistry {

    protected static CommonRegistry registry = null;

    public static Block HORIZONTAL_OAK_DOOR;
    public static Item HORIZONTAL_OAK_DOOR_ITEM;

    public static void RegisterBlocks(){
        CommonRegistry.RegisterHorizontalOakDoorItem();

        if (registry == null) return;

        registry.AddItemToCreativeTabRedstone(Items.OAK_DOOR, HORIZONTAL_OAK_DOOR_ITEM);
        registry.AddItemToCreativeTabBuilding(Items.OAK_DOOR, HORIZONTAL_OAK_DOOR_ITEM);
    }

    public static Supplier<Block> RegisterHorizontalOakDoorBlock() {
        HORIZONTAL_OAK_DOOR = new HorizontalDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of()
                .mapColor(OAK_PLANKS.defaultMapColor())
                .instrument(NoteBlockInstrument.BASS)
                .strength(3.0F)
                .noOcclusion()
                .ignitedByLava()
                .pushReaction(PushReaction.DESTROY)
        );
        if (registry != null)
            registry.RenderBlockAsCutout(HORIZONTAL_OAK_DOOR);
        return registerBlock("horizontal_oak_door", () -> HORIZONTAL_OAK_DOOR);
    }

    public static Supplier<Item> RegisterHorizontalOakDoorItem() {
        HORIZONTAL_OAK_DOOR_ITEM = new BlockItem(RegisterHorizontalOakDoorBlock().get(), new Item.Properties());
        return registerItem("horizontal_oak_door", () -> HORIZONTAL_OAK_DOOR_ITEM);
    }

    // Registers block (to be implemented per platform)
    public static Supplier<Block> registerBlock(String name, Supplier<Block> blockSupplier) {
        Block block = blockSupplier.get();
        Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(Constants.MOD_ID, name), block);
        return () -> block;
    }

    // Registers item (to be implemented per platform)
    public static Supplier<Item> registerItem(String name, Supplier<Item> itemSupplier) {
        Item item = itemSupplier.get();
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Constants.MOD_ID, name), item);
        return () -> item;
    }

    public abstract void RenderBlockAsCutout(Block block);

    public abstract void AddItemToCreativeTabRedstone(Item itemBefore, Item item);

    public abstract void AddItemToCreativeTabBuilding(Item itemBefore, Item item);
}