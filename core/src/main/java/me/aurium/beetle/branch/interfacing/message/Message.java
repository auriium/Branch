package me.aurium.beetle.branch.interfacing.message;

import me.aurium.beetle.branch.interfacing.message.model.MessageInfo;

public interface Message<C> {

    void accept(C sender);

}
