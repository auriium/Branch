package me.aurium.beetle.branch.annotate.marker.permission;

public @interface Permission {

    Class<? extends StringPermChecker> getRelativeChecker();

    String permission();

}
