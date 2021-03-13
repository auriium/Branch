package me.aurium.beetle.branch.nodes;

import me.aurium.beetle.api.command.ContextHandler;
import me.aurium.beetle.api.command.ContextSource;
import me.aurium.beetle.api.nodes.path.Block;
import me.aurium.beetle.api.nodes.path.BlockPath;
import me.aurium.beetle.branch.CommandNode;

import java.util.Collection;
import java.util.Optional;

/**
 * Node representing literally the command itself
 *
 * If you were to lay it out, it would be like
 * /kitpvp join
 *
 * @param <T>
 */
public class BaseNode<T> implements CommandNode<T> {

    private final ContextSource<T> source;
    private final Block commandIdentifier;

    public BaseNode(ContextSource<T> source, CommandNode<T> delegate, Block commandIdentifier)  {
        this.source = source;
        this.commandIdentifier = commandIdentifier;
    }

    @Override
    public ContextHandler<T> getContextHandler() {
        return null;
    }

    @Override
    public BlockPath getAbsolutePath() {
        // FIXME: 3/12/21 This entire class will not work because the
        // FIXME: 3/12/21 utils produce a blockpath from the args **ALONE**. The utils must produce a blockpath from command
        // FIXME: 3/12/21 NOT ALIAS + args
        return getShortPath().asSingleBlockpath();
    }

    @Override
    public Block getShortPath() {
        return commandIdentifier;
    }

    @Override
    public CommandNode<T> getRoot() {
        return this;
    }

    @Override
    public CommandNode<T> getParent() {
        return this;
    }

    @Override
    public Optional<CommandNode<T>> getSpecificNode(BlockPath blockPath) {
        return null
    }

    @Override
    public Collection<CommandNode<T>> getLinkedNodes() {
        return null;
    }

}
