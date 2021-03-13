package me.aurium.beetle.branch.builders;

import me.aurium.beetle.api.command.ContextSource;
import me.aurium.beetle.branch.CommandNode;
import me.aurium.beetle.branch.nodes.BaseNode;

import java.util.HashSet;
import java.util.Set;

public class SplittableLaunchPoint<T> implements FrameBuilder<T> {

    private final BaseNode<T> baseNode;
    private final Set<FrameBuilder<T>> builderSet;
    private final ContextSource<T> contextSource;

    public SplittableLaunchPoint(BaseNode<T> baseNode, ContextSource<T> source) {
        this.baseNode = baseNode;
        this.builderSet = new HashSet<>();
        this.contextSource = source;
    }

    public SplittableLaunchPoint<T> split(BuilderFunction<SplittableFrameBuilder<T>,T> function) {
        SplittableFrameBuilder<T> builder = new SplittableFrameBuilder<>(this,this,contextSource);

        function.consume(builder);

        builderSet.add(builder);

        return this;
    }

    //public SplittableLaunchPoint<T> single(BuilderFunction<>)

    public CommandNode<T> build() {




    }


    @Override
    public FrameBuilder<T> getBase() {
        return this;
    }

    @Override
    public FrameBuilder<T> getParent() {
        return this;
    }
}
