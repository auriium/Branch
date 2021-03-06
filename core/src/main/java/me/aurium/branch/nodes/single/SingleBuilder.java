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

package me.aurium.branch.nodes.single;

import me.aurium.branch.execution.Block;
import me.aurium.branch.execution.StringBlock;
import me.aurium.branch.execution.api.ExecutionHandler;
import me.aurium.branch.information.description.Description;
import me.aurium.branch.information.description.StringDescription;
import me.aurium.branch.nodes.Builder;
import me.aurium.branch.nodes.CommandNode;
import me.aurium.branch.fallback.permissions.Permission;
import me.aurium.branch.fallback.permissions.EmptyPermission;

import java.util.Objects;

public class SingleBuilder<C> implements Builder<C> {

    private Block block;
    private ExecutionHandler<C> contextHandler;
    private Permission<C> permission = new EmptyPermission<>();
    private Description description;

    public void withIdentifier(Block identifier) {
        this.block = identifier;
    }

    public void withIdentifier(String string) {
        this.block = StringBlock.of(string);
    }

    public void withHandler(ExecutionHandler<C> handler) {
        this.contextHandler = handler;
    }

    public void withPermission(Permission<C> permission) {
        this.permission = permission;
    }

    public void withDescription(Description description) {
        this.description = description;
    }

    public CommandNode<C> build() {
        Objects.requireNonNull(block);
        Objects.requireNonNull(contextHandler);

        Description returned = Objects.requireNonNullElse(description,new StringDescription("Default description for subcommand " + block.getIdentifier()));

        return new SingleNode<>(block, contextHandler, permission, returned);
    }

}
