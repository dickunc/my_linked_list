package myLinkedList;

import org.junit.Assert;
import org.junit.Test;

public class NodeTest {

    @Test
    public void testNewNode() {
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
    public void testToStringFirstAlone() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("Alone Element");
        Assert.assertEquals("Node{item=Alone Element}", myLinkedList.getFirst().toString());
    }

    @Test
    public void testToStringLastAlone() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("Alone Element");
        Assert.assertEquals("Node{item=Alone Element}", myLinkedList.getLast().toString());
    }

    @Test
    public void testNodeToString() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>(new String[]{"First", "Second", "Third", "Forth", "Fifth"});
        MyLinkedList.Iterator<String> iterator = myLinkedList.getIterator();
        iterator.next();
        Assert.assertEquals("Node{item=Second, previous=First, next=Third}", iterator.getItem().toString());
    }

    @Test
    public void testToStringLast() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>(new String[]{"First", "Second", "Third", "Forth", "Fifth"});
        Assert.assertEquals("Node{item=Fifth, previous=Forth}", myLinkedList.getLast().toString());
    }
}