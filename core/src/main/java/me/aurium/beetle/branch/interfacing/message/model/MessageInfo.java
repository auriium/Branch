package me.aurium.beetle.branch.interfacing.message.model;

public class MessageInfo {

    private final String key;
    private final String value;

    public MessageInfo(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static MessageInfo of(String key, String value) {
        return new MessageInfo(key, value);
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }
}
