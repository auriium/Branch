package me.aurium.beetle.branch.block;
public class StringBlock implements Block {

    private final String identifier;

    StringBlock(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public BlockPath asSingleBlockpath() {
        return CommonBlockPath.of(this);
    }

    public static Block of(String string) {
        if (string.contains(" ")) throw new IllegalStateException("Identifier cannot have spaces!");

        return new StringBlock(string);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringBlock that = (StringBlock) o;
        return identifier.equalsIgnoreCase(that.identifier);
    }

    @Override
    public int hashCode() {
        return identifier.hashCode();
    }
}
