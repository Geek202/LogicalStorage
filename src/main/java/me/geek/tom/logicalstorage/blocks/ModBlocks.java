package me.geek.tom.logicalstorage.blocks;

import me.geek.tom.logicalstorage.blocks.superchest.SuperChestContainer;
import me.geek.tom.logicalstorage.blocks.superchest.SuperChestTile;
import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

public class ModBlocks {

    @ObjectHolder("logicalstorage:superchest")
    public static Block SUPERCHESTBLOCK;

    @ObjectHolder("logicalstorage:superchest")
    public static TileEntityType<SuperChestTile> SUPERCHEST_TILE;

    @ObjectHolder("logicalstorage:superchest")
    public static ContainerType<SuperChestContainer> SUPERCHEST_CONTAINER;
}
