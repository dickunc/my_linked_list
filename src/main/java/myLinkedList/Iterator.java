package myLinkedList;

import myLinkedList.MyLinkedList.Node;

public class Iterator {
    private Node currentNode = null;

    public Iterator(MyLinkedList list) {
        currentNode = list.first;
    }


    public boolean hasNext() {
        return currentNode.getNext() != null;
    }

    public boolean hasPrevious() {
        return currentNode.getPrevious() != null;
    }

    public void next() {
        currentNode = currentNode.getNext();
    }

    public void previous() {
        currentNode = currentNode.getPrevious();
    }

    public Node getItem() {
        return currentNode;
    }
}
