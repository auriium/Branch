package xyz.auriium.branch.nodes.argument;

/**
 * Base argument that ignores context
 * @param <O> the type of object returned by parsing
 */
public interface IgnorantBaseArgument<O> extends ContextualBaseArgument<Object,O> {
}
