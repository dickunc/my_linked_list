package com.github.ovorobeva.mylinkedlist;

public class MyLinkedList<E> {

    private int size = 0;

    private Node<E> first = null;
    private Node<E> last = null;

    public MyLinkedList() {
    }

    public MyLinkedList(E[] items) {
        for (E item : items) {
            add(item);
        }
    }

    public Node<E> getFirst() throws NullPointerException {
        if (first == null) {
            throw new NullPointerException("First element is not found");
        } else
            return first;
    }

    public Node<E> getLast() throws NullPointerException {
        if (last == null) {
            throw new NullPointerException("Last element is not found");
        } else
            return last;
    }

    public Iterator<E> getIterator() throws NullPointerException {
        try {
            return new Iterator<>(this);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            return null;
        }
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

    public void add(E[] items) {
        for (E item : items) {
            add(item);
        }
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        Iterator<E> iterator = this.getIterator();

        StringBuilder toStringBuilder = new StringBuilder(iterator.getItem().toString());
        do {
            toStringBuilder.append("\n");
            iterator.next();
            toStringBuilder.append(iterator.getItem().toString());
        } while (iterator.hasNext());
        String toString;
        toString = toStringBuilder.toString();

        return toString;
    }

    public static class Node<E> extends MyLinkedList<E> {

        private E item;
        private Node<E> previous;
        private Node<E> next;

        public Node(E item, Node<E> previous, Node<E> next) {
            this.item = item;
            this.previous = previous;
            this.next = next;
        }

        public E value() throws NullPointerException {
            return item;
        }

        public void setValue(E item) {
            this.item = item;
        }


        @Override
        public String toString() {
            String string = "Node{";
            if (this.value() != null) {
                string = "Node{";
            }
            if (this.previous != null) {
                string += "previous=" + this.previous.value() + ", ";
            }
            string += "item=" + item;

            if (this.next != null) {
                string += ", next=" + this.next.value() + "}";
            } else
                string += "}";
            return string;
        }
    }

    public static class Iterator<E> extends MyLinkedList<E> {

        private Node<E> currentNode;

        private Iterator(MyLinkedList<E> list) {
            try {
                currentNode = list.getFirst();
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
                System.out.println("Fill the list and try again");
            }
        }

        public boolean hasNext() {
            return currentNode.next != null;
        }

        public boolean hasPrevious() {
            return currentNode.previous != null;
        }

        public Node<E> next() throws NullPointerException {
            if (currentNode.next != null) {
                currentNode = currentNode.next;
                return currentNode;
            } else return null;
        }

        public Node<E> previous() throws NullPointerException {
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
