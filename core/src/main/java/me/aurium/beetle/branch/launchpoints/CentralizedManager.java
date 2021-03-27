package me.aurium.beetle.branch.launchpoints;

import me.aurium.beetle.branch.launchpoints.base.NodeBase;

/**
 * Represents the utmost base part of a command
 * @param <T> the input type, does not need to be of same type as the node bases it utilizes
 */
public interface CentralizedManager<T> {

    CentralizedManagerBinder getBinder(); //think of Beetle's accessors for files, except this time it's for commands? idk




}
