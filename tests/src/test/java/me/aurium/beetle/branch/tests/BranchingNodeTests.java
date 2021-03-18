package me.aurium.beetle.branch.tests;

import me.aurium.beetle.branch.tests.mockups.BranchingCommand;
import org.junit.jupiter.api.Test;

public class BranchingNodeTests extends AbstractTests {

    private final BranchingCommand command = new BranchingCommand(adapter,logger);

    @Test
    public void testNoArgsExecution() {
        beginTest("BranchingNode: NoArgs");

        command.execute(SENDER,ALIAS,of());
    }

    @Test
    public void testLinkedNodeExecution() {
        beginTest("BranchingNode: Linked Node Execution");

        command.execute(SENDER,ALIAS,of("help"));
    }

    public void testNotLinkedNodeExecution() {
        beginTest("BranchingNode: Unlinked Node Execution");

        command.execute(SENDER,ALIAS,of("invites","unrinked"));
    }

    public void testBranchingExecution() {
        beginTest("BranchingNode: Branching Execution");

        command.execute(SENDER,ALIAS,of("join"));
    }

    public void testBranchInBranchExecution() {
        beginTest("BranchingNode: Branch in Branch Execution");

        command.execute(SENDER,ALIAS,of("invites","on"));
    }



}
