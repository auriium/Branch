package xyz.auriium.branch.base.execution.blocks;

public class BracketPattern {

    private final Character startChar;
    private final Character closeChar;

    public BracketPattern(Character startChar, Character closeChar) {
        this.startChar = startChar;
        this.closeChar = closeChar;
    }

    public String parse(String input) {
        StringBuilder builder = new StringBuilder();

        if (startChar != null) {
            builder.append(startChar);
        }

        builder.append(input);

        if (closeChar != null) {
            builder.append(closeChar);
        }

        return builder.toString();
    }

    public static BracketPattern empty() {
        return new BracketPattern(null, null);
    }
}
