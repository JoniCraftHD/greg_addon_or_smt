package net.joni.luna.common.data.materials;


import com.gregtechceu.gtceu.api.block.ActiveBlock;

import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

import static net.joni.luna.common.registry.LunaRegistration.REGISTRATE;

public class LunaBlocks {

    public static final BlockEntry<Block> RESONITE_CASING = REGISTRATE
            .block("resonite_casing", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .properties(p -> p
                    .mapColor(MapColor.COLOR_PURPLE)
                    .strength(5.0f, 10.0f)
                    .sound(SoundType.METAL)
                    .requiresCorrectToolForDrops())
            .lang("Resonite Casing")
            .item(BlockItem::new)
            .build()
            .register();

    public static final BlockEntry<ActiveBlock> RESONANCE_GLASS = REGISTRATE
            .block("resonance_glass", ActiveBlock::new)
            .initialProperties(() -> Blocks.GLASS)
            .properties(p -> p
                    .mapColor(MapColor.NONE)
                    .strength(2.0f)
                    .noOcclusion())
            .addLayer(() -> RenderType::cutout)
            .lang("Resonance Glass")
            .item(BlockItem::new)
            .build()
            .register();

    public static void init() {

    }
}