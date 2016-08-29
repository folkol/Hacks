public class MyLinkedList
{
    Node head;

    public void reverse()
    {
        if (head == null) {
            return;
        }

        while (head.next != null) {

        }
    }

    static class Node
    {
        Node next;
        int value;

        public Node(int value)
        {
            this.value = value;
        }
    }

    public void add(int value)
    {
        Node tmp = new Node(value);
        if (head == null) {
            head = tmp;
        } else {
            Node node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = tmp;
        }
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        Node node = head;
        while (node != null) {
            sb.append(node.value);
            node = node.next;
        }
        return sb.toString();
    }
}
