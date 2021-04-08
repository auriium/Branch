package me.aurium.beetle.branch.interfacing.model;

import me.aurium.beetle.branch.interfacing.model.Message;

public interface ResponseAction<T,C extends Response> {

    Message<T> consume(C response);

}
