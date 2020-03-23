package myLinkedList;

import org.junit.Assert;
import org.junit.Test;

public class MyLinkedListTest {

    @Test
    public void testAddStringsTest() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>(new String[]{"First", "Second", "Third", "Forth", "Fifth"});
        myLinkedList.add("Sixth");
        Assert.assertEquals(6, myLinkedList.size);
    }

    @Test
    public void testAddArray() {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(new Integer[]{4, 8, 15, 16, 23, 42});
        MyLinkedList.Iterator<Integer> iterator = myLinkedList.getIterator();
        Integer result = iterator.getItem().item;
        do {
            result += iterator.next().item;
        } while (iterator.hasNext());

        Assert.assertEquals(108, (int) result);
    }

    @Test
    public void testListToString() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>(new String[]{"First", "Second", "Third", "Forth", "Fifth"});
        Assert.assertEquals("Node{item=First, next=Second}\n" +
                "Node{previous=First, item=Second, next=Third}\n" +
                "Node{previous=Second, item=Third, next=Forth}\n" +
                "Node{previous=Third, item=Forth, next=Fifth}\n" +
                "Node{previous=Forth, item=Fifth}", myLinkedList.toString());
    }

}