package xyz.auriium.branch.tests.node.utility;

import org.junit.jupiter.api.Test;
import xyz.auriium.branch.interfacing.exceptional.AnomalyType;
import xyz.auriium.branch.results.Result;

import static org.junit.jupiter.api.Assertions.*;

public class ResultTest {

    @Test
    public void whenResultSuppliedAnomaly_isUnsuccessfulAndHasAnomaly() {
        Result<String> result = Result.fail(new MockAnomaly());

        assertFalse(result.isSuccessful());
        assertEquals(result.getFailure().type(), AnomalyType.INVALID_SYNTAX);
    }

    @Test
    public void whenResultSuppliedSuccess_isSuccessfulAndHasSuccess() {
        Result<String> result = Result.success("test");

        assertTrue(result.isSuccessful());
        assertEquals(result.getSuccess(), "test");
    }

}
