package me.aurium.beetle.branch.builders;

import me.aurium.beetle.api.command.ContextSource;
import me.aurium.beetle.branch.PreStoredHashSet;
import me.aurium.beetle.branch.CommandNode;
import me.aurium.beetle.branch.IndividualNode;
import me.aurium.beetle.branch.nodes.BranchingNode;

import java.util.HashSet;
import java.util.Set;

public class SplittableFrameBuilder<T> implements FrameBuilder<T> {

    private final ContextSource<T> source;
    private final Set<CommandNode<T>> nodesToInsert;

    private final FrameBuilder<T> base;
    private final FrameBuilder<T> parent;

    private IndividualNode<T> singleFunctionNode;

    private final Set<FrameBuilder<T>> frames = new HashSet<>();

    public SplittableFrameBuilder(FrameBuilder<T> base, FrameBuilder<T> parent, ContextSource<T> source) {
        this.source = source;
        this.nodesToInsert = new HashSet<>();

        this.base = base;
        this.parent = parent;
    }


    public void addCustomNode(CommandNode<T> node) {
        this.nodesToInsert.add(node);
    }

    public void addSplit(BuilderFunction<SplittableFrameBuilder<T>,T> function) {
        SplittableFrameBuilder<T> builder = new SplittableFrameBuilder<T>(base,this,source);

        function.consume(builder);

        nodesToInsert.add(builder.build());
    }

    public BranchingNode<T> build() {

        PreStoredHashSet<CommandNode<T>> set;

        if (singleFunctionNode == null) {
            set = new PreStoredHashSet<>(nodesToInsert);
        } else {
            set = new PreStoredHashSet<>(singleFunctionNode,nodesToInsert);
        }


        new BranchingNode<T>(set,fr)

        return null;
    }

    @Override
    public FrameBuilder<T> getBase() {
        return base;
    }

    @Override
    public FrameBuilder<T> getParent() {
        return parent;
    }

    @Override
    public FrameBuilder<T> getLinkedFrames() {
        return null;
    }
}
