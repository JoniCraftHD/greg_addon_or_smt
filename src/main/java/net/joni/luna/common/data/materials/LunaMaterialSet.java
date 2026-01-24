package net.joni.luna.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconType;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.DULL;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.SHINY;

public class LunaMaterialSet {

    public static final MaterialIconType nanites = new MaterialIconType("nanites");
    public static final MaterialIconType crystal_rose = new MaterialIconType("crystal_rose");
    public static final MaterialIconSet ALMOST_PURE_NEVONIAN_STEEL = new MaterialIconSet("almost_pure_nevonian_steel",
            SHINY);
    public static final MaterialIconSet TEST = new MaterialIconSet("test", DULL);
    public static final MaterialIconType file_head = new MaterialIconType("file_head");

    public static void init() {}
}
