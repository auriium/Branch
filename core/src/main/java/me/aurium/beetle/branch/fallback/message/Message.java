package me.aurium.beetle.branch.fallback.message;

public interface Message<C> {

    void accept(C c, Object... strings);

}
