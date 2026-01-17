package net.joni.luna.common.data.materials;

import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;

import static net.joni.luna.common.registry.LunaRegistration.REGISTRATE;

public class LunaItems {

    public static final ItemEntry<Item> MI_ITEM = REGISTRATE
            .item("mi_item", Item::new)
            .lang("Mi Item")
            .register();

    public static final ItemEntry<Item> MI_ITEM_CUSTOM = REGISTRATE
            .item("mi_item_custom", Item::new)
            .properties(p -> p.stacksTo(16))
            .lang("Mi Item Custom")
            .register();

    public static final ItemEntry<MoonDustItem> RAW_MOON_DUST = REGISTRATE
            .item("raw_moon_dust", MoonDustItem::new) // <--- Verweist jetzt auf deine neue Klasse
            .lang("Raw Moon Dust")
            .register();

    public static final ItemEntry<ComponentItem> MOON_INGOT = REGISTRATE
            .item("moon_ingot", ComponentItem::create)
            .lang("Moon Ingot")
            .register();
    public static final ItemEntry<Item> FILE_HEAD_CAST = REGISTRATE
            .item("file_head_cast", Item::new)
            .properties(p -> p.stacksTo(1))
            .model((context, provider) -> provider.generated(context))
            .lang("File Head Cast")
            .register();


    public static void init() {
    }
}

