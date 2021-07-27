/*
 *
 *  Branch
 *  Copyright © 2021 Aurium
 *
 *  Branch is free software: you can redistribute it and/or modify
 *  It under the terms of the GNU Affero General Public License as
 *  published by the Free Software Foundation, either version 3 of the
 *  License, or (at your option) any later version.
 *
 *  Branch is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Affero General Public License for more details.
 *
 *  You should have received a copy of the GNU Affero General Public License
 *  along with Branch. If not, see <https://www.gnu.org/licenses/>
 *  and navigate to version 3 of the GNU Affero General Public License.
 *
 */

package xyz.auriium.branch.tests;

import xyz.auriium.branch.centralized.base.NodeBase;
import xyz.auriium.branch.centralized.base.NodeBaseBuilder;
import xyz.auriium.branch.centralized.typeadapter.ManagerAdapter;
import xyz.auriium.branch.centralized.CentralizedManager;
import xyz.auriium.branch.centralized.CentralizedManagerBinder;
import xyz.auriium.branch.centralized.NodeSource;
import xyz.auriium.branch.nodes.CommandNode;

public class StringManager implements CentralizedManager<String,Void> {

    private final static StringAdapter defaultAdapter = new StringAdapter();

    @Override
    public CentralizedManagerBinder getBinder(Void platform) {
        throw new IllegalStateException("StringManager is for tests!");
    }

    @Override
    public NodeSource<String> getSource() {
        return null;
    }

    @Override
    public NodeBaseBuilder<String, String> newCommandWithBuilder() {
        return new NodeBaseBuilder<>(this,defaultAdapter);
    }

    @Override
    public <C extends String> NodeBaseBuilder<String, C> newCommandWithBuilder(ManagerAdapter<String, C> adapter) {
        return new NodeBaseBuilder<>(this,adapter);
    }

    @Override
    public void newCommandWithNode(CommandNode<String> node) {

    }

    @Override
    public <C extends String> void newCommandWithNode(CommandNode<String> node, ManagerAdapter<String, C> adapter) {

    }

    @Override
    public void newCommand(NodeBase<String> base) {
        throw new IllegalStateException("StringManager is for tests!");
    }
}
