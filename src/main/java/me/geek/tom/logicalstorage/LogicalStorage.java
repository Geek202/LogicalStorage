package me.geek.tom.logicalstorage;

import me.geek.tom.logicalstorage.proxy.ClientProxy;
import me.geek.tom.logicalstorage.proxy.IProxy;
import me.geek.tom.logicalstorage.proxy.ServerProxy;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(LogicalStorage.MODID)
public class LogicalStorage {

    public static ItemGroup getCreativeTab() {
        return creativeTab;
    }

    public static final String MODID = "logicalstorage";

    public static IProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> ServerProxy::new);

    public LogicalStorage() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    private static ItemGroup creativeTab = new ItemGroup("logicalstorage") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(EventSubscriber.superChestBlockItem);
        }
    };

    public void setup(FMLCommonSetupEvent event) {
        proxy.init();
    }

}
