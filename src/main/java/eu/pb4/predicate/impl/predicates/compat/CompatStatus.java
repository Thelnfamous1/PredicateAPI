package eu.pb4.predicate.impl.predicates.compat;

import net.minecraftforge.fml.ModList;

public interface CompatStatus {
    boolean PLACEHOLDER_API = ModList.get().isLoaded("placeholder-api");

    boolean LUCKO_PERMISSION_API = ModList.get().isLoaded("fabric-permissions-api-v0");
}
