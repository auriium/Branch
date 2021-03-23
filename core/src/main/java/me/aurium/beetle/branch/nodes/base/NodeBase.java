package me.aurium.beetle.branch.nodes.base;

import me.aurium.beetle.branch.permission.PermAccessor;

import java.util.List;

public interface NodeBase<T,C extends PermAccessor<T>> {

    C getAccessor();

    void execute(T t, String alias, String[] args);

    List<String> suggest(T t, String alias, String[] args);

    //void setAccessor(C c);

}
