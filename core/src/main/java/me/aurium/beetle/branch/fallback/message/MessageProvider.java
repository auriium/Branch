package me.aurium.beetle.branch.fallback.message;

import java.util.HashMap;
import java.util.Map;

public interface MessageProvider<T> {

    Map<MessageKey,Message<T>> make();

}
