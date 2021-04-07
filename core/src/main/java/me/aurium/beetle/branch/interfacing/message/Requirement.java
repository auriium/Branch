package me.aurium.beetle.branch.interfacing.message;

import me.aurium.beetle.branch.interfacing.message.model.MessageInfo;

/**
 * rename messageRequirement
 * @param <C>
 */
public interface Requirement<C> {

    Message<C> toMessage(MessageInfo... infos);

}
