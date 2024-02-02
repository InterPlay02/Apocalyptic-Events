package interplay.apocalypticevents.item;

import interplay.apocalypticevents.ApocalypticEvents;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    //This is just a long list (of items, in this case) to store all the items of the mod:
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ApocalypticEvents.MODID);

    //This is creating the item called Newspaper:
    public static final RegistryObject<Item> NEWSPAPER = ITEMS.register("newspaper", () -> new Item(new Item.Properties()));
                                                         //This is registering the new item with the id "newspaper"
                                                                                           // and is suppying it with the default Item properties.

    //This is registering the DeferredRegistrer itself
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
