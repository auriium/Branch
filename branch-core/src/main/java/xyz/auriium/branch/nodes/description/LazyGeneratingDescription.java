package xyz.auriium.branch.nodes.description;

import java.util.function.Supplier;

/**
 * Represents generator that generates it's description once whenever it is requested to.
 * Functions like a lazy developer's singleton. Use this if you don't want heavy logic being called often.
 *
 * A potential use case of this: idk argnode
 */
public class LazyGeneratingDescription implements Description{

    private final Supplier<String> generator;
    private volatile String generated;

    public LazyGeneratingDescription(Supplier<String> generator) {
        this.generator = generator;
    }

    @Override
    public String getTextDescription() {
        if (generated == null) {
            generated = generator.get();
        }

        return generated;
    }
}
