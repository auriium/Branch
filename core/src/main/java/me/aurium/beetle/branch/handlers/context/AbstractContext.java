package me.aurium.beetle.branch.handlers.context;

public abstract class AbstractContext<T> implements Context<T> {

    private final T t;
    private final String alias;
    private final String[] args;

    protected AbstractContext(T t, String alias, String[] args) {
        this.t = t;
        this.alias = alias;
        this.args = args;
    }

    @Override
    public T getSender() {
        return t;
    }

    @Override
    public String getAlias() {
        return alias;
    }

    @Override
    public String[] getArgs() {
        return args;
    }

}
