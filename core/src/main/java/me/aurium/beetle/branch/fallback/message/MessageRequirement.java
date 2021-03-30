package me.aurium.beetle.branch.fallback.message;

public class MessageRequirement {

    private final String key;
    private final String value;

    private MessageRequirement(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static MessageRequirement of(String key, String value) {
        return new MessageRequirement(key, value);
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }
}
