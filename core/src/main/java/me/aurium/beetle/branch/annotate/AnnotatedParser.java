package me.aurium.beetle.branch.annotate;

import me.aurium.beetle.branch.CommandNode;

public interface AnnotatedParser<T> {

    CommandNode<T> parse(AnnotatedCommand command);
    CommandNode<T> parser(AnnotatedCommand command, ParserOptions options);

}
