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

package me.aurium.branch.fallback.permissions;

import me.aurium.branch.execution.NodeContext;

/**
 * Represents the accessibility predicate of a command -> whether a command can be executed or not
 */
public interface Permission<T> {

   /**
    * Checks whether the sender has acccess or not
    * @param sender sender
    * @param alias alias
    * @param args args
    * @return true if so, false if not
    */
   boolean attempt(T sender, String alias, String[] args); //because fuck you

   default boolean attempt(NodeContext<T> nodeContext) {
      return attempt(nodeContext.getSender(),nodeContext.getAlias(), nodeContext.getArgs());
   }

   /**
    * Represents the name shown when the permission fails.
    * @return the name shown if the permission fails, injected into a Result.
    */
   String failureIdentifiableName();

}
