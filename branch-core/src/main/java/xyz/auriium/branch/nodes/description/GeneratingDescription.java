package xyz.auriium.branch.nodes.description;

import java.util.function.Supplier;

/**
 * Represents a description that can calculate a response whenever called
 *
 * Potential usecase: command that updates it's description whenever a global command is on cooldown? idk
 */
public class GeneratingDescription implements Description{

    private final Supplier<String> generator;

    public GeneratingDescription(Supplier<String> generator) {
        this.generator = generator;
    }

    @Override
    public String getTextDescription() {
        return generator.get();
    }
}
