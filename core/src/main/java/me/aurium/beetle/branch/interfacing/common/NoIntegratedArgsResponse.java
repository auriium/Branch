package me.aurium.beetle.branch.interfacing.common;

import me.aurium.beetle.branch.handlers.context.NodeContext;
import me.aurium.beetle.branch.interfacing.model.Response;

import java.util.ArrayList;
import java.util.List;

//This can probably be improved

/**
 * Represents a response to the scenario in which not enough arguments were supplied to execute a splittable
 * node, so all alternative commands are suggested. This needs work, however, as it cannot list all alternative commands
 * and their arguments just yet. (logic for this must be some kind of greedy queue consumer with potentially dangerous loops)
 */
public class NoIntegratedArgsResponse implements Response {

    private final List<String> alternativeCommands;

    public NoIntegratedArgsResponse(List<String> alternativeCommands) {
        this.alternativeCommands = alternativeCommands;
    }

    public List<String> getAlternativeCommands() {
        return alternativeCommands;
    }

    /**
     * Use a basic nodeContext to produce a simple no integrated args response
     * @param context lah
     * @return lah
     */
    public static NoIntegratedArgsResponse of(NodeContext<?> context) {
        return new NoIntegratedArgsResponse(new ArrayList<>()); //TODO IMPLEMENT
    }
}
