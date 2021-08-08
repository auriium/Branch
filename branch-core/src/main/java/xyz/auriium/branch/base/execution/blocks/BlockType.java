package xyz.auriium.branch.base.execution.blocks;

public enum BlockType {

    INPUT("input"),

    LITERAL_GROUP("subgroup"), //used for blocks representing a subgroup's identifier e.g. group in /command group <foo> [bar]
    LITERAL_ENDPOINT("endpoint"), //used for blocks representing an endpoint command's identifier e.g. help or join in /command help or /command kitpvp join
    ARGUMENT_OPTIONAL("optional"), //used for blocks representing a command's optional argument e.g. bar in /command group <foo> [bar]
    ARGUMENT_REQUIRED("required"), //used for blocks representing a required argument e.g. foo in /command group <foo> [bar]

    LITERAL_CUSTOM("custom"); //for framework-user implemented blocks (why?)

    String readable;

    BlockType(String humanReadable) {
        readable = humanReadable;
    }

    public String getReadable() {
        return readable;
    }
}
