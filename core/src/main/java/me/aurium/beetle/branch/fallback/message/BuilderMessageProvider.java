package me.aurium.beetle.branch.fallback.message;

import me.aurium.beetle.branch.handlers.context.NodeContext;

/**
 * Might not be the most scalable thing in the world but who the fuck cares
 *
 * I can't think of any nodes besides single (do an action) branching (do an action or separate out based on top buffer arg)
 * and value (do an action or separate action based on buffer from this argument)
 *
 * so who cares? This will give me fallback messages
 * @param <T>
 */
public interface BuilderMessageProvider<T> {

    void handleDefaultSingle(NodeContext<T> context);
    void handleDefaultBranching(NodeContext<T> context);
    void handleDefaultValue(NodeContext<T> context);

}
