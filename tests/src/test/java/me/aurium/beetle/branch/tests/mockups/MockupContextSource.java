package me.aurium.beetle.branch.tests.mockups;

import me.aurium.beetle.api.command.Context;
import me.aurium.beetle.api.command.ContextSource;

public class MockupContextSource implements ContextSource<String> {
    @Override
    public Context<String> context(String s, String s2, String[] strings) {
        return new MockupContext(s,s2,strings);
    }
}
