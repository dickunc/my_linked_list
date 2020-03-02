package myLinkedList;

public class MyLinkedList<E> implements Iterator {

    public int size = 0;
    public Node<E> first = null;
    public Node<E> last = null;
    public Node<E> newNode;
    public Node<E> currentNode = null;

    public MyLinkedList() {
    }

    public MyLinkedList(E[] items) {
        for (E item : items) {
            add(item);
        }
    }

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

    public Node<E> getNext(Node<E> item) {
        if (item.next != null)
            return item.next;
        else return last;
    }

    public Node<E> getPrevious(Node<E> item) {
        if (item.previous != null)
            return item.previous;
        else return first;
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "first=" + first +
                ", last=" + last +
                ", newNode=" + newNode +
                '}';
    }

    @Override
    public void getIterator() {
        currentNode = this.first;
    }

    @Override
    public boolean hasNext() {
        return currentNode.next != null;
    }

    @Override
    public boolean hasPrevious() {
        return currentNode.previous != null;
    }

    @Override
    public void next() {
        currentNode = currentNode.next;
    }

    @Override
    public void previous() {
        currentNode = currentNode.previous;
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
