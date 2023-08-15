package eu.pb4.predicate.api;

import com.google.gson.JsonElement;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.MapCodec;
import eu.pb4.predicate.impl.BaseCodec;
import eu.pb4.predicate.impl.PredicatesInit;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public final class PredicateRegistry {
    private static final Map<ResourceLocation, MapCodec<MinecraftPredicate>> CODECS = new HashMap<>();
    private static final Map<MapCodec<MinecraftPredicate>, ResourceLocation> CODEC_IDS = new HashMap<>();
    public static final Codec<MinecraftPredicate> CODEC = new MapCodec.MapCodecCodec(new BaseCodec());

    private PredicateRegistry() {}

    public static MinecraftPredicate decode(JsonElement object) {
        return decode(JsonOps.INSTANCE, object);
    }

    public static <T> MinecraftPredicate decode(DynamicOps<T> ops, T object) {
        try {
            var data = CODEC.decode(ops, object);
            return data.getOrThrow(false, (s) -> {}).getFirst();
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Nullable
    public static MapCodec<MinecraftPredicate> getCodec(ResourceLocation identifier) {
        return CODECS.get(identifier);
    }

    @Nullable
    public static ResourceLocation getIdentifier(MapCodec<MinecraftPredicate> codec) {
        return CODEC_IDS.get(codec);
    }

    public static <T extends MinecraftPredicate> void register(ResourceLocation identifier, MapCodec<T> predicateCodec) {
        CODECS.put(identifier, (MapCodec<MinecraftPredicate>) predicateCodec);
        CODEC_IDS.put((MapCodec<MinecraftPredicate>) predicateCodec, identifier);
    }

    static {
        PredicatesInit.initialize();
    }
}
