package xyz.auriium.branch.base;

import xyz.auriium.branch.results.PostProcessSearch;

public class DelegatingEnhancedContext<T> implements EnhancedNodeContext<T> {

    private final NodeContext<T> delegate;
    private final PostProcessSearch<T> search;

    public DelegatingEnhancedContext(NodeContext<T> delegate, PostProcessSearch<T> search) {
        this.delegate = delegate;
        this.search = search;
    }

    @Override
    public T getSender() {
        return delegate.getSender();
    }

    @Override
    public String getAlias() {
        return delegate.getAlias();
    }

    @Override
    public String[] getArgs() {
        return delegate.getArgs();
    }

    @Override
    public boolean hasStringPermissible(String string) {
        return delegate.hasStringPermissible(string);
    }

    @Override
    public PostProcessSearch<T> getProcessedSearch() {
        return search;
    }
}
