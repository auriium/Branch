package me.aurium.beetle.branch.nodes;

import me.aurium.beetle.api.command.ContextHandler;
import me.aurium.beetle.api.command.ContextSource;
import me.aurium.beetle.api.nodes.path.Block;
import me.aurium.beetle.api.nodes.path.BlockPath;
import me.aurium.beetle.branch.AlreadyStoredHashSet;
import me.aurium.beetle.branch.CommandNode;

import java.util.Collection;
import java.util.Optional;

public class BaseNode<T> implements CommandNode<T> {

    private final AlreadyStoredHashSet<CommandNode<T>> set;
    private final ContextSource<T> source;

    public BaseNode(ContextSource<T> source, AlreadyStoredHashSet<CommandNode<T>> nodes)  {
        this.set = nodes;
        this.source = source;
    }

    @Override
    public ContextHandler<T> getContextHandler() {
        return null;
    }

    @Override
    public BlockPath getAbsolutePath() {
        return null;
    }

    @Override
    public Block getShortPath() {
        return null;
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
        return getSpecificNode(blockPath);
    }

    @Override
    public Collection<CommandNode<T>> getLinkedNodes() {
        return null;
    }

    public static class Assembly {
        public static <T> BaseNode<T> of(ContextSource<T> source, AlreadyStoredHashSet<CommandNode<T>> nodes) {
            return new BaseNode<>(source,nodes);
        }

        public static <T> BaseNode<T> of(ContextSource<T> source, CommandNode<T> singleNode) {
            return new BaseNode<>(source,new AlreadyStoredHashSet<>(singleNode));
        }
    }
}
