package eu.pb4.predicate.api;

import com.mojang.serialization.MapCodec;
import net.minecraft.resources.ResourceLocation;

public abstract class AbstractPredicate implements MinecraftPredicate {

    private final ResourceLocation identifier;
    private final MapCodec<MinecraftPredicate> codec;

    public <T extends MinecraftPredicate> AbstractPredicate(ResourceLocation identifier, MapCodec<T> codec) {
        this.identifier = identifier;
        this.codec = (MapCodec<MinecraftPredicate>) codec;
    }

    @Override
    public ResourceLocation identifier() {
        return this.identifier;
    }

    @Override
    public MapCodec<MinecraftPredicate> codec() {
        return this.codec;
    }
}
