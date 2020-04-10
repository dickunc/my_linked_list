package com;

import com.github.ovorobeva.NoSuchElementException;
import com.github.ovorobeva.mylinkedlist.MyLinkedList;
import org.junit.Assert;
import org.junit.Test;

public class NodeTest {

    @Test
    public void testNewNode() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>(new String[]{"First", "Second", "Third", "Forth", "Fifth"});
        myLinkedList.add("Sixth");
        Assert.assertEquals(6, myLinkedList.getSize());
    }

    @Test
    public void testToStringFirst() throws NoSuchElementException {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>(new String[]{"First", "Second", "Third", "Forth", "Fifth"});
        Assert.assertEquals("Node{item=First, next=Second}", myLinkedList.getFirst().toString());
    }

    @Test
    public void testToStringFirstAlone() throws NoSuchElementException {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("Alone Element");
        Assert.assertEquals("Node{item=Alone Element}", myLinkedList.getFirst().toString());
    }

    @Test
    public void testToStringLastAlone() throws NoSuchElementException {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("Alone Element");
        Assert.assertEquals("Node{item=Alone Element}", myLinkedList.getLast().toString());
    }

    @Test
    public void testNodeToString() throws NoSuchElementException {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>(new String[]{"First", "Second", "Third", "Forth", "Fifth"});
        MyLinkedList.Iterator<String> iterator = myLinkedList.getIterator();
        iterator.next();
        Assert.assertEquals("Node{previous=First, item=Second, next=Third}", iterator.getItem().toString());
    }

    @Test
    public void testToStringLast() throws NoSuchElementException {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>(new String[]{"First", "Second", "Third", "Forth", "Fifth"});
        Assert.assertEquals("Node{previous=Forth, item=Fifth}", myLinkedList.getLast().toString());
    }

    @Test
    public void testSetValue() throws NoSuchElementException {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("Old value");
        myLinkedList.getIterator().getItem().setValue("New value");
        Assert.assertEquals("New value", myLinkedList.getFirst().value());
    }

}