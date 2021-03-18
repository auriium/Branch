package me.aurium.beetle.branch.tests;

import me.aurium.beetle.branch.adapter.ContextAdapterFactory;
import me.aurium.beetle.branch.adapter.DelegatingContextAdapterFactory;
import me.aurium.beetle.branch.tests.mockups.MockupContextSource;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CommandTests {

    private final ContextAdapterFactory<String> adapter = new DelegatingContextAdapterFactory<>(new MockupContextSource());
    private final TestCommand command = new TestCommand(adapter);

    @BeforeAll
    static void defineTestingVars() {

    }

    @Test
    public void testSingleVarExecution() {
        String[] args = of("test");

        command.execute("sender","testCommand",args);
    }

    protected String[] of(String... strings) {
        return strings;
    }

}
