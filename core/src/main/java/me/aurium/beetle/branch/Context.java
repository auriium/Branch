package me.aurium.beetle.branch;

/**
 * The context of a command
 * @param <T> the type of command source
 */
public interface Context<T> {

    T getSender();
    String getAlias();
    String[] getArgs();

}
