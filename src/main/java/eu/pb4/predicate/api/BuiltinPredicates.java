package eu.pb4.predicate.api;

import eu.pb4.predicate.impl.predicates.compat.CompatStatus;
import eu.pb4.predicate.impl.predicates.compat.PermissionPredicate;
import eu.pb4.predicate.impl.predicates.compat.PlaceholderPredicate;
import eu.pb4.predicate.impl.predicates.generic.*;
import eu.pb4.predicate.impl.predicates.player.EntityPredicatePredicate;
import eu.pb4.predicate.impl.predicates.player.OperatorPredicate;
import eu.pb4.predicate.impl.predicates.player.StatisticPredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.stats.StatType;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;

public final class BuiltinPredicates {
    private BuiltinPredicates() {}

    public static MinecraftPredicate all(MinecraftPredicate... predicates) {
        return new AllPredicate(List.of(predicates));
    }

    public static MinecraftPredicate all(Collection<MinecraftPredicate> predicates) {
        return new AllPredicate(List.copyOf(predicates));
    }

    public static MinecraftPredicate any(MinecraftPredicate... predicates) {
        return new AnyPredicate(List.of(predicates));
    }

    public static MinecraftPredicate any(Collection<MinecraftPredicate> predicates) {
        return new AnyPredicate(List.copyOf(predicates));
    }

    public static MinecraftPredicate negate(MinecraftPredicate predicate) {
        return new NegatePredicate(predicate);
    }

    public static MinecraftPredicate equal(Object object, Object object2) {
        return new EqualityPredicate(object, object2);
    }

    public static MinecraftPredicate lessThan(Object object, Object object2) {
        return new NumberPredicate.LessThan(object, object2);
    }

    public static MinecraftPredicate lessOrEqual(Object object, Object object2) {
        return new NumberPredicate.LessEqual(object, object2);
    }

    public static MinecraftPredicate moreThan(Object object, Object object2) {
        return new NumberPredicate.MoreThan(object, object2);
    }

    public static MinecraftPredicate moreOrEqual(Object object, Object object2) {
        return new NumberPredicate.MoreEqual(object, object2);
    }

    public static MinecraftPredicate operatorLevel(int level) {
        return new OperatorPredicate(level);
    }

    public static <T> MinecraftPredicate statistic(StatType<T> type, T key) {
        return new StatisticPredicate(type, type.getRegistry().getKey(key));
    }

    public static <T> MinecraftPredicate vanillaEntityPredicate(EntityPredicate predicate) {
        return new EntityPredicatePredicate(predicate);
    }

    @Nullable
    public static MinecraftPredicate modPlaceholderApi(String placeholder, boolean raw) {
        return CompatStatus.isPlaceholderApiLoaded() ? new PlaceholderPredicate(placeholder, raw) : null;
    }

    @Nullable
    public static MinecraftPredicate modPlaceholderApi(String placeholder) {
        return CompatStatus.isPlaceholderApiLoaded() ? new PlaceholderPredicate(placeholder, false) : null;
    }

    @Nullable
    public static MinecraftPredicate modPermissionApi(String permission, int alternativeOperatorLevel) {
        return CompatStatus.isLuckoPermissionApiLoaded() ? new PermissionPredicate(permission, alternativeOperatorLevel) : null;
    }

    @Nullable
    public static MinecraftPredicate modPermissionApi(String permission) {
        return CompatStatus.isLuckoPermissionApiLoaded() ? new PermissionPredicate(permission, -1) : null;
    }
}
