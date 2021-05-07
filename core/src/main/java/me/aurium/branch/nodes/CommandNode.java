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

package me.aurium.branch.nodes;

import me.aurium.branch.execution.api.BranchHandler;
import me.aurium.branch.information.description.Description;
import me.aurium.branch.nodes.results.SearchInput;
import me.aurium.branch.nodes.results.SearchInfo;
import me.aurium.branch.fallback.permissions.Permission;
import me.aurium.branch.nodes.results.model.Result;

/**
 * Base object
 * @param <T> fuck
 */
public interface CommandNode<T> {

    //int getExpectedConsumeAmount() //used to check how much was expected as you pass through vs how much was received, among other htings.

    Result<SearchInfo<T>> getSpecificNode(SearchInput path);
    BranchHandler<T> getHandling();


    /**
     * Gets the permission required to execute and interact with this node. Depending on the base, this may cause the node to become locked, or just completely be ignored.
     * @return the permission binding
     */
    Permission<T> getPermission();
    Description getDescription();

}
