package me.aurium.beetle.branch.fallback.message;

public class MessageInfo {

    private final MessageKey key;
    private final Object[] args;

    public MessageInfo(MessageKey key, Object[] args) {
        this.key = key;
        this.args = args;
    }

    public MessageKey getKey() {
        return key;
    }

    public Object[] getStrings() {
        return args;
    }

}
