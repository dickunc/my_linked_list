package myLinkedList;

public class MyLinkedList<E> {

    public int size = 0;
    public Node<E> first = null;
    public Node<E> last = null;
    public Node<E> newNode;

    public void add(E item) {

        if (first == null) {
            first = new Node<>(item, null, null);
            last = first;
        } else {

            newNode = new Node<>(item, last, null);
            last.next = newNode;
            last = newNode;

            if (size == 2) {
                first.next = newNode;
            }
        }
    }

    public MyLinkedList() {
    }

    public MyLinkedList(E[] items) {
        for (E item : items) {
            add(item);
        }
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "first=" + first +
                ", last=" + last +
                ", newNode=" + newNode +
                '}';
    }

    private static class Node<E> extends MyLinkedList<E> {
        E item;
        Node<E> previous;
        Node<E> next;

        public Node(E item, Node<E> previous, Node<E> next) {
            size++;
            this.item = item;
            this.previous = previous;
            this.next = next;
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
}
