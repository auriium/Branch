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
import me.aurium.branch.execution.api.BranchHandler;
import me.aurium.branch.fallback.permissions.Permission;
import me.aurium.branch.nodes.single.EndpointNode;

/**
 * Represents a node that pregenerates help entries based on the message context
 */
public class HelpNode<T> extends EndpointNode<T> {
    @Override
    public BranchHandler<T> getHandling() {
        return null;
    }

    @Override
    public Permission<T> getPermission() {
        return null;
    }

    @Override
    public Block getIdentifier() {
        return null;
    }
}
