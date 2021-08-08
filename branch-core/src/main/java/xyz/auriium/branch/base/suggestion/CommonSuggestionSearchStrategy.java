package xyz.auriium.branch.base.suggestion;

import xyz.auriium.branch.base.NodeContext;

import java.util.ArrayList;
import java.util.List;

public class CommonSuggestionSearchStrategy<I> extends AbstractSuggestionSearchStrategy<I> {

    private final boolean hideNoPermissions;

    public CommonSuggestionSearchStrategy(boolean hideNoPermissions) {
        this.hideNoPermissions = hideNoPermissions;
    }

    @Override
    List<String> orderThen(List<Suggestion<I>> suggestions, NodeContext<I> ctx) {

        List<String> strings = new ArrayList<>();

        for (Suggestion<I> suggestion : suggestions) {
            if (hideNoPermissions) {
                if (!suggestion.getPermission().attempt(ctx)) continue;
            }


            strings.add(suggestion.getIdentifier().getLabel());
        }

        return strings;
    }
}
