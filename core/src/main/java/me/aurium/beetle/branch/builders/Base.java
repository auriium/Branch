package me.aurium.beetle.branch.builders;

import me.aurium.beetle.branch.nodes.CommandNode;

import java.util.function.Consumer;

public class Base {

    public static <E, C extends Builder<E>> CommandNode<E> base(C key, Consumer<C> consumer) {
        consumer.accept(key);

        return key.buildWithoutIdentifier();
    }

    //TODO a separate base logic to consume a ClassParser and turn it into a command :)
    public static <T> CommandNode<T> base() {
        return null;
    }

}
