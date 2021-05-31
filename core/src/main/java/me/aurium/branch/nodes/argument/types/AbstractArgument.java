package me.aurium.branch.nodes.argument.types;

public abstract class AbstractArgument<T> implements Argument<T> {

    protected final String label;

    public AbstractArgument(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return label;
    }

}
