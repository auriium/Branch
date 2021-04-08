package me.aurium.beetle.branch.launchpoints.typeadapter;

import me.aurium.beetle.branch.interfacing.common.FailedAdaptingResponse;

/**
 * Represents something that can convert an object of a certain type to another object
 * @param <INPUT> Input object type
 * @param <OUTPUT> Output object type
 */
public interface ManagerAdapter<INPUT,OUTPUT extends INPUT> {

    OUTPUT adapt(INPUT input);
    boolean canAdapt(INPUT input);

    FailedAdaptingResponse failedParseResponse(INPUT input);

}
