package net.joni.gtsia.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;

import net.joni.gtsia.GTSIA;

public class GTSIAMaterials {

    public static Material QuantumCoolant;
    public static Material EightyFivePercentPureNevvonianSteel;
    public static Material PHOENIX_ENRICHED_TRITANIUM;
    public static Material PHOENIX_ENRICHED_NAQUADAH;
    public static Material ALUMINFROST;
    public static Material SOURCE_OF_MAGIC; // Showtime, Fire!
    public static Material SOURCE_IMBUED_TITANIUM;
    public static Material EightyFivePercentPureNevonianSteel;
    public static Material FROST;
    public static Material BORON_CARBIDE;
    public static Material NIOBIUM_MODIFIED_SILICON_CARBIDE;
    public static Material SUGAR_WATER;
    public static Material WAX_MELTING_CATALYST;
    public static Material CRYO_GRAPHITE_BINDING_SOLUTION;
    public static Material TEST_ALLOY;
    public static Material AERIC_ALLOY;

    public static void register() {
        SUGAR_WATER = new Material.Builder(
                GTSIA.id("sugar_water"))
                .fluid()
                .color(0xFFFFF0)
                .iconSet(MaterialIconSet.DULL) // Icon set from KubeJS
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        ALUMINFROST = new Material.Builder(
                GTSIA.id("aluminfrost"))
                .color(0xadd8e6).secondaryColor(0xc0c0c0).iconSet(MaterialIconSet.DULL)
                .flags(MaterialFlags.GENERATE_PLATE)
                .buildAndRegister();
        SOURCE_IMBUED_TITANIUM = new Material.Builder(
                GTSIA.id("source_imbued_titanium"))
                .ingot()
                .fluid()
                .formula("✨C✨Ti")
                .langValue("§5Source Imbued Titanium")
                .fluidPipeProperties(2800, 200, true, true, false, false)
                .color(0xc600ff).iconSet(MaterialIconSet.METALLIC)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_RING, MaterialFlags.GENERATE_GEAR,
                        MaterialFlags.PHOSPHORESCENT, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_LONG_ROD,
                        MaterialFlags.GENERATE_BOLT_SCREW, MaterialFlags.GENERATE_FRAME, MaterialFlags.GENERATE_DENSE,
                        MaterialFlags.GENERATE_ROTOR)
                .buildAndRegister();
        AERIC_ALLOY = new Material.Builder(
                GTSIA.id("aeric_alloy"))
                .flags(MaterialFlags.GENERATE_PLATE)
                .fluid()
                .ingot()
                .color(0xa95629)
                .iconSet(MaterialIconSet.SHINY)
                .element(GTSIAElements.AE).formula("Ae")
                .buildAndRegister();
    }

    public static void modifyMaterials() {}
}
