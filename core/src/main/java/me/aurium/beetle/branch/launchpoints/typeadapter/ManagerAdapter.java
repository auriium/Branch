package me.aurium.beetle.branch.launchpoints.typeadapter;

import me.aurium.beetle.branch.handlers.context.ContextProducer;

import java.util.function.Consumer;

public interface ManagerAdapter<INPUT,OUTPUT extends INPUT> {

    OUTPUT adapt(INPUT input);

    boolean canAdapt(INPUT input);

    Consumer<INPUT> failedAdaptAction();

}
