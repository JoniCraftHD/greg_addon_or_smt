package net.joni.gtsia.datagen;

import com.gregtechceu.gtceu.api.registry.registrate.SoundEntryBuilder;
import net.joni.gtsia.GTSIA;
import net.minecraft.data.PackOutput;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GTSIA.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class GTSIADataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        PackOutput packOutput = event.getGenerator().getPackOutput();

        if (event.includeClient()) {
            event.getGenerator().addProvider(
                    true,
                    new SoundEntryBuilder.SoundEntryProvider(packOutput, GTSIA.MOD_ID));
        }
    }
}
