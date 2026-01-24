package net.joni.luna.common.data.materials;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.common.data.GTBlocks;

import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import com.gregtechceu.gtceu.integration.kjs.helpers.MachineModifiers;
import net.joni.luna.LunaCore;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import static com.gregtechceu.gtceu.common.registry.GTRegistration.REGISTRATE;

public class LunaMultiblocks {

    public static final MultiblockMachineDefinition RESONANCE_GEN = REGISTRATE


            .multiblock("resonance_gen", WorkableElectricMultiblockMachine::new)
            .langValue("§bResonance Generator")
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(LunaRecipeTypes.RESONANCE_GEN)
            .recipeModifiers(GTRecipeModifiers.PARALLEL_HATCH, GTRecipeModifiers.OC_NON_PERFECT,
                  LunaRecipeModifiers.RIFT_CHECK,
                  GTRecipeModifiers.BATCH_MODE)
            .generator(true)
            .regressWhenWaiting(false)
            .appearanceBlock(GTBlocks.CASING_STEEL_SOLID)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("BBBBB", "CCCCC", "CDDDC", "DDDDD", "DDDDD", "CDDDC", "CCCCC", "BBBBB")
                    .aisle("BBBBB", "CEEEC", "DAAAD", "DAAAD", "DAAAD", "DFGFD", "CEEEC", "BBBBB")
                    .aisle("BBBBB", "CEEEC", "DAAAD", "DAAAD", "DAAAD", "DGGGD", "CEEEC", "BBBBB")
                    .aisle("BBBBB", "CEEEC", "DAAAD", "DAAAD", "DAAAD", "DFGFD", "CEEEC", "BBBBB")
                    .aisle("BBHBB", "CCCCC", "CDDDC", "DDDDD", "DDDDD", "CDDDC", "CCCCC", "BBBBB")

                    .where("A", Predicates.any())
                    .where("B",
                            Predicates.blocks(ForgeRegistries.BLOCKS.getValue(ResourceLocation.parse("luna:resonite_casing")))

                            .or(Predicates.abilities(PartAbility.MAINTENANCE)
                                    .setExactLimit(1))

                            .or(Predicates.abilities(PartAbility.PARALLEL_HATCH)
                                    .setMaxGlobalLimited(1))

                            .or(Predicates.abilities(PartAbility.IMPORT_ITEMS)
                                    .setMaxGlobalLimited(1))

                            .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS)
                                    .setMaxGlobalLimited(1))

                    )
                    .where("C",
                            Predicates.blocks(ForgeRegistries.BLOCKS
                                    .getValue(ResourceLocation.parse("gtceu:steel_turbine_casing")))
                    .or(Predicates.blocks(GTMachines.ENERGY_OUTPUT_HATCH[GTValues.OpV].get())
                            .setMaxGlobalLimited(2))
                    )
                    .where("H", Predicates.controller(Predicates.blocks(definition.get())))

                    .where("E",
                            Predicates.blocks(ForgeRegistries.BLOCKS
                                    .getValue(ResourceLocation.parse("gtceu:corrosion_proof_casing"))))
                    .where("F",
                            Predicates.blocks(ForgeRegistries.BLOCKS
                                    .getValue(ResourceLocation.parse("strangematter:shade_shard_lamp"))))
                    .where("G",
                            Predicates.blocks(ForgeRegistries.BLOCKS
                                    .getValue(ResourceLocation.parse("gtceu:kanthal_coil_block"))))
                    .where("D",
                            Predicates.blocks(ForgeRegistries.BLOCKS
                                    .getValue(ResourceLocation.parse("gtceu:tempered_glass"))))

                    .build())

            .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_clean_stainless_steel"),
                    (LunaCore.id("block/multiblock/resonance_gen")))
            .register();

    public static void init(){}
}


