package me.aurium.beetle.branch.annotate;

import me.aurium.beetle.branch.nodes.api.CommandNode;

public interface AnnotatedParser<T> {

    CommandNode<T> parse(Class<AnnotatedCommand> command);
    CommandNode<T> parser(Class<AnnotatedCommand> command, ParserOptions options);

}
