package net.joni.gtsia.common.data.materials;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;

import java.util.function.Consumer;

public class GTSIARecipeProvider extends RecipeProvider {

    public GTSIARecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> writer) {
        // Hier rufst du deine Recipe-Klasse auf
        // LunaMachineRecipes.init(writer);
    }
}
