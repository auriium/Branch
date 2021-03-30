package me.aurium.beetle.branch.annotate.parsers;

import me.aurium.beetle.branch.annotate.AnnotatedCommand;
import me.aurium.beetle.branch.annotate.UncheckedInvocationException;
import me.aurium.beetle.branch.annotate.marker.SingleNode;
import me.aurium.beetle.branch.handlers.context.NodeContext;
import me.aurium.beetle.branch.handlers.api.ExecutionHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

//TODO one of these days refactor, but right now i really don't care.
public class SingleAnnotatedParser<T> {

    private final Class<T> senderClass;

    public SingleAnnotatedParser(Class<T> senderClass) {
        this.senderClass = senderClass;
    }

    public List<me.aurium.beetle.branch.nodes.SingleNode<T>> parse(Class<? extends AnnotatedCommand> command) {

        List<me.aurium.beetle.branch.nodes.SingleNode<T>> nodes = new ArrayList<>();

        for (Method method : command.getMethods()) {
            if (method.isAnnotationPresent(SingleNode.class)) {
                //This method is a SingleNode, verify the argument signature of the command
                SingleNode annotate = method.getAnnotation(SingleNode.class);
                Parameter[] parameters = method.getParameters();

                if (!method.getReturnType().equals(Void.TYPE)) throw new SingleNodeParsingException("Annotation return must be void");
                if (parameters.length != 1 || !parameters[0].getType().isAssignableFrom(NodeContext.class)) throw new SingleNodeParsingException("Method signature length must be one argument!");

                if (parameters[0].getParameterizedType() instanceof ParameterizedType) {

                }


                //all of this is really really stupid lmfao we should be working with an instance of the class

                if (parameters[0].getType().isAssignableFrom(NodeContext.class)) {


                    ExecutionHandler<T> handler = (context) -> {
                        try {
                            method.invoke(command,context);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            throw new UncheckedInvocationException(e);
                        }

                    };

                } else {
                    throw new SingleNodeParsingException("The method signature of a single-node must only contain a single NodeContext!");
                }
            }
        }

        return null;
    }

    public static class SingleNodeParsingException extends RuntimeException {

        SingleNodeParsingException(String error) {
            super(error);
        }
    }


}
