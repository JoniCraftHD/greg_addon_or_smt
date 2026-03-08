package net.joni.gtsia.common.data.materials;

import com.gregtechceu.gtceu.api.block.ActiveBlock;

import com.tterrag.registrate.providers.loot.RegistrateBlockLootTables;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

import com.tterrag.registrate.util.entry.BlockEntry;

import static net.joni.gtsia.common.registry.GTSIARegistration.REGISTRATE;

public class GTSIABlocks {

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
    public static final BlockEntry<Block> MOON_COBBLESTONE = REGISTRATE
            .block("moon_cobblestone", Block::new)
            .initialProperties(() -> Blocks.COBBLESTONE)
            .properties(p -> p
                    .mapColor(MapColor.COLOR_GRAY)
                    .strength(2.0f, 4.0f)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops())
            .lang("Moon Cobblestone")
            .item(BlockItem::new)
            .build()
            .register();
    public static final BlockEntry<Block> MOSSY_MOON_COBBLESTONE = REGISTRATE
            .block("mossy_moon_cobblestone", Block::new)
            .initialProperties(() -> Blocks.COBBLESTONE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)

            .properties(p -> p
                    .mapColor(MapColor.COLOR_GRAY)
                    .requiresCorrectToolForDrops()
                    .strength(0.5f, 4.0f)
                    .sound(SoundType.STONE))
            .lang("Mossy Moon Cobblestone")
            .item(BlockItem::new)
            .build()
            .register();

    public static void init() {}
}
