import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {
    @Test
    public void addAndRetrieve() throws Exception {
        LinkedList list = new LinkedList();
        Object o1 = new Object(), o2 = new Object();

        assertFalse(list.contains(o1));
        assertFalse(list.contains(o2));
        assertEquals(0, list.size());

        list.add(o1);
        list.add(o2);

        assertTrue(list.contains(o1));
        assertTrue(list.contains(o2));
        assertEquals(2, list.size());

        assertTrue(list.get(0) == o1);
        assertTrue(list.get(1) == o2);
    }

    @Test
    public void reverse() throws Exception {
        LinkedList list = new LinkedList();

        Object o1 = new Object(), o2 = new Object(), o3 = new Object();

        list.add(o1);
        list.add(o2);
        list.add(o3);

        assertTrue(list.get(0) == o1);
        assertTrue(list.get(1) == o2);
        assertTrue(list.get(2) == o3);

        list.reverse();

        assertTrue(list.get(0) == o3);
        assertTrue(list.get(1) == o2);
        assertTrue(list.get(2) == o1);
    }
}