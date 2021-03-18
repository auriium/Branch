package me.aurium.beetle.branch.tests.mockups;

import me.aurium.beetle.branch.annotate.BranchCommand;
import me.aurium.beetle.branch.annotate.SingleNode;

@BranchCommand
public class ImproperAnnotatedCommand {

    @SingleNode(identifier = "test")
    public void someShit() {

    }

}
