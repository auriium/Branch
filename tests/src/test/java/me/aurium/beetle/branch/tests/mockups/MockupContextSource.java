package me.aurium.beetle.branch.tests.mockups;

import me.aurium.beetle.api.command.Context;
import me.aurium.beetle.api.command.ContextSource;
import org.junit.platform.commons.logging.Logger;

public class MockupContextSource implements ContextSource<String> {

    private final Logger logger;

    public MockupContextSource(Logger logger) {
        this.logger = logger;
    }

    @Override
    public Context<String> context(String s, String s2, String[] strings) {
        return new MockupContext(s,s2,strings,logger);
    }
}
