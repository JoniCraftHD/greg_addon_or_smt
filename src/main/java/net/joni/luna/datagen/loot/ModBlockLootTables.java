package net.joni.luna.datagen.loot;





import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.stream.Collectors;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        // Hier definierst du, welche Blöcke sich selbst droppen (z.B. Casings)
        // dropSelf(LunaBlocks.RESONITE_CASING.get());

        // Beispiel für ein Erz, das ein Raw-Item droppt (wie Kupfer/Sapphire)
        /*
        this.add(LunaBlocks.RESONITE_ORE.get(),
                block -> createResoniteOreDrops(LunaBlocks.RESONITE_ORE.get(), LunaItems.RAW_RESONITE.get()));
        */
    }

    // Eine Hilfsmethode für Erze (ähnlich wie Kupfer oder dein Sapphire-Beispiel)
    protected LootTable.Builder createResoniteOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ForgeRegistries.BLOCKS.getValues().stream()
                // Ersetze LunaCore.MOD_ID mit deiner Mod-ID "luna"
                .filter(block -> ForgeRegistries.BLOCKS.getKey(block).getNamespace().equals("luna"))
                .collect(Collectors.toList());
    }
    }

