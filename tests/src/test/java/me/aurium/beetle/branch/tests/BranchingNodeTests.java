package me.aurium.beetle.branch.tests;

import me.aurium.beetle.branch.tests.mockups.BranchingCommand;
import org.junit.jupiter.api.Test;

public class BranchingNodeTests extends AbstractTests {

    private final BranchingCommand command = new BranchingCommand(adapter,logger);

    @Test
    public void testNoArgsExecution() {
        logTestStarting("BranchingNode: NoArgs");

        command.execute(SENDER,ALIAS,new String[]{""});
    }

    @Test
    public void testLinkedNodeExecution() {
        logTestStarting("BranchingNode: Linked Node Execution");

        command.execute(SENDER,ALIAS,new String[]{"help"});
    }

    @Test
    public void testNotLinkedNodeExecution() {
        logTestStarting("BranchingNode: Unlinked Node Execution");

        command.execute(SENDER,ALIAS,new String[]{"invites","nonexistent"});
    }

    @Test
    public void testBranchingExecution() {
        logTestStarting("BranchingNode: Branching Execution");

        command.execute(SENDER,ALIAS,new String[]{"join"});
    }

    @Test
    public void testBranchInBranchExecution() {
        logTestStarting("BranchingNode: Branch in Branch Execution");

        command.execute(SENDER,ALIAS,new String[]{"invites","on"});
    }



}
