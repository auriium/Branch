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

package me.aurium.beetle.branch.execution.context;


import me.aurium.beetle.branch.nodes.model.CommandNode;
import me.aurium.beetle.branch.nodes.results.SearchInfo;

public abstract class AbstractNodeContext<T> implements NodeContext<T> {

    private final T sender;
    private final String alias;
    private final String[] args;

    private final CommandNode<T> baseNode;
    private final SearchInfo<T> searchInfo;

    protected AbstractNodeContext(T sender, String alias, String[] args, CommandNode<T> baseNode, SearchInfo<T> result) {
        this.sender = sender;
        this.alias = alias;
        this.args = args;

        this.searchInfo = result;
        this.baseNode = baseNode;
    }

    @Override
    public T getSender() {
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
    public CommandNode<T> getBaseExecutedNode() {
        return baseNode;
    }

    @Override
    public SearchInfo<T> getResults() {
        return searchInfo;
    }

}
