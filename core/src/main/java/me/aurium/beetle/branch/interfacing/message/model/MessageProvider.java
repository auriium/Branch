package me.aurium.beetle.branch.interfacing.message.model;

import me.aurium.beetle.branch.interfacing.message.Message;
import me.aurium.beetle.branch.interfacing.message.Requirement;

import java.util.Map;
import java.util.UUID;

public interface MessageProvider<T> {

    Map<UUID, Requirement<T>> make();

}
