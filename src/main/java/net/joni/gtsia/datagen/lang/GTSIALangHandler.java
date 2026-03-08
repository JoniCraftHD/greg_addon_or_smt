package net.joni.gtsia.datagen.lang;

import com.tterrag.registrate.providers.RegistrateLangProvider;

public class GTSIALangHandler {
    public static void init(RegistrateLangProvider provider) {
        provider.add("tooltip.gtsia.file_head.type", "§1This is the File Head for the %s File");

    }
    protected static void multiLang(RegistrateLangProvider provider, String key, String... values) {
        for (var i = 0; i < values.length; i++) {
            provider.add(getSubKey(key, i), values[i]);
        }
    }

    protected static String getSubKey(String key, int index) {
        return key + "." + index;
    }
}
