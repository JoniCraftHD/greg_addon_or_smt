package net.joni.gtsia.common.data.materials;

import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static net.joni.gtsia.common.data.materials.GTSIARecipeTypes.RESONANCE_GEN;


public class GTSIAMachineRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {


        RESONANCE_GEN.recipeBuilder("neutronium_resonance")
                .inputItems(GTSIAItems.MOON_INGOT.get(), 4)
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
