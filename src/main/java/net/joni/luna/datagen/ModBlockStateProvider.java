package net.joni.luna.datagen;

import com.tterrag.registrate.util.entry.BlockEntry;
import net.joni.luna.LunaCore;
import net.joni.luna.common.data.materials.LunaBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.UnknownNullability;

public class ModBlockStateProvider extends BlockStateProvider {
        public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
            super(output, LunaCore.MOD_ID, exFileHelper);
        }

        @Override
        protected void registerStatesAndModels() {
            blockWithItem(LunaBlocks.RESONITE_CASING);
        }

        private void blockWithItem(@UnknownNullability BlockEntry<Block> blockRegistryObject) {
            simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
        }
    }

