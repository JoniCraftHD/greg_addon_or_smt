package net.joni.gtsia.datagen.model;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.registry.registrate.MachineBuilder;
import com.gregtechceu.gtceu.common.machine.electric.ChargerMachine;
import net.joni.gtsia.GTSIA;
import net.joni.gtsia.common.machine.multi.ShieldRenderProperty;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockModelBuilder;

import static com.gregtechceu.gtceu.api.machine.property.GTMachineModelProperties.CHARGER_STATE;
import static com.gregtechceu.gtceu.common.data.models.GTMachineModels.*;

public class LunaMachineModels {

        // ============================================================
        // BASE MODELS (EXISTING)
        // ============================================================

        public static MachineBuilder.ModelInitializer createOverlayFillLevelCasingMachineModel(
                String overlayName,
                String casingTexturePath) {
            return (ctx, prov, builder) -> {
                builder.forAllStatesModels(state -> {
                    BlockModelBuilder model = prov.models().nested()
                            .parent(prov.models().getExistingFile(
                                    GTCEu.id("block/overlay/2_layer/front_emissive")));
                    casingTextures(model, casingTexturePath);

                    var prop = state.getValue(ShieldRenderProperty.TYPE);
                    var key = prop.getSerializedName();

                    model.texture("overlay",
                            GTSIA.id("block/overlay/machine/" + overlayName + "_base"));

                    model.texture("overlay_emissive",
                            GTSIA.id("block/overlay/machine/" + overlayName + "_overlay_" + key));

                    return model;
                });

                builder.addReplaceableTextures("bottom", "top", "side");
            };
        }
    public static final ResourceLocation RESONANCE_GEN_IDLE = GTSIA
            .id("block/multiblock/resonance_gen/overlay_front");
        public static final  ResourceLocation RESONANCE_GEN_RUNNING = GTSIA
                .id("block/multiblock/resonance_gen/overlay_front_active");
    public static final ResourceLocation RESONANCE_GEN_RUNNING_EMISSIVE = GTSIA
            .id("block/multiblock/resonance_gen/overlay_front_active_emissive");
    public static final ResourceLocation RESONANCE_GEN_FINISHED = GTSIA
            .id("block/multiblock/resonance_genoverlay_front");
    public static final ResourceLocation RESONANCE_GEN_FINISHED_EMISSIVE = GTSIA
            .id("block/multiblock/resonance_gen/overlay_front_emissive");


    public static MachineBuilder.ModelInitializer createResonanceGenModel() {
        return (ctx, prov, builder) -> {
            builder.forAllStatesModels(renderState -> {
                ChargerMachine.State state = renderState.getValue(CHARGER_STATE);

                BlockModelBuilder model = prov.models().nested()
                        .parent(prov.models().getExistingFile(SIDED_SIDED_OVERLAY_MODEL));
                tieredHullTextures(model, builder.getOwner().getTier());

                switch (state) {
                    case IDLE -> {
                        model.texture("overlay_front", RESONANCE_GEN_IDLE);

                    }
                    case RUNNING -> {
                        model.texture("overlay_front", RESONANCE_GEN_RUNNING);
                        model.texture("overlay_front_emissive", RESONANCE_GEN_RUNNING_EMISSIVE);

                    }
                    case FINISHED -> {
                        model.texture("overlay_front", RESONANCE_GEN_FINISHED);
                        model.texture("overlay_front_emissive", RESONANCE_GEN_FINISHED_EMISSIVE);
                    }

                }
                return model;
            });
        };
    }

    public static void casingTextures(BlockModelBuilder model, String casingTexturePath) {
        ResourceLocation casing = GTSIA.id("block/casings/" + casingTexturePath);
        model.texture("bottom", casing);
        model.texture("top", casing);
        model.texture("side", casing);
    }
}
