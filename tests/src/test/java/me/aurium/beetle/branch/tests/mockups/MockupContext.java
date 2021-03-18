package me.aurium.beetle.branch.tests.mockups;

import me.aurium.beetle.api.command.Context;
import me.aurium.beetle.core.logger.SLFLogger;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class MockupContext implements Context<String> {

    private final Logger logger;

    public MockupContext(String string, String alias, String[] args, Logger logger) {
        this.string = string;
        this.alias = alias;
        this.args = args;

        this.logger = logger;
    }

    private final String string;
    private final String alias;
    private final String[] args;

    @Override
    public String getSender() {
        return string;
    }

    @Override
    public String getAlias() {
        return alias;
    }

    @Override
    public String[] getArgs() {
        return args;
    }

    @Override
    public void debugString(String s) {
        logger.info(() -> "DEBUG: " + s);
    }
}
