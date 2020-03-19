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
    public void testToStringFirst() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>(new String[]{"First", "Second", "Third", "Forth", "Fifth"});
        Assert.assertEquals("Node{item=First, next=Second}", myLinkedList.getFirst().toString());
    }

    @Test
    public void testToString() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>(new String[]{"First", "Second", "Third", "Forth", "Fifth"});
        Iterator iterator = myLinkedList.getIterator();
        iterator.next();
        Assert.assertEquals("Node{item=Second, previous=First, next=Third}", iterator.getItem().toString());
    }

    @Test
    public void testListToString() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>(new String[]{"First", "Second", "Third", "Forth", "Fifth"});
        Assert.assertEquals("Node{item=First, next=Second}Node{item=Second, previous=First, next=Third}Node{item=Third, previous=Second, next=Forth}Node{item=Forth, previous=Third, next=Fifth}Node{item=Fifth, previous=Forth}", myLinkedList.toString());
    }

    @Test
    public void iteratorNext() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>(new String[]{"First", "Second", "Third", "Forth", "Fifth"});
        Iterator iterator = myLinkedList.getIterator();
        iterator.next();
        Assert.assertEquals("Second", iterator.getItem().item);
    }

    @Test
    public void iteratorPrevious() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>(new String[]{"First", "Second", "Third", "Forth", "Fifth"});
        Iterator iterator = myLinkedList.getIterator();
        iterator.next();
        iterator.previous();
        Assert.assertEquals("First", iterator.getItem().item);
    }

    @Test
    public void iteratorHasPrevious() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>(new String[]{"First", "Second", "Third", "Forth", "Fifth"});
        Iterator iterator = myLinkedList.getIterator();
        iterator.next();
        Assert.assertEquals(true, iterator.hasPrevious());
    }

    @Test
    public void iteratorHasNext() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>(new String[]{"First", "Second", "Third", "Forth", "Fifth"});
        Iterator iterator = myLinkedList.getIterator();
        Assert.assertEquals(true, iterator.hasNext());
    }

    @Test
    public void iteratorGetItem() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>(new String[]{"First", "Second", "Third", "Forth", "Fifth"});
        Iterator iterator = myLinkedList.getIterator();
        iterator.next();
        iterator.previous();
        Assert.assertEquals("First", iterator.getItem().item);
    }
}