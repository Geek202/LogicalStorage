package me.geek.tom.logicalstorage;

import me.geek.tom.logicalstorage.blocks.ModBlocks;
import me.geek.tom.logicalstorage.blocks.superchest.SuperChestBlock;
import me.geek.tom.logicalstorage.blocks.superchest.SuperChestContainer;
import me.geek.tom.logicalstorage.blocks.superchest.SuperChestTile;
import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = LogicalStorage.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EventSubscriber {

    public static Block superChestBlock = new SuperChestBlock();
    public static Item superChestBlockItem = new BlockItem(superChestBlock, new Item.Properties().group(LogicalStorage.getCreativeTab())).setRegistryName("superchest");

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
            superChestBlockItem
        );
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                superChestBlock
        );
    }

    @SubscribeEvent
    public static void registerContainers(RegistryEvent.Register<ContainerType<?>> event) {
        event.getRegistry().registerAll(
                IForgeContainerType.create((windowId, inv, data) -> {
                    BlockPos pos = data.readBlockPos();
                    return new SuperChestContainer(windowId, LogicalStorage.proxy.getClientWorld(), pos, inv, LogicalStorage.proxy.getClientPlayer());
                }).setRegistryName("superchest")
        );
    }

    @SubscribeEvent
    public static void registerTileEntityTypes(RegistryEvent.Register<TileEntityType<?>> event) {
        event.getRegistry().registerAll(
                TileEntityType.Builder.create(SuperChestTile::new, ModBlocks.SUPERCHESTBLOCK).build(null).setRegistryName("superchest")
        );
    }

}
