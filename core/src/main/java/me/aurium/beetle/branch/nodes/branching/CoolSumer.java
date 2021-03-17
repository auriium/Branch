package me.aurium.beetle.branch.nodes.branching;

import me.aurium.beetle.branch.Builder;

public interface CoolSumer<T> {

    <C extends Builder<T>> void cool(C builder);

}
