package me.aurium.beetle.branch.builders;

import me.aurium.beetle.api.command.ContextSource;
import me.aurium.beetle.branch.CommandNode;
import me.aurium.beetle.branch.IndividualNode;
import me.aurium.beetle.branch.bases.SimpleBase;
import me.aurium.beetle.branch.nodes.BaseNode;
import me.aurium.beetle.branch.nodes.BranchingCommandNode;

import java.util.HashSet;
import java.util.Set;

public class BaseBuilder<T>{

    private final ContextSource<T> contextSource;
    private BaseNode<T> baseNode;

    public BaseBuilder(ContextSource<T> contextSource) {
        this.contextSource = contextSource;
        this.baseNode = new BaseNode<>(contextSource);
    }

    public SplitMode<T> baseSplit(SplitBuilderFunction<T> function) {

        SplittableBuilder<T> builder = new SplittableBuilder<>(base,base,contextSource);

        function.consume(builder);

        return new SplitMode<>(builder.build());
    }

    public static class SplitMode<T> {

        private final BranchingCommandNode<T> baseNode;

        public SplitMode(BranchingCommandNode<T> baseNode) {
            this.baseNode = baseNode;
        }

    }

}
