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

package xyz.auriium.branch.interfacing.exceptional.anomalies;

import xyz.auriium.branch.interfacing.exceptional.Anomaly;
import xyz.auriium.branch.interfacing.exceptional.AnomalyHandler;
import xyz.auriium.branch.interfacing.exceptional.AnomalyType;

/**
 * Represents a response to the scenario in which a certain object was attempted to be adapted to an extending type
 * but it was not an instance of it (or similar scenarios, such as attempting to flatmap a certain type to another.)
 */
public class WrongTypeParseAnomaly implements Anomaly {

    private final Class<?> expectedClass;
    private final Class<?> receivedClass;

    public WrongTypeParseAnomaly(Class<?> expectedClass, Class<?> receivedClass) {
        this.expectedClass = expectedClass;
        this.receivedClass = receivedClass;
    }

    public Class<?> getExpectedClass() {
        return expectedClass;
    }

    public Class<?> getReceivedClass() {
        return receivedClass;
    }

    @Override
    public AnomalyType type() {
        return AnomalyType.INVALID_SENDER;
    }
}
