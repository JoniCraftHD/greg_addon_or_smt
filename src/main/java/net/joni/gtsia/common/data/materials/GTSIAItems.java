package net.joni.gtsia.common.data.materials;

import com.gregtechceu.gtceu.api.item.ComponentItem;

import net.minecraft.world.item.Item;

import com.tterrag.registrate.util.entry.ItemEntry;

import static net.joni.gtsia.common.registry.GTSIARegistration.REGISTRATE;

public class GTSIAItems {

    public static final ItemEntry<Item> MI_ITEM = REGISTRATE
            .item("mi_item", Item::new)
            .lang("Mi Item")
            .register();

    public static final ItemEntry<Item> MI_ITEM_CUSTOM = REGISTRATE
            .item("mi_item_custom", Item::new)
            .properties(p -> p.stacksTo(16))
            .lang("Mi Item Custom")
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
    public static final ItemEntry<Item> PLANT_CHUNKS = REGISTRATE
            .item("plant_chunks", Item::new)
            .properties(p -> p.stacksTo(64))
            .model((context, provider) -> provider.generated(context))
            .lang("Plant Chunks")
            .register();
    public static final ItemEntry<Item> PLANT_FIBERS = REGISTRATE
            .item("plant_fibers", Item::new)
            .properties(p -> p.stacksTo(64))
            .model((context, provider) -> provider.generated(context))
            .lang("Plant Fibers")
            .register();

    public static void init() {}
}
