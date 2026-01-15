package net.joni.luna.common.data.materials;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.EntityLeaveLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModEvents {

    @SubscribeEvent
    public static void onEntityLeaveLevel(EntityLeaveLevelEvent event) {
        if (event.getEntity() instanceof FireworkRocketEntity rocket) {
            if (rocket.getTags().contains("is_luna_rocket") && !event.getLevel().isClientSide) {

                Level level = event.getLevel();
                BlockPos pos = rocket.blockPosition();
                var random = level.getRandom();

                // 1. Grundchance: Soll überhaupt etwas droppen? (z.B. 40%)
                if (random.nextFloat() < 0.40f) {

                    // 2. Welches Item droppt basierend auf Gewichtung?
                    ItemStack stackToDrop = MoonDustItem.getRandomDrop(random);

                    if (!stackToDrop.isEmpty()) {
                        ItemEntity itemEntity = new ItemEntity(
                                level,
                                pos.getX(), pos.getY() + 0.5, pos.getZ(),
                                stackToDrop
                        );

                        // Ein bisschen "Schwung" hinzufügen, damit es cooler aussieht
                        itemEntity.setDeltaMovement(
                                random.nextGaussian() * 0.05,
                                0.2,
                                random.nextGaussian() * 0.05
                        );

                        level.addFreshEntity(itemEntity);
                    }
                }
            }
        }
    }
}