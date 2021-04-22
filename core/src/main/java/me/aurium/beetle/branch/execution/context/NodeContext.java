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

import me.aurium.beetle.branch.interfacing.model.Message;
import me.aurium.beetle.branch.interfacing.model.Response;
import me.aurium.beetle.branch.nodes.model.CommandNode;
import me.aurium.beetle.branch.nodes.results.SearchInfo;


public interface NodeContext<T> {

    T getSender();
    String getAlias();
    String[] getArgs();
    CommandNode<T> getBaseExecutedNode();
    SearchInfo<T> getResults();

    /**
     * Sends an ugly string to the player using the platform's message handler. Whatever floats your boat!
     * @param string string
     */
    void stringSender(String string);

    /**
     * Sends a fancy formatted message to a player using the bound platform's message-handler
     * @param message message
     */
    void messageSender(Message<T> message);

    /**
     * Sends a formatted response to a player coded to a key
     * @param failure the response
     */
    void response(Response failure);


}
