package me.aurium.beetle.branch.tests.mockups;

import me.aurium.beetle.branch.annotate.marker.BranchCommand;
import me.aurium.beetle.branch.annotate.marker.SingleNode;

@BranchCommand
public class ImproperAnnotatedCommand {

    @SingleNode(identifier = "test")
    public void someShit() {

    }

}
