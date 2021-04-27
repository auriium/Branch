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

package me.aurium.branch.nodes.builders;

import me.aurium.branch.execution.Block;
import me.aurium.branch.execution.EmptyBlock;
import me.aurium.branch.execution.StringBlock;
import me.aurium.branch.fallback.permissions.Permission;
import me.aurium.branch.fallback.permissions.EmptyPermission;
import me.aurium.branch.nodes.BranchingNode;
import me.aurium.branch.nodes.model.CommandNode;
import me.aurium.branch.nodes.model.IdentifiableNode;
import me.aurium.branch.utility.PreStoredHashSet;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;

public class BranchingBuilder<T> implements Builder<T> {

    private final Set<IdentifiableNode<T>> commands;

    private Block block;
    private IdentifiableNode<T> noArgs;

    private boolean linked;

    private Permission<T> permission;

    public BranchingBuilder() {
        this.commands = new HashSet<>();

/*        this.noArgs = new SingleNode<>(new EmptyBlock(), messageProvider::handleDefaultBranching, new EmptyPermission<>());*/
        this.linked = false;

        this.permission = new EmptyPermission<>();
    }

    public void withIdentifier(Block block) {
        this.block = block;
    }

    public void withIdentifier(String string) {
        this.block = StringBlock.of(string);
    }

    public void withPermission(Permission<T> permission) {
        this.permission = permission;
    }

    public BranchingBuilder<T> addNode(IdentifiableNode<T> node) {
        commands.add(node);

        return this;
    }

    public <C extends Builder<T>> void withNode(C key, Consumer<C> consumer) {
        consumer.accept(key);

        commands.add(key.build());
    }

    public <C extends SingleBuilder<T>> void withNoArgs(C key, boolean linked, Consumer<C> consumer) {
        consumer.accept(key);

        this.noArgs = key.build();
        this.linked = linked;
    }


    @Override
    public BranchingNode<T> build() {

        Objects.requireNonNull(block);

        PreStoredHashSet<IdentifiableNode<T>> set;



        if (noArgs == null) {
            if (linked) {
                throw new IllegalStateException("Attempted link without no-arguments handler!");
            } else {
                set = new PreStoredHashSet<>(commands,false);
            }
        } else {
            set = new PreStoredHashSet<>(noArgs,commands,linked);
        }

        return new BranchingNode<>(set,block, permission);
    }

    @Override
    public CommandNode<T> buildWithoutIdentifier() {

        PreStoredHashSet<IdentifiableNode<T>> set;

        if (noArgs == null) {
            if (linked) {
                throw new IllegalStateException("Attempted link without no-arguments handler!");
            } else {
                set = new PreStoredHashSet<>(commands,false);
            }
        } else {
            set = new PreStoredHashSet<>(noArgs,commands,linked);
        }

        return new BranchingNode<>(set, EmptyBlock.of(), permission);
    }

    public static <C> BranchingBuilder<C> make() {
        return new BranchingBuilder<>();
    }
}