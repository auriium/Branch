package xyz.auriium.branch.execution;

public enum BlockType {

    INPUT,

    LITERAL_COMMAND, //used only to identify the string representing the root of a command e.g. command in /command group <foo> [bar]
    LITERAL_GROUP, //used for blocks representing a subgroup's identifier e.g. group in /command group <foo> [bar]
    ARGUMENT_OPTIONAL, //used for blocks representing a command's optional argument e.g. bar in /command group <foo> [bar]
    ARGUMENT_REQUIRED //used for blocks representing a required argument e.g. foo in /command group <foo> [bar]


}
