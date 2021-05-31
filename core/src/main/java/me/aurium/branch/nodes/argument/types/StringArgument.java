package me.aurium.branch.nodes.argument.types;

import me.aurium.branch.execution.Block;
import me.aurium.branch.execution.NodeContext;
import me.aurium.branch.nodes.results.model.Result;

import java.util.List;
import java.util.Optional;

public class StringArgument extends AbstractArgument<String> {

    public StringArgument(String label) {
        super(label);
    }

    @Override
    public List<String> getBounds(NodeContext<String> context) {
        return null;
    }

    @Override
    public Result<String> parse(NodeContext<String> context) {
        return null;
    }

    @Override
    public Optional<String> getDefault() {
        return Optional.empty();
    }
}
