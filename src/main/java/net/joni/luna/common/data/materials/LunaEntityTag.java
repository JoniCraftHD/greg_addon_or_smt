package net.joni.luna.common.data.materials;

import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class LunaEntityTag {
    @SubscribeEvent
    public static void onEntityJoin(EntityJoinLevelEvent event) {
        if (event.getEntity() instanceof WitherSkeleton) {
            event.getEntity().addTag("luna:resonance_entity");
        }
    }
}
