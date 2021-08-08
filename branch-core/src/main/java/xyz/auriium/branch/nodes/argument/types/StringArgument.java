package xyz.auriium.branch.nodes.argument.types;

import xyz.auriium.branch.base.execution.blocks.ArgumentBlock;
import xyz.auriium.branch.nodes.argument.model.SingleIgnorantArgument;
import xyz.auriium.branch.results.Result;

import java.util.Objects;
import java.util.Optional;

public class StringArgument implements SingleIgnorantArgument<String> {

    private final String label;
    private final String nullableOptional;

    private final ArgumentBlock block;

    StringArgument(String label, String nullableOptional) {
        this.label = label;
        this.nullableOptional = nullableOptional;

        this.block = new ArgumentBlock(label, "string", nullableOptional != null);
    }

    public static StringArgument of(String label) {
        return new StringArgument(label, null);
    }

    public static StringArgument ofOptional(String label, String optional) {
        Objects.requireNonNull(optional);

        return new StringArgument(label, optional);
    }

    @Override
    public ArgumentBlock getType() {
        return block;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public Optional<String> getOptional() {
        return Optional.ofNullable(nullableOptional);
    }

    @Override
    public Result<String> microParse(Object sender, String alias, String toParse) {
        return Result.success(toParse);
    }
}
