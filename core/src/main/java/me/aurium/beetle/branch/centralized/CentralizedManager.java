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

package me.aurium.beetle.branch.centralized;

import me.aurium.beetle.branch.centralized.base.NodeBase;
import me.aurium.beetle.branch.centralized.base.NodeBaseBuilder;
import me.aurium.beetle.branch.centralized.typeadapter.ManagerAdapter;

/**
 * Represents the utmost base part of a command
 * @param <T> the input type, does not need to be of same type as the node bases it utilizes
 * @param <V> the platform, void if there is none (how?)
 */
public interface CentralizedManager<T,V> {

    CentralizedManagerBinder getBinder(V platform);

    NodeBaseBuilder<T,T> newCommand();
    <C extends T> NodeBaseBuilder<T,C> newCommand(ManagerAdapter<T,C> adapter);

    void injectCommand(NodeBase<T> base);


}
