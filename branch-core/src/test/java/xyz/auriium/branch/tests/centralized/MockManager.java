package xyz.auriium.branch.tests.centralized;

import xyz.auriium.branch.centralized.CentralizedManager;
import xyz.auriium.branch.centralized.CentralizedManagerBinder;
import xyz.auriium.branch.centralized.NodeSource;
import xyz.auriium.branch.centralized.base.NodeBase;
import xyz.auriium.branch.centralized.base.NodeBaseBuilder;
import xyz.auriium.branch.centralized.typeadapter.ManagerAdapter;
import xyz.auriium.branch.nodes.CommandNode;

public class MockManager implements CentralizedManager<MockSender,Void> {

    private final static MockAdapter adapter = new MockAdapter();

    @Override
    public CentralizedManagerBinder getBinder(Void platform) {
        throw new IllegalStateException("Cannot bind a mock manager to any platform (lol)");
    }

    @Override
    public NodeSource<MockSender> getSource() {
        return null;
    }

    @Override
    public NodeBaseBuilder<MockSender, MockSender> newCommandWithBuilder() {
        return new NodeBaseBuilder<>(this, adapter);
    }

    @Override
    public <C extends MockSender> NodeBaseBuilder<MockSender, C> newCommandWithBuilder(ManagerAdapter<MockSender, C> adapter) {
        return new NodeBaseBuilder<>(this, adapter);
    }

    @Override
    public void newCommandWithNode(CommandNode<MockSender> node) {
        //TODO
    }

    @Override
    public <C extends MockSender> void newCommandWithNode(CommandNode<MockSender> node, ManagerAdapter<MockSender, C> adapter) {
        //TODO
    }

    @Override
    public void newCommand(NodeBase<MockSender> base) {
        //TODO
    }
}
