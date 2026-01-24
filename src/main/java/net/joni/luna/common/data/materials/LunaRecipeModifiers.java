package net.joni.luna.common.data.materials;

import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.modifier.ModifierFunction;
import com.gregtechceu.gtceu.api.recipe.modifier.RecipeModifier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

public class LunaRecipeModifiers {

    public static final RecipeModifier RIFT_CHECK = LunaRecipeModifiers::checkRiftInCore;

    public static @NotNull ModifierFunction checkRiftInCore(MetaMachine machine, @NotNull GTRecipe recipe) {
        var level = machine.getLevel();
        if (level == null) return ModifierFunction.NULL;

        var pos = machine.getPos();

        // Box für das Innere des 7x7x7 Generators
        AABB searchBox = new AABB(pos).inflate(3.5);

        // Suche nach Entities
        var rifts = level.getEntities((Entity) null, searchBox, entity -> {
            // Der modernste Weg über ForgeRegistries, um Deprecations zu umgehen:
            ResourceLocation entityKey = ForgeRegistries.ENTITY_TYPES.getKey(entity.getType());

            return entityKey != null && entityKey.toString().equals("strangematter:energetic_rift");
        });

        if (!rifts.isEmpty()) {
            return ModifierFunction.IDENTITY;
        }

        return ModifierFunction.NULL;
    }
}