package me.aurium.branch.information.description;

public class StringDescription implements Description {

    private final String textDescription;

    public StringDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public String getTextDescription() {
        return textDescription;
    }
}
