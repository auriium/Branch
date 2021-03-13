package me.aurium.beetle.branch.bases;

import me.aurium.beetle.api.nodes.impl.StringBlock;
import me.aurium.beetle.branch.nodes.BaseNode;

public class Example {

    void s() {
        new BaseNode<String>(null, StringBlock.of("kitpvp"))
                .singleNode(builder -> {
                    builder.setIdentifier(StringBlock.of("help"));
                    builder.setHandler(content -> {
                       System.out.println(content.getSender());
                       return true;
                    });
                });
    }

}
