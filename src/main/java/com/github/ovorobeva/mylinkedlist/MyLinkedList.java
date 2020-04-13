package com.github.ovorobeva.mylinkedlist;

import com.github.ovorobeva.NoSuchElementException;

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

    public Node<E> getFirstNode() throws NoSuchElementException {
        if (first == null) {
            throw new NoSuchElementException("First element is not found");
        } else
            return first;
    }

    public E getFirst() throws NoSuchElementException {
        if (first == null) {
            throw new NoSuchElementException("First element is not found");
        } else
            return first.item;
    }

    public Node<E> getLastNode() throws NoSuchElementException {
        if (last == null) {
            throw new NoSuchElementException("Last element is not found");
        } else
            return last;
    }

    public E getLast() throws NoSuchElementException {
        if (last == null) {
            throw new NoSuchElementException("Last element is not found");
        } else
            return last.item;
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
            try {
                iterator.next();
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
            toStringBuilder.append(iterator.getItem().toString());
        } while (iterator.hasNext());
        String toString;
        toString = toStringBuilder.toString();

        return toString;
    }

    public static class Node<E> {

        private E item;
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

    //TODO: Implement iterable
    public static class Iterator<E> {

        private Node<E> currentNode;

        private Iterator(MyLinkedList<E> list) {
            try {
                currentNode = list.getFirstNode();
            } catch (NoSuchElementException e) {
                System.out.println("Fill the list and try again");
                currentNode = null;
            }
        }

        public boolean hasNext() {
            if (currentNode != null) {
                return currentNode.next != null;
            } else {
                return false;
            }
        }

        public boolean hasPrevious() {
            if (currentNode != null) {
                return currentNode.previous != null;
            } else {
                return false;
            }
        }

        public E next() throws NoSuchElementException {
            if (currentNode.next != null) {
                currentNode = currentNode.next;
                return currentNode.item;
            } else throw new NoSuchElementException("Next element is not found");
        }

        public E previous() throws NoSuchElementException {
            if (currentNode.previous != null) {
                currentNode = currentNode.previous;
                return currentNode.item;
            } else throw new NoSuchElementException("Previous element is not found");
        }

        public E getItem() {
            return currentNode.item;
        }

        public void setValue(E value) {
            currentNode.item = value;
        }


    }
}
