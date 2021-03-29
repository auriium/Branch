package me.aurium.beetle.branch.launchpoints.typeadapter;

import java.util.function.Consumer;

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
    default Consumer<T> failedAdaptAction() {
        return (i) -> {}; //noops
    }
}
