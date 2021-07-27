package xyz.auriium.branch.nodes.argument.types;

import xyz.auriium.branch.execution.Block;
import xyz.auriium.branch.nodes.argument.SingleIgnorantArgument;
import xyz.auriium.branch.nodes.results.model.Result;

public class StringArgument implements SingleIgnorantArgument<String> {

    private final String label;

    StringArgument(String label) {
        this.label = label;
    }

    public static StringArgument of(String label) {
        return new StringArgument(label);
    }


    @Override
    public Class<String> outputClass() {
        return String.class;
    }

    @Override
    public String getType() {
        return "StringArgument";
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public Result<String> microParse(Object sender, String alias, Block toParse) {
        return null;
    }
}
