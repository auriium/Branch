package me.aurium.beetle.branch.tests;

import me.aurium.beetle.branch.tests.mockups.SingleCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class SingleNodeTests extends AbstractTests {

    private final SingleCommand command = new SingleCommand(adapter);

    @BeforeEach
    public void logTestStarting(TestInfo info) {
        logger.info("Starting test {}", info.getDisplayName());
    }

    @DisplayName("Test command with single variable, single node")
    @Test
    public void testSingleVarExecution() {
        command.execute(SENDER,ALIAS,new String[]{"arg1"});
    }

    @DisplayName("Test command with no arguments, single node")
    @Test
    public void testNoArgsExecution() {
        command.execute(SENDER,ALIAS,new String[]{"join"});
    }

    @DisplayName("Test command with two arguments, single node")
    @Test
    public void testMultiArgsExecution() {
        command.execute(SENDER,ALIAS,new String[]{"arg1","arg2"});
    }


}
