package me.aurium.beetle.branch.annotate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) //refer to dazzleconf for interesting ideas
public @interface BranchingNode {

    String identifier();

}
