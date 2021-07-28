package xyz.auriium.branch.interfacing.exceptional.printing;

import xyz.auriium.branch.interfacing.exceptional.AnomalyType;

public class StringlyPrinter extends SettablePrinter<String> {

    public static SettablePrinter<String> defaults() {
        return new StringlyPrinter()
                .add(AnomalyType.ARGUMENT_PARSING, s -> "Error parsing argument: " + s)
                .add(AnomalyType.INVALID_SENDER, s -> "Invalid sender: " + s)
                .add(AnomalyType.INVALID_SYNTAX, s -> "Invalid syntax: " + s)
                .add(AnomalyType.NO_PERMISSION, s -> "No permission to execute command!");
    }

}
