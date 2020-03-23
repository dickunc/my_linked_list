package myLinkedList;

import org.junit.Assert;
import org.junit.Test;

public class IteratorTest {

    @Test
    public void iteratorNext() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>(new String[]{"First", "Second", "Third", "Forth", "Fifth"});
        MyLinkedList.Iterator<String> iterator = myLinkedList.getIterator();
        Assert.assertEquals("Second", iterator.next().value());
    }

    @Test
    public void iteratorNextNull() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>(new String[]{"First"});
        MyLinkedList.Iterator<String> iterator = myLinkedList.getIterator();
        Assert.assertEquals("NPE", iterator.next().value());
    }


    @Test
    public void iteratorPrevious() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>(new String[]{"First", "Second", "Third", "Forth", "Fifth"});
        MyLinkedList.Iterator<String> iterator = myLinkedList.getIterator();
        iterator.next();
        iterator.previous();
        Assert.assertEquals("First", iterator.getItem().value());
    }

    @Test
    public void iteratorPreviousNull() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>(new String[]{"First", "Second", "Third", "Forth", "Fifth"});
        MyLinkedList.Iterator<String> iterator = myLinkedList.getIterator();
        iterator.previous();
        Assert.assertEquals("NPE", iterator.getItem().value());
    }


    @Test
    public void iteratorHasPreviousTrue() {
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
    public void iteratorGetItem() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>(new String[]{"First", "Second", "Third", "Forth", "Fifth"});
        MyLinkedList.Iterator<String> iterator = myLinkedList.getIterator();
        iterator.next();
        iterator.previous();
        Assert.assertEquals("First", iterator.getItem().value());
    }
}