package me.aurium.beetle.branch.fallback.permissions;

public class EmptyPermission<T> implements Permission<T> {

    @Override
    public boolean attempt(T sender, String alias, String[] args) {
        return true;
    }

    @Override
    public String easyName() {
        return "none"; //TODO perhaps throw? This shouldn't happen.
    }
}
