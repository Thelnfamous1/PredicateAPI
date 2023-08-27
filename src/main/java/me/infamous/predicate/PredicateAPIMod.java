package me.infamous.predicate;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

@Mod(PredicateAPIMod.MODID)
public class PredicateAPIMod {
    public static final String MODID = "predicate_api";
    public static final Logger LOGGER = LogUtils.getLogger();

    public PredicateAPIMod() {}
}
