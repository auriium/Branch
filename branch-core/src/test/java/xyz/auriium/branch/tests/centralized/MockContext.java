package xyz.auriium.branch.tests.centralized;

import xyz.auriium.branch.base.NodeContext;

public class MockContext implements NodeContext<MockSender> {

    private final MockSender sender;
    private final String alias;
    private final String[] args;

    public MockContext(MockSender sender, String alias, String[] args) {
        this.sender = sender;
        this.alias = alias;
        this.args = args;
    }

    @Override
    public MockSender getSender() {
        return sender;
    }

    @Override
    public String getAlias() {
        return alias;
    }

    @Override
    public String[] getArgs() {
        return args;
    }

    @Override
    public boolean hasStringPermissible(String string) {
        return sender.hasPermission(string);
    }
}
