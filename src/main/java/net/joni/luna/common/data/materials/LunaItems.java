package net.joni.luna.common.data.materials;




import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.joni.luna.common.registry.LunaRegistration;
import net.minecraft.world.item.Item;
import static net.joni.luna.common.registry.LunaRegistration.REGISTRATE;



public class LunaItems {


    private static final GTRegistrate REGISTRATE = LunaRegistration.REGISTRATE;

    // Registering a single item
    public static final ItemEntry<Item> MI_ITEM = REGISTRATE
            .item("mi_item", Item::new)
            .register();

    // Item with custom properties
    public static final ItemEntry<Item> MI_ITEM_CUSTOM = REGISTRATE
            .item("mi_item_custom", properties -> new Item(properties.stacksTo(16)))
            .register();

    // Method to initialize (call from your main class)

        public static void init() {
            REGISTRATE.registerRegistrate();
            LunaMaterialFlags.init();
        // This method only needs to be called to force the class to load
    }
}


