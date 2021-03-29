package me.aurium.beetle.branch.annotate.parsers;

import me.aurium.beetle.branch.annotate.marker.permission.Permission;
import me.aurium.beetle.branch.fallback.permission.StringPermission;

import java.lang.annotation.Annotation;

//TODO fix all of this bullshit - we need checks - this class only exists to tell me what i need to do in the future.
public class PermissionAnnotationParser<T> {


    me.aurium.beetle.branch.fallback.permission.Permission<T> parse(Annotation annotate) throws IllegalAccessException, InstantiationException {

        if (!annotate.annotationType().equals(Permission.class)) throw new PermissionParsingException("Annotation must be of type Permission");

        Permission permission = (Permission) annotate;

        //TODO checks

        //TODO fix this shit
        StringPermission<?> perm = permission.getRelativeChecker().newInstance().get(permission.permission());


        return (me.aurium.beetle.branch.fallback.permission.Permission<T>) perm;
    }

    public static class PermissionParsingException extends RuntimeException {
        public PermissionParsingException(String lol ) {
            super(lol);
        }
    }


}
