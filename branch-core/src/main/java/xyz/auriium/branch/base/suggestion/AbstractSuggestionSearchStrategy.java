package xyz.auriium.branch.base.suggestion;

import xyz.auriium.branch.base.NodeContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Abstract suggestion strategy handler that
 * @param <I>
 */
public abstract class AbstractSuggestionSearchStrategy<I> implements SuggestionSearchStrategy<I> {

    @Override
    public List<String> order(List<Suggestion<I>> suggestions, NodeContext<I> ctx) {
        String[] strings = ctx.getArgs();

        return copyPartialMatches(strings[strings.length - 1], order(suggestions, ctx));
    }

    abstract List<String> orderThen(List<Suggestion<I>> suggestions, NodeContext<I> ctx);

    private List<String> copyPartialMatches(final String token, final Collection<String> originals) throws UnsupportedOperationException, IllegalArgumentException {

        List<String> results = new ArrayList<>();

        for (String string : originals) {

            if (startsWithIgnoreCase(string, token)) {
                results.add(string);
            }

        }

        return results;
    }

    private boolean startsWithIgnoreCase(final String string, final String prefix) throws IllegalArgumentException, NullPointerException {
        if (string.length() < prefix.length()) {
            return false;
        }
        return string.regionMatches(true, 0, prefix, 0, prefix.length());
    }

}
