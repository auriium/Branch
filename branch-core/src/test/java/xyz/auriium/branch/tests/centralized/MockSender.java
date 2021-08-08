package xyz.auriium.branch.tests.centralized;

import java.util.Arrays;
import java.util.UUID;

public class MockSender {

    private final UUID field = UUID.randomUUID();
    private final String[] permissions;

    public MockSender(String... permissions) {
        this.permissions = permissions;
    }

    public UUID getField() {
        return field;
    }

    public boolean hasPermission(String str) {
        return Arrays.asList(permissions).contains(str);
    }
}
