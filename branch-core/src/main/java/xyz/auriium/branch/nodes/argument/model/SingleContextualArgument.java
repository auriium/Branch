package xyz.auriium.branch.nodes.argument.model;

import xyz.auriium.branch.results.Result;

import java.util.List;

public interface SingleContextualArgument<T,O> extends ContextualBaseArgument<T,O> {

    @Override
    default int reservedBlockAmount() {
        return 1;
    }

    @Override
    default Result<O> parse(T sender, String alias, List<String> reserved) {
        return microParse(sender,alias,reserved.get(0));
    }

    Result<O> microParse(T sender, String alias, String toParse);
}
