package me.aurium.beetle.branch.annotate;

public class TypeToken<T> {

    private final Class<T> type;

    public <X> TypeToken(Class<T> type) {
        this.type = type;
    }
    public Class<T> getType() {
        return type;
    }


}
