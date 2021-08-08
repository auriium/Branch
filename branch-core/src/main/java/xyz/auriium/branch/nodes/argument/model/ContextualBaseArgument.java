package xyz.auriium.branch.nodes.argument.model;

import xyz.auriium.branch.base.execution.blocks.ArgumentBlock;
import xyz.auriium.branch.results.Result;

import java.util.List;
import java.util.Optional;

/**
 * Base-type SPI interface describing an
 * argument that requires information about the node's contextual sender base
 *
 * Convention dictates that when writing an argument instantiation of said argument will be done
 * via the use of a static #of method with a private constructor.
 *
 * @param <T> input type of command node
 * @param <O> output type of argument parsing e.g. world or string
 */
public interface ContextualBaseArgument<T,O> {

    /**
     * Method describing the single-word "type" of this argument, like
     * "StringArgument" or "IntegerArgument"
     *
     * @return the type
     */
    ArgumentBlock getType();

    /**
     * Method describing what label this argument uses
     * Label is typically defined by the user of the framework
     *
     * @return the label
     */
    String getLabel();

    /**
     * Method describing how many blocks this argument reserves
     * @return the amount of blocks this argument requires
     */
    int reservedBlockAmount();

    /**
     * If this object is an optional, return a value. If it is not, will always return empty
     * @return the optional describing whether this object is optional or not
     */
    Optional<O> getOptional();

    /**
     * Method describing how this object parses
     *
     * Always assume that {@param reserved} contains the exact amount of arguments you requested.
     * It will never contain only 1 if you request 2, and will never be empty if you request 1.
     *
     * @return a result describing the execution success of parsing
     */
    Result<O> parse(T sender, String alias, List<String> reserved);

    

}
