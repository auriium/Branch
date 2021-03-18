package me.aurium.beetle.branch.builder;

public interface BuilderPair<T extends Builder<?>> {

    <C> T newBuilder();

}
