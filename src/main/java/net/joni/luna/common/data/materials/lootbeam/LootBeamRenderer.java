package net.joni.luna.common.data.materials.lootbeam;

import net.minecraft.client.renderer.entity.EntityRendererProvider;

import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class LootBeamRenderer extends GeoEntityRenderer<LootBeamEntity> {

    public LootBeamRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new LootBeamModel());
    }
}
