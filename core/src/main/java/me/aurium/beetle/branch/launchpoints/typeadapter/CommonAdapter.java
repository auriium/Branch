package me.aurium.beetle.branch.launchpoints.typeadapter;

import me.aurium.beetle.branch.interfacing.common.FailedAdaptingResponse;
import me.aurium.beetle.branch.interfacing.model.Response;

/**
 * Represents an adapter that does not convert and simply returns the same object
 * @param <T> the object type
 */
public interface CommonAdapter<T> extends ManagerAdapter<T,T> {

    @Override
    default T adapt(T input) {
        return input;
    }

    @Override
    default boolean canAdapt(T input) {
        return true;
    }

    @Override
    default FailedAdaptingResponse failedParseResponse(T input) {
        throw new IllegalStateException("How did you get here (Since canAdapt is always true this should never occur?)");
    }
}
