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

package me.aurium.beetle.branch.nodes.results.model;

import me.aurium.beetle.branch.interfacing.Response;

/**
 * A result that has failed
 * @param <T> the response
 */
public class FailingResult<T> implements Result<T> {

    private final Response failure;

    public FailingResult(Response failure) {
        this.failure = failure;
    }

    @Override
    public boolean isSuccessful() {
        return false;
    }

    @Override
    public T getSuccess() {
        throw new IllegalStateException("Attempted to get success of a failing result! (e.g. was not checked)");
    }

    @Override
    public Response getFailure() {
        return failure;
    }

}
