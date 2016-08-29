import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyLinkedListTest
{
    @Test
    public void testAdd()
        throws Exception
    {
        MyLinkedList target = new MyLinkedList();

        for (int i = 0; i < 10; i++) {
            target.add(i);
        }

        assertEquals("0123456789", target.toString());
    }

    @Test
    public void testReverse()
        throws Exception
    {
        MyLinkedList target = new MyLinkedList();

        for (int i = 0; i < 10; i++) {
            target.add(i);
        }

        assertEquals("0123456789", target.toString());

        target.reverse();
        assertEquals("9876543210", target.toString());
    }

}