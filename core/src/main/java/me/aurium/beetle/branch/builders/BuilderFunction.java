package me.aurium.beetle.branch.builders;

public interface BuilderFunction<T extends FrameBuilder<C>, C> {

    void consume(T builder);

}
