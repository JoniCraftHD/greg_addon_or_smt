package net.joni.luna.common.data.materials;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import java.util.List;

public class MoonDustItem extends Item {

    // 1. Definition der Beute und deren Gewichtung (höheres Gewicht = häufiger)
    private static class WeightedDrop {

        final Item item;
        final int weight;

        WeightedDrop(Item item, int weight) {
            this.item = item;
            this.weight = weight;
        }
    }

    private static final List<WeightedDrop> DROPS = List.of(
            new WeightedDrop(Items.IRON_INGOT, 50),
            new WeightedDrop(Items.GOLD_INGOT, 25),
            new WeightedDrop(Items.DIAMOND, 10),
            new WeightedDrop(Items.NETHERITE_SCRAP, 2));

    public MoonDustItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos pos = pContext.getClickedPos().above(); // Spawnt einen Block über dem Boden

        if (!level.isClientSide) {
            ServerLevel serverLevel = (ServerLevel) level;
            RandomSource random = level.getRandom();

            // 2. Deine Lootbeam-Entity spawnen
            // Ersetze 'DEINE_ENTITY_REGISTRIERUNG' durch deinen Registrate-Eintrag (z.B. LunaEntities.LOOT_BEAM.get())
            /*
             * LootBeamEntity beam = new LootBeamEntity(LunaEntities.LOOT_BEAM.get(), level);
             * beam.setPos(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
             * level.addFreshEntity(beam);
             */

            // 3. Loot-Berechnung
            if (random.nextFloat() < 0.60f) { // 60% Chance auf Loot
                ItemStack lootStack = getRandomDrop(random);

                if (!lootStack.isEmpty()) {
                    ItemEntity itemEntity = new ItemEntity(level,
                            pos.getX() + 0.5, pos.getY() + 0.2, pos.getZ() + 0.5,
                            lootStack);

                    // Ein kleiner physikalischer Effekt beim Erscheinen
                    itemEntity.setDeltaMovement(0, 0.1, 0);
                    level.addFreshEntity(itemEntity);
                }
            }

            // 4. Visuelle Effekte & Sound
            serverLevel.sendParticles(ParticleTypes.END_ROD,
                    pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                    15, 0.2, 0.2, 0.2, 0.05);

            // 5. Item verbrauchen
            if (pContext.getPlayer() != null && !pContext.getPlayer().isCreative()) {
                pContext.getItemInHand().shrink(1);
            }
        }

        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    // Hilfsmethode zur Berechnung des zufälligen Loots
    public static ItemStack getRandomDrop(RandomSource random) {
        int totalWeight = DROPS.stream().mapToInt(d -> d.weight).sum();
        int r = random.nextInt(totalWeight);
        int currentWeight = 0;

        for (WeightedDrop drop : DROPS) {
            currentWeight += drop.weight;
            if (r < currentWeight) {
                return new ItemStack(drop.item);
            }
        }
        return ItemStack.EMPTY;
    }
}
