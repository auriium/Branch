package me.aurium.beetle.branch.tests;

import me.aurium.beetle.branch.context.ContextProducer;
import me.aurium.beetle.branch.tests.context.TestContextProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractTests {

    protected final Logger logger = LoggerFactory.getLogger(AbstractTests.class);

    protected final ContextProducer<String> adapter = new TestContextProducer();

    protected final static String SENDER = "Tester";
    protected final static String ALIAS = "TestCommand";


}
