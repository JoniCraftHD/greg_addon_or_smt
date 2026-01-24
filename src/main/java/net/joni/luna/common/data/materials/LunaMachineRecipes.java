package net.joni.luna.common.data.materials;

import com.gregtechceu.gtceu.common.data.GTMaterials;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.ibm.icu.impl.CurrencyData.provider;
import static net.joni.luna.common.data.materials.LunaRecipeTypes.RESONANCE_GEN;


public class LunaMachineRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {

        RESONANCE_GEN.recipeBuilder("resonance_from_moon_dust")
                .inputItems(LunaItems.RAW_MOON_DUST.get(), 1)
                .inputFluids(GTMaterials.Helium.getFluid(100))
                .duration(1200)
                .EUt(-VA[UHV])
                .save(provider);


        RESONANCE_GEN.recipeBuilder("neutronium_resonance")
                .inputItems(LunaItems.MOON_INGOT.get(), 4)
                .inputFluids(GTMaterials.Argon.getFluid(1000))

                .duration(2400)
                .EUt(-VA[UEV])
                .save(provider);


        RESONANCE_GEN.recipeBuilder("resonance_test")
                .inputItems(net.minecraft.world.item.Items.NETHER_STAR)
                .duration(600)
                .EUt(-VA[ZPM])
                .save(provider);
    }

}