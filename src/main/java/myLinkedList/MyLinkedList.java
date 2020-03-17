package myLinkedList;

public class MyLinkedList<E> {

    public int size = 0;

    private Node<E> first = null;
    private Node<E> last = null;

    public Node<E> getFirst() {
        return first;
    }

    public Node<E> getLast() {
        return last;
    }

    public MyLinkedList() {
    }

    public MyLinkedList(E[] items) {
        for (E item : items) {
            add(item);
        }
    }

    public Iterator getIterator() {
        return new Iterator(this);
    }

    public void add(E item) {
        size++;

        if (first == null) {
            first = new Node<>(item, null, null);
            last = first;
        } else {

            Node<E> newNode = new Node<>(item, last, null);
            last.next = newNode;
            last = newNode;

            if (size == 2) {
                first.next = newNode;
            }
        }
    }




    static class Node<E> extends MyLinkedList<E> {
        E item;

        private Node<E> previous;
        private Node<E> next;

        public Node(E item, Node<E> previous, Node<E> next) {
            this.item = item;
            this.previous = previous;
            this.next = next;
        }

        public Node<E> getNext() {
            if (this.next != null)
                return this.next;
                //   else return last; exception is needed
            else return null;
        }

        public Node<E> getPrevious() {
            if (this.previous != null)
                return this.previous;
                //  else return first; exception is needed
            else return null;
        }


        @Override
        public String toString() {
            if ((this.previous != null) && (this.next != null)) {
                return "Node{" +
                        "item=" + item +
                        ", previous=" + previous.item +
                        ", next=" + next.item +
                        '}';
            } else if (this.previous == null) {
                return "Node{" +
                        "item=" + item +
                        ", next=" + next.item +
                        '}';
            } else
                return "Node{" +
                        "item=" + item +
                        ", previous=" + previous.item +
                        '}';
        }
    }

    @Override
    public String toString() {
        String toString;
        Iterator iterator = this.getIterator();
        toString = iterator.getItem().toString();

        do {
            iterator.next();
            toString = toString + iterator.getItem().toString();
        } while (iterator.hasNext());

        return toString;
    }
}
