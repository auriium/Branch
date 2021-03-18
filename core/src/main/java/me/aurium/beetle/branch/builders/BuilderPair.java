package me.aurium.beetle.branch.builders;

public interface BuilderPair<T extends Builder<?>> {

    <C> T newBuilder();

}
