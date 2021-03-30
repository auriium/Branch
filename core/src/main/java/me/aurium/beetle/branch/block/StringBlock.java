package me.aurium.beetle.branch.block;

public class StringBlock implements Block {

    private final String identifier;

    public StringBlock(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String getIdentifier() {
        return identifier;
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
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int hashCode() {
        return identifier.hashCode();
    }
}
