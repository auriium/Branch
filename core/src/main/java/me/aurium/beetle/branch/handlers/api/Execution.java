package me.aurium.beetle.branch.handlers.api;

import me.aurium.beetle.branch.handlers.context.NodeContext;

public class Execution {
    private final Runnable runnable;

    public Execution(Runnable runnable) {
        this.runnable = runnable;
    }
}
