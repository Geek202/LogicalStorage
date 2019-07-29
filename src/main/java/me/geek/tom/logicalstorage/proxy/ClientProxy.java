package me.geek.tom.logicalstorage.proxy;

import me.geek.tom.logicalstorage.blocks.ModBlocks;
import me.geek.tom.logicalstorage.blocks.superchest.SuperChestScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class ClientProxy extends CommonProxy implements IProxy {

    @Override
    public void init() {
        ScreenManager.registerFactory(ModBlocks.SUPERCHEST_CONTAINER, SuperChestScreen::new);
    }

    @Override
    public World getClientWorld() {
        return Minecraft.getInstance().world;
    }

    @Override
    public PlayerEntity getClientPlayer() {
        return Minecraft.getInstance().player;
    }

}
