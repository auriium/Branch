package me.aurium.beetle.branch.handlers.context;

import me.aurium.beetle.branch.fallback.message.BaseContext;
import me.aurium.beetle.branch.nodes.model.CommandNode;
import me.aurium.beetle.branch.nodes.results.SearchInfo;


public interface NodeContext<T> extends Context<T> {

    CommandNode<T> getBaseExecutedNode();

    SearchInfo<T> getResults();
    BaseContext<T> getBaseContext();

    //TODO add more cool features like the debug message sender,
    // because NodeContext should be a collection of both context and context-specific actions? /review a248

}
