package me.aurium.beetle.branch.fallback.permissions;

import java.util.function.Predicate;

public class PredicatePermission<T> implements Permission<T> {

    private final String easyName;
    private final Predicate<T> predicate;

    public PredicatePermission(String easyName, Predicate<T> predicate) {
        this.easyName = easyName;
        this.predicate = predicate;
    }

    @Override
    public boolean attempt(T sender, String alias, String[] args) {
        return predicate.test(sender);
    }

    @Override
    public String easyName() {
        return easyName;
    }
}
