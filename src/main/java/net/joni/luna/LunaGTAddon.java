package net.joni.luna;

import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.data.chemical.material.event.PostMaterialEvent;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;

import net.joni.luna.common.data.materials.LunaElements;
import net.joni.luna.common.data.materials.LunaItems;
import net.joni.luna.common.data.materials.LunaMaterials;
import net.joni.luna.common.registry.LunaRegistration;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


import java.util.function.Consumer;

@SuppressWarnings("unused")
@GTAddon
public class LunaGTAddon implements IGTAddon {

    @Override
    public GTRegistrate getRegistrate() {
        return LunaRegistration.REGISTRATE;
    }

    @Override
    public void initializeAddon() {}

    @Override
    public String addonModId() {
        return LunaCore.MOD_ID;
    }

    @Override
    public void registerTagPrefixes() {
        // CustomTagPrefixes.init();
    }

    @Override
    public void addRecipes(Consumer<FinishedRecipe> provider) {
        // CustomRecipes.init(provider);
    }

    @Override
    public void registerElements() {
        LunaElements.init();
    }
    private void modifyMaterials(PostMaterialEvent event) {
        LunaMaterials.modifyMaterials();
    }

    @Mod("luna")
    public class ModId {

        public static final String MOD_ID = "luna";

        public ModId() {
            IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

            // Initialize your items
            LunaItems.init();

            modEventBus.addListener(this::commonSetup);
        }

        private void commonSetup(FMLCommonSetupEvent event) {
            // Additional configuration if necessary
        }
    }


    // KubeJS WILL REMOVE YOUR RECIPES IF THESE ARE NOT REGISTERED.
            /*
             * public static final ContentJS<Double> PRESSURE_IN = new ContentJS<>(NumberComponent.ANY_DOUBLE,
             * CustomRecipeCapabilities.PRESSURE, false);
             * public static final ContentJS<Double> PRESSURE_OUT = new ContentJS<>(NumberComponent.ANY_DOUBLE,
             * CustomRecipeCapabilities.PRESSURE, true);
             *
             * @Override
             * public void registerRecipeKeys(KJSRecipeKeyEvent event) {
             * event.registerKey(CustomRecipeCapabilities.PRESSURE, Pair.of(PRESSURE_IN, PRESSURE_OUT));
             * }
             */
        }
