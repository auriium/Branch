package me.aurium.beetle.branch.tests;

import me.aurium.beetle.branch.tests.mockups.SingleCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingleNodeTests extends AbstractTests {

    private final SingleCommand command = new SingleCommand(adapter,logger);

    @DisplayName("Test command with single variable, single node")
    @Test
    public void testSingleVarExecution() {
        beginTest("SingleNode: Single argument execution");

        command.execute(SENDER,ALIAS,of("arg1"));
    }

    @DisplayName("Test command with no arguments, single node")
    @Test
    public void testNoArgsExecution() {
        beginTest("SingleNode: No arguments execution");

        command.execute(SENDER,ALIAS,of());
    }

    @DisplayName("Test command with two arguments, single node")
    @Test
    public void testMultiArgsExecution() {
        beginTest("SingleNode: Argument overflow execution");

        command.execute(SENDER,ALIAS,of("arg1","arg2"));
    }


}
