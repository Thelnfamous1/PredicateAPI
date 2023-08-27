package eu.pb4.predicate.impl.predicates.compat;

import net.minecraftforge.fml.ModList;

public class CompatStatus {

    public static boolean isPlaceholderApiLoaded() {
        return ModList.get().isLoaded("placeholder_api");
    }

    public static boolean isLuckoPermissionApiLoaded() {
        return ModList.get().isLoaded("permissions-api");
    }
}
