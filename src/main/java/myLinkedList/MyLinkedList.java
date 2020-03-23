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

    public Iterator<E> getIterator() {
        return new Iterator<>(this);
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


        @Override
        public String toString() {
            String string = "Node{";
            if (this.item != null) {
                string = "Node{";
            }
            if (this.previous != null) {
                string += "previous=" + this.previous.item + ", ";
            }
            string += "item=" + item;

            if (this.next != null) {
                string += ", next=" + this.next.item + "}";
            } else
                string += "}";
            return string;
        }
    }

    @Override
    public String toString() {
        String toString;
        Iterator<E> iterator = this.getIterator();

        StringBuilder toStringBuilder = new StringBuilder(iterator.getItem().toString());
        do {
            iterator.next();
            toStringBuilder.append(iterator.getItem().toString());
        } while (iterator.hasNext());
        toString = toStringBuilder.toString();

        return toString;
    }

    public static class Iterator<E> extends MyLinkedList<E> {

        private Node<E> currentNode = null;

        private Iterator(MyLinkedList<E> list) {
            currentNode = list.getFirst();
        }

        public boolean hasNext() {
            return currentNode.next != null;
        }

        public boolean hasPrevious() {
            return currentNode.previous != null;
        }

        public Node<E> next() {
            if (currentNode.next != null) {
                currentNode = currentNode.next;
                return currentNode;
            } else return null;
        }

        public Node<E> previous() {
            if (currentNode.previous != null) {
                currentNode = currentNode.previous;
                return currentNode;
            } else return null;
        }

        public Node<E> getItem() {
            return currentNode;
        }
    }
}
