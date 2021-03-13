package me.aurium.beetle.branch.builders;

import me.aurium.beetle.api.command.ContextSource;
import me.aurium.beetle.api.nodes.path.Block;
import me.aurium.beetle.branch.nodes.BaseNode;

public class CentralBuilder<T>  {

    private final ContextSource<T> contextSource;
    private final Block commandName;

    public CentralBuilder(ContextSource<T> contextSource, Block commandName) {
        this.contextSource = contextSource;
        this.commandName = commandName;
    }

    public SplittableLaunchPoint<T> split(SplitBuilderFunction<T> function) {

        SplittableFrameBuilder<T> builder = new SplittableFrameBuilder<T>(this,this,contextSource);

        function.consume(builder);

        return new SplittableLaunchPoint<T>(new BaseNode<T>(contextSource, builder.build(), commandName));
    }


}
