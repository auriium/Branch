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

package me.aurium.beetle.branch.nodes;

//kinda like a branching node except it throws forward and not to the sides

//one of these days ill actually finish this class LMFAO
/*
public class ArgumentNode<T> implements IdentifiableNode<T> {

    private final Block identifier;
    private final List<Argument<?>> sequentialValueNodes; //the nodes in order from here on out
    private final SingleNode<T> noArgs;

    private final Permission<T> permission;

    public ArgumentNode(Block identifier, List<Argument<?>> sequentialValueNodes, SingleNode<T> noArgs, Permission<T> permission) {
        this.identifier = identifier;
        this.sequentialValueNodes = sequentialValueNodes;
        this.noArgs = noArgs;
        this.permission = permission;
    }


    // - These two methods can remain unimplemented because this node will never be used for contexthandlers and suggestionhandlers -
    // - The actual contextHandler and Suggestionhandler are provided by the getSpecificNode method returning an anonymous basenode -
    // - This is because the contexthandler and suggestion handler here always depend on the blockpath, and in order to respect -
    // - the node map object model, we must do this.


    @Override
    public SearchResult<T> getSpecificNode(SearchInput input) {
        return new SearchResult<>(this, input);
    }

    */
/*if (path.isEmpty()) return Optional.of(noArgs);

        return Optional.of(this);*//*


        */
/* This was pointless, see below note

        //we can either do this shit, or we can return **THIS** no matter what and let the context handler be variable, since the context handler delegates
        //to another adapter anyways

        int position = path.length() - 1; //wow real throwback to LEAF framework huh
        int size = sequentialValueNodes.size();

        //check the length
        if (position == size) return Optional.of(sequentialValueNodes.get(size - 1));

        return Optional.of(sequentialValueNodes.get(position));
        *//*


    @Override
    public ExecutionResult<T> getExecutionHandler() {
        return new ExecutionResult<>((context) -> {
            Deque<Block> executed = context.executedPath();
        });
    }

    @Override
    public SuggestionHandler<T> getSuggestionHandler() {
        return (context) -> {
            return null;
        };
    }

    @Override
    public Permission<T> getPermission() {
        return permission;
    }

    @Override
    public Block getIdentifier() {
        return identifier;
    }
}
*/
