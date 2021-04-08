package me.aurium.beetle.branch.interfacing.common;

import me.aurium.beetle.branch.interfacing.model.Response;

/**
 * Represents a response to the scenario in which a certain object was attempted to be adapted to an extending type
 * but it was not an instance of it (or similar scenarios, such as attempting to flatmap a certain type to another.)
 */
public class FailedAdaptingResponse implements Response {

    private final Class<?> expectedClass;
    private final Class<?> receivedClass;

    public FailedAdaptingResponse(Class<?> expectedClass, Class<?> receivedClass) {
        this.expectedClass = expectedClass;
        this.receivedClass = receivedClass;
    }

    public Class<?> getExpectedClass() {
        return expectedClass;
    }

    public Class<?> getReceivedClass() {
        return receivedClass;
    }

}
