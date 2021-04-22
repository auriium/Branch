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

package me.aurium.beetle.branch.interfacing.responses;

import me.aurium.beetle.branch.execution.context.NodeContext;
import me.aurium.beetle.branch.interfacing.model.Response;

import java.util.ArrayList;
import java.util.List;

//This can probably be improved

/**
 * Represents a response to the scenario in which not enough arguments were supplied to execute a splittable
 * node, so all alternative commands are suggested. This needs work, however, as it cannot list all alternative commands
 * and their arguments just yet. (logic for this must be some kind of greedy queue consumer with potentially dangerous loops)
 */
public class NoIntegratedArgsResponse implements Response {

    private final List<String> alternativeCommands;

    public NoIntegratedArgsResponse(List<String> alternativeCommands) {
        this.alternativeCommands = alternativeCommands;
    }

    public List<String> getAlternativeCommands() {
        return alternativeCommands;
    }

    /**
     * Use a basic nodeContext to produce a simple no integrated args response
     * @param context lah
     * @return lah
     */
    public static NoIntegratedArgsResponse of(NodeContext<?> context) {
        return new NoIntegratedArgsResponse(new ArrayList<>()); //TODO IMPLEMENT
    }
}
