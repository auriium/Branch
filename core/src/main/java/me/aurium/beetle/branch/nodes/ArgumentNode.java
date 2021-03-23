package me.aurium.beetle.branch.nodes;

import me.aurium.beetle.branch.block.Block;
import me.aurium.beetle.branch.block.BlockPath;
import me.aurium.beetle.branch.handlers.api.ExecutionHandler;
import me.aurium.beetle.branch.handlers.api.SuggestionHandler;
import me.aurium.beetle.branch.nodes.api.IdentifiableNode;
import me.aurium.beetle.branch.argument.Argument;
import me.aurium.beetle.branch.nodes.result.GetNodeResult;
import me.aurium.beetle.branch.nodes.result.NullableNodeResult;
import me.aurium.beetle.branch.permission.Permission;

import java.util.List;

//kinda like a branching node except it throws forward and not to the sides
public class ArgumentNode<T> implements IdentifiableNode<T> {

    private final Block identifier;
    private final List<Argument<?>> sequentialValueNodes; //the nodes in order from here on out
    private final SingleNode<T> noArgs;

    private final Permission<T> permission;

    public ArgumentNode(Block identifier, List<Argument<?>> sequentialValueNodes, SingleNode<T> noArgs, Permission<T> permission) {
        this.identifier = identifier;
        this.sequentialValueNodes = sequentialValueNodes;
        this.noArgs = noArgs;
        this.permission = permission;
    }


    // - These two methods can remain unimplemented because this node will never be used for contexthandlers and suggestionhandlers -
    // - The actual contextHandler and Suggestionhandler are provided by the getSpecificNode method returning an anonymous basenode -
    // - This is because the contexthandler and suggestion handler here always depend on the blockpath, and in order to respect -
    // - the node map object model, we must do this.


    @Override
    public GetNodeResult<T> getSpecificNode(BlockPath path) {
        return new NullableNodeResult<>(this,path);
    }

    /*if (path.isEmpty()) return Optional.of(noArgs);

        return Optional.of(this);*/

        /* This was pointless, see below note

        //we can either do this shit, or we can return **THIS** no matter what and let the context handler be variable, since the context handler delegates
        //to another adapter anyways

        int position = path.length() - 1; //wow real throwback to LEAF framework huh
        int size = sequentialValueNodes.size();

        //check the length
        if (position == size) return Optional.of(sequentialValueNodes.get(size - 1));

        return Optional.of(sequentialValueNodes.get(position));
        */

    @Override
    public ExecutionHandler<T> getExecutionHandler() {
        return (context) -> {
            BlockPath path = context.executedPath();

            //sort
        };
    }

    @Override
    public SuggestionHandler<T> getSuggestionHandler() {
        return (context) -> {
            return null;
        };
    }

    @Override
    public Permission<T> getPermission() {
        return permission;
    }

    @Override
    public Block getIdentifier() {
        return identifier;
    }
}
