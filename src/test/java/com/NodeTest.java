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
    public void testSetValue() throws NoSuchElementException {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("Old value");
        myLinkedList.getIterator().setValue("New value");
        Assert.assertEquals("New value", myLinkedList.getFirst());
    }

}