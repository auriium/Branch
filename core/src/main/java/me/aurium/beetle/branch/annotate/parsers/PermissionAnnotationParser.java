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

package me.aurium.beetle.branch.annotate.parsers;

import me.aurium.beetle.branch.annotate.marker.permission.Permission;
import me.aurium.beetle.branch.fallback.permissions.StringPermission;

import java.lang.annotation.Annotation;

//TODO fix all of this bullshit - we need checks - this class only exists to tell me what i need to do in the future.
public class PermissionAnnotationParser<T> {


    me.aurium.beetle.branch.fallback.permissions.Permission<T> parse(Annotation annotate) throws IllegalAccessException, InstantiationException {

        if (!annotate.annotationType().equals(Permission.class)) throw new PermissionParsingException("Annotation must be of type Permission");

        Permission permission = (Permission) annotate;

        //TODO checks

        //TODO fix this shit
        StringPermission<?> perm = permission.getRelativeChecker().newInstance().get(permission.permission());


        return (me.aurium.beetle.branch.fallback.permissions.Permission<T>) perm;
    }

    public static class PermissionParsingException extends RuntimeException {
        public PermissionParsingException(String lol ) {
            super(lol);
        }
    }


}
