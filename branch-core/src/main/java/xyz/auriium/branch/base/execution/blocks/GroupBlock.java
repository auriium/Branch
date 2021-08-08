package xyz.auriium.branch.base.execution.blocks;

public class GroupBlock implements Block {

    private final String groupName;

    public GroupBlock(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String getLabel() {
        return groupName;
    }

    @Override
    public String getType() {
        return BlockType.LITERAL_GROUP.getReadable();
    }

    @Override
    public BracketPattern getBracketPattern() {
        return BracketPattern.empty();
    }

    @Override
    public BlockType getTypeObject() {
        return BlockType.LITERAL_GROUP;
    }
}
