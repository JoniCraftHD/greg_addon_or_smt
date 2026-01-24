package net.joni.luna.common.data.datagen;

import net.joni.luna.LunaCore;
import net.joni.luna.common.data.materials.LunaBlocks;
import net.joni.luna.common.data.materials.LunaTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, LunaCore.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(LunaTags.Blocks.METAL_DETECTOR_VALUABLES);
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(LunaBlocks.RESONITE_CASING.get()
                );




    }
}