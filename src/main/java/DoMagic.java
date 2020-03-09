import myLinkedList.Iterator;
import myLinkedList.MyLinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DoMagic {
    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("First");
        myLinkedList.add("Second");
        myLinkedList.add("Third");
        myLinkedList.add("Forth");

        System.out.println(myLinkedList.first);

        MyLinkedList<Integer> integerMyLinkedList = new MyLinkedList<>(new Integer[]{0, 1, 2});

        System.out.println(integerMyLinkedList.last);

        MyLinkedList<String> stringMyLinkedList = new MyLinkedList<>(new String[]{"First", "Second", "Third", "Forth", "Fifth"});
        stringMyLinkedList.add("Sixth");
        Iterator iterator = stringMyLinkedList.getIterator();
        System.out.println(iterator.getItem());

        do {
            iterator.next();
            System.out.println(iterator.getItem());
        } while (iterator.hasNext());
    }
}
