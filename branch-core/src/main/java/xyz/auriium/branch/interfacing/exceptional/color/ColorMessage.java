package xyz.auriium.branch.interfacing.exceptional.color;

/*
 * Homegrown shitty adventure alternative (just use the fucking adventure module)
 * Represents a message that can be colored with <color1> <color2>
 */
public class ColorMessage {

    private final String string;

    public ColorMessage(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public static ColorMessage of(String string) {
        return new ColorMessage(string);
    }
}
