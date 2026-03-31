package net.joni.gtsia.common.handler;

import earth.terrarium.adastra.api.systems.TemperatureApi;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "gtsia") // deine modid anpassen
public class TemperatureFireHandler {

    private static final int CHECK_INTERVAL = 40;

    @SubscribeEvent
    public static void onLevelTick(TickEvent.LevelTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;
        if (!(event.level instanceof ServerLevel level)) return;
        if (level.getGameTime() % CHECK_INTERVAL != 0) return;

        level.players().forEach(player -> {
            BlockPos playerPos = player.blockPosition();

            for (int x = -16; x <= 16; x += 2) {
                for (int z = -16; z <= 16; z += 2) {
                    for (int y = -2; y <= 4; y++) {
                        BlockPos pos = playerPos.offset(x, y, z);
                        BlockState state = level.getBlockState(pos);

                        if (state.isAir()) continue;

                        // isHot() nutzt direkt die Ad Astra Temperatur-API
                        if (!TemperatureApi.API.isHot(level, pos)) continue;

                        boolean isFlammable = state.is(BlockTags.LOGS)
                                || state.is(BlockTags.PLANKS)
                                || state.is(BlockTags.LEAVES)
                                || state.is(BlockTags.WOOL)
                                || state.is(BlockTags.FENCES)
                                || state.is(BlockTags.WOODEN_SLABS);

                        if (!isFlammable) continue;

                        BlockPos above = pos.above();
                        if (!level.getBlockState(above).isAir()) continue;

                        if (level.random.nextFloat() > 0.3f) continue;

                        level.setBlock(above, Blocks.FIRE.defaultBlockState(), 3);
                    }
                }
            }
        });
    }
}