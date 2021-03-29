package me.aurium.beetle.branch.launchpoints.base;

import java.util.List;

public interface NodeBase<T> {

    void execute(T t, String alias, String[] args);
    List<String> suggest(T t, String alias, String[] args);

}
