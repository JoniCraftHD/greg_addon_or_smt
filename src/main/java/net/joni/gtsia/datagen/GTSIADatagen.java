package net.joni.gtsia.datagen;

import com.tterrag.registrate.providers.ProviderType;
import net.joni.gtsia.datagen.lang.GTSIALangHandler;

import static com.gregtechceu.gtceu.common.registry.GTRegistration.REGISTRATE;

public class GTSIADatagen {
    public static void init() {
        REGISTRATE.addDataGenerator(ProviderType.LANG, GTSIALangHandler::init);
    }
}
