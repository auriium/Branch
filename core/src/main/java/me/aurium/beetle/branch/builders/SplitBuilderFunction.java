package me.aurium.beetle.branch.builders;

public interface SplitBuilderFunction<T> {

    void consume(SplittableFrameBuilder<T> builder);

}
