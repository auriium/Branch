package me.aurium.beetle.branch.converted.launchpoints;

import me.aurium.beetle.branch.context.ContextProducer;
import me.aurium.beetle.branch.nodes.base.NodeBase;

public abstract class AbstractBaseCommand<T> extends AbstractBranchCommand<T> {

    protected AbstractBaseCommand(ContextProducer<T> factory) {
        super(factory);
    }

    public abstract NodeBase<T,?> getBase();
}
