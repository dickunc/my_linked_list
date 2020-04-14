package com;

import com.github.ovorobeva.NoSuchElementException;
import com.github.ovorobeva.mylinkedlist.MyLinkedList;
import org.junit.Assert;
import org.junit.Test;

public class MyLinkedListTest {

    @Test
    public void testAddStringsTest() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>(new String[]{"First", "Second", "Third", "Forth", "Fifth"});
        myLinkedList.add("Sixth");
        Assert.assertEquals(6, myLinkedList.getSize());
    }

    @Test
    public void testAddArray() throws NoSuchElementException {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(new Integer[]{4, 8, 15, 16, 23, 42});
        MyLinkedList.Iterator<Integer> iterator = myLinkedList.getIterator();
        Integer[] expectedResult = new Integer[]{4, 8, 15, 16, 23, 42};
        Assert.assertEquals(expectedResult[0], iterator.getItem());
        int i = 1;
        do {
            Assert.assertEquals(expectedResult[i++], iterator.next());
        } while (iterator.hasNext());

    }

    @Test
    public void testListToString() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>(new String[]{"First", "Second", "Third", "Forth", "Fifth"});
        Assert.assertEquals("First\n" +
                "Second\n" +
                "Third\n" +
                "Forth\n" +
                "Fifth", myLinkedList.toString());
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetFirstEmpty() throws NoSuchElementException {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(myLinkedList.getFirst());
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetLastEmpty() throws NoSuchElementException {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(myLinkedList.getLast());
    }

    @Test
    public void testGetLast() throws NoSuchElementException {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("First");
        myLinkedList.add("Last");
        Assert.assertEquals("Last", myLinkedList.getLast());
    }

}