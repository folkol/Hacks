import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class LinkedList implements List {
    private MapEntry head;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        MapEntry temp = head;
        while (temp != null) {
            if (temp.entry == o) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        MapEntry entry = new MapEntry(o);
        if (head == null) {
            head = entry;
        } else {
            MapEntry temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = entry;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        MapEntry temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.entry;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    public void reverse() {
        LinkedList linkedList = new LinkedList();
        for(int i = 0; i < size; i++) {
            linkedList.add(this.get(size - i - 1));
        }
        head = linkedList.head;
    }

    private class MapEntry {
        MapEntry next;
        Object entry;

        MapEntry(Object entry) {
            this.entry = entry;
        }
    }
}
