package me.aurium.beetle.branch.annotate;

import me.aurium.beetle.api.command.Command;

public interface AnnotatedParser<T> {

    Command<T> parse(AnnotatedCommand command);
    Command<T> parser(AnnotatedCommand command, ParserOptions options);

}
