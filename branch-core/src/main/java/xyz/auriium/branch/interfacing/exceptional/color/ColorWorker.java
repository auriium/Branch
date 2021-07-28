package xyz.auriium.branch.interfacing.exceptional.color;

import xyz.auriium.branch.interfacing.MessageWorker;

public abstract class ColorWorker<T> implements MessageWorker<T,ColorMessage> {

    private final ColorMessageController controller;

    public ColorWorker(ColorMessageController controller) {
        this.controller = controller;
    }

    @Override
    public void sendMessage(String message, T type) {
        sendTo(controller.parse(ColorMessage.of(message)), type);
    }

    @Override
    public void sendObject(ColorMessage message, T type) {
        sendTo(controller.parse(message), type);
    }

    abstract void sendTo(String alreadyColored, T type);
}
