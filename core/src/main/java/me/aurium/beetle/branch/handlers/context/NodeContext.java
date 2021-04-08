package me.aurium.beetle.branch.handlers.context;

import me.aurium.beetle.branch.interfacing.model.Message;
import me.aurium.beetle.branch.interfacing.model.Response;
import me.aurium.beetle.branch.nodes.model.CommandNode;
import me.aurium.beetle.branch.nodes.results.SearchInfo;


public interface NodeContext<T> {

    T getSender();
    String getAlias();
    String[] getArgs();
    CommandNode<T> getBaseExecutedNode();
    SearchInfo<T> getResults();

    /**
     * Sends an ugly string to the player using the platform's message handler. Whatever floats your boat!
     * @param string string
     */
    void stringSender(String string);

    /**
     * Sends a fancy formatted message to a player using the bound platform's message-handler
     * @param message message
     */
    void messageSender(Message<T> message);

    /**
     * Sends a formatted response to a player coded to a key
     * @param failure the response
     */
    void response(Response failure);


}
