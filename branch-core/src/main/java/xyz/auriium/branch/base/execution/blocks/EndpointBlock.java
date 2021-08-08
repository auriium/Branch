package xyz.auriium.branch.base.execution.blocks;

public class EndpointBlock implements Block {

    private final String endpointIdentifier;

    public EndpointBlock(String endpointIdentifier) {
        this.endpointIdentifier = endpointIdentifier;
    }

    @Override
    public String getLabel() {
        return endpointIdentifier;
    }

    @Override
    public String getType() {
        return BlockType.LITERAL_ENDPOINT.getReadable();
    }

    @Override
    public BracketPattern getBracketPattern() {
        return BracketPattern.empty();
    }

    @Override
    public BlockType getTypeObject() {
        return BlockType.LITERAL_ENDPOINT;
    }
}
