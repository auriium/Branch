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

package me.aurium.branch.nodes.branching;

import me.aurium.branch.execution.Block;
import me.aurium.branch.execution.StringBlock;
import me.aurium.branch.fallback.permissions.Permission;
import me.aurium.branch.fallback.permissions.EmptyPermission;
import me.aurium.branch.information.description.Description;
import me.aurium.branch.information.description.StringDescription;
import me.aurium.branch.nodes.single.EndpointNode;
import me.aurium.branch.nodes.single.HelpNode;
import me.aurium.branch.nodes.Builder;
import me.aurium.branch.nodes.CommandNode;
import me.aurium.branch.nodes.IdentifiableNode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class InclusiveBranchingBuilder<T> implements Builder<T> {

    private final Set<IdentifiableNode<T>> commands;

    private Block block;
    private EndpointNode<T> noArgs;
    private Permission<T> permission;
    private Description description;

    public InclusiveBranchingBuilder() {
        this.commands = new HashSet<>();
        this.permission = new EmptyPermission<>();
        this.noArgs = new HelpNode<>();
    }

    public InclusiveBranchingBuilder<T> withIdentifier(Block block) {
        this.block = block;

        return this;
    }

    public InclusiveBranchingBuilder<T> withIdentifier(String string) {
        this.block = StringBlock.of(string);

        return this;
    }

    public InclusiveBranchingBuilder<T> withPermission(Permission<T> permission) {
        this.permission = permission;

        return this;
    }

    public InclusiveBranchingBuilder<T> withNode(IdentifiableNode<T> node) {
        commands.add(node);

        return this;
    }

    public InclusiveBranchingBuilder<T> withNoArgs(EndpointNode<T> node) {
        this.noArgs = node;

        return this;
    }

    public InclusiveBranchingBuilder<T> withDescription(Description description) {
        this.description = description;

        return this;
    }

    public CommandNode<T> build() {

        Objects.requireNonNull(block);
        Objects.requireNonNull(permission);
        Objects.requireNonNull(noArgs);

        Description returned = Objects.requireNonNullElse(description,new StringDescription("Default description for subcommand " + block.getIdentifier()));

        return new BranchingNode<>(new InclusivePrestoredSet<>(noArgs,commands),block, returned, permission);
    }

}