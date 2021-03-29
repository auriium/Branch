package me.aurium.beetle.branch.annotate.marker.permission;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.CONSTRUCTOR})
public @interface Permission {

    Class<? extends StringPermChecker> getRelativeChecker();

    String permission();

}
