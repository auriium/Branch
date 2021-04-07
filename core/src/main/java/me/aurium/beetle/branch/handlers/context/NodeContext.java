package me.aurium.beetle.branch.handlers.context;

import me.aurium.beetle.branch.interfacing.responses.ExecutionResponse;
import me.aurium.beetle.branch.fallback.message.BaseContext;
import me.aurium.beetle.branch.interfacing.message.Message;
import me.aurium.beetle.branch.nodes.model.CommandNode;
import me.aurium.beetle.branch.nodes.results.SearchInfo;


public interface NodeContext<T> {

    T getSender();
    String getAlias();
    String[] getArgs();
    CommandNode<T> getBaseExecutedNode();
    SearchInfo<T> getResults();
    BaseContext<T> getBaseContext();

    /**
     * Sends an ugly string to the player using the platform's message handler. Whatever floats your boat!
     * @param string string
     */
    void stringSender(String string);

    /**
     * Sends a fancy formatted message to a player using the bound platform's message-handler
     * @param message message
     */
    void messageSender(Message<? extends T> message);

    /**
     * Sends a fancy formatted failure to a player that is bound to a Message using the platform's message-handler
     * @param failure the failure
     */
    void failureSender(ExecutionResponse failure);


}
