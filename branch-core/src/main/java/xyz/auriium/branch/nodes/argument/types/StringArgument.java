package xyz.auriium.branch.nodes.argument.types;

import xyz.auriium.branch.execution.blocks.ArgumentBlock;
import xyz.auriium.branch.nodes.argument.model.SingleIgnorantArgument;
import xyz.auriium.branch.nodes.results.model.Result;

public class StringArgument implements SingleIgnorantArgument<String> {

    private final String label;
    private final String option;

    StringArgument(String label, String option) {
        this.label = label;
        this.option = option;
    }

    /**
     * Requires a new required string argument
     * @param label label
     * @return value to return
     */
    public static StringArgument ofRequired(String label) {
        return new StringArgument(label, null);
    }

    /**
     * Returns a new optional string argument
     * @param label the label
     * @param defaultVar the default value that is inserted if nothing is present
     *                   use null if you don't have any idea what to default
     * @return argument
     */
    public static StringArgument ofOptional(String label, String defaultVar) {
        return new StringArgument(label, defaultVar);
    }

    @Override
    public Class<String> outputClass() {
        return String.class;
    }

    @Override
    public ArgumentBlock getType() {
        return new ArgumentBlock(label,"string",option == null);
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public Result<String> microParse(Object sender, String alias, String toParse) {
        return null; //TODO
    }
}
