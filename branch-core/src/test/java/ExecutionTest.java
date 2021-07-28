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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.auriium.branch.centralized.NodeSource;
import xyz.auriium.branch.execution.StringBlock;
import xyz.auriium.branch.fallback.permissions.EmptyPermission;
import xyz.auriium.branch.centralized.information.description.StringDescription;
import xyz.auriium.branch.nodes.IdentifiableNode;
import xyz.auriium.branch.nodes.single.SingleNode;
import xyz.auriium.branch.tests.StringManager;

public class ExecutionTest {

    private final static Logger logger = LoggerFactory.getLogger(ExecutionTest.class);

    private final StringManager manager = new StringManager();
    private final NodeSource<String> source = manager.getSource();

    public void test1() {

        manager.newCommandWithBuilder()
                .withNode(source.single()
                        .withHandler(context -> {

                        }).build()
                ).finish();

        manager.newCommandWithNode(SingleNode.of(StringBlock.of("test"), act -> {

        },new EmptyPermission<>(), new StringDescription("cum")));

        manager.newCommandWithNode(SingleNode.of(StringBlock.of("hi"), handler -> {

        }));

        IdentifiableNode<String> cum = SingleNode.of(StringBlock.of("hi"), act -> {

        });

        manager.newCommandWithBuilder()
                .withNode(source.exclusiveBranching().withNode(SingleNode.of(StringBlock.of("hi"), act -> {})).build());

        //oh my god i can't believe singlenode is actually working

    }

}
