package xyz.auriium.branch.tests.node.utility;


import org.junit.jupiter.api.Test;
import xyz.auriium.branch.results.DelegatingImmutableList;
import xyz.auriium.branch.results.ImmutableList;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ImmutableListTest {

    @Test
    public void whenListCreated_IsSeparate() {
        List<String> list = new ArrayList<>();
        ImmutableList<String> immutableList = DelegatingImmutableList.make(list);

        list.add("test");

        assertFalse(() -> immutableList.contains("test"));
        assertTrue(immutableList::isEmpty);
    }

    @Test
    public void whenListCreated_CannotModifyDelegate() {
        ImmutableList<String> immutableList = DelegatingImmutableList.make();

        assertThrows(UnsupportedOperationException.class, () -> {
            immutableList.delegate().add("i am going to ruin this list's day"); //THROWS
        });
    }

    @Test
    public void whenListCreated_ImmutableSharesValues() {
        List<String> toDelegate = new ArrayList<>();
        toDelegate.add("test");

        ImmutableList<String> immutableList = DelegatingImmutableList.make(toDelegate);

        assertTrue(toDelegate.contains("test"));
        assertTrue(immutableList.contains("test"));

    }

    @Test
    public void whenImmutableListCopied_CanModifyCopy() {
        List<String> toDelegate = new ArrayList<>();
        toDelegate.add("test");

        ImmutableList<String> immutableList = DelegatingImmutableList.make(toDelegate);
        List<String> modifiable = new ArrayList<>(immutableList.delegate());

        modifiable.remove("test");

        assertTrue(modifiable.isEmpty());
    }

}
