package net.joni.gtsia.mixin;

import earth.terrarium.adastra.common.systems.EnvironmentEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EnvironmentEffects.class)
public class AbyssalSunMixin {

    @Inject(method = "tickHot", at = @At("TAIL"), remap = false)
    private static void gtsia$handleAbydosSunBurn(ServerLevel level, BlockPos pos, BlockState state, CallbackInfo ci) {
        // Nachricht 1: Wird die Methode überhaupt aufgerufen?
        System.out.println("GTSIA: tickHot aufgerufen an " + pos);

        if (level.dimension().location().toString().equals("sgjourney:abydos")) {
            System.out.println("GTSIA: Dimension ist Abydos!");

            if (state.is(BlockTags.LOGS)) {
                System.out.println("GTSIA: Block ist Holz: " + state.getBlock().getName().getString());

                if (level.isDay() && level.canSeeSky(pos.above())) {
                    System.out.println("GTSIA: Sonne scheint auf das Holz!");

                    BlockPos spaceAbove = pos.above();
                    if (level.isEmptyBlock(spaceAbove)) {
                        level.setBlockAndUpdate(spaceAbove, Blocks.FIRE.defaultBlockState());
                        System.out.println("GTSIA: FEUER GESETZT!");
                    }
                }
            }
        }
    }
}