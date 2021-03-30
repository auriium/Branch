package me.aurium.beetle.branch.block;

public class EmptyBlock implements Block{

    @Override
    public String getIdentifier() {
        throw new UnsupportedOperationException("Empty block should not exist in path!");
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    public static EmptyBlock of() {
        return new EmptyBlock();
    }


}
