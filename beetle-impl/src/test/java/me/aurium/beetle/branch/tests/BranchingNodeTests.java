package me.aurium.beetle.branch.tests;

import me.aurium.beetle.branch.tests.mockups.BranchingCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class BranchingNodeTests extends AbstractTests {

    private final BranchingCommand command = new BranchingCommand(adapter);

    @BeforeEach
    public void logTestStarting(TestInfo info) {
        logger.info("Starting test {}", info.getDisplayName());
    }

    @DisplayName("Test with no arguments")
    @Test
    public void testNoArgsExecution() {
        command.execute(SENDER,ALIAS,new String[]{""});
    }

    @DisplayName("Test targetting the linked no-args node of a command")
    @Test
    public void testLinkedNodeExecution() {
        command.execute(SENDER,ALIAS,new String[]{"help"});
    }

    @DisplayName("Test targeting an unlinked no-args node")
    @Test
    public void testNotLinkedNodeExecution() {
        command.execute(SENDER,ALIAS,new String[]{"invites","nonexistent"});
    }

    @DisplayName("Test targetting a branching node")
    @Test
    public void testBranchingExecution() {
        command.execute(SENDER,ALIAS,new String[]{"join"});
    }

    @DisplayName("Test branch node inside of branch node")
    @Test
    public void testBranchInBranchExecution() {
        command.execute(SENDER,ALIAS,new String[]{"invites","on"});
    }



}
