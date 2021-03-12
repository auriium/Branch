package me.aurium.beetle.branch.builders;

public interface SplitBuilderFunction<T> {

    void consume(SplittableBuilder<T> builder);

}
