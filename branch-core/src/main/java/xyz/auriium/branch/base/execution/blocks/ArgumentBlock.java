package xyz.auriium.branch.base.execution.blocks;

public class ArgumentBlock implements Block {

    private final String label;
    private final String argumentType;
    private final boolean isOptional;

    public ArgumentBlock(String label, String argumentType, boolean isOptional) {
        this.label = label;
        this.argumentType = argumentType;
        this.isOptional = isOptional;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String getType() {
        return argumentType;
    }

    @Override
    public BracketPattern getBracketPattern() {
        return isOptional ? new BracketPattern('<','>') : new BracketPattern('[',']');
    }

    @Override
    public BlockType getTypeObject() {
        return isOptional ? BlockType.ARGUMENT_OPTIONAL : BlockType.ARGUMENT_REQUIRED;
    }
}
