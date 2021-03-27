package me.aurium.beetle.branch.permission;

import java.util.function.Predicate;

public class PredicatePermission<T> implements Permission<T> {

    private final Predicate<T> predicate;

    public PredicatePermission(Predicate<T> predicate) {
        this.predicate = predicate;
    }

    @Override
    public boolean attempt(T sender, String alias, String[] args) {
        return predicate.test(sender);
    }
}
