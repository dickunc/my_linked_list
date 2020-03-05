package myLinkedList;

public class Iterator {
    MyLinkedList list;

    public Iterator(MyLinkedList list) {
        this.list = list;
        list.currentNode = list.first;
    }

    ;


    public boolean hasNext() {
        return list.currentNode.getNext() != null;
    }

    public boolean hasPrevious() {
        return list.currentNode.getPrevious() != null;
    }

    public void next() {
        list.currentNode = list.currentNode.getNext();
    }

    public void previous() {
        list.currentNode = list.currentNode.getPrevious();
    }

    public MyLinkedList.Node getItem() {
        return list.currentNode;
    }
}
