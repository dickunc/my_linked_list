package myLinkedList;

import java.awt.*;

public class MyLinkedList<E> {

    public int size;
    transient Node<E> first;
    transient Node<E> last;
    transient Node<E> newNode;


    //  public MyLinkedList(){};

    public void add(E item){
        size++;

        if (first == null){
            first = new Node<E>(item,null,null);
            last = first;
        }

        newNode = new Node<E>(item, last, null);
        last.next = newNode;
        last = newNode;
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "first=" + first +
                ", last=" + last +
                ", newNode=" + newNode +
                '}';
    }

    private static class Node<E>{
        E item;
        Node<E> previous;
        Node<E> next;

        public Node(E item, Node<E> previous, Node<E> next) {
            this.item = item;
            this.previous = previous;
            this.next = next;
        }

        @Override
        public String toString() {
            return "" + item;
        }
    }
}
