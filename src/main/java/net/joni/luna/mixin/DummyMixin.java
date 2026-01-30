package net.joni.luna.mixin;

import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldgenRandom.class)
public class DummyMixin {
    @Inject(method = "<init>", at = @At("RETURN"))
    private void onInit(RandomSource randomSource, CallbackInfo ci) {
        System.out.println("Luna-Mod: Mixin erfolgreich in WorldgenRandom injiziert!");
    }
}