package xyz.auriium.branch.tests.fallback.permission;

import org.junit.jupiter.api.Test;
import xyz.auriium.branch.base.permissions.EmptyPermission;
import xyz.auriium.branch.base.permissions.StringPermission;
import xyz.auriium.branch.tests.centralized.MockContextProducer;
import xyz.auriium.branch.tests.centralized.MockSender;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PermissionTest {

    private final MockContextProducer producer = new MockContextProducer();

    @Test
    public void whenEmptyPermission_alwaysSuccessful() {
        EmptyPermission<MockSender> permission = EmptyPermission.instance();

        assertTrue(
                permission.attempt(
                        producer.produce(new MockSender(), "alias", new String[]{})
                )
        );

    }

    @Test
    public void whenStringPermission_checkValue() {
        var permission = new StringPermission<MockSender>("permissionTest");

        assertTrue(permission.attempt(
                producer.produce(new MockSender("permissionTest"), "test", new String[]{})
        ));

        assertFalse(permission.attempt(
                producer.produce(new MockSender("permissionYouDontHave"), "test", new String[]{})
        ));


    }



}
