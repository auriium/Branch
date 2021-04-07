package me.aurium.beetle.branch.launchpoints.typeadapter;

import me.aurium.beetle.branch.interfacing.responses.ExecutionResponse;

public interface ManagerAdapter<INPUT,OUTPUT extends INPUT> {

    OUTPUT adapt(INPUT input);
    boolean canAdapt(INPUT input);

    ExecutionResponse failedAdaptAction(INPUT input);

}
