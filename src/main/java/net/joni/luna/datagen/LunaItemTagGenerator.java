package net.joni.luna.datagen;


import net.joni.luna.LunaCore;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class LunaItemTagGenerator extends ItemTagsProvider {

    public LunaItemTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                CompletableFuture<TagLookup<Block>> blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
        // Hier wird deine Mod-ID 'luna' genutzt
        super(output, lookupProvider, blockTagProvider, LunaCore.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        // Beispiel: Falls du Rüstung aus Resonite hast, die getrimmt werden kann
        /*
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(LunaItems.RESONITE_HELMET.get(),
                     LunaItems.RESONITE_CHESTPLATE.get());
        */

        // Beispiel: Deine Casings zu den entsprechenden Tags hinzufügen
        // (Wichtig, damit andere Mods erkennen, was deine Blöcke sind)
        /*
        this.tag(ItemTags.PLANKS)
                .add(LunaBlocks.SOME_CUSTOM_PLANKS.get().asItem());
        */


        // Hier kannst du deine eigenen Tags definieren oder Standard-Minecraft-Tags füllen
    }
}