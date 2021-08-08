package xyz.auriium.branch.tests.centralized;

import xyz.auriium.branch.base.ContextProvider;
import xyz.auriium.branch.base.NodeContext;

public class MockContextProducer implements ContextProvider<MockSender> {
    @Override
    public NodeContext<MockSender> produce(MockSender sender, String alias, String[] strings) {
        return new MockContext(sender, alias, strings);
    }
}
