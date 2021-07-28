package xyz.auriium.branch.interfacing.information.description;

/**
 * Immutable description returning a simple string
 */
public class StringDescription implements Description {

    private final String textDescription;

    public StringDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public String getTextDescription() {
        return textDescription;
    }
}