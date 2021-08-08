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

package xyz.auriium.branch.results;

import xyz.auriium.branch.interfacing.exceptional.Anomaly;

public interface Result<T> {

    boolean isSuccessful();

    T getSuccess();

    Anomaly getFailure();

    static <X> SuccessfulResult<X> success(X t) {
        return new SuccessfulResult<>(t);
    }
    static <X> FailingResult<X> fail(Anomaly failure) {
        return new FailingResult<>(failure);
    }

    static <X,T> Result<X> transmuteFail(Result<T> result) {
        return Result.fail(result.getFailure());
    }

}
