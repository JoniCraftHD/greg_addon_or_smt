package net.joni.luna.common.data.materials;

import net.joni.luna.common.data.materials.lootbeam.LootBeamRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "luna", bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        // Hier wird deine Entity mit dem LootBeamRenderer verknüpft
        event.registerEntityRenderer(LunaEntities.LOOT_BEAM.get(), LootBeamRenderer::new);
    }


    }
