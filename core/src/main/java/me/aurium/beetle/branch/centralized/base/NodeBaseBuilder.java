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

package me.aurium.beetle.branch.centralized.base;

import me.aurium.beetle.branch.fallback.strategies.OneBackStrategy;
import me.aurium.beetle.branch.execution.context.ContextProvider;
import me.aurium.beetle.branch.nodes.model.CommandNode;
import me.aurium.beetle.branch.fallback.strategies.FallbackSearchStrategy;

public class NodeBaseBuilder<T> {

    private ContextProvider<T> producer;

    private CommandNode<T> base;
    private FallbackSearchStrategy<T> strategy = new OneBackStrategy<>();

    public NodeBaseBuilder<T> withBaseNode(CommandNode<T> node) {
        this.base = node;

        return this;
    }

    public NodeBaseBuilder<T> withStrategy(FallbackSearchStrategy<T> strategy) {
        this.strategy = strategy;

        return this;
    }

}
