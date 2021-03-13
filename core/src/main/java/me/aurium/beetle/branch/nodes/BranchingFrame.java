package me.aurium.beetle.branch.nodes;

import me.aurium.beetle.api.nodes.path.Block;
import me.aurium.beetle.branch.CommandNode;
import me.aurium.beetle.branch.PreStoredHashSet;

import java.util.HashSet;
import java.util.Set;

public class BranchingFrame<T> implements Frame<T> {

    private boolean linked;
    private final Set<Frame<T>> builders;
    private SingleFrame<T> noArgs;

    private final Frame<T> parent;
    private final Frame<T> root;

    public BranchingFrame(Frame<T> parent, Frame<T> root) {
        linked = true;
        builders = new HashSet<>();
        noArgs = null;

        this.root = root;
        this.parent = parent;
    }

    public BranchingFrame<T> branch(Block identifier, BranchingFunc<T> func) {
        BranchingFrame<T> frame = new BranchingFrame<T>(parent,root); //this doesnt work because the real parent (or what will be built from **this** builder doesn't exist yet (hasn't been built).

        func.accept(frame);

        this.builders.add(frame);

        return this;
    }

    public BranchingFrame<T> single(Block identifier, SingleFunc<T> func) {
        SingleFrame<T> frame = new SingleFrame<>();

        func.accept(frame);

        this.builders.add(frame);

        return this;
    }

    public BranchingFrame<T> noArgs(Block identifier, SingleFunc<T> func, boolean linked) {
        SingleFrame<T> frame = new SingleFrame<>();

        func.accept(frame);

        if (linked) {

        }

        return this;
    }

    public BranchingNode<T> build() {

        //maybe something like having all the above factories built instantly on initialize?
        // but then the problem of branchingnode requiring its nodes on construction still remains

        PreStoredHashSet<CommandNode<T>> set;

        if (noArgs == null) {
            set = new PreStoredHashSet<>(nodes, false);
        } else {
            set = new PreStoredHashSet<>(noArgs,nodes,linked);
        }

        new BranchingNode<T>()

        return new BranchingNode<>(set,root,parent,par)
    }

}
