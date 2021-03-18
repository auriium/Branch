package me.aurium.beetle.branch.tests.mockups;

import me.aurium.beetle.api.command.Context;

public class MockupContext implements Context<String> {

    public MockupContext(String string, String alias, String[] args) {
        this.string = string;
        this.alias = alias;
        this.args = args;
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
        System.out.println(s);
    }
}
