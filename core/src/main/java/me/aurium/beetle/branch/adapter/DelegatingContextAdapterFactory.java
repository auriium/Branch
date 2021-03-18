package me.aurium.beetle.branch.adapter;

import me.aurium.beetle.api.command.Context;
import me.aurium.beetle.api.command.ContextSource;
import me.aurium.beetle.branch.CommandNode;
import me.aurium.beetle.branch.IdentifiableNode;
import me.aurium.beetle.branch.block.BlockPath;

/**
 * UndeterministicImmutableModifiableContextAdapterFactoryPatternSelectorNodeContainerSource!
 *
 * I feel like a real dev now! /s
 */
public class DelegatingContextAdapterFactory<T> implements ContextAdapterFactory<T> {

    public DelegatingContextAdapterFactory(ContextSource<T> delegate) {
        this.delegate = delegate;
    }

    public final ContextSource<T> delegate;

    @Override
    public ContextAdapter<T> produce(T t, String alias, String[] strings, IdentifiableNode<T> executedNode, CommandNode<T> baseNode, BlockPath path) {

        Context<T> context = context(t,alias,strings);

        return new ContextWrapper<>(context,executedNode,baseNode,path);
    }

    @Override
    public Context<T> context(T t, String alias, String[] strings) {
        return delegate.context(t,alias,strings);
    }
}
