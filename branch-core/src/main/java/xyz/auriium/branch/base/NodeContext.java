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

package xyz.auriium.branch.base;


/**
 * Represents the in-context of an executed command -> Basically, all the important information gleaned from the execution of a command
 * such as the sender, arguments as string, and all nodes involved.
 * @param <T> the sender
 */
public interface NodeContext<T> {

    /**
     * Gets the parsed sender object used by this object
     * @return the sender object
     */
    T getSender();

    /**
     * Returns the specific name used to execute this command
     * @return alias string
     */
    String getAlias();
    String[] getArgs();

    /**
     * Gets whether the context's delegating sender has access to a permission. On some platforms, this may always be false.
     * @param string the permission
     * @return whether it is permissible or not.
     */
    boolean hasStringPermissible(String string);


}
