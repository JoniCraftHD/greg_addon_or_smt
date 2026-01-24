package net.joni.luna.common.data.materials.lootbeam;

import net.minecraft.resources.ResourceLocation;

import software.bernie.geckolib.model.GeoModel;

public class LootBeamModel extends GeoModel<LootBeamEntity> {

    @Override
    public ResourceLocation getModelResource(LootBeamEntity animatable) {
        // Pfad zur .geo.json
        return new ResourceLocation("luna", "geo/lootbeam.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(LootBeamEntity animatable) {
        // Pfad zur .png
        return new ResourceLocation("luna", "textures/entity/lootbeam.png");
    }

    @Override
    public ResourceLocation getAnimationResource(LootBeamEntity animatable) {
        // Pfad zur .animation.json
        return new ResourceLocation("luna", "animations/model.animation.json");
    }
}
