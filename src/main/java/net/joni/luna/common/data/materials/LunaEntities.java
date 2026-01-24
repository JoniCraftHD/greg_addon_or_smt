package net.joni.luna.common.data.materials;

import net.joni.luna.common.data.materials.lootbeam.LootBeamEntity;
import net.joni.luna.common.data.materials.lootbeam.LootBeamRenderer;
import net.minecraft.world.entity.MobCategory;

import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.EntityEntry;

public class LunaEntities {

    // Hier nutzen wir dein Registrate-Objekt (muss dasselbe wie bei LunaItems sein)
    private static final Registrate REGISTRATE = Registrate.create("luna"); // Deine Mod-ID hier rein!

    public static final EntityEntry<LootBeamEntity> LOOT_BEAM = REGISTRATE
            .entity("loot_beam", LootBeamEntity::new, MobCategory.MISC)
            .renderer(() -> LootBeamRenderer::new) // Das verknüpft automatisch den Renderer!
            .register();

    public static void register() {
        // Diese Methode rufen wir in der Hauptklasse auf, damit die Registrierung startet
    }

    public static void init() {}
}
