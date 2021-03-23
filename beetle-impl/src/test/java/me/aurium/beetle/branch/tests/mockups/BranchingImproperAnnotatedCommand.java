package me.aurium.beetle.branch.tests.mockups;

import me.aurium.beetle.branch.context.NodeContext;
import me.aurium.beetle.branch.annotate.BranchCommand;
import me.aurium.beetle.branch.annotate.marker.BranchingNode;
import me.aurium.beetle.branch.annotate.marker.SingleNode;

//rule of thumb: If 1 alonenode is found in the class, it is considered an alone-node based class.
//if more than 1 commandnode is found in the class, it is considered a branching node based class
//if there is one branching node in the class, it is considered a branching node based class sans that branching node (it's identifier doesn't matter)

@BranchCommand
public class BranchingImproperAnnotatedCommand {

    @SingleNode(identifier = "branch1")
    public void branch1(NodeContext<String> nodeContext) {
        nodeContext.getSender();

        //do some action, command looks like this: /command branch1
    }

    @SingleNode(identifier = "branch2")
    public void branch2(NodeContext<String> nodeContext) {
        nodeContext.getSender();

        //do some action here, command looks like this: /command branch2
    }

    @BranchingNode(identifier = "branching1")
    public static class branching1 {

        @SingleNode(identifier = "mee")
        public void lol() {
            //do some action here, command looks like this: /command branching1 mee
        }

        @SingleNode(identifier = "cringe")
        public void haha(NodeContext<String> context) {
            //do some action here, command looks like this /command branching1 cringe
        }

    }

}
