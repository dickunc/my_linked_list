import myLinkedList.MyLinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DoMagic {
    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();

        System.out.println(myLinkedList.getIterator().getItem());
        myLinkedList.add("Item");
        System.out.println(myLinkedList.getIterator().getItem());

        MyLinkedList<Integer> integerMyLinkedList = new MyLinkedList<>(new Integer[]{0, 1, 2});

        System.out.println(integerMyLinkedList.getLast());

        MyLinkedList<String> stringMyLinkedList = new MyLinkedList<>(new String[]{"First", "Second", "Third", "Forth", "Fifth"});
        stringMyLinkedList.add("Sixth");
        MyLinkedList.Iterator<String> iterator = stringMyLinkedList.getIterator();
        System.out.println(iterator.getItem());

        do {
            iterator.next();
            System.out.println(iterator.getItem().value());
        } while (iterator.hasNext());


    }
}
