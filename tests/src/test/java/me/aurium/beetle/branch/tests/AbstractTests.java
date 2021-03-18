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

    protected String[] of(String... strings) {
        return strings;
    }

    protected void beginTest(String name) {
        logger.info(() -> "(BRANCH) Beginning test: " + name);
    }

}
