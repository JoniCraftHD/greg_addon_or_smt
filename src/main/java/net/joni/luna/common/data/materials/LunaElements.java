package net.joni.luna.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.api.registry.GTRegistries;

public class LunaElements {

    public static final Element AE = createAndRegister(22, 60, -1, null, "aeric_alloy", "AE", false);

    public static final Element APNS = createAndRegister(35, 450, -1, null, "Almost Pure Nevvonian Steel", "", false);

    public static Element createAndRegister(long protons, long neutrons, long halfLifeSeconds, String decayTo,
                                            String name, String symbol, boolean isIsotope) {
        Element element = new Element(protons, neutrons, halfLifeSeconds, decayTo, name, symbol, isIsotope);
        GTRegistries.ELEMENTS.register(name, element);
        return element;
    }

    public static void init() {}
}
