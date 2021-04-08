package me.aurium.beetle.branch.interfacing.model;

public interface Message<C> {

    void accept(C sender);

}
