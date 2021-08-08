package xyz.auriium.branch.typeadapter;

import xyz.auriium.branch.results.Result;

/**
 * New version of adapter in accordance with new design
 * @param <I> input type
 * @param <O> output type
 *
 *           TODO: rename to SenderParser
 */
public interface ReduxAdapter<I,O> {

    Result<O> parse(I input);

}
