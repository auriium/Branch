package me.aurium.beetle.branch.launchpoints;

import me.aurium.beetle.branch.launchpoints.base.NodeBaseBuilder;
import me.aurium.beetle.branch.launchpoints.typeadapter.ManagerAdapter;

/**
 * Represents the utmost base part of a command
 * @param <T> the input type, does not need to be of same type as the node bases it utilizes
 * @param <V> the platform, void if there is none (how?)
 */
public interface CentralizedManager<T,V> {

    CentralizedManagerBinder getBinder(V platform);

    NodeBaseBuilder<T> newCommand();
    <C extends T> NodeBaseBuilder<C> newCommand(ManagerAdapter<T,C> adapter);


}
