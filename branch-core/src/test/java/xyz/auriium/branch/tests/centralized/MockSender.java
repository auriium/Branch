package xyz.auriium.branch.tests.centralized;

import java.util.UUID;

public class MockSender {

    private final UUID field = UUID.randomUUID();

    public UUID getField() {
        return field;
    }
}
