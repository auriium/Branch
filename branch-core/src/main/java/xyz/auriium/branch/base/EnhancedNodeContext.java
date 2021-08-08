package xyz.auriium.branch.base;

import xyz.auriium.branch.results.PostProcessSearch;

public interface EnhancedNodeContext<T> extends NodeContext<T> {

    PostProcessSearch<T> getProcessedSearch();

}
