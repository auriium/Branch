package xyz.auriium.branch.execution;

import xyz.auriium.branch.nodes.results.PostProcessSearch;

public interface EnhancedNodeContext<T> extends NodeContext<T> {

    PostProcessSearch<T> getProcessedSearch();

}
