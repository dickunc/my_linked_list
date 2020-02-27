import myLinkedList.MyLinkedList;

public class DoMagic {
    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("First");
        myLinkedList.add("Second");
        myLinkedList.add("Third");
        myLinkedList.add("Forth");

        System.out.println(myLinkedList.first);
    }
}
