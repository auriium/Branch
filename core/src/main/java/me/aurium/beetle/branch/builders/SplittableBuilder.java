package me.aurium.beetle.branch.builders;

import me.aurium.beetle.api.command.ContextSource;
import me.aurium.beetle.branch.CommandNode;
import me.aurium.beetle.branch.IndividualNode;
import me.aurium.beetle.branch.nodes.BaseNode;
import me.aurium.beetle.branch.nodes.BranchingCommandNode;

import java.util.HashSet;
import java.util.Set;

public class SplittableBuilder<T> {

    private final ContextSource<T> source;
    private final Set<CommandNode<T>> nodesToInsert;

    private final BaseNode<T> base;
    private final CommandNode<T> parent;

    private IndividualNode<T> singleFunctionNode;

    public SplittableBuilder(BaseNode<T> base, CommandNode<T> parent, ContextSource<T> source) {
        this.source = source;
        this.nodesToInsert = new HashSet<>();

        this.base = base;
        this.parent = parent;
    }


    public void addCustomNode(CommandNode<T> node) {
        this.nodesToInsert.add(node);
    }

    public BranchingCommandNode<T> build() {

        if (base == null || parent == null) {

        } else {
            new BranchingCommandNode<T>()
        }




        return null;
    }

}
