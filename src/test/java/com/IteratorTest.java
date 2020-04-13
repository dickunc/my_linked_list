package com;

import com.github.ovorobeva.NoSuchElementException;
import com.github.ovorobeva.mylinkedlist.MyLinkedList;
import org.junit.Assert;
import org.junit.Test;

public class IteratorTest {

    @Test
    public void iteratorNext() throws NoSuchElementException {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>(new String[]{"First", "Second", "Third", "Forth", "Fifth"});
        MyLinkedList.Iterator<String> iterator = myLinkedList.getIterator();
        Assert.assertEquals("Second", iterator.next().value());
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorNextNull() throws NoSuchElementException {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>(new String[]{"First"});
        MyLinkedList.Iterator<String> iterator = myLinkedList.getIterator();
        iterator.next().value();
    }


    @Test
    public void iteratorPrevious() throws NoSuchElementException {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>(new String[]{"First", "Second", "Third", "Forth", "Fifth"});
        MyLinkedList.Iterator<String> iterator = myLinkedList.getIterator();
        iterator.next();
        iterator.previous();
        Assert.assertEquals("First", iterator.getItem().value());
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorPreviousNull() throws NoSuchElementException {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>(new String[]{"First", "Second", "Third", "Forth", "Fifth"});
        MyLinkedList.Iterator<String> iterator = myLinkedList.getIterator();
        iterator.previous().value();

    }


    @Test
    public void iteratorHasPreviousTrue() throws NoSuchElementException {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>(new String[]{"First", "Second", "Third", "Forth", "Fifth"});
        MyLinkedList.Iterator<String> iterator = myLinkedList.getIterator();
        iterator.next();
        Assert.assertTrue(iterator.hasPrevious());
    }

    @Test
    public void iteratorHasPreviousFalse() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>(new String[]{"First", "Second", "Third", "Forth", "Fifth"});
        MyLinkedList.Iterator<String> iterator = myLinkedList.getIterator();
        Assert.assertFalse(iterator.hasPrevious());
    }

    @Test
    public void iteratorHasNextTrue() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>(new String[]{"First", "Second", "Third", "Forth", "Fifth"});
        MyLinkedList.Iterator<String> iterator = myLinkedList.getIterator();
        Assert.assertTrue(iterator.hasNext());
    }

    @Test
    public void iteratorHasNextFalse() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>(new String[]{"First"});
        MyLinkedList.Iterator<String> iterator = myLinkedList.getIterator();
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void iteratorGetItem() throws NoSuchElementException {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>(new String[]{"First", "Second", "Third", "Forth", "Fifth"});
        MyLinkedList.Iterator<String> iterator = myLinkedList.getIterator();
        iterator.next();
        iterator.previous();
        Assert.assertEquals("First", iterator.getItem().value());
    }

    @Test(expected = NullPointerException.class)
    public void testGetIteratorEmptyList() {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.getIterator().getItem().value();
    }

    @Test
    public void emptyListIteratorHasNext() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        MyLinkedList.Iterator<String> iterator = myLinkedList.getIterator();
        Assert.assertFalse(iterator.hasNext());
        myLinkedList.add("e");
        iterator = myLinkedList.getIterator();
        myLinkedList.add("123");
        Assert.assertTrue(iterator.hasNext());
    }

    @Test
    public void fullIterationTest() throws NoSuchElementException {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>(new Integer[]{1, 2, 3, 4});
        Assert.assertEquals(1, (int) myLinkedList.getFirst().value());

        final MyLinkedList.Iterator<Integer> iterator = myLinkedList.getIterator();

        int expectedValue = 2;
        while (iterator.hasNext()) {
            Assert.assertEquals(expectedValue, (int) iterator.next().value());
            expectedValue++;
        }
    }
}