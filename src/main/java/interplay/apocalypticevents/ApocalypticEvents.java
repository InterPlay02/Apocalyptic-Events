package interplay.apocalypticevents;

import com.mojang.logging.LogUtils;
import interplay.apocalypticevents.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(ApocalypticEvents.MODID)
public class ApocalypticEvents
{
    public static final String MODID = "apocalypticevents";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ApocalypticEvents() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        //This will ensure the DeferredRegister gets registered (because it also needs to be registered)
        ModItems.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        // This makes the "addCreative" method to work
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event){

    }

    // Add block item to the mod's tab
    private void addCreative(BuildCreativeModeTabContentsEvent event){
        //If, when pressing E, the player is on creative mode and is opening
        //the tools and utilities tab
        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES){
            //Then add the newspaper to this tab
            event.accept(ModItems.NEWSPAPER);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event){

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event){

        }
    }
}
