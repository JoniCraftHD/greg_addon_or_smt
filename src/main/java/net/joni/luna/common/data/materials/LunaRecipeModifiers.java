package net.joni.luna.common.data.materials;

import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.modifier.ModifierFunction;
import com.gregtechceu.gtceu.api.recipe.modifier.RecipeModifier;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

public class LunaRecipeModifiers {

    public static final RecipeModifier WITHER_CHECK = LunaRecipeModifiers::checkWitherInCore;

    public static @NotNull ModifierFunction checkWitherInCore(MetaMachine machine, GTRecipe recipe) {
        if (!(machine instanceof WorkableElectricMultiblockMachine workableMachine)) {
            return ModifierFunction.IDENTITY;
        }

        var level = machine.getLevel();
        var pos = machine.getPos();
        var facing = machine.getFrontFacing(); // Wichtig, um den "Hohlraum" relativ zum Controller zu finden

        if (level != null) {
            // Wir definieren eine Box für den Hohlraum.
            // Da dein Controller in der Mitte einer Wand sitzt (D),
            // schieben wir die Box 3 Blöcke nach hinten in die Mitte des Multiblocks.
            AABB coreBox = new AABB(pos).inflate(4);
            // inflate(4) macht die Box groß genug, damit das Skelett auch
            // etwas außerhalb oder genau im Glas stehen kann, ohne dass es buggt.

            var withers = level.getEntitiesOfClass(WitherSkeleton.class, coreBox);

            if (!withers.isEmpty()) {
                // Bonus: Das Skelett könnte durch die Resonanz Schaden nehmen
                withers.get(0).hurt(level.damageSources().magic(), 0.5f);
                return ModifierFunction.IDENTITY;
            }
        }

        // Kein Wither-Skelett gefunden -> Maschine arbeitet nicht
        return null;
    }
}