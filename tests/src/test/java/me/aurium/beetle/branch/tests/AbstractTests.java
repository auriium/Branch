package me.aurium.beetle.branch.tests;

import me.aurium.beetle.branch.adapter.ContextAdapterFactory;
import me.aurium.beetle.branch.adapter.DelegatingContextAdapterFactory;
import me.aurium.beetle.branch.tests.mockups.MockupContextSource;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public abstract class AbstractTests {

    protected final Logger logger = LoggerFactory.getLogger(BranchingNodeTests.class);

    protected final ContextAdapterFactory<String> adapter = new DelegatingContextAdapterFactory<>(new MockupContextSource(logger));

    protected final static String SENDER = "Tester";
    protected final static String ALIAS = "TestCommand";

    //@A248 is there a better way to do this with junit5? i'm not used to it. Is ther also a way to make the logger messages less ugly? They look shitty compared to juni4
    protected void logTestStarting(String name) {
        logger.info(() -> "(BRANCH) Beginning test: " + name);
    }

}
