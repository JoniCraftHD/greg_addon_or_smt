package net.joni.luna.common.data.materials.lootbeam;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

import net.minecraft.world.level.Level;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

public class LootBeamEntity extends Entity implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public LootBeamEntity(EntityType<?> type, Level level) {
        super(type, level);
    }


    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 0, state -> {
            // "animation.lootbeam.deploy" ist der Name aus deiner .animation.json


            return state.setAndContinue(RawAnimation.begin().thenPlay("loot beam"));

        }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }


    @Override protected void defineSynchedData() {}
    @Override protected void readAdditionalSaveData(CompoundTag nbt) {}
    @Override protected void addAdditionalSaveData(CompoundTag nbt) {}




}