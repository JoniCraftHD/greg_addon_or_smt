package net.joni.luna.common.data.materials;


import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import java.util.function.Consumer;

public class LunaRecipeProvider extends RecipeProvider {
    public LunaRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> writer) {
        // Hier rufst du deine Recipe-Klasse auf
        // LunaMachineRecipes.init(writer);
    }
}