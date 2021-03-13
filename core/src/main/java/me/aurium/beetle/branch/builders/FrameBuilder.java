package me.aurium.beetle.branch.builders;

public interface FrameBuilder<T> {

    FrameBuilder<T> getBase();
    FrameBuilder<T> getParent();
    FrameBuilder<T> getLinkedFrames();

}
