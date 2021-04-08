package me.aurium.beetle.branch.interfacing.handlers;

import me.aurium.beetle.branch.interfacing.model.Response;
import me.aurium.beetle.branch.interfacing.model.ResponseAction;

import java.util.Map;

public interface MessageProvider<T> {

    ResponseActionHandler<T> make();

}
