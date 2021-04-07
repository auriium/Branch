package me.aurium.beetle.branch.launchpoints.typeadapter;

import me.aurium.beetle.branch.interfacing.responses.ExecutionResponse;

public interface CommonAdapter<T> extends ManagerAdapter<T,T> {

    @Override
    default T adapt(T in) {
        return in;
    }

    @Override
    default boolean canAdapt(T t) {
        return true;
    }

    @Override
    default ExecutionResponse failedAdaptAction() {
        throw new IllegalStateException("How did you get here (Since canAdapt is always true this should never occur?)");
    }
}
