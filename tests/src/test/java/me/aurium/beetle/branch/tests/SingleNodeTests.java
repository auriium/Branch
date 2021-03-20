package me.aurium.beetle.branch.tests;

import me.aurium.beetle.branch.tests.mockups.SingleCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingleNodeTests extends AbstractTests {

    private final SingleCommand command = new SingleCommand(adapter,logger);

    @DisplayName("Test command with single variable, single node")
    @Test
    public void testSingleVarExecution() {
        logTestStarting("SingleNode: Single argument execution");

        command.execute(SENDER,ALIAS,new String[]{"arg1"});
    }

    @DisplayName("Test command with no arguments, single node")
    @Test
    public void testNoArgsExecution() {
        logTestStarting("SingleNode: No arguments execution");

        command.execute(SENDER,ALIAS,new String[]{"join"});
    }

    @DisplayName("Test command with two arguments, single node")
    @Test
    public void testMultiArgsExecution() {
        logTestStarting("SingleNode: Argument overflow execution");

        command.execute(SENDER,ALIAS,new String[]{"arg1","arg2"});
    }


}
