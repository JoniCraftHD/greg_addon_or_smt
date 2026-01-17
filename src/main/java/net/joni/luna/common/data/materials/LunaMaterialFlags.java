package net.joni.luna.common.data.materials;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlag;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconType;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.item.tool.GTToolType;
import com.gregtechceu.gtceu.common.data.GTMaterialItems;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.GENERATE_DENSE;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.Conditions.hasNoCraftingToolProperty;

public class LunaMaterialFlags {

    public static final MaterialFlag GENERATE_NANITES = new MaterialFlag.Builder("generate_nanites")
            .requireFlags(GENERATE_DENSE)
            .requireProps(PropertyKey.DUST)
            .build();

    public static final MaterialFlag GENERATE_CRYSTAL_ROSE = new MaterialFlag.Builder("generate_crystal_rose")
            .requireProps(PropertyKey.DUST)
            .build();
    public static final MaterialFlag GENERATE_FILE_HEAD = new MaterialFlag.Builder("generate_file_head")
            .requireProps(PropertyKey.INGOT)
            .build();

    public static final TagPrefix nanites = new TagPrefix("nanites")
            .idPattern("%s_nanites")
            .defaultTagPath("nanites/%s")
            .unformattedTagPath("nanites")
            .langValue("%s Nanites")
            .materialAmount(GTValues.M / 4)
            .unificationEnabled(true)
            .generateItem(true)
            .materialIconType(LunaMaterialSet.nanites)
            .generationCondition(mat -> mat.hasFlag(LunaMaterialFlags.GENERATE_NANITES));

    public static final TagPrefix crystal_rose = new TagPrefix("crystal_rose")
            .idPattern("%s_crystal_rose")
            .defaultTagPath("crystal_roses/%s")
            .unformattedTagPath("crystal_rose")
            .langValue("%s Crystal Rose")
            .materialAmount(GTValues.M / 4)
            .unificationEnabled(true)
            .generateItem(true)
            .materialIconType(LunaMaterialSet.crystal_rose)
            .generationCondition(mat -> mat.hasFlag(LunaMaterialFlags.GENERATE_CRYSTAL_ROSE));
    public static final TagPrefix File_Head = new TagPrefix("filehead")
            .itemTable(() -> GTMaterialItems.MATERIAL_ITEMS)
            .langValue("%s File Head")
            .materialAmount(GTValues.M * 4)
            .maxStackSize(16)
            .materialIconType(LunaMaterialSet.file_head)
            .unificationEnabled(true)
            .enableRecycling()
            .generateItem(true)
            .generationCondition(hasNoCraftingToolProperty.and(mat -> mat.hasFlag(MaterialFlags.GENERATE_PLATE))
                    .and(mat -> mat.getProperty(PropertyKey.TOOL).hasType(GTToolType.FILE)));

    public static void init() {}
}
